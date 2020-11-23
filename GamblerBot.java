/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 20:15:04
 */

import java.util.*;

public class GamblerBot extends FollowerBot {
    
    GamblerBot() {
        super();
        name = "GamblerBot";
        color = Texts.YELLOW; //Yellow
    }

    /**
     * Cooperate first. If opponent cheat once, always cheat til the end.
     * @param key
     * @return
     */
    @Override
    public int move(int key) {
        List<Integer> oppoRecord = oppoRecords.get(key);
        if (oppoRecord==null || !oppoRecord.contains(-1)) {
            return 1;
        } else {
            return -1;
        }
    }
}