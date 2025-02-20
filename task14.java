/* FileReaderUtility */

import java.io.*;

public class FileReaderUtility {
    public static void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void main(String[] args) {
        try {
            readFile("example.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/* ----------------------------- (Serialization and Deserialization)------------------ */

import java.io.*;

class Student implements Serializable {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("John", 85);

        // Serialization
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"));
        out.writeObject(student);
        out.close();

        // Deserialization
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"));
        Student deserializedStudent = (Student) in.readObject();
        in.close();

        System.out.println("Name: " + deserializedStudent.name);
        System.out.println("Marks: " + deserializedStudent.marks);
    }
}


/*---------------------------------(Count Words in Text File)-------------*/

  import java.io.*;

public class WordCountInFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("textfile.txt"));
        String line;
        int wordCount = 0;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        System.out.println("Number of words: " + wordCount);
        reader.close();
    }
}
