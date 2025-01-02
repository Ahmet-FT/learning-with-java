import java.util.*;

public class Lab8 {
    public static void main(String[] args) {
        // Inner class'ları static yaparak doğrudan kullanabiliriz
        Ogrenci ogrenci1 = new Ogrenci();
        Ogrenci ogrenci2 = new Ogrenci("Ali", new ArrayList<>());
        Ogrenci ogrenci3 = new Ogrenci("ahmet", 3, new ArrayList<>());

        ogrenci1.OgrenciBilgisiYaz();
        ogrenci2.OgrenciBilgisiYaz();
        ogrenci3.OgrenciBilgisiYaz();

        ogrenci1.dersListesi.add(new Ders());
        ogrenci2.dersListesi.add(new Ders("Matematik"));
        ogrenci3.dersListesi.add(new Ders("Fizik" ,2 , "Mustafa"));

        ogrenci1.OgrenciDersBilgisiYaz();
        ogrenci2.OgrenciDersBilgisiYaz();
        ogrenci3.OgrenciDersBilgisiYaz();

        Ders.DersSayiBilgisiYaz();


    }

    // Outer sınıf
    public static class Ogrenci {
        public String ad = "bilinmiyor";
        public int sinif = 0;
        public ArrayList<Ders> dersListesi = new ArrayList<>();
        public static int ogrenciSayisi = 0;

        // Constructor'lar
        public Ogrenci() {
            ogrenciSayisi++;
        }

        public Ogrenci(String ad, ArrayList<Ders> dersListesi) {
            this.ad = ad;
            this.dersListesi = dersListesi;
            ogrenciSayisi++;
        }

        public Ogrenci(String ad, int sinif, ArrayList<Ders> dersListesi) {
            this.ad = ad;
            this.sinif = sinif;
            this.dersListesi = dersListesi;
            ogrenciSayisi++;
        }

        // Bilgi yazdırma metotları
        public void OgrenciBilgisiYaz() {
            System.out.println("Öğrenci Adi: " + ad);
            System.out.println("Sinif: " + sinif);
            System.out.println("Toplam Öğrenci Sayisi: " + ogrenciSayisi);
            System.out.println();
        }

        public void OgrenciDersBilgisiYaz() {
            System.out.println(ad + " ders listesi:");
            for (Ders ders : dersListesi) {
                ders.DersBilgisiYaz();
            }
            System.out.println();

        }
    }

    // Ders sınıfı
    public static class Ders {
        public String ad = "bilinmiyor";
        public int sinif = 0;
        public String hoca = "bilinmiyor";
        public static int dersSayisi = 0;

        // Constructor'lar
        public Ders() {
            dersSayisi++;
        }

        public Ders(String ad) {
            this.ad = ad;
            dersSayisi++;
        }

        public Ders(String ad, int sinif, String hoca) {
            this.ad = ad;
            this.sinif = sinif;
            this.hoca = hoca;
            dersSayisi++;
        }

        // Bilgi yazdırma metotları
        public void DersBilgisiYaz() {
            System.out.println("Ders Adi: " + ad);
            System.out.println("Sinif: " + sinif);
            System.out.println("Hoca: " + hoca);
            System.out.println();


        }

        public static void DersSayiBilgisiYaz() {
            System.out.println("Toplam Ders Sayisi: " + dersSayisi);
            System.out.println();
            
        }
    }
}