package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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


    public static ArrayList<String> readFromFile(String filename)  throws IOException{

        ArrayList<String> list = new ArrayList<String>();

            String file ="languages\\"+filename+".txt";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine = reader.readLine();
            while (currentLine != null){
                list.add(currentLine);
                currentLine = reader.readLine();
            }
            reader.close();


        return list;
    }
}
