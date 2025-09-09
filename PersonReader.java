import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(".");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            ArrayList<Person> people = new ArrayList<>();

            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length == 5) {
                        String firstName = fields[0].trim();
                        String lastName = fields[1].trim();
                        String id = fields[2].trim();
                        String title = fields[3].trim();
                        int yob = Integer.parseInt(fields[4].trim());

                        Person p = new Person(firstName, lastName, id, title, yob);
                        people.add(p);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            System.out.printf("%-8s %-12s %-12s %-6s %-6s %-12s %-6s\n",
                    "ID#", "FirstName", "LastName", "Title", "YOB", "FullName", "Age");
            System.out.println("=====================================================================");

            for (Person p : people) {
                System.out.printf("%-8s %-12s %-12s %-6s %-6d %-12s %-6s\n",
                        p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB(),
                        p.fullName(), p.getAge());
            }

        } else {
            System.out.println("No file selected.");
        }
    }
}
