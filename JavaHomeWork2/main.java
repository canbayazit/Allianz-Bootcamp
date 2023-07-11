import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Category;
import model.Film;

/**
 * main
 */
public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Category> categoryList = new ArrayList<>();

    public static void addCategory() {
        while (true) {
            String category = input.nextLine();
            if (category.equals("0")) {
                break;
            }
            Category categoryComedy = new Category();
            categoryComedy.setName(category);
            categoryList.add(categoryComedy);

            // System.out.println("category" + category.getClass());

        }

    }

    public static void main(String[] args) {
        // List<Category> filmCategoryArr = new ArrayList<>();
        // Film film = new Film();
        String user;
        System.out.println("Adminsen 1'e Kullanıcı isen 2'e Tıkla");
        user = input.nextLine();

        // System.out.println("user " + user);
        if (user.equals("1")) {
            System.out.println(
                    "Lütfen kategori giriniz..., Eğer kategori ekleme işleminiz bittiyse işlemi tamamlamak için 0 basınız");
            addCategory();
        } else {

        }
        for (Category category : categoryList) {
            System.out.println(category.getName());
        }
        System.out.println(categoryList.size());

    }
}