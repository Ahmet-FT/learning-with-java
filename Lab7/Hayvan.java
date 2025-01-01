public class Hayvan {
    String isim;
    int yas;
    
    void sesCikar() {
        System.out.println("BU hayvan ses cikariyor!");
    }

    void hareketEt() {
        System.out.println("BU hayvan hareket ediyor!");
    }
    
    public class Kedi extends Hayvan {
        @Override
        void sesCikar() {
            System.out.println("Miyav!");
        }
        
        void oyuncakOyna() {
            System.out.println("Kedi oyuncak oynuyor!");
        }
    }
    
    public class Kopek extends Hayvan {
        @Override
        void sesCikar() {
            System.out.println("Hav hav!");
        }
        
        void topOyna() {
            System.out.println("Kopek top oynuyor!");
        }
    }
    
    public class Kus extends Hayvan {
        @Override
        void sesCikar() {
            System.out.println("Cik cik");
        }
        
        void uc() {
            System.out.println("Kus ucuyor!");
        }
    }
    
}
