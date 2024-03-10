import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            String content = new String(Files.readAllBytes(Paths.get("lab3.txt")));

            String resultContent = insertWordAfterSubstring(content, "obbit", "123456");

            FileOutputStream fos = new FileOutputStream("resultLab3.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(resultContent.toString().hashCode());
            oos.close();

            System.out.println(resultContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String content) {
        StringBuilder sb = new StringBuilder();
        for (char c : content.toCharArray()) {
            sb.append((char) (c + 5));
        }
        return sb.toString();
    }

    private static String insertWordAfterSubstring(String textFromFile, String substring, String wordToInsert) {
        return textFromFile.replaceAll(substring, substring + " " + wordToInsert);
    }
}