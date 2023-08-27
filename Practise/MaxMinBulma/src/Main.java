import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Kaç tane sayı gireceksiniz: ");
        int N = input.nextInt();

        System.out.print("1. Sayıyı giriniz: ");
        int sayi = input.nextInt();

        int enBuyuk = sayi;
        int enKucuk = sayi;

        for (int i = 2; i <= N; i++) {
            System.out.print(i + ". Sayıyı giriniz: ");
            sayi = input.nextInt();

            if (sayi > enBuyuk) {
                enBuyuk = sayi;
            }

            if (sayi < enKucuk) {
                enKucuk = sayi;
            }
        }

        System.out.println("En büyük sayı: " + enBuyuk);
        System.out.println("En küçük sayı: " + enKucuk);
    }
}