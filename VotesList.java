
import java.util.ArrayList;
import java.util.Collections;

public class VotesList {
    private final ArrayList<String> votes;
    private final ArrayList<String> items;
    private int numVotes;
    private int numItems;

    // This is the constructor for the class. It initializes the votes and items lists, and sets the number of votes and
    // items to 0.
    public VotesList(){
        votes = new ArrayList<String>();
        items = new ArrayList<String>();
        numVotes = 0;
        numItems = 0;
    }

    /**
     * Returns the list of votes
     *
     * @return An ArrayList of Strings.
     */
    public ArrayList<String> getVotes(){
        return votes;
    }

    /**
     * Add an item to the ballot if it's not already on the ballot
     *
     * @param i the item to be added to the ballot.
     */
    public void addItem(String i){
        if(!items.contains(i)) {
            items.add(i.toLowerCase());
            numItems++;
        }
        else {
            System.out.println("Item already on ballot! Please try again.");
        }
    }

    /**
     * Add the given vote to the list of votes
     *
     * @param v the item to be added to the ballot.
     */
    public void addVote(String v){
        if(items.contains(v.toLowerCase())){
            votes.add(v);
            numVotes++;
        }
        else{
            System.out.println("Item not on ballot! Please try again.");
        }
    }

    /**
     * Shuffle the votes array
     */
    public void shuffleVotes(){
        Collections.shuffle(votes);
    }

    /**
     * Returns the items on the ballot
     *
     * @return An ArrayList of Strings.
     */
    public ArrayList<String> getItems(){
        return items;
    }

    /**
     * Given a string, count the number of times that string appears in the list of votes
     *
     * @param v the name of the vote to count
     * @return The number of votes for the given answer.
     */
    public int countVotes(String v){
        int count = 0;
        for(String i : votes) {
            if(v.toLowerCase().equals(i)){
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the total number of votes cast in the election
     *
     * @return The number of votes.
     */
    public int getTotalVotes(){
        return numVotes;
    }

    /**
     * Returns the total number of items on the ballot
     *
     * @return The number of items on the ballot.
     */
    public int getTotalItems(){
        return numItems;
    }

    /**
     * Remove the item from the ballot
     *
     * @param i the item to be removed
     */
    public void removeItem(String i){
        items.remove(i);
        numItems--;
    }

    /**
     * Remove the last vote from the list of votes
     */
    public void removeLastVote(){
        votes.remove(votes.size()-1);
        numVotes--;
    }

    /**
     * Remove all votes for a given item
     *
     * @param v the name of the vote to remove
     */
    public void removeAllVotes(String v){
        for(String i : votes){
            if(i.equals(v)){
                votes.remove(v);
                numVotes--;
            }
        }
    }

}
