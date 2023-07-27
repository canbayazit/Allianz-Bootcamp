package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

// dans course ile ilgili işlemler burda yapılır
public class DanceCourseService {

    // dans course object oluşturma methodu
    public DanceCourse createDanceCourse(String name, String address, String founder, String taxNumber, String taxOffice) {

        DanceCourse danceCourse = new DanceCourse();
        danceCourse.setName(name);
        danceCourse.setAddress(address);
        danceCourse.setFounder(founder);
        danceCourse.setTaxNumber(taxNumber);
        danceCourse.setTaxOffice(taxOffice);
        return danceCourse;
    }

    /*

    Overloading :

    * createDanceCourse isminde bir method tanımladık yukarda.
    Aşağıda da aynı isimde method tanımladık ama parametre sayısı farklı

    Aynı isimlerde farklı parametreler alan methodlar tanımlayabiliriz buna overloading denir.
    *
    *
    * public DanceCourse createDanceCourse(String address, String founder, String taxNumber, String taxOffice) {

        DanceCourse danceCourse = new DanceCourse();
        danceCourse.setAddress(address);
        danceCourse.setFounder(founder);
        danceCourse.setTaxNumber(taxNumber);
        danceCourse.setTaxOffice(taxOffice);
        return danceCourse;
    }
    * */

    // dans course'a bank account ekliyoruz.

    // ŞART:
    // aynı iban no ile 2. bir hesap eklenemez
    // eğer eklenmeye çalışılırsa da o iban no'nun amount'una
    // eklemek istedim iban no'daki amount'u üstüne eklemek istiyorum
    public void createBankAccountToDanceCourse(DanceCourse danceCourse, BankAccount bankAccount) {

        if (danceCourse.getBankAccountList() != null) {
            // aşağıda tanımladığım isExistBankAccount fonksiyonu yazıyoruz
            if (isExistBankAccount(danceCourse, bankAccount)) {
                addAmountToExistBankAccount(danceCourse, bankAccount);
            } else {
                danceCourse.getBankAccountList().add(bankAccount);
            }
        } else {

            // yorum satırına aldığım kısım eşittir -> List.of(bankAccount)
            // List.of methodu içine aldığı object'i direk Listeye çevirir.

            /*List<BankAccount> bankAccountList = new ArrayList<>();
            bankAccountList.add(bankAccount);*/
            danceCourse.setBankAccountList(List.of(bankAccount));
        }
    }


    // Yukarda şartı belirttiğimiz şartı sağlamak için yeni bir iban no gönderdiğimizde bu iban no,
    // dans kursunun hesaplarında var mı yok mu onun kontrolünü yapan method
    private boolean isExistBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {

        boolean isExist = false;
        // dans kursundaki banka hesaplarını foreach ile dönüyoruz
        for (BankAccount bankAccount1 : danceCourse.getBankAccountList()) {
            // equals için not :
            // Object'lerde kullanırız, object'lerin valuları kıyaslanır eşit midir diye.
            // ama int, long gibi Object olmayan durumlarda == kullanabilirsin.

            // eğer hesaplardan birinin iban no'su parametre olarak gönderdiğimiz iban no'ya eşitse
            // demekki bu iban no hesabı dans kursunun banka hesaplarında varmış deyip true dönüyoruz
            if (bankAccount1.getIbanNo().equals(bankAccount.getIbanNo())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    private void addAmountToExistBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {

        for (BankAccount bankAccount1 : danceCourse.getBankAccountList()) {
            if (bankAccount1.getIbanNo().equals(bankAccount.getIbanNo())) {
                bankAccount1.setAmount(bankAccount1.getAmount().add(bankAccount.getAmount()));
                break;
            }
        }
    }

    // dans kursuna bank account ekliyoruz. Çünkü Dans kursu object'i bank account'ları List şeklinde tutuyor
    // dans kursunu manipüle ettiğimiz için bu metodu dans kursu service'inde oluşturduk
    public void createBankAccountToDanceCourse(DanceCourse danceCourse, List<BankAccount> bankAccountList) {

        if (danceCourse.getBankAccountList() != null) {
            danceCourse.getBankAccountList().addAll(bankAccountList);
        } else {
            danceCourse.setBankAccountList(bankAccountList);
        }

    }

    public void addInstructorToDanceCourse(DanceCourse danceCourse, Instructor instructor) {

        BankAccountService bankAccountService = new BankAccountService();
        PaymentMovementService paymentMovementService = new PaymentMovementService();

        if (danceCourse.getBankAccountList() != null) {
            // bankAccount servisimizden getBankAccountWithEnoughMoney methodunu çağırdık ve bankAccount setledik
            BankAccount bankAccount = bankAccountService.
                    getBankAccountWithEnoughMoney(danceCourse, instructor.getSalary());

            // setlenen değerimiz olan bankAccount null değilse
            // dans kursunun, eğitmenin maaşını karşılayacağı bir banka hesabı vardır demek.
            if (bankAccount != null) {

                // bu banka hesabındaki paradan öğretmenin ücretini çıkarıyoruz yani öğretmene ücreti ödüyoruz
                bankAccount.setAmount(bankAccount.getAmount().subtract(instructor.getSalary()));
                // öğretmene ücret ödendiği için bir ödeme işlemi yapıldı.
                // bu işlemi tutmak için ödeme hareketlerimizi tutan object'i oluşturup bilgileri giriyoruz.
                PaymentMovement paymentMovement = paymentMovementService.
                        createPaymentMovement(bankAccount,
                                instructor.getName() + " maaş ödemesi",
                                MovementType.OUTCOME, instructor.getSalary());

                addPaymentMovementToDanceCourse(danceCourse, paymentMovement);

                if (danceCourse.getInstructorList() != null) {
                    danceCourse.getInstructorList().add(instructor);
                } else {
                    danceCourse.setInstructorList(List.of(instructor));
                }
            } else {
                System.err.println("Yeterli bakiyesi olan banka Hesabı olmadığı için öğretmen alımı yapılamaz");
            }
        } else {
            System.err.println("Banka Hesabı olmadığı için öğretmen alımı yapılamaz");
        }
    }

    // ödeme işlemlerini dans kursu objectindeki ödeme işlemleri list'ine ekliyoruz
    // bu işlemleri bünyesinde tutması için. Böylece Dans kursunun daha önceki ödeme işlemlerini
    // bu sayede öğrenmiş oluyoruz.
    public void addPaymentMovementToDanceCourse(DanceCourse danceCourse, PaymentMovement paymentMovement) {

        if (danceCourse.getPaymentMovementList() != null) {
            danceCourse.getPaymentMovementList().add(paymentMovement);
        } else {
            List<PaymentMovement> paymentMovementList = new ArrayList<>();
            paymentMovementList.add(paymentMovement);
            danceCourse.setPaymentMovementList(paymentMovementList);
        }
    }

    public void addLectureToDanceCourse(DanceCourse danceCourse, Lecture lecture) {

        if (danceCourse.getLectureList() != null) {
            danceCourse.getLectureList().add(lecture);
        } else {
            danceCourse.setLectureList(List.of(lecture));
        }


    }


}
