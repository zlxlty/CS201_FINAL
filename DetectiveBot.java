/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 20:16:45
 */

import java.util.*;

public class DetectiveBot extends FollowerBot {
    
    DetectiveBot() {
        super();
        name = "DetectiveBot";
        color = Texts.BOLD; // Bold cyan high intensity
    }

    /**
     * Starts by 1, -1, 1, 1. If opponent cheat in first four step, use FollowerBot strategy.
     * If opponent doesn't cheat in first four step. user MeanBot strategy.
     * @param key
     * @return
     */
    @Override
    public int move(int key) {
        int[] startMove = {-1, 1, 1};
        List<Integer> oppoRecord = oppoRecords.get(key);

        if (oppoRecord == null) {
            return 1;
        }
        
        if (oppoRecord.size() < 4) {
            return startMove[oppoRecord.size()-1];
        } else {
            if (oppoRecord.contains(-1)) {
                return oppoRecord.get(oppoRecord.size()-1);
            } else {
                return -1;
            }
        }
    }
}