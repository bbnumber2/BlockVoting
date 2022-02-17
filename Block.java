import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;



public class Block{
    private Integer index;
    private Date timestamp;
    private String[] data;
    private byte[] prevHash;
    private byte[] hash;

    /**
     * default constructor for a block
     * @param index
     * @param timestamp
     * @param data
     * @param prevHash
     */
    public Block(Integer index, Date timestamp, String[] data, byte[] prevHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.prevHash = prevHash;
        this.hash = hashBlock();
    }

    /**
     * @param arrays
     * @return the combined arrays in the order given
     */
    private byte[] combine(byte[] ... arrays){
        int length = 0;
        for(byte[] array : arrays){
            length += array.length;
        }
        byte[] total = new byte[length];
        index = 0;
        for(byte[] array : arrays){
            for(byte bit : array){
                total[index++] = bit;
            }
        }
        return total;
    }

    /**
     * generates a hash for the current block
     * @return the hash generated
     */
    private byte[] hashBlock(){
        try {
            MessageDigest encryption = MessageDigest.getInstance("SHA-256");
            byte[] index = this.index.toString().getBytes();
            byte[] timestamp = this.timestamp.toString().getBytes();
            byte[] data = this.data.getBytes();
            byte[] prevHash = this.prevHash.toString().getBytes();
            byte[] total = combine(index, timestamp, data, prevHash);
            
            encryption.update(total);
            return encryption.digest();
            
        } catch (NoSuchAlgorithmException e) {
            //TODO: handle exception
        }
        return null;
        
    }

    /**
     * gets the index of the block
     * @return the index of the block
     */
    public Integer getIndex(){
        return this.index;
    }

    /**
     * gets the timestamp of the block
     * @return the timestamp of the block
     */
    public Date getTimestamp(){
        return this.timestamp;
    }

    /**
     *
     * @return
     */
    public String getData(){
        return this.data;
    }

    public byte[] getHash(){
        return this.hash;
    }

    /**
     * initializes the first block in the chain
     * @return the first block
     */
    public static Block genesisBlock(){
        return new Block(0, new Date(), "genesis block", new byte[]{});
    }

    /**
     * adds a new block to the chain
     * @return the block added
     */
    public static Block newBlock(Block prevBlock){
        Integer index = prevBlock.getIndex() + 1;
        Date timestamp = new Date();
        String data = "Transaction " + index.toString();
        byte[] prevHash = prevBlock.getHash();
        return new Block(index, timestamp, data, prevHash);
    }

}