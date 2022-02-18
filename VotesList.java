
import java.util.ArrayList;
import java.util.Collections;

public class VotesList {
    private ArrayList<String> votes;
    private ArrayList<String> items;
    private int numVotes;
    private int numItems;

    public VotesList(){
        votes = new ArrayList<String>();
        items = new ArrayList<String>();
        numVotes = 0;
        numItems = 0;
    }

    public ArrayList<String> getVotes(){
        return votes;
    }

    public void addItem(String i){
        if(!items.contains(i)) {
            items.add(i.toLowerCase());
            numItems++;
        }
        else {
            System.out.println("Item already on ballot! Please try again.");
        }
    }

    public void addVote(String v){
        if(items.contains(v.toLowerCase())){
            votes.add(v);
            numVotes++;
        }
        else{
            System.out.println("Item not on ballot! Please try again.");
        }
    }

    public void shuffleVotes(){
        Collections.shuffle(votes);
    }

    public ArrayList<String> getItems(){
        return items;
    }

    public int countVotes(String v){
        int count = 0;
        for(String i : votes) {
            if(v.toLowerCase().equals(i)){
                count++;
            }
        }
        return count;
    }

    public int getTotalVotes(){
        return numVotes;
    }

    public int getTotalItems(){
        return numItems;
    }

    public void removeItem(String i){
        items.remove(i);
        numItems--;
    }

    public void removeLastVote(){
        votes.remove(votes.size()-1);
        numVotes--;
    }

    public void removeAllVotes(String v){
        for(String i : votes){
            if(i.equals(v)){
                votes.remove(v);
                numVotes--;
            }
        }
    }

}
