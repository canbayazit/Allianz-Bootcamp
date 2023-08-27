import java.util.Scanner;

public class Main {
    static void kuralaUyanDongu(int sayi) {
        System.out.print(sayi + " ");
        if (sayi > 0) {
            kuralaUyanDongu(sayi - 5);
        }
        System.out.print(sayi + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("N Sayısı: ");
        int n = scanner.nextInt();

        kuralaUyanDongu(n);
    }
}