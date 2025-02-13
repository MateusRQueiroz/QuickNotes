import java.util.ArrayList;
import java.util.Scanner;

public class Journal {
    private ArrayList<Note> notes = new ArrayList<>();
    private final String file_name = "journal.txt";
    private Scanner scanner = new Scanner(System.in);

    public Journal() {
        loadFromFile();
    }

    public void addNote() {
        System.out.println("Category? ");
        String category = scanner.nextLine();
        System.out.println("Content: ");
        String content = scanner.nextLine();

        Note newNote = new Note(category, content);
        notes.add(newNote);
        saveToFile();
    }
    
    public void displayNotes() {
        if (notes.isEmpty()) {
            System.out.println("You don't have any notes.");
        }
        else {
            for (Note note : notes) {
                System.out.println(note.toString());
            }
        }
    }

    public void loadFromFile() {

    }

    public void saveToFile() {

    }
}
