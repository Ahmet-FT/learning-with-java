import java.io.*;


abstract class Hesap {
    protected String hesapNumarasi;
    protected String musteriAdi;
    protected double bakiye;

    public Hesap(String hesapNumarasi, String musteriAdi, double bakiye) {
        this.hesapNumarasi = hesapNumarasi;
        this.musteriAdi = musteriAdi;
        this.bakiye = bakiye;
    }

    public abstract void paraYatir(double miktar);

    public abstract void paraCek(double miktar) throws BakiyeYetersizException;

    public String getHesapDetaylari() {
        return "Hesap Numarası: " + hesapNumarasi + ", Müşteri Adı: " + musteriAdi + ", Bakiye: " + bakiye;
    }
}


interface Raporlanabilir {
    void raporOlustur(String dosyaAdi) throws IOException;
}


class BakiyeYetersizException extends Exception {
    public BakiyeYetersizException(String mesaj) {
        super(mesaj);
    }
}


class VadesizHesap extends Hesap implements Raporlanabilir {
    public VadesizHesap(String hesapNumarasi, String musteriAdi, double bakiye) {
        super(hesapNumarasi, musteriAdi, bakiye);
    }

    @Override
    public void paraYatir(double miktar) {
        bakiye += miktar;
        logIslem("Para yatırıldı: " + miktar);
    }

    @Override
    public void paraCek(double miktar) throws BakiyeYetersizException {
        if (bakiye < miktar) {
            throw new BakiyeYetersizException("Bakiye yetersiz.");
        }
        bakiye -= miktar;
        logIslem("Para çekildi: " + miktar);
    }

    @Override
    public void raporOlustur(String dosyaAdi) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi))) {
            writer.write(getHesapDetaylari());
        }
    }

    private void logIslem(String mesaj) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(mesaj + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class VadeliHesap extends Hesap implements Raporlanabilir {
    private double faizOrani;

    public VadeliHesap(String hesapNumarasi, String musteriAdi, double bakiye, double faizOrani) {
        super(hesapNumarasi, musteriAdi, bakiye);
        this.faizOrani = faizOrani;
    }

    @Override
    public void paraYatir(double miktar) {
        bakiye += miktar;
        logIslem("Para yatırıldı: " + miktar);
    }

    @Override
    public void paraCek(double miktar) throws BakiyeYetersizException {
        double ceza = miktar * 0.05;
        if (bakiye < miktar + ceza) {
            throw new BakiyeYetersizException("Bakiye yetersiz.");
        }
        bakiye -= (miktar + ceza);
        logIslem("Para çekildi (ceza dahil): " + miktar + ", Ceza: " + ceza);
    }

    @Override
    public void raporOlustur(String dosyaAdi) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi))) {
            writer.write(getHesapDetaylari());
        }
    }

    private void logIslem(String mesaj) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(mesaj + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Ana sınıf
public class Lab11 {
    public static void main(String[] args) {
        VadesizHesap vadesizHesap = new VadesizHesap("12345", "Ali", 1000);
        VadeliHesap vadeliHesap = new VadeliHesap("67890", "Ayşe", 2000, 0.05);

        try {
            vadesizHesap.paraYatir(500);
            vadesizHesap.paraCek(300);

            vadeliHesap.paraYatir(1000);
            vadeliHesap.paraCek(500);

            vadesizHesap.raporOlustur("vadesiz_rapor.txt");
            vadeliHesap.raporOlustur("vadeli_rapor.txt");
        } catch (BakiyeYetersizException | IOException e) {
            e.printStackTrace();
        }
    }
}
