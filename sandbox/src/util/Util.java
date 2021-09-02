package util;

import java.io.*;

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

    public static void writeFile(String fileName, String targetString){

        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            bufferedWriter.write(targetString);
            bufferedWriter.flush();
            bufferedWriter.close();


        }catch (IOException e){
            System.out.println(String.format("Can not write file : %s", fileName));
            e.getStackTrace();
        }




    }



}
