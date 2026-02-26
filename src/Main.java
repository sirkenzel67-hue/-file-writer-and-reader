import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // STEP 1 - Keep showing menu until user exits
        while (choice != 3) {
            System.out.println("\n=== Contact Book ===");
            System.out.println("1. Add contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear the buffer

            switch (choice) {

                // STEP 2 - Add a contact
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    try {
                        FileWriter writer = new FileWriter("contacts.txt", true);
                        writer.write(name + " - " + phone + "\n");
                        writer.close();
                        System.out.println("Contact saved! ✅");
                    } catch (IOException e) {
                        System.out.println("Error saving: " + e.getMessage());
                    }
                    break;

                // STEP 3 - View all contacts
                case 2:
                    System.out.println("\n=== Your Contacts ===");
                    try {
                        File file = new File("contacts.txt");
                        if (!file.exists()) {
                            System.out.println("No contacts yet!");
                        } else {
                            Scanner reader = new Scanner(file);
                            while (reader.hasNextLine()) {
                                System.out.println(reader.nextLine());
                            }
                            reader.close();
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading: " + e.getMessage());
                    }
                    break;

                // STEP 4 - Exit
                case 3:
                    System.out.println("Goodbye! 👋");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}