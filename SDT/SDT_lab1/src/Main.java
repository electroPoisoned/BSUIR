import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n:");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.stream(array).forEach(System.out::println);

        int evenDigitNumbers = 0;
        int equalEvenOddDigitNumbers = 0;

        Arrays.stream(array);

        for (int num : array) {
            int evenDigits = 0;
            int oddDigits = 0;
            while (num > 0) {
                int digit = num % 10;
                if (digit % 2 == 0) {
                    evenDigits++;
                } else {
                    oddDigits++;
                }
                num /= 10;
            }
            if (evenDigits == oddDigits) {
                equalEvenOddDigitNumbers++;
            }
            if (oddDigits == 0) {
                evenDigitNumbers++;
            }
        }

        System.out.println("Number of digits which contain only even digits: " + evenDigitNumbers);
        System.out.println("Number of digits which contain equal even and odd digits number: " + equalEvenOddDigitNumbers);

        System.out.println("\n\nDaniliuk Vladislav\nDate of creation: 10.02.2024");
    }
}

