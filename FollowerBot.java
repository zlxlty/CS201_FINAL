/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 17:31:22
 */

import java.util.*;

public class FollowerBot implements Bot {

    protected String name;
    protected String color;
    
    protected int score;
    protected Map<Integer, List<Integer>> oppoRecords;
    protected Map<Integer, List<Integer>> selfRecords;

    public FollowerBot() {
        score = 0;
        name = "FollowerBot";
        color = Texts.BLUE; //blue
        oppoRecords = new HashMap<Integer, List<Integer>>();
        selfRecords = new HashMap<Integer, List<Integer>>();
    }

    @Override
    public void changeScore(int n) {
        score += n;
    }

    @Override
    public void clearRecord() {
        score = 0;
        oppoRecords.clear();
        selfRecords.clear();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public List<Integer> getOppoRecords(int key) {
        return oppoRecords.get(key);
    }

    @Override
    public List<Integer> getSelfRecords(int key) {
        return selfRecords.get(key);
    }

    @Override
    public int move(int key) {
        List<Integer> oppoRecord = oppoRecords.get(key);

        if (oppoRecord==null) {
            return 1;
        } else {
            return oppoRecord.get(oppoRecord.size()-1);
        }
    }

    @Override
    public void addOppoRecord(int key, int decision) {
        if (oppoRecords.get(key)==null) {
            oppoRecords.put(key, new LinkedList<Integer>());
        }

        oppoRecords.get(key).add(decision);
    }

    @Override
    public void addSelfRecord(int key, int decision) {
        if (selfRecords.get(key)==null) {
            selfRecords.put(key, new LinkedList<Integer>());
        }

        selfRecords.get(key).add(decision);
    }

    @Override
    public int compareTo(Bot player2) {
        return this.score - player2.getScore();
    }
}
