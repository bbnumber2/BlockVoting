import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.EncryptedPrivateKeyInfo;

public class Block{
    private int index;
    private Date timestamp;
    private String data;
    private MessageDigest prevHash;
    private MessageDigest hash;

    /**
     * default constructor for a block
     * @param index
     * @param timestamp
     * @param data
     * @param prevHash
     */
    public Block(int index, Date timestamp, String data, MessageDigest prevHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.prevHash = prevHash;
        this.hash = hashblock();
    }


    private MessageDigest hashblock(){
        try {
            MessageDigest encryption = MessageDigest.getInstance("SHA-256");
            
        } catch (NoSuchAlgorithmException e) {
            //TODO: handle exception
        }
        
    }


    public static  Block genesisBlock(){
        // TODO: Add code
    }


    public static Block newBlock(){
        // TODO: Add code
    }

}