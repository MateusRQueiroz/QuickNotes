import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {
     private String category;
     private String content; 
     private String timestamp;

     public Note(String category, String content) {
        this.category = category;
        this.content = content;
        this.timestamp = generateTimestamp();
     }

     public Note(String category, String content, String timestamp) {
        this.category = category;
        this.content = content;
        this.timestamp = timestamp;
     }

     private String generateTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.now().format(formatter);
     }

     public String get_category() {return category;}
     public String get_content() {return content;}
     public String get_timestamp() {return timestamp;}

     @Override
     public String toString() {
        return "[" + timestamp + "]" + category + " - " + content;
     }
}
