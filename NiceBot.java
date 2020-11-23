/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 20:14:31
 */

import java.util.*;

public class NiceBot extends FollowerBot {
    
    NiceBot() {
        super();
        name = "NiceBot";
        color = Texts.GREEN; //Green
    }

    /**
     * Always cooperate bot
     * @param key
     * @return 1
     */
    @Override
    public int move(int key) {
        return 1;
    }
}