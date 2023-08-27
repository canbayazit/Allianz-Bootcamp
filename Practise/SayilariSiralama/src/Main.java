import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sayi1, sayi2, sayi3;

        Scanner input = new Scanner(System.in);
        System.out.print("Birinci sayıyı giriniz: ");
        sayi1 = input.nextInt();
        System.out.print("İkinci sayıyı giriniz: ");
        sayi2 = input.nextInt();
        System.out.print("Üçüncü sayıyı giriniz: ");
        sayi3 = input.nextInt();

        if (sayi1 <= sayi2 && sayi1 <= sayi3) {
            if (sayi2 <= sayi3) {
                System.out.println("Sıralama: " + sayi1 + " < " + sayi2 + " < " + sayi3);
            } else {
                System.out.println("Sıralama: " + sayi1 + " < " + sayi3 + " < " + sayi2);
            }
        } else if (sayi2 <= sayi1 && sayi2 <= sayi3) {
            if (sayi1 <= sayi3) {
                System.out.println("Sıralama: " + sayi2 + " < " + sayi1 + " < " + sayi3);
            } else {
                System.out.println("Sıralama: " + sayi2 + " < " + sayi3 + " < " + sayi1);
            }
        } else {
            if (sayi1 <= sayi2) {
                System.out.println("Sıralama: " + sayi3 + " < " + sayi1 + " < " + sayi2);
            } else {
                System.out.println("Sıralama: " + sayi3 + " < " + sayi2 + " < " + sayi1);
            }
        }
    }
}