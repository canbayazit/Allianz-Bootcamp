import model.*;
import service.*;

import java.math.BigDecimal;
import java.util.*;

// null ile ilgili Not:
// Object olarak tanımlanan değişkenler ilk başta nulldır,default değeri yoksa
// null olan bir list'e eleman eklemek için add methodunu değil setter ile önce
// setlemeliyiz eğer daha önceden setter ile setlenip bir List oluşturulduysa
// add methodu ile ekleyebiliriz. O yüzden null kontrolü yapılmalı yoksa error verir program

public class Main {

    /**
     * Dans Senaryosu :
     *
     * öğrenci kayıt
     * kurs tipleri
     * ödeme bilgileri
     * öğretmen bilgileri
     * kurs programı
     * telafi dersleri
     *
     *Modellerimizi veritabanında bir tablo olarak düşün.
     *
     *her modelin service'ini ayrı yazsak daha şık olabilir
     *
     * */


    public static void main(String[] args) throws Exception {


        DanceCourseService danceCourseService = new DanceCourseService();
        BankAccountService bankAccountService = new BankAccountService();
        BranchService branchService = new BranchService();
        InstructorService instructorService = new InstructorService();
        LectureService lectureService = new LectureService();
        LectureScheduleTimeService lectureScheduleTimeService = new LectureScheduleTimeService();

        // branch'in initial değerlerini load ettik
        List<Branch> branchList = InitialDataService.loadInitialDataForBranch();

        System.out.println(branchList);

        // dans kursu oluşturduk
        DanceCourse danceCourse = danceCourseService.createDanceCourse("Can Dance School", "İstanbul",
                "Can Bayazit", "98728998789", "İstanbul");

        System.out.println(danceCourse.toString());

        // banka hesabı oluşturduk
        BankAccount bankAccount = bankAccountService.createBankAccount("T.C. ZİRAAT BANKASI",
                "BAYAZİT LİMİTED ŞİRKETİ", "TR1200002902343", new BigDecimal(100000));

        // oluşturduğumuz banka hesabını dans kursunun hesaplar listesine ekliyoruz
        danceCourseService.createBankAccountToDanceCourse(danceCourse, bankAccount);
        System.out.println(danceCourse);

        // aynı ibanda tekrar bir hesap oluşturduk istediğimiz şartları sağlıyor mu diye kontrol ettik
        BankAccount bankAccount1 = bankAccountService.createBankAccount("T.C. ZİRAAT BANKASI",
                "BAYAZİT LİMİTED ŞİRKETİ", "TR1200002902343", new BigDecimal(200000));


        danceCourseService.createBankAccountToDanceCourse(danceCourse, bankAccount1);
        System.out.println(danceCourse);

        // yeni branş ekliyoruz
        branchService.createBranchToBranchPool(branchList, "Halayy");

        System.out.println(branchList);

        // eğitmen oluşturduk
        Instructor instructor = instructorService.createInstructor("Ahmet Demir", 28,
                Sex.MALE, new BigDecimal(12000));

        danceCourseService.addInstructorToDanceCourse(danceCourse, instructor);

        System.out.println(danceCourse);

        // Dans dersi oluşturduk
        Lecture lecture = lectureService.createLecture("Bachata", branchList.get(0), 10);

        LectureScheduleTime lectureScheduleTime = lectureScheduleTimeService.
                createLectureScheduleTime(Day.MONDAY, "12:00-14:00");

        Set<LectureScheduleTime> lectureScheduleTimeSet = new HashSet<>();
        lectureScheduleTimeSet.add(lectureScheduleTime);

        lectureService.addScheduleTimeToLecture(lecture, lectureScheduleTimeSet);

        danceCourseService.addLectureToDanceCourse(danceCourse, lecture);

        System.out.println(danceCourse);


    }

}