import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int sayi;
        boolean mukemmel;

        do {
            System.out.print("Bir sayı giriniz: ");
            sayi = input.nextInt();
            mukemmel = mukemmelSayiKontrol(sayi);

            if (mukemmel) {
                System.out.println(sayi + " Mükemmel sayıdır.");
            } else {
                System.out.println(sayi + " Mükemmel sayı değildir.");
            }
        } while (!mukemmel);
    }
    public static boolean mukemmelSayiKontrol(int sayi) {
        int toplam = 0;
        for (int i = 1; i < sayi; i++) {
            if (sayi % i == 0) {
                toplam += i;
            }
        }
        return toplam == sayi;
    }
}