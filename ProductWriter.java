import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("=== Product Writer ===");
        boolean more = true;

        while (more) {
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String code = SafeInput.getNonZeroLenString(in, "Enter Product Code");
            double price = SafeInput.getDouble(in, "Enter Product Price");
            int quantity = SafeInput.getInt(in, "Enter Product Quantity");

            Product product = new Product(name, code, price, quantity);
            products.add(product);

            more = SafeInput.getYNConfirm(in, "Add another product?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name to save (e.g., ProductTestData.txt)");
        Path file = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (Product p : products) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            System.out.println("File saved: " + file.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
