/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:08:44
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 19:59:35
 */

import java.util.*;

public interface Bot extends Comparable<Bot>{

    /**
     * Makes decision for the match.
     * 1 for putting the coin (Cooperate), -1 for holding the coin (Cheat).
     * @param key the position of the current opponent
     * @return 1 or -1
     */
    public int move(int key);

    /**
     * Adds the previous decision of the current opponent to OppoRecords
     * @param key
     * @param decision
     */
    public void addOppoRecord(int key, int decision);

    /**
     * Adds the previous decision of the current bot to SelfRecords
     * @param key
     * @param decision
     */
    public void addSelfRecord(int key, int decision);

    public String getName();

    public int getScore();

    public String getColor();

    /**
     * Increases the score by certain amount.
     * @param n amount of increase
     */
    public void changeScore(int n);

    /**
     * Clear both OppoRecords and SelfRecords
     */
    public void clearRecord();

    public List<Integer> getOppoRecords(int key);

    public List<Integer> getSelfRecords(int key);

    public int compareTo(Bot player2);
}
