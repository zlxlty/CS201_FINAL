/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 11:56:08
 */

import java.util.*;

public class AlterBot extends FollowerBot {
    
    AlterBot() {
        super();
        name = "AlterBot";
        color = "\u001B[35m"; //purple
    }

    @Override
    public int move(int key) {
        List<Integer> selfRecord = selfRecords.get(key);
        if (selfRecord==null) {
            return 1;
        } else {
            return -1*selfRecord.get(selfRecord.size()-1);
        }
    }
}