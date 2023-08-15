/*
*   POKEMON GAME SENARYO:
*
* - Pokemonlarımızı ve Karakterlerimizi oyunun başında sisteme tanımlıyoruz loadService ile.
*
* - Scanner ile 2 tane Player tanımlıyoruz. Kullanıcılar Ad giriyor, karakterini seçiyor sonra pokemonunu seçiyor sırayla.
*
* - Sonra oyuna başlatmak için 1 e çıkmak için 2 e basın diye komut veriyorsun console da.
*
* - Eğer 1'e başlarsa arka planda zar atıyor random 1 mi 2 mi diye bir sonuç dönüyor.
*   Random olarak dönen sonuç 1 ise 1. oyuncu 2 ise 2. oyuncu ilk başlıyor.
*
* - Oyun oynanırken her 2 kullanıcıya her turda pokemonun ve karakterin  özel güçlerini kullanmak ister misin diye soruluyor.
*
* - Eğer özel güçlerden 1'ini kullanmak isterse özel güç ile pokemonun normal saldırısı toplanıp rakibin pokemonuna
*   saldırıyor ve rakibin pokemonunun sağlığından toplam saldırı gücü kadar düşüş sağlanıyor.
*
* - 2 eğer özel güçlerden 2'sini de kullanmak isterse o zaman 2 özel güç ile birlikte pokemonun normal saldırısı
*   toplanıyor ve toplam saldırı gücü kadar rakip oyuncunun pokemonunun sağlığından gidiyor.
*
* - Her pokemonun sağlığı 100 olacak şekilde ayarlanıyor en başta.
*
* - Sonra healthCheck diye bir metodumuz olacak. healthCheck, oyun esnasında 2 oyuncu arasındaki pokemonlardan birinin
*   sağlığı 0 veya 0'ın altına inip inmediğini kontrol eden bir metot olacak. Eğer 2 oyuncu arasındaki pokemonlardan
*   birinin sağlığı 0 veya 0'ın altına indiyse 2. tura geçilecek.
*
* - 2. turda pokemonunun sağlığı 0 ve 0'ın altına inen oyuncu pokemonunu rakibine verecek ve rakibinin çantasına pokemon
*   eklenecek. Kaybeden oyuncu pokemon listesinden saldırı gücü en düşük pokemonu alacak ve onunla savaşmaya
*   devam edecek 2. turda.
*
* - 1. turda kazanan ise 2 pokemonu olmuş olacak. 1. pokemonu oyun başında seçtiği pokemon, 2. pokemonu rakibinden aldığı pokemon.
*
* - 1. turda kazanan oyuncunun pokemonun sağlığı kaçta kaldıysa 2. turda da o sağlıkta savaşmaya devam edecek.
*   Yani canı sıfırlanıp 100 olmayacak. Ama rakibinden aldığı pokemonun sağlığı 100 olarak çantasına eklenecek.
*
* - Oyun karşılıklı oynanacak multiplayer olarak.
*
* - 2. turda kazanan oyunu kazanmış olacak.
*
* - Özel güçlerin hakkı 1 olacak. Özel güç hakkı olmayan oyuncu bir daha kullanmaya kalkarsa ıska vuracak.
*
* */
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}