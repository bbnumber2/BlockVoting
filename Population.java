import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public final class Population {
    private static ArrayList<String> names;
    private static ArrayList<String> sexes;
    private static ArrayList<String> states;
    private static ArrayList<String> eyeColors;
    private static ArrayList<Integer> heights;
    private static ArrayList<Integer> weights;
    private static ArrayList<Integer> countyNumbers;
    private static ArrayList<Integer> voterIds;
    private static ArrayList<Date> dateOfBirths;
    private static ArrayList<Date> issuingDates;

    private static Random random = new Random();

    private static ArrayList<Voter> population;

    public Population(){
        generateNames();
        generateSexes();
        generateStates();
        generateEyeColors();
        generateHeights();
        generateWeights();
        generateCountyNumbers();
        generateVoterIds();
        generateDateOfBirths();
        generateIssuingDates();

        generatePopulation();
    }

    private void generatePopulation() {
        generatePopulation(100_000);
    }

    private void generatePopulation(int populationSize) {
        System.out.println("Generating population!");
        population = new ArrayList<Voter>();
        for(int i = 0; i < populationSize; i++){
            String name = names.get(random.nextInt(names.size()));
            String sex = sexes.get(random.nextInt(sexes.size()));
            String state = states.get(random.nextInt(states.size()));
            String eyeColor = eyeColors.get(random.nextInt(eyeColors.size()));
            Integer height = heights.get(random.nextInt(heights.size()));
            Integer weight = weights.get(random.nextInt(weights.size()));
            Integer countyNumber = countyNumbers.get(random.nextInt(countyNumbers.size()));
            Integer voterId = voterIds.get(random.nextInt(voterIds.size()));
            Date dateOfBirth = dateOfBirths.get(random.nextInt(dateOfBirths.size()));
            Date issuingDate = issuingDates.get(random.nextInt(issuingDates.size()));
            population.add(new Voter(name, sex, state, eyeColor, height, weight, countyNumber, voterId, dateOfBirth, issuingDate));
        }
    }

    public ArrayList<Voter> getPopulation(){
        return population;
    }

    private void generateIssuingDates() {
        System.out.println("Generating issuing dates!");
        issuingDates = new ArrayList<Date>();
        for(int year = 0; year <= 103; year++){
            for(int month = 1; month < 13; month++){
                for(int date = 1; date < 32; date++){
                    issuingDates.add(new Date(year, month, date));
                }
            }
        }
    }

    private void generateDateOfBirths() {
        System.out.println("Generating date of births!");
        dateOfBirths = new ArrayList<Date>();
        for(int year = 0; year <= 103; year++){
            for(int month = 1; month < 13; month++){
                for(int date = 1; date < 32; date++){
                    dateOfBirths.add(new Date(year, month, date));
                }
            }
        }
    }

    private void generateVoterIds() {
        System.out.println("Generating voter IDs!");
        voterIds = new ArrayList<Integer>();
        for(int i = 100_000; i < 999_999; i++){
            voterIds.add(i);
        }
    }

    private void generateCountyNumbers() {
        System.out.println("Generating county numbers!");
        countyNumbers = new ArrayList<Integer>();
        for(int i = 1; i < 101; i++){
            countyNumbers.add(i);
        }
    }

    private void generateWeights() {
        System.out.println("Generating weights!");
        weights = new ArrayList<Integer>();
        for(int i = 45; i < 137; i++){
            weights.add(i);
        }
    }

    private void generateHeights() {
        System.out.println("Generating heights!");
        heights = new ArrayList<Integer>();
        for(int i = 120; i < 213; i++){
            heights.add(i);
        }
    }

    private void generateEyeColors() {
        System.out.println("Generating eye colors!");
        eyeColors = new ArrayList<String>();
        eyeColors.add("Brown");
        eyeColors.add("Blue");
        eyeColors.add("Green");
        eyeColors.add("Gray");
        eyeColors.add("Other");
    }

    private void generateStates() {
        System.out.println("Generating states!");
        states = new ArrayList<String>();
        File statesFile = new File("states.txt");
        try {
            Scanner scanner = new Scanner(statesFile);
            while(scanner.hasNextLine()){
                states.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error loading states!");
        }
    }

    private void generateSexes() {
        System.out.println("Generating sexes!");
        sexes = new ArrayList<String>();
        sexes.add("Male");
        sexes.add("Female");
    }

    private void generateNames(){
        System.out.println("Generating names!");
        names = new ArrayList<String>();
        File nameFile = new File("names.txt");
        try {
            Scanner scanner = new Scanner(nameFile);
            while(scanner.hasNextLine()){
                names.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error loading names!");
        }
    }
}
