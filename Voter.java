import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

public class Voter {
    private byte[] voterHash;
    private boolean verified;

    public Voter(String name, String sex, String state, String eyeColor, 
                Integer height, Integer weight, Integer countyNumber, Integer voterId,
                Date dateofBirth, Date issuingDate){
        try {
            MessageDigest encryption = MessageDigest.getInstance("SHA-256");
            // Can be replaced with combining byte arrays
            encryption.update(name.getBytes());
            encryption.update(sex.getBytes());
            encryption.update(state.getBytes());
            encryption.update(eyeColor.getBytes());
            encryption.update(height.toString().getBytes());
            encryption.update(weight.toString().getBytes());
            encryption.update(countyNumber.toString().getBytes());
            encryption.update(voterId.toString().getBytes());
            encryption.update(dateofBirth.toString().getBytes());
            encryption.update(issuingDate.toString().getBytes());
            voterHash = encryption.digest();
            verified = verify();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-256 algorithm not found");
        }
    }
    
    private static boolean verify(){
        // TODO: Check against database
        return false;
    }
}
