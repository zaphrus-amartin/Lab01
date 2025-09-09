import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(".");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            ArrayList<Product> products = new ArrayList<>();

            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length == 4) {
                        String name = fields[0].trim();
                        String code = fields[1].trim();
                        double price = Double.parseDouble(fields[2].trim());
                        int quantity = Integer.parseInt(fields[3].trim());

                        Product p = new Product(name, code, price, quantity);
                        products.add(p);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            System.out.printf("%-15s %-8s %-10s %-10s %-12s\n", "Name", "Code", "Price", "Quantity", "TotalValue");
            System.out.println("==============================================================");

            for (Product p : products) {
                System.out.printf("%-15s %-8s %-10.2f %-10d %-12.2f\n",
                        p.getName(), p.getCode(), p.getPrice(), p.getQuantity(), p.getTotalValue());
            }

        } else {
            System.out.println("No file selected.");
        }
    }
}
