package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenerateTranscript {
    public void takeInputFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Id: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Transcript transcript = new Transcript(studentID);

        while (true) {
            System.out.print("Enter Department: ");
            String courseDepartment = scanner.nextLine();

            System.out.print("Enter Course Code: ");
            int courseCode = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Credit: ");
            int courseCredit = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Please enter a value between 0 and 4.");
            System.out.print("Enter Grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine();

            CourseGrade courseGrade = new CourseGrade(courseDepartment, courseCode, courseCredit);
            courseGrade.setGradeTaken(grade);

            System.out.println("1-Continue \n2-Save and exit");
            int endOfFile = scanner.nextInt();
            scanner.nextLine();

            if (endOfFile == 2) {
                break;
            }
        }

        scanner.close();
        System.out.println(transcript);
    }


    public void takeInputFromFile(String filename) {
        // örnek file dosyamız grades.txt dir.
        try {
            // scanner sınıfı konsoldan ve dosyalardan(file) veri okumak için kullanılır javada.
            // konsoldan veri okumak için System.in yazıyoruz ->  Scanner scanner = new Scanner(System.in);
            // file'dan okumak için aşağıdaki gibi yazıyoruz.
            // new file içine file'in içinde bulunduğu dosya uzantısını da yazıyoruz.
            Scanner scanner = new Scanner(new File("src/" + filename));
            // Scanner sınıfı javada dosyayı default olarak String olarak okur
            // Fakat dosyadaki ilk satırımız öğrenci numarası yani integer olarak ihtiyaç duyduğumuz için
            // nextInt() metodu ile String olan değeri integer'a dönüştürüyoruz aşağıdaki code'da.
            int studentID = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Transcript transcript = new Transcript(studentID);

            // Java'da hasNextLine(), Scanner sınıfı tarafından sağlanan ve taranan giriş kaynağında
            // başka bir girdi satırı olup olmadığını kontrol etmek için kullanılan bir yöntemdir.
            // Başka bir giriş satırı varsa doğru, aksi takdirde yanlış döndürür.
            //
            // Scanner sınıfı, konsoldan veya dosyalardan veri okumak gibi metin tabanlı girdileri ayrıştırmak ve
            // belirtmek için yaygın olarak kullanılır. HasNextLine() yöntemi, okunacak başka satır kalmayıncaya kadar
            // giriş satırları arasında yineleme yapmak için genellikle döngülerde kullanılır.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" "); // text'te her satır 4 parçadan oluşuyor boşluklarla birlikte

                String courseDepartment = parts[0]; // ilk parça departman
                int courseCode = Integer.parseInt(parts[1]); // 2. parça kursun kodu
                int courseCredit = Integer.parseInt(parts[2]); // 3. parça kursun kredisi
                double grade = Double.parseDouble(parts[3]); // 4. parça öğrencinin kurstan aldığı not sayısal olarak

                CourseGrade courseGrade = new CourseGrade(courseDepartment, courseCode, courseCredit);
                courseGrade.setGradeTaken(grade);

                transcript.addCourseTaken(courseGrade);

            }

            scanner.close();

            System.out.println(transcript);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid format in the file.");
        }
    }


}
