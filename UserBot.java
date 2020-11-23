/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 17:31:11
 */

import java.util.*;

public class UserBot extends FollowerBot {
    
    UserBot() {
        super();
        name = "User";
        color = Texts.RESET; //Bold White
    }

    @Override
    public int move(int key) {
        Scanner userInput = new Scanner(System.in);
        String decision = userInput.next();
        if (decision.equals("1") || decision.equals("-1")) {
            return Integer.parseInt(decision);
        } else {
            return 1;
        }
    }
}