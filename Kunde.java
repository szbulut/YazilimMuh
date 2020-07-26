
import java.util.Objects;


public class Kunde {
    private String name;
    private int InsID;
    private String district;
    private String province;
    private int offerNo;
    private int jobOrderNo;
    private int CustomerID;
    private int ProvinceID;
    
    public Kunde(String name, String district, String province, int offerNo, int jobOrderNo,int CustomerID) {
        this.name = name;
        this.district = district;
        this.province = province;
        this.offerNo = offerNo;
        this.jobOrderNo = jobOrderNo;
        this.CustomerID=CustomerID;
    }
    public Kunde(String name,int CustomerID,int ProvinceID){
        this.name=name;
        this.CustomerID=CustomerID;
        this.ProvinceID=ProvinceID;
        
    }

    public int getProvinceID() {
        return ProvinceID;
    }

    public void setProvinceID(int ProvinceID) {
        this.ProvinceID = ProvinceID;
    }


    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kunde other = (Kunde) obj;
        if (this.CustomerID != other.CustomerID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public int getInsID() {
        return InsID;
    }

    public void setInsID(int InsID) {
        this.InsID = InsID;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getOfferNo() {
        return offerNo;
    }

    public void setOfferNo(int offerNo) {
        this.offerNo = offerNo;
    }

    public int getJobOrderNo() {
        return jobOrderNo;
    }

    public void setJobOrderNo(int jobOrderNo) {
        this.jobOrderNo = jobOrderNo;
    }

   
    
    
}

