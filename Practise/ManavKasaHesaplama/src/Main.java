import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double armutFiyat = 2.14;
        double elmaFiyat = 3.67;
        double domatesFiyat = 1.11;
        double muzFiyat = 0.95;
        double patlicanFiyat = 5.00;

        System.out.print("Armut kaç kilogram? : ");
        double armutKg = scanner.nextDouble();

        System.out.print("Elma kaç kilogram? : ");
        double elmaKg = scanner.nextDouble();

        System.out.print("Domates kaç kilogram? : ");
        double domatesKg = scanner.nextDouble();

        System.out.print("Muz kaç kilogram? : ");
        double muzKg = scanner.nextDouble();

        System.out.print("Patlıcan kaç kilogram? : ");
        double patlicanKg = scanner.nextDouble();
        double toplamTutar = (armutFiyat * armutKg) + (elmaFiyat * elmaKg) + (domatesFiyat * domatesKg) + (muzFiyat * muzKg) + (patlicanFiyat * patlicanKg);

        System.out.println("Toplam Tutar: " + toplamTutar + " TL");
    }
}