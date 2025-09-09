public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        String name = input.getNonZeroLenString("Enter your name");
        int age = input.getRangedInt("Enter your age", 1, 120);
        double score = input.getDouble("Enter a test score");
        boolean confirm = input.getYNConfirm("Do you want to continue?");
        String code = input.getRegExString("Enter a code (3 letters and 3 numbers):", "[A-Za-z]{3}\\d{3}");


        System.out.println("\nYou entered:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
        System.out.println("Continue? " + confirm);
        System.out.println("Code: " + code);
    }
}
