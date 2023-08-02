package util;

// Enum'larla ilgili önemli not. Enumları foreach ile dönmek için statik bir metodu var.
// for (Grade grade : Grade.values()) {
//            System.out.println(grade);
// }
//Grade.values() => values() metodu enumdaki constant'lardan oluşan bir array döner.
public enum Grade {
    A("A", 4), // constant
    B("B", 3), // constant
    C("C", 2), // constant
    D("D", 1), // constant
    F("F", 0); // constant

    /*
     *  final keyword'ü ile ilgili not:
     *
     * Declare constants, immutable variables, and unchangeable references.
     * Bir değişken bildirmek için final kullanıldığında, sabit olur
     * ve atandıktan sonra değeri değiştirilemez
     * Sabitler tipik olarak büyük harflerle yazılır.
     *
     * final, nesne referanslarıyla birlikte kullanıldığında, referansın farklı bir nesneyi
     * gösterecek şekilde değiştirilemeyeceği anlamına gelir. Bununla birlikte,
     * değişken ise nesnenin kendisi yine de değiştirilebilir.
     *
     * Örnek:
     *
     public class UnchangeableReferenceExample {
        public void methodWithFinalReference() {
        final StringBuilder sb = new StringBuilder("Hello"); // final tanımlayarak referansı değiştirilemez yaptık.
        // sb = new StringBuilder("World"); // Error: Referansı değiştirielemez
        sb.append(" World"); // Object'in kendisi değiştirilebilir.
    }
    }
    }
* Grade enum örneği bağlamında, stringValue ve numericValue için final kullanmak,
* bu özelliklerin enum sabitinin başlatılması sırasında ayarlanmasını ve daha sonra
* değiştirilememesini sağlayarak, her Grade sabitini (constant) bir harf notunun ve
* buna karşılık gelen sayısal değerin sabit bir temsili haline getirir.
     */

    private final String stringValue; // variable
    private final int numericValue; // variable

    // enum'larda enum sabitine(constant) spesifik bir değer atamak istersek onu constructor oluşturarak
    // yapıyoruz.
    // Enum sabitine girdiğimiz değerler Constructor'a parametre olarak gidiyor ve ordan değişkenlere assign
    // ediliyor. Sonra bu değişkenlere encapsulation yaparak get metodu aracılığıyla dışardan ulaşıyoruz.
    // Aslında ulaştığımız değer enum sabitimize girdiğimiz değere denk olduğu için enum sabiti'nin değerine
    // ulaşmış oluyoruz.
    Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public int getNumericValue() {
        return numericValue;
    }

    /*
    The toString() method is a special method in Java that provides a string representation of an object.
    In our case, we are overriding the default toString() method to return a custom string representation for a Grade.
    When we use System.out.println(grade), Java will call this toString() method automatically
    to print the grade in a readable form.
    */
    @Override
    public String toString() {
        return "Grade " + stringValue + " corresponds to numeric grade " + numericValue;
    }
}
