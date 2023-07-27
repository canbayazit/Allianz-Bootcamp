package service;

import model.BankAccount;
import model.DanceCourse;

import java.math.BigDecimal;

public class BankAccountService {

    public BankAccount createBankAccount(String bankName, String companyName, String iban, BigDecimal amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankName(bankName);
        bankAccount.setCompanyName(companyName);
        bankAccount.setIbanNo(iban);
        bankAccount.setAmount(amount);
        return bankAccount;
    }


    // dans kursumuza bir eğitmeni işe alacaz. Fakat önce kursun banka hesaplarını tek tek dönerek bakiyesini  kontrol
    // ediyoruz. Eğer bakiyemiz eğitmenin maaşını karşılıyorsa o banka hesabını return ediyoruz.
    public BankAccount getBankAccountWithEnoughMoney(DanceCourse danceCourse, BigDecimal amount) {

        for (BankAccount bankAccount : danceCourse.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }


}
