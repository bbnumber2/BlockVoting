import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.EncryptedPrivateKeyInfo;

public class Block{
    public Block(int index, Date timestamp, String data, MessageDigest prevHash){
        // TODO: Add code
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