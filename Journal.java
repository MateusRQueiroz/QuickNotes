import java.io.*;
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
            int i = 1;
            for (Note note : notes) {
                System.out.println(i + ") " + note.toString());
                i++;
            }
        }
    }

    public void removeNote() {
        System.out.println("Enter note number: ");
        int id = scanner.nextInt();
        notes.remove(id-1);
        saveToFile();
    }

    public void loadFromFile() {
        File file = new File(file_name);
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                System.out.println("Unable to create file");
                System.err.println("Error: " + e.getMessage());
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("//|",3);
                if (parts.length == 3) {
                    notes.add(new Note(parts[0], parts[1], parts[2]));
                } 
            }
        } catch (IOException e) {
            System.out.println("Unable to read file");
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_name, false))) {
            int i = 1;
            for (Note note : notes) {
                writer.write(i + ") " + note.get_timestamp() + "|" + note.get_category() + "|" + note.get_content());
                writer.newLine();
                i++;
            }
        }
        catch (IOException e) {
            System.out.println("Unable to write or save file.");
            System.err.println("Error " + e.getMessage());
        }
    }
}
