
public class Lab7 {
    public static void main(String[] args) {
        Hayvan hayvan = new Hayvan();

        Hayvan.Kedi kedi = hayvan.new Kedi();
        Hayvan.Kopek kopek = hayvan.new Kopek();
        Hayvan.Kus kus = hayvan.new Kus();

        kedi.sesCikar();
        kopek.sesCikar();
        kus.sesCikar();

        System.out.println("");

        kedi.hareketEt();
        kopek.hareketEt();
        kus.hareketEt();
        
        System.out.println("");


        kedi.oyuncakOyna();
        kopek.topOyna();
    }

}