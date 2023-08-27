import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Sınır sayısını giriniz: ");
        n = input.nextInt();

        int kuvvet4 = 4;
        int kuvvet5 = 5;

        while (kuvvet4 <= n || kuvvet5 <= n) {
            if (kuvvet4 <= n) {
                System.out.println(kuvvet4);
                kuvvet4 *= 4;
            }
            if (kuvvet5 <= n) {
                System.out.println(kuvvet5);
                kuvvet5 *= 5;
            }
        }
    }
}