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
     * Default constructor for a block.
     * Should not be called explicitly.
     * Use the provided addBlock method to ensure hash consistency
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
     * Combines any number of byte arrays
     * @param arrays The byte arrays to be combined
     * @return The combined byte array
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
     * Generates a hash for the current block
     * @return The hash generated
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
            System.out.println("Error: SHA-256 Algorithm not found!");
        }
        return null;
    }

    /**
     * Gets the index of the block
     * @return The index of the block
     */
    public Integer getIndex(){
        return this.index;
    }

    /**
     * Gets the timestamp of the block
     * @return The timestamp of the block
     */
    public Date getTimestamp(){
        return this.timestamp;
    }

    /**
     * Gets the arraylist of data of the block
     * @return The arraylist of data of the block
     */
    public ArrayList<String> getData(){
        return this.data;
    }

    /**
     * Gets the hash value for the block
     * @return The hash value of the block
     */
    public byte[] getHash(){
        return this.hash;
    }

    /**
     * Gets the hash value of the previous block
     * @return The hash value of the previous block
     */
    public byte[] getPrevHash(){
        return this.prevHash;
    }

    /**
     * Initializes the first block in the chain
     * @return The first block
     */
    public static Block genesisBlock() {
        return new Block(0, new Date(), new ArrayList<String>(Collections.singleton("GENESIS BLOCK")), new byte[]{});
    }

    /**
     * Adds a new block to the chain
     * @return The block added
     */
    public static Block newBlock(Block prevBlock, ArrayList<String> votes){
        Integer index = prevBlock.getIndex() + 1;
        Date timestamp = new Date();
        ArrayList<String> data = votes;
        byte[] prevHash = prevBlock.getHash();
        return new Block(index, timestamp, data, prevHash);
    }
}