import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    static final String FILE_NAME = "sample.txt";

    // Method to write to a file
    public static void writeFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read from a file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- File Content ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("---------------------\n");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to append text to a file
    public static void modifyFile(String newText) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.newLine(); // Adds a new line before appending
            writer.write(newText);
            System.out.println("Text appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String input;

        do {
            System.out.println("\nFile Handling Utility");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify (Append to) File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text to write: ");
                    input = scanner.nextLine();
                    writeFile(input);
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    System.out.print("Enter text to append: ");
                    input = scanner.nextLine();
                    modifyFile(input);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        scanner.close();
    }
}
