/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 17:30:48
 */

import java.util.*;

public class DetectiveBot extends FollowerBot {
    
    DetectiveBot() {
        super();
        name = "DetectiveBot";
        color = Texts.BOLD; // Bold cyan high intensity
    }

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