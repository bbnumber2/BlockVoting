import java.util.ArrayList;

public class Blockchain{
    ArrayList<Block> blockchain;

    public Blockchain(){
        this.blockchain = new ArrayList<Block>();

    }

    /**
     * Adds the given block to the blockchain
     * @param block The block to be added
     */
    public void add(Block block){
        blockchain.add(block);
        if(verify()){
            System.out.println("Verified!");
        } else{
            // TODO: Handle failed verification
            System.out.println("Failed to verify! Removing.");
            blockchain.remove(block);
        }
    }

    /**
     * Verifies that each block in the blockchain is valid
     * @return A boolean corresponding to validity (valid/invalid)
     */
    private boolean verify(){
        byte[] prevHash = this.blockchain.get(0).getHash();
        for(Block block : this.blockchain.subList(1, this.blockchain.size())){
            if(!block.getPrevHash().equals(prevHash)){
                return false;
            }
            prevHash = block.getHash();
        }
        return true;
    }
}