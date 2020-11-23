/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 20:14:15
 */

import java.util.*;

public class MeanBot extends FollowerBot {
    
    MeanBot() {
        super();
        name = "MeanBot";
        color = Texts.RED; //Red
    }

    /**
     * Always cheat bot
     * @param key
     * @return -1
     */
    @Override
    public int move(int key) {
        return -1;
    }
}