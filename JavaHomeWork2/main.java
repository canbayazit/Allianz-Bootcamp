import java.util.ArrayList;
import java.util.Scanner;

import model.Category;
import model.Film;
import model.Platform;

/**
 * main
 */
public class Main {

    // NOT: Farklı bir tuşa basınca kontrol etme mekanizması oluşturmaya zamanım
    // yetmedi o yüzden ekranda ne yazıyorsa ona göre ilerlendiği sürece sıkıntı
    // yok.

    static Scanner input = new Scanner(System.in);
    static ArrayList<Category> categoryList = new ArrayList<>();
    static ArrayList<Platform> platformList = new ArrayList<>();
    static ArrayList<Film> filmList = new ArrayList<>();

    private static void addCategory() {
        while (true) {
            String categoryInput = input.nextLine();
            if (categoryInput.equals("0")) {
                break;
            }
            Category category = new Category();
            category.setName(categoryInput);
            categoryList.add(category);
        }
    }

    private static void addPlatform() {
        while (true) {
            String platformInput = input.nextLine();
            if (platformInput.equals("0")) {
                break;
            }
            Platform platform = new Platform();
            platform.setName(platformInput);
            platformList.add(platform);
        }
    }

    private static void addFilm() {
        while (true) {
            Film film = new Film();
            System.out.println("Film ismini giriniz:");
            String filmName = input.nextLine();
            film.setName(filmName);

            System.out.println("Film yılını giriniz:");
            String filmYear = input.nextLine();
            film.setYear(Integer.parseInt(filmYear));

            System.out.println("Film Yönetmenini giriniz:");
            String filmDirector = input.nextLine();
            film.setDirector(filmDirector);

            System.out.println("Film IMDB puanını giriniz:");
            String filmImdb = input.nextLine();
            film.setImdb(Double.parseDouble(filmImdb));

            System.out.println(
                    "Filmin kategorisine listeden seçip ekleyiniz. Eklemek için kategorinin solundaki rakam neyse ona basarak seçmelisiniz:");
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.println((i + 1) + "-" + categoryList.get(i).getName());
            }

            String filmCategoryId = input.nextLine();
            // ilgili kategorinin film sayını 1 arttırdık
            categoryList.get(Integer.parseInt(filmCategoryId) - 1).setFilmCount();
            // ilgili kategoriyi filmin kategori field'ine ekledik.
            film.setCategoryList(categoryList.get(Integer.parseInt(filmCategoryId) - 1));

            System.out.println("Film süresini giriniz:");
            String timeInput = input.nextLine();
            film.setTime(timeInput);

            System.out.println(
                    "Filmin platformunu listeden seçip ekleyiniz. Eklemek için platformun solundaki rakam neyse ona basarak seçmelisiniz:");
            for (int i = 0; i < platformList.size(); i++) {
                System.out.println((i + 1) + "-" + platformList.get(i).getName());
            }

            String filmPlatformId = input.nextLine();
            film.setPlatformList(platformList.get(Integer.parseInt(filmPlatformId) - 1));
            filmList.add(film);
            System.out.println("Film başarıyla eklenmiştir !");
            System.out.println("Daha fazla film eklemek istiyor musunuz ? \n Evet: e, Hayır: h");
            String answer = input.nextLine();
            if (answer.equals("e")) {
                continue;
            } else if (answer.equals("h")) {
                break;
            }

        }
    }

    private static void userPage() {
        System.out.println("Filmleri Listelemek için Kategori seçiniz...");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println((i + 1) + "-" + categoryList.get(i).getName() + " - Film Sayısı: "
                    + categoryList.get(i).getFilmCount());
        }

        String filmCategoryId = input.nextLine();

        for (int i = 0; i < filmList.size(); i++) {
            int x = i;
            filmList.get(i).getCategoryList().forEach(category -> {
                if (category.getName().equals(categoryList.get(Integer.parseInt(filmCategoryId) - 1).getName())) {
                    System.out.println(filmList.get(x).toString());
                }

            });
            ;
        }
    }

    public static void main(String[] args) {
        String user;
        System.out.println("Adminsen 1'e Kullanıcı isen 2'e Tıkla");
        user = input.nextLine();

        // System.out.println("user " + user);
        if (user.equals("1")) {
            System.out.println(
                    "Lütfen kategori giriniz..., Eğer kategori ekleme işleminiz bittiyse işlemi tamamlamak için 0 basınız");
            addCategory();
            System.out.println(
                    "Lütfen platform giriniz..., Eğer platform ekleme işleminiz bittiyse işlemi tamamlamak için 0 basınız");
            addPlatform();
            System.out.println("Lütfen film bilgisi giriniz...");
            addFilm();
            userPage();
        } else if (user.equals("2")) {
            userPage();
        }

    }
}