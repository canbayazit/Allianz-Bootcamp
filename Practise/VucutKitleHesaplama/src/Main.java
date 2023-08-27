import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kilonuzu kg cinsinden giriniz: ");
        double kilo = scanner.nextDouble();

        System.out.print("Boyunuzu m cinsinden giriniz: ");
        double boy = scanner.nextDouble();

        double vki = kilo / (boy * boy);

        System.out.println("Vücut Kitle İndeksi (VKİ): " + vki);
    }
}