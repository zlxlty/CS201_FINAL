/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 17:31:55
 */

import java.util.*;

public class MeanBot extends FollowerBot {
    
    MeanBot() {
        super();
        name = "MeanBot";
        color = Texts.RED; //Red
    }

    @Override
    public int move(int key) {
        return -1;
    }
}