import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Voter {
    private byte[] voterHash;
    private boolean verified;

    public Voter(String name, String sex, String state, String eyeColor, 
                Integer height, Integer weight, Integer countyNumber, Integer voterId,
                Date dateOfBirth, Date issuingDate){
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
            encryption.update(dateOfBirth.toString().getBytes());
            encryption.update(issuingDate.toString().getBytes());
            voterHash = encryption.digest();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-256 algorithm not found");
        }
    }

    public byte[] getHash(){
        return voterHash;
    }
    
    public boolean verify(Database database){
        return database.contains(voterHash);
    }
}
