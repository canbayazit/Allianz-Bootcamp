import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner inp = new Scanner(System.in);

        System.out.print("Sayı Giriniz: ");
        n = inp.nextInt();

        int sum = 0;
        int count = 0;

        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                sum += i;
                count++;
            }
        }

        if (count != 0) {
            double average = (double) sum / count;
            System.out.println("3'e ve 4'e tam bölünen sayıların ortalaması: " + average);
        } else {
            System.out.println("3'e ve 4'e tam bölünen sayı bulunamadı.");
        }
    }
}