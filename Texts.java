/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-23 15:15:09
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 22:06:21
 */

/**
 * A class that contains commonly used Strings.
 */
public class Texts {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String UNDERLINED = "\033[4;37m";
    public static final String BOLD = "\033[1;37m"; 

    public static final String TITLE = "\n\n\t████████╗██████╗ ██╗   ██╗███████╗████████╗     ██████╗  █████╗ ███╗   ███╗███████╗\n"+
                                           "\t╚══██╔══╝██╔══██╗██║   ██║██╔════╝╚══██╔══╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝\n"+
                                           "\t   ██║   ██████╔╝██║   ██║███████╗   ██║       ██║  ███╗███████║██╔████╔██║█████╗  \n"+
                                           "\t   ██║   ██╔══██╗██║   ██║╚════██║   ██║       ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  \n"+
                                           "\t   ██║   ██║  ██║╚██████╔╝███████║   ██║       ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗\n"+
                                           "\t   ╚═╝   ╚═╝  ╚═╝ ╚═════╝ ╚══════╝   ╚═╝        ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝\n\n";

    public static final String WELCOME = "\tWelcome to Trust Game! Now, You have one choice. In front of you is a machine: if\n"+
                                         "\tyou put a coin in the machine, the other player gets three coins – and vice versa.\n"+
                                         "\tYou both can either choose to "+UNDERLINED+"COOPERATE"+RESET+" (put in coin), or "+UNDERLINED+"CHEAT"+RESET+" (don't put in coin).\n\n"+
                                         "\tLet's say the other player "+UNDERLINED+"cheats"+RESET+", and doesn't put in a coin.\n"+
                                         "\tWhat should you do?";

    public static final String MACHINE = "\n\t                          _____________________________                          \n"+
                                           "\t                          ||                          ||                         \n"+
                                           "\t                          ||                          ||                         \n"+
                                           "\t           "+GREEN+"YOU"+RESET+"            ||          "+BOLD+"MACHINE"+RESET+"         ||           "+RED+"BOT"+RESET+"           \n"+
                                           "\t           /|\\           \\||                          ||/          /|\\          \n"+
                                           "\t            |             ||                          ||            |            \n"+
                                           "\t           / \\            ||__________________________||           / \\          \n\n";
    
    public static final String INSTRUCT = "\n\tPlease enter 1 for "+UNDERLINED+"COOPERATE"+RESET+", -1 for "+UNDERLINED+"CHEAT"+RESET+"\n";

    public static final String LOSE1 = "\n\tAlas, turning the other cheek just gets you slapped!\n"+
                                         "\tIf you cooperate & they cheat, you lose a coin while they gain three. (score: -1 vs +3)\n"+
                                         "\tHowever, if you both cheat, neither of you gain or lose anything. (score: 0 vs 0)\n"+
                                         "\tTherefore: you should "+UNDERLINED+"CHEAT."+RESET;

    public static final String LOSE2 = "\n\tExactly! Why let that moocher mooch off of you?\n"+
                                         "\tIf you cooperate & they cheat, you lose a coin while they gain three. (score: -1 vs +3)\n"+
                                         "\tHowever, if you both cheat, neither of you gain or lose anything. (score: 0 vs 0)\n"+
                                         "\tTherefore: you should "+UNDERLINED+"CHEAT."+RESET;

    public static final String Win1 = "\n\tWow, that's mean... and also the correct answer!\n"+
                                        "\tBecause if you both cooperate, you both give up a coin to gain three. (score: +2 vs +2)\n"+
                                        "\tBut if you cheat & they cooperate, you gain three coins at their cost of one. (score: +3 vs -1)\n"+
                                        "\tTherefore: you \"should\" still "+UNDERLINED+"CHEAT."+RESET;

    public static final String Win2 = "\n\tSure, seems like the right thing to do... OR IS IT??\n"+
                                        "\tBecause if you both cooperate, you both give up a coin to gain three. (score: +2 vs +2)\n"+
                                        "\tBut if you cheat & they cooperate, you gain three coins at their cost of one. (score: +3 vs -1)\n"+
                                        "\tTherefore: you \"should\" still "+UNDERLINED+"CHEAT"+RESET;

    public static final String INSTRUCT2 = "\n\tBut let's say the other player cooperates, and puts in a coin.\n"+
                                            "\tWhat should you do now?";

    public static final String CONTINUE = "\n\t(Enter anything to continue): ";

    public static final String REPEAT = "\n\tNow, let's play for real. You'll be playing against 5 different opponents,\n"+
                                          "\teach with their own game \"strategy\". With each opponent, you'll play 7 rounds.\n"+
                                          "\tCan you trust them? Or rather... can they trust you?";

