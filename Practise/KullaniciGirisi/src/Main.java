import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dogruKullaniciAdi = "patika";
        String dogruSifre = "java123";
        String girilenKullaniciAdi, girilenSifre;

        Scanner input = new Scanner(System.in);
        System.out.print("Kullanıcı Adınızı Giriniz: ");
        girilenKullaniciAdi = input.nextLine();
        System.out.print("Şifrenizi Giriniz: ");
        girilenSifre = input.nextLine();

        if (girilenKullaniciAdi.equals(dogruKullaniciAdi) && girilenSifre.equals(dogruSifre)) {
            System.out.println("Giriş Yaptınız!");
        } else {
            System.out.println("Bilgileriniz Yanlış!");
            System.out.print("Şifrenizi sıfırlamak ister misiniz? (Evet/Hayır): ");
            String secim = input.nextLine();

            if ("Evet".equalsIgnoreCase(secim)) {
                System.out.print("Yeni şifrenizi giriniz: ");
                String yeniSifre = input.nextLine();

                if (yeniSifre.equals(girilenSifre)) {
                    System.out.println("Şifre oluşturuldu.");
                } else {
                    dogruSifre = yeniSifre;
                    System.out.println("Şifre oluşturulamadı, lütfen başka bir şifre giriniz.");
                }
            } else {
                System.out.println("Şifre sıfırlama işlemi iptal edildi.");
            }
        }
    }
}