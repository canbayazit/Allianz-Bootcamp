package main;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private int studentID;
    private List<CourseGrade> gradeList; // öğrencinin aldığı kurslar ve o kurslardan aldığı notları tutan list
    private double gpa;

    //Class has a one-argument constructor that takes an integer containing the student’s id ,sets
    //GPA to 0.0 and initializes the list of CourseGrade objects
    public Transcript(int studentID) {
        this.studentID = studentID;
        this.gpa = 0.0;
        this.gradeList = new ArrayList<>();
    }

    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade != null) {
            gradeList.add(courseGrade);
            updateGPA();
        } else {
            System.out.println("Error: Cannot add a null courseGrade.");
        }
    }

    // Harf Notları : A ise 4, B ise 3, C ise 2, D ise 1, F ise 0
    // Not Ortalaması += Aldığı Harf Notuna karşılık gelen sayı * Kursun Kredisi
    // GPA = Not Ortalaması / Alınan derslerin toplam kredi sayısı
    private void updateGPA() {
        int totalCredits = 0;
        double totalGradePoints = 0.0;

        for (CourseGrade courseGrade : gradeList) {
            totalCredits += courseGrade.getCourseCredit(); // Toplam Kredi sayısı
            // Harf notu * dersin kredisi
            totalGradePoints += courseGrade.getGradeTaken().getNumericValue() * courseGrade.getCourseCredit();
        }

        if (totalCredits > 0) {
            gpa = totalGradePoints / totalCredits;
        }
    }

    public int getStudentID() {
        return studentID;
    }

    public List<CourseGrade> getGradeList() {
        return gradeList;
    }

    public double getGpa() {
        return gpa;
    }

    // NOT : StringBuilder() ile ilgili
    // Javada String'ler immutable'dır. Yani değiştirelemez.

    /*
    *
        String s="Can";
        s.concat(" Bayazit");
        System.out.println(s);
        Output : Can

        String s="Can";
        s=s.concat(" Bayazit");
        System.out.println(s);
        Output : Can Bayazit

        Referansına atarsak değiştirebiliriz.
        *
 Java'da Bir String'i değiştiriyor gibi görünen birleştirme (Concatenation) veya başka bir işlem gerçekleştirdiğinizde,
 aslında orijinal String ile yeni içeriğin birleşik sonucunu temsil eden yeni bir String nesnesi oluşturur.
 Orijinal String bellekte değişmeden kalır. Bunu engellemek için referansına atamak gerekir.
 İşte bu durumda Java'nın kendisine ait StringBuilder class'ını kullanıyoruz. Bu class Stringleri yeni bir nesne
 oluşturmadan birleştirmemizi sağlar. Birleştirme için append methodunu çağırıyoruz.
    *
    *
    * */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student ID: ").append(studentID).append("\n");

        for (CourseGrade courseGrade : gradeList) {
            sb.append(courseGrade).append("\n");
        }

        sb.append("GPA: ").append(gpa);
        // son olarak sb'i toString() methoduyla return ediyoruz. Böylece sb tekrar immutable (değiştirilemez)
        // yapıya dönüşüyor.
        return sb.toString();
    }
}
