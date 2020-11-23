/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-22 17:45:33
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 11:58:41
 */

import java.util.*;

@FunctionalInterface
interface BotConstructor {
    public Bot construct();
}

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

    public Bot getBot(String name) {
        Bot newBot = botMap.get(name).construct();
        return newBot;
    }
}
