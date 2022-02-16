import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;



public class Block{
    private Integer index;
    private Date timestamp;
    private String data;
    private byte[] prevHash;
    private byte[] hash;

    /**
     * default constructor for a block
     * @param index
     * @param timestamp
     * @param data
     * @param prevHash
     */
    public Block(Integer index, Date timestamp, String data, byte[] prevHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.prevHash = prevHash;
        this.hash = hashblock();
    }

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

    private byte[] hashblock(){
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


    public static  Block genesisBlock(){
        // TODO: Add code
    }


    public static Block newBlock(){
        // TODO: Add code
    }

}