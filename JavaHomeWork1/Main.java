package JavaHomeWork1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main
 */
public class Main {

    // ÖDEV TANIMI

    // okulumuzun sınıfları var, 1A sınıfı öğrencileri, 2A sınıfı öğrencileri gibi
    // öğrencilerin sadece adı soyadı olacak.

    // öğrencilerden adı an ile biten kişileri görmek istiyorum ama hangi sınıfta
    // olduğunu göster.
    public static void main(String[] args) {

        Map<String, List<String>> classMap = new HashMap<>(); // sınıf + öğrenciler
        List<String> class1A = new ArrayList<>(); // okuldaki sınıflarımız
        List<String> class1B = new ArrayList<>();
        List<String> class1C = new ArrayList<>();

        class1A.add("Can Bayazit");
        class1A.add("Akın Özdemir");
        class1A.add("Murat Yılmaz");
        class1A.add("Ali Kaan Biber");
        class1A.add("Canan Yıldız");

        class1B.add("Hasan Delice");
        class1B.add("Ezgi Çelik");
        class1B.add("Metehan Kirazoğlu");
        class1B.add("Emrah Kuru");
        class1B.add("Sinan Çetin");

        class1C.add("Cem Yılmaz");
        class1C.add("Uğur Özkan");
        class1C.add("Berk Ağın");
        class1C.add("Tuna Poyraz");
        class1C.add("Mert Yıldırım");

        classMap.put("1-A", class1A);
        classMap.put("1-B", class1B);
        classMap.put("1-C", class1C);

        //** entrySet() Metodu **
        // ctrl + click ile içine bakınca aldığım notlar 

        // Set List'in içine ***Entry interface***'ini argument alıyor
        // Entry interface'ide Map ile tanımladığımız classMap değişkenin
        // key ve value'ların argumentlarını alıyor.

        // getValue() ve getKey() Entry interface'inin built-in metodları.
        // Set<   Entry<(String => 1. parametre(key)) , (List<String> => 2. parametre(class1A,1B,1C))>   > 
        
        for (var entry : classMap.entrySet()) {   
            System.out.println(entry.getKey() + "/" + entry.getValue());
            entry.getValue().forEach(student->{
                String[] studentNameArray = student.split(" ");
                // surname'i studentNameArray.length - 1 ile bypass ediyoruz.
                for (int i = 0; i < studentNameArray.length - 1; i++) { 
                    if (studentNameArray[i].endsWith("an")) {
                        System.out.println("Class: " + entry.getKey() + " / Student Name: " + student);
                        break;
                    }
                }
            });
        }      
  
    }

}