import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;



public class Block{
    private Integer index;
    private Date timestamp;
    private ArrayList<String> data;
    private byte[] prevHash;
    private byte[] hash;

    /**
     * default constructor for a block
     * @param index
     * @param timestamp
     * @param data
     * @param prevHash
     */
    public Block(Integer index, Date timestamp, ArrayList<String> data, byte[] prevHash) {
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
            byte[] data = this.data.toString().getBytes();
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
     * gets the arraylist of data of the block
     * @return the arraylist of data of the block
     */
    public ArrayList<String> getData(){
        return this.data;
    }

    /**
     * gets the hash value for the block
     * @return the hash value of the block
     */
    public byte[] getHash(){
        return this.hash;
    }

    /**
     * gets the hash value of the previous block
     * @return the hash value of the previous block
     */
    public byte[] getPrevHash(){
        return this.prevHash;
    }

    /**
     * initializes the first block in the chain
     * @return the first block
     */
    public static Block genesisBlock(){
        return new Block(0, new Date(), new ArrayList<String>(Collections.singleton("GENESIS BLOCK")), new byte[]{});
    }

    /**
     * adds a new block to the chain
     * @return the block added
     */
    public static Block newBlock(Block prevBlock, ArrayList<String> votes){
        Integer index = prevBlock.getIndex() + 1;
        Date timestamp = new Date();
        ArrayList<String> data = votes;
        byte[] prevHash = prevBlock.getHash();
        return new Block(index, timestamp, data, prevHash);
    }

}