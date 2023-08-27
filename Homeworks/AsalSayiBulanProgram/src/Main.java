import java.util.Scanner;

public class Main {
    static boolean asalMi(int sayi, int i) {
        if (i == 1)
            return true;
        if (sayi % i == 0)
            return false;
        return asalMi(sayi, i - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayı giriniz: ");
        int sayi = scanner.nextInt();

        if (asalMi(sayi, sayi / 2))
            System.out.println(sayi + " sayısı ASALDIR !");
        else
            System.out.println(sayi + " sayısı ASAL değildir !");
    }
}