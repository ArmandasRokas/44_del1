package util;

import java.util.Random;

public class GameTool {

    /**
     * Calculates a random value between min and max
     *
     * @return  Random integer between min and max
     */
    public static int randomIntValue(int min, int max) {
        Random r = new Random();

        int randomNum = r.nextInt(max - min + 1);
        int finalNum = randomNum + min;

        return finalNum;
    }

}
