import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        createFileWithRandomNumbers();
        readFileAndPrintSum();
        countLinesInFile("numbers.txt");
        copyBinaryFile("image.jpg", "copy_image.jpg");
    }

    public static void createFileWithRandomNumbers() throws IOException {
        FileWriter writer = new FileWriter("numbers.txt");
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            writer.write(rand.nextInt(100) + "\n");
        }
        writer.close();
    }

    public static void readFileAndPrintSum() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
        String line;
        int sum = 0;
        while ((line = reader.readLine()) != null) {
            sum += Integer.parseInt(line);
        }
        System.out.println("Sum of numbers: " + sum);
        reader.close();
    }

    public static void countLinesInFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        System.out.println("Number of lines: " + lineCount);
        reader.close();
    }

    public static void copyBinaryFile(String sourceFile, String destinationFile) throws IOException {
        FileInputStream inputStream = new FileInputStream(sourceFile);
        FileOutputStream outputStream = new FileOutputStream(destinationFile);
        int byteData;
        while ((byteData = inputStream.read()) != -1) {
            outputStream.write(byteData);
        }
        inputStream.close();
        outputStream.close();
    }
}
