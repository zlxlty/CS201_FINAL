/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-22 17:45:33
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 19:40:49
 */

import java.util.*;

@FunctionalInterface
interface BotConstructor {
    public Bot construct();
}

/**
 * A class that contains a map to map the name of the bot to its constructor.
 * In this way, we can create any bot we want just by providing its name.
 */
public class BotMap {
    private Map<String, BotConstructor> botMap;
    
    public BotMap() {
        botMap = new HashMap<String, BotConstructor>();

        botMap.put("FollowerBot", FollowerBot::new);
        botMap.put("AlterBot", AlterBot::new);
        botMap.put("GamblerBot", GamblerBot::new);
        botMap.put("NiceBot", NiceBot::new);
        botMap.put("MeanBot", MeanBot::new);
        botMap.put("DetectiveBot", DetectiveBot::new);

    }

    /**
     * Creates a bot corresponding to the name.
     * @param name the name of the bot to be created
     * @return bot
     */
    public Bot getBot(String name) {
        Bot newBot = botMap.get(name).construct();
        return newBot;
    }
}