    public static final String FOLLOWER = "\tHello! I start with Cooperate, and afterwards,\n"+
                                          "\tI just copy whatever you did in the last round.";
    
    public static final String MEAN = "\tI always Cheat. The strong shall eat the weak.";

    public static final String NICE = "\tI always Cooperate. Let's be friends!";

    public static final String GAMBLER = "\tListen. I'll start Cooperatin', and keep Cooperatin',\n"+
                                         "\tbut if y'all ever cheat me, I'LL CHEAT YOU BACK 'TIL\n"+
                                         "\tTHE END OF THE WORLD!";

    public static final String DETECTIVE = "\tFirst: I analyze you. I start: Cooperate, Cheat,\n"+
                                           "\tCooperate, Cooperate. If you cheat back, I'll act\n"+
                                           "\tlike FollowerBot. If you never cheat back, I'll act\n"+
                                           "\tlike MeanBot, to exploit you. Elementary, my dear Watson.";

    public static final String ARENA = "\tNow, let's let our bot players play against each other.\n"+
                                       "\tIt's a 3-step dance:\n"+
                                       BOLD+"\n\t1. Play a Tournament\n"+RESET+
                                       "\tLet them all play against each other for 10 times, and tally up their scores.\n"+
                                       BOLD+"\n\t2. Eliminate Losers\n"+RESET+
                                       "\tGet rid of the 5 worst players. (if there's a tie, pick randomly between them)\n"+
                                       BOLD+"\n\t3. Reproduce Winners\n"+RESET+
                                       "\tClone the 5 best players. (if there's a tie, pick randomly between them)";

    public static final String ARENARESULT = "\n\t"+BLUE+"FollowerBot"+RESET+" did not win at first – but at least they didn't do as bad as "+GREEN+"NiceBot.\n"+RESET+
                                             "\tBut after all the "+GREEN+"NiceBot"+RESET+" are dead, the "+RED+"MeanBot"+RESET+" became a victim of their own success!\n\n"+
                                             "\tThey exploited the naive "+GREEN+"NiceBot"+RESET+", but once they ran out of them, they had to face\n"+
                                             "\tthe "+BLUE+"Followers"+RESET+": who are nice, but not naive.\n\n"+
                                             "\tBy simply copying the other player's moves, "+BLUE+"FollowerBot"+RESET+" can play nice with each other,\n"+
                                             "\twhile "+RED+"MeanBot"+RESET+" just cheat themselves! Not only that, but it also means "+BLUE+"FollowerBot can give\n"+RESET+
                                             "\t"+RED+"MeanBot"+RESET+" a taste of their own medicine.\n\n"+
                                             "\tSo, in the long run, "+BLUE+"FollowerBot"+RESET+" wins! "+RED+"MeanBot"+RESET+" may have won in the short run, but its\n"+
                                             "\texploitativeness was its downfall.\n\n";

    public static final String END = "\n\t"+BOLD+"Acknowledgement:\n"+RESET+
                                     "\tThank you for trying out the game. The original version of this game, called\n"+
                                     "\t\"The Evolution of Trust\" was created by one of my favorite programmers called Nicky Case.\n"+
                                     "\tYou can try out his masterpiece here: https://ncase.me/trust/ \n\n"+
                                     "\t"+BOLD+"What's Next?\n"+RESET+
                                     "\t1. You can play against bots again by typing \"java Main -c\" in the console\n"+
                                     "\t2. You can let bots play against each other with customized parameters in\n"+
                                     "\t\"settings.txt\" and \"players.txt\" again by typing \"java Main -a\" in the console\n";

    /**
     * Returns the MACHINE string with specific color on opponents "BOT" head. 
     * @param color the color of "BOT" head
     * @return customized MACHINE string
     */
    public static String getMachine(String color) {
        return "\n\t                          _____________________________                          \n"+
        "\t                          ||                          ||                         \n"+
        "\t                          ||                          ||                         \n"+
        "\t           "+GREEN+"YOU"+RESET+"            ||          "+BOLD+"MACHINE"+RESET+"         ||           "+color+"BOT"+RESET+"           \n"+
        "\t           /|\\           \\||                          ||/          /|\\          \n"+
        "\t            |             ||                          ||            |            \n"+
        "\t           / \\            ||__________________________||           / \\          \n\n";
    }                                      
    public static void main(String[] args) {
        TrustGame.clearConsole();
        System.out.println(TITLE);
        System.out.println(MACHINE);
        System.out.println(WELCOME);
    }
}
