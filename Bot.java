/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:08:44
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 10:54:00
 */

import java.util.*;

public interface Bot extends Comparable<Bot>{
    /**
     * Makes decision for the match.
     * 1 for putting the coin, -1 for holding the coin.
     * @return 1 or -1
     */
    public int move(int key);

    public void addOppoRecord(int key, int decision);

    public void addSelfRecord(int key, int decision);

    public String getName();

    public int getScore();

    public String getColor();

    public void changeScore(int n);

    public void clearRecord();

    public List<Integer> getOppoRecords(int key);

    public List<Integer> getSelfRecords(int key);

    public int compareTo(Bot player2);
}
