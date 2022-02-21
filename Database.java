import java.util.HashSet;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Database{
    HashSet<byte[]> database;

    public Database(){
        database = new HashSet<byte[]>();
    }

    public void addPerson(byte[] voterHash){
        database.add(voterHash);
    }

    public boolean contains(byte[] voterHash){
        return database.contains(voterHash);
    }

    public int getTotal(){
        return database.size();
    }

    public void save() throws IOException{
        save("database.txt");
    }

    public void save(String filename) throws IOException{
        File file = new File(filename);
        FileWriter writer = new FileWriter(file);
        for(byte[] voterHash : database){
            writer.write(voterHash.toString() + "\n");
        }
        writer.close();
    }

    public void load() throws IOException{
        load("database.txt");
    }

    public void load(String filename) throws IOException{
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            database.add(scanner.nextLine().getBytes());
        }
        scanner.close();
    }

}
