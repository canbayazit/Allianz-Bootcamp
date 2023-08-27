import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Üçgenin birinci kenar uzunluğunu girin: ");
        double a = scanner.nextDouble();

        System.out.print("Üçgenin ikinci kenar uzunluğunu girin: ");
        double b = scanner.nextDouble();

        System.out.print("Üçgenin üçüncü kenar uzunluğunu girin: ");
        double c = scanner.nextDouble();

        double u = (a + b + c) / 2;

        double alan = Math.sqrt(u * (u - a) * (u - b) * (u - c));

        System.out.println("Üçgenin alanı: " + alan);
    }
}