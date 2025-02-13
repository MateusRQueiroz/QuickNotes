import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Journal journal = new Journal();
        while (true) {
            System.out.println("""
                    Select an Option: 
                    1. Create a Note
                    2. Remove a Note 
                    3. Display Notes 
                    4. Exit 
                    """);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    journal.addNote();
                } 
                case 2 -> {
                    journal.removeNote();
                }
                case 3 -> {
                    journal.displayNotes();
                }
                case 4 -> {
                    scanner.close();
                    return;
                }
            }
        }
    }
}
