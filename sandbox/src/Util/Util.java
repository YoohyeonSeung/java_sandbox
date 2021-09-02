package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Util {

    public static String readTextFile(String filePath){

        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            String line = null;

            while ((line = bufferedReader.readLine()) != null){
                if(stringBuilder.length() > 0)
                    stringBuilder.append(",");
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        }
        catch (FileNotFoundException e){
            System.out.println(String.format("Can not find file : %s", filePath));
            e.getStackTrace();
        }
        catch (IOException e){
            System.out.println(String.format("Can not read file : %s", filePath));
            e.getStackTrace();
        }
        return null;
    }

}
