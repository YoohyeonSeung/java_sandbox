import services.ParallelPractice;

import java.nio.file.Paths;
import Util.Util;
import java.util.AbstractMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {

        String targetDir = Paths.get("C:", "java_sandBox", "textFile").toString();

        String filePaths = Paths.get(targetDir, "sample.txt").toString();

        String result = Util.readTextFile(filePaths);

        System.out.println(result);
    }

}
