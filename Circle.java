/*
 * @Author: Tianyi Lu
 * @Description: 
 * @Date: 2020-11-21 17:17:23
 * @LastEditors: Tianyi Lu
 * @LastEditTime: 2020-11-23 18:17:49
 */
import java.util.*;

class Circle {

    private int radius;
    private int numPoints;
    private List<List<Integer>> coordinates;
    private final String RESET = "\u001B[0m";

    public Circle(int radius, int numPoints) {
        this.radius = radius;
        this.numPoints = numPoints;
        coordinates = new ArrayList<List<Integer>>();
    }

    public void draw(Stack<String> colorStack) {
        for (int i=1; i <= numPoints; i++) {
            long x = Math.round(radius * Math.cos(i*2*Math.PI/numPoints));
            long y = Math.round(radius * Math.sin(i*2*Math.PI/numPoints));
            coordinates.add(Arrays.asList((int) x,(int) y));
        }

        int size = radius+1;
        for (int j=-size; j <= size; j++) {
            for (int i=-size; i <= size; i++) {
                List<Integer> pairs = Arrays.asList(i, j);
                if (i == -size) {
                    System.out.print("\t");
                }
                if (coordinates.contains(pairs)) {
                    String color = colorStack.pop();
                    System.out.print(color+" *"+RESET);
                } else {
                    System.out.print("  ");
                }

                if (i==size) System.out.println();
            }
        }
    }
}


/*
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";
*/