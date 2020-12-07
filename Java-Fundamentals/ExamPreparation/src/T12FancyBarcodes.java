import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T12FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern validationPattern = Pattern.compile("@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+");
        Pattern groupPattern = Pattern.compile("\\d+");
        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            Matcher validationMatcher = validationPattern.matcher(barcode);
            if (validationMatcher.find()) {
                StringBuilder productGroup = new StringBuilder();
                Matcher groupMatcher = groupPattern.matcher(barcode);
                boolean isNotFound = true;
                while (groupMatcher.find()) {
                    productGroup.append(groupMatcher.group());
                    isNotFound = false;
                }
                if (isNotFound) {
                    productGroup.append("00");
                }
                System.out.println("Product group: " + productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
