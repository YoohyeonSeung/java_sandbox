import java.nio.file.Paths;
import util.Util;

public class Main {

    public static void main(String[] args) {

        String targetDir = Paths.get("C:", "java_sandBox", "textFile").toString();

        String filePaths = Paths.get(targetDir, "sample.txt").toString();

        String result = Util.readTextFile(filePaths);

        System.out.println(result);


        Util.writeFile(Paths.get(targetDir, "write.txt").toString(), result);

    }

}
