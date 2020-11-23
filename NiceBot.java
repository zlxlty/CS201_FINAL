/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 17:31:47
 */

import java.util.*;

public class NiceBot extends FollowerBot {
    
    NiceBot() {
        super();
        name = "NiceBot";
        color = Texts.GREEN; //Green
    }

    @Override
    public int move(int key) {
        return 1;
    }
}