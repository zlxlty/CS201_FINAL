/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-23 11:42:33
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 20:13:49
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        if (args.length==1) {
            if (args[0].equals("-c")) {
                competeMode();
            } else if (args[0].equals("-a")) {
                arenaMode(userInput, true);
            } else {
                System.out.println("Invalid parameter");
                System.out.println("Please Choose From:");
                System.out.println("\tjava Main");
                System.out.println("\tjava Main -c");
                System.out.println("\tjava Main -a");
            }
        } else {
            storyMode(userInput);
        }
    }

    /**
     * Full game experience.
     * @param userInput
     */
    public static void storyMode(Scanner userInput) {

        TrustGame.clearConsole();
        System.out.println(Texts.TITLE);
        System.out.println(Texts.MACHINE);
        System.out.println(Texts.WELCOME);
        System.out.println(Texts.INSTRUCT);

        int result = getDecision(userInput);

        if (result == 1) {
            System.out.println(Texts.LOSE1);
        } else {
            System.out.println(Texts.LOSE2);
        }

        System.out.print(Texts.CONTINUE);
        userInput.next();

        TrustGame.clearConsole();
        System.out.println(Texts.TITLE);
        System.out.println(Texts.MACHINE);
        System.out.println(Texts.INSTRUCT2);
        System.out.println(Texts.INSTRUCT);

        result = getDecision(userInput);

        if (result == 1) {
            System.out.println(Texts.Win2);
        } else {
            System.out.println(Texts.Win1);
        }

        System.out.print(Texts.CONTINUE);
        userInput.next();

        TrustGame.clearConsole();
        System.out.println(Texts.TITLE);
        System.out.println(Texts.REPEAT);

        System.out.print(Texts.CONTINUE);
        userInput.next();

        competeMode();

        System.out.print(Texts.CONTINUE);
        userInput.next();

        arenaMode(userInput, false);

        System.out.print(Texts.CONTINUE);
        userInput.next();
        
        TrustGame.clearConsole();
        System.out.println(Texts.TITLE);
        System.out.println(Texts.ARENARESULT);

        System.out.print(Texts.CONTINUE);
        userInput.next();

        TrustGame.clearConsole();
        System.out.println(Texts.TITLE);
        System.out.println(Texts.END);
    }

    /**
     * Lets user fight with five kinds of bots.
     */
    public static void competeMode() {
        TrustGame game = new TrustGame(null);
        String[] opponents = {"FollowerBot", 
                              "MeanBot",
                              "NiceBot", 
                              "GamblerBot", 
                              "DetectiveBot"};

        String[] colors = {Texts.BLUE,
                           Texts.RED,
                           Texts.GREEN,
                           Texts.YELLOW,
                           Texts.BOLD};
        
        int totalScore = 0;
        for (int i=0; i<opponents.length; i++) {
            TrustGame.clearConsole();
            System.out.println(Texts.TITLE);
            System.out.println(Texts.getMachine(colors[i]));
            System.out.println(colors[i]+"\tOpponent ["+(i+1)+"]"+Texts.RESET);
            System.out.println("\t"+"Total Scores: "+totalScore+"\n");
            totalScore += game.matchUser(opponents[i]);
        }

        TrustGame.clearConsole();
        System.out.println(Texts.TITLE);
        System.out.println("\tYour Final Score is: "+totalScore+"\n");

        System.out.println("\tThe Minimum scores you can get is 9.");
        System.out.println("\tThe Maximum scores you can get is 65.");

        game.introduceBots();
    }

    /**
     * Lets different kinds of bot fight with each other under customized settings.
     * @param userInput
     * @param fileIn whether to load settings from files.
     */
    public static void arenaMode(Scanner userInput, boolean fileIn) {
        String settingSrc = fileIn ? "settings.txt" : null;
        String playerSrc = fileIn ? "players.txt" : null;

        TrustGame game = new TrustGame(settingSrc);
        
        game.loadPlayers(playerSrc);

        Circle circle = new Circle((int)game.getSize()/3, game.getSize());

        TrustGame.clearConsole();
        System.out.println(Texts.TITLE);
        System.out.println(Texts.ARENA);

        
        circle.draw(game.toStringStack());
        game.printPlayers();
        System.out.println("\t\t* Nobody\n");
        
        System.out.print("\tWho do you think will be the winner: ");
        String guess = userInput.next();
        TrustGame.clearConsole();

        for (int i = 0; i < game.MAXUPDATE && !game.hasWinner(); i++) {
            System.out.println(Texts.TITLE);
            System.out.println("\tROUND "+(i+1)+"\n");
            circle.draw(game.toStringStack());
            game.matches();
            game.printPlayers();
            game.update();
            // game.printScores();
            game.sleep(1500);
            game.clearAllRecords();
            TrustGame.clearConsole();
        }

        System.out.println(Texts.TITLE);
        System.out.println("\tEND!\n");
        circle.draw(game.toStringStack());
        
        System.out.println("\tThe Winner is: "+game.getWinner());
        if (guess.toLowerCase().equals(game.getWinner().toLowerCase())) {
            System.out.println("\tYou Guess is correct!");
        } else {
            System.out.println("\tYou Guess is wrong!");
        }
    }

    /**
     * Gets users decision and return 1 or -1
     * @param userInput
     * @return 1 or -1
     */
    private static int getDecision(Scanner userInput) {
        String decision = "";
        while (!decision.equals("1") && !decision.equals("-1")){
            System.out.print("\tYour Decision: ");
            decision = userInput.next();
        }

        return Integer.parseInt(decision);
    }

}
