
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;


public class Personel {
    private String adsoyad;
    private int level;
    private String st;
    private int signature;
    private int id;
    private String username;
    private Date sertifika;
    
    
    public Personel(String adsoyad, int level, String st,int signature,int id,String username,Date sertifika) {
        this.adsoyad = adsoyad;
        this.level = level;
        this.st = st;
        this.signature=signature;
        this.id=id;
        this.username=username;
        this.sertifika=sertifika;
    }

    public int getSignature() {
        return signature;
    }

    public void setSignature(int signature) {
        this.signature = signature;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getSertifika() {
        return sertifika;
    }

    public void setSertifika(Date sertifika) {
        this.sertifika = sertifika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    
    
}

