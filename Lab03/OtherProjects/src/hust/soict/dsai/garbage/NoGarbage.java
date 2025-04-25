package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "ggg.txt"; 
        byte[] inputBytes;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            long startTime = System.currentTimeMillis();

            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }

            String outputString = outputStringBuilder.toString();
            long endTime = System.currentTimeMillis();
            System.out.println("NoGarbage time: " + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
