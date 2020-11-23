/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 17:31:36
 */

import java.util.*;

public class GamblerBot extends FollowerBot {
    
    GamblerBot() {
        super();
        name = "GamblerBot";
        color = Texts.YELLOW; //Yellow
    }

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