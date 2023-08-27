import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Çıkmak için 0'a basınız.");

        do {
            System.out.print("Sayı giriniz: ");
            number = scanner.nextInt();

            if (number % 2 == 0 && number % 4 == 0) {
                sum += number;
            }
        } while (number != 0);

        System.out.println("Girilen çift ve 4'ün katı olan sayıların toplamı: " + sum);
    }
}