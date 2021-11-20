package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class L02WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);
        Set<Character> punctuations = Set.of(',', '.', '!', '?');

        FileOutputStream outputStream = new FileOutputStream("out.txt");

        int value = fileStream.read();

        while (value != -1) {
            char current = (char) value;
            if (!punctuations.contains(current)) {
                outputStream.write(current);
            }
                value = fileStream.read();
        }


    }
}
