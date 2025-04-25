package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "ggg.txt"; // Đảm bảo bạn có tệp test.exe hoặc thay bằng đường dẫn file lớn bất kỳ
        byte[] inputBytes;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            long startTime = System.currentTimeMillis();

            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }

            long endTime = System.currentTimeMillis();
            System.out.println("GarbageCreator time: " + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
