/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:15:08
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 19:16:01
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class TrustGame {
    public final String RESET = "\u001B[0m";
    public final int MAXUPDATE = 20;
    
    private Map<String, Integer> settings;
    private Map<String, Integer> pSettings;
    private List<Bot> players;
    private BotMap botMap;

    TrustGame(String fileName) {
        
        players = new ArrayList<Bot>();
        botMap = new BotMap();
        settings = new HashMap<String, Integer>();
        pSettings = new HashMap<String, Integer>();
        // rewards = new HashMap<String, Integer>();

        //Default settings
        settings.put("numMatches", 10);
        settings.put("numUpdates", 5);
        settings.put("win1", 3);
        settings.put("lose1", -1);
        settings.put("win2", 2);
        settings.put("lose2", 0);
        
        if (fileName!=null) {
            fileToMap(fileName, settings);
        }
    }

    public void loadPlayers(String fileName) {

        //Default Player Settings
        pSettings.put("FollowerBot", 1);
        pSettings.put("MeanBot", 1);
        pSettings.put("NiceBot", 22);
        pSettings.put("GamblerBot", 0);
        pSettings.put("DetectiveBot", 0);

        if (fileName!=null) {
            fileToMap(fileName, pSettings);
        }

        for (String key : pSettings.keySet()) {
            for (int i=0; i < pSettings.get(key); i++) {
                players.add(botMap.getBot(key));
            }
        }
    }

    public void fileToMap(String fileName, Map<String, Integer> map) { 
        try (Scanner fileInput = new Scanner(new File(fileName))) {
            while (fileInput.hasNextLine()) {
                String newLine = fileInput.nextLine();
                String[] keyValue = newLine.split("\\s+");
            
                if (map.containsKey(keyValue[0])) {
                    System.out.println(keyValue[0]+":"+keyValue[1]+"/");
                    map.put(keyValue[0], Integer.parseInt(keyValue[1]));
                }
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
    }

    public void printScores() {
        System.out.println("\t--------------------------");
        players.forEach(p->System.out.println("\t"+p.getName()+": "+p.getScore()+" coins"));
        System.out.println("\t--------------------------");
    }

    public void printPlayers() {
        List<String> seen = new LinkedList<String>();
        for (Bot player : players) {
            if (!seen.contains(player.getName())) {
                System.out.println("\t\t"+player.getColor()+"* "+player.getName()+"\t"+player.getScore()+RESET);
                seen.add(player.getName());
            }
        }
    }

    public void introduceBots() {
        String[] bots = {"FollowerBot", 
                         "MeanBot",
                         "NiceBot", 
                         "GamblerBot", 
                         "DetectiveBot"};

        String[] descriptions = {Texts.FOLLOWER,
                                 Texts.MEAN,
                                 Texts.NICE,
                                 Texts.GAMBLER,
                                 Texts.DETECTIVE};

        System.out.println("\n\tNow, lets meet our opponents:\n");

        for (int i = 0; i < 5; i++) {
            Bot player = botMap.getBot(bots[i]);
            System.out.println("\t"+player.getColor()+"* "+player.getName()+Texts.RESET);
            System.out.println(descriptions[i]+"\n");
        }
        
    }

    public void clearAllRecords() {
        players.forEach(p->p.clearRecord());
    }

    public boolean hasWinner() {
        if (players.size() == 0) {
            return false;
        }

        String firstName = players.get(0).getName();

        for (Bot player : players) {
            if (player.getName() != firstName) {
                return false;
            }
        }

        return true;
    }

    public String getWinner() {
        if (hasWinner()) {
            return players.get(0).getName();
        } else {
            return "Nobody";
        }
    }

    public int getSize() {
        return players.size();
    }

    public Stack<String> toStringStack() {
        Stack<String> colorStack = new Stack<String>();
        for (Bot player: players) {
            colorStack.push(player.getColor());
        }

        Collections.sort(colorStack);

        return colorStack;
    }

    public void match(int index1, int index2) {
        Bot player1 = players.get(index1);
        Bot player2 = players.get(index2);

        int result1 = player1.move(index2);
        int result2 = player2.move(index1);

        List<String> results = Arrays.asList("win2", "win2");

        player1.addOppoRecord(index2, result2);
        player1.addSelfRecord(index2, result1);
        player2.addOppoRecord(index1, result1);
        player2.addSelfRecord(index1, result2);

        if (result1 == -1 && result2 == -1) {
            results.set(0, "lose2");
            results.set(1, "lose2");
        } else if (result1 == 1 && result2 == -1) {
            results.set(0, "lose1");
            results.set(1, "win1");
        } else if (result1 == -1 && result2 == 1) {
            results.set(0, "win1");
            results.set(1, "lose1");
        }

        player1.changeScore((int)settings.get(results.get(0)));
        player2.changeScore((int)settings.get(results.get(1)));
    }

    public int matchUser(String botName) {
        int score;
        Scanner userInput = new Scanner(System.in);
        players.add(new UserBot());
        players.add(botMap.getBot(botName));


        for (int i = 0; i<7; i++) {
            System.out.print("\tYour Decision: ");
            match(0, 1);
            printScores();
        }

        score = players.get(0).getScore();

        players.clear();

        return score;
    }

    public void matches() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = i+1; j < players.size(); j++) {
                for (int k = 0; k < settings.get("numMatches"); k++) match(i, j);
            }
        }
    }

    public void update() {
        Collections.shuffle(players);
        Collections.sort(players);

        
        for (int i = 0; i < settings.get("numUpdates"); i++) {
            String winnerName = players.get(players.size()-1-i).getName();
            Bot newPlayer = botMap.getBot(winnerName); //NOTE: using functional interface and method reference
            players.set(i, newPlayer);
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush(); //clean the console for clearer outputs
    }

    public void sleep(int n) {
        try {
            TimeUnit.MILLISECONDS.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
