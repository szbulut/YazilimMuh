
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;


public class Baglanti {
 
 public String kullanici_adi="sa";
 public String parola="Szb0804.";

 public String db_ismi="yazilimprojesii";

 public String host="localhost";

 public int port=1433;
 
 public Connection con=null;
 
 public Statement statement=null;
 
 public PreparedStatement preparedstatement=null;
 

 
 /*public void preparedClsnGtr(String ad){
     
     
     String sorgu="SELECT*FROM tbPersonal where NameSurname="?"";
     try {
         preparedstatement=con.prepareStatement(sorgu);
         preparedstatement.setString(1, ad);
         
         ResultSet rs=preparedstatement.executeQuery();
         
         while(rs.next()){
             String nsn=rs.getString("NameSurname");
             int level=rs.getInt("Level");
             int signature=rs.getInt("İmza");
             int password=rs.getInt("Password");
             
             System.out.println(nsn+level+signature+password);
             
         }
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     
     
     
     
     
     
 }*/
public void calisanAra(String username,int password){
     String sorgu="Select Username,Password FROM tbPersonal where Username=?";
 
     try {
         preparedstatement=con.prepareStatement(sorgu);
         preparedstatement.setString(1, username);
         
         ResultSet rs=preparedstatement.executeQuery();
         while(rs.next()){
           String i=rs.getString("Username");
           int pass=rs.getInt("Password");
         
          
           if(password==pass){
               Raporlar a=new Raporlar();
               a.setVisible(true);
           }
           else{
               System.out.println("Yanlış parola");
             
         }
          
           
           
           
         }
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        
     }
}
public void adminGiris(String username,int password){
     String sorgu="Select Username,Password,Status FROM tbPersonal where Username=?";
 
     try {
         preparedstatement=con.prepareStatement(sorgu);
         preparedstatement.setString(1, username);
         
         ResultSet rs=preparedstatement.executeQuery();
         while(rs.next()){
           String i=rs.getString("Username");
           int pass=rs.getInt("Password");
           String s=rs.getString("Status");
         
          
           if(!s.contains("Admin")||password != pass){
               System.out.println("Yanlış parola");
               
           }
           else{
               Anasayfa a=new Anasayfa();
               a.setVisible(true);
           }
          
           
           
           
         }
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        
     }
}
 
 
 public void preparedCalisanGetir(int id){
  
    String sorgu="SELECT*FROM tbPersonal where PersonalId=?";
     try {
         preparedstatement=con.prepareStatement(sorgu);
         preparedstatement.setInt(1, id);
         
         ResultSet rs=preparedstatement.executeQuery();
         
         while(rs.next()){
             String nsn=rs.getString("NameSurname");
             int level=rs.getInt("Level");
             int signature=rs.getInt("İmza");
             int password=rs.getInt("Password");
             
             System.out.println(nsn+level+signature+password);
             
         }
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    
    
    
}
 
 
public void calisanEkle(){
    
     try {
         statement=con.createStatement();
         String nsn="osman emre balta";
         int l=3;
         int s=158796;
         int pass=154236;
         
         String sorgu="insert into tbPersonal(NameSurname,Level,İmza,Password) VALUES("+"'"+ nsn +"',"+ l +","+ s +","+ pass +")" ;
         
         statement.executeUpdate(sorgu);
         
                 
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    
}
  public ArrayList<Personel> getPersonel() throws SQLException{
         Baglanti a=new Baglanti();
         String sorgu="SELECT*FROM tbPersonal";
         ArrayList<Personel>p=null;
    
     
     try {
         a.statement=a.con.createStatement();
         ResultSet rs=a.statement.executeQuery(sorgu);
         p=new ArrayList<Personel>();
         
         while(rs.next()){
           
             String nsn=rs.getString("NameSurname");
             int parola=rs.getInt("Password");
             int l=rs.getInt("Level");
             String st=rs.getString("Status");
              int i=rs.getInt("İmza");
             int id=rs.getInt("PersonalID");
             String un=rs.getString("Username");
             Date d=rs.getDate("CertificateDate");
             p.add(new Personel(nsn,l,st,i,id,un,d));
             
             System.out.println(nsn);
             
             
             
             
             
         }
         
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
        return p;
    }
  public ArrayList<Kunde> getKunde(){
         Baglanti a=new Baglanti();
         String sorgu="SELECT*FROM Kunde";
         ArrayList<Kunde>k=null;
    
     
     try {
         a.statement=a.con.createStatement();
         ResultSet rs=a.statement.executeQuery(sorgu);
         k=new ArrayList<Kunde>();
         
         while(rs.next()){
           
             String cn=rs.getString("CustomerName");
             int id=rs.getInt("CustomerID");
             int ipid=rs.getInt("InspectionPlaceID");
             
             k.add(new Kunde(cn,id,ipid));
             
             System.out.println(cn);
             
             
             
             
             
         }
         
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
        return k;
      
  }
  public void calisanDegistir(int i,String ns,String st,String l){
     try {
         statement=con.createStatement();
         String sorgu="UPDATE tbPersonal SET NameSurname WHERE PersonalID="+i;
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
      
      
  }
 
 
 
public void calisanSil(int i){
    
     try {
         statement=con.createStatement();
         String sorgu="DELETE from tbPersonal where PersonalID="+i ;
         
         statement.executeUpdate(sorgu);
         
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    
    
    
    
}
public void equSil(int i){
    
     try {
         statement=con.createStatement();
         String sorgu="DELETE from Equipment where EquipmentID="+i ;
         
         statement.executeUpdate(sorgu);
         
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    
    
    
    
}
 
  public void kundeGuncelle(String nsn,String d,String p,int j,int o,int id){
      String sorgu="UPDATE kunde SET tbKunde.CustomerName=?,InspectionPlace.District=?,InspectionPlace.Province=?,JobOrder.JobOrderNo=?,Offer.OfferNo=?  FROM tbKunde AS kunde INNER JOIN InspectionPlace ON kunde.InspectionPlaceID=InspectionPlace.InspectionPlaceID INNER JOIN JobOrder ON kunde.CustomerID=JobOrder.CustomerID INNER JOIN Offer ON kunde.CustomerID=Offer.CustomerID WHERE CustomerID=?";
     try {
         preparedstatement=con.prepareStatement(sorgu);
         preparedstatement.setString(1, nsn);
         preparedstatement.setString(2, d);
         preparedstatement.setString(3, p);
         preparedstatement.setInt(4, j);
         preparedstatement.setInt(5, o);
         preparedstatement.setInt(6, id);
         
         preparedstatement.executeUpdate();

     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
  }


 
 public Baglanti(){
     
  //String url="jdbc:sqlserver://"+host+":"+port+"/"+db_ismi;
    String url="jdbc:sqlserver://localhost:1433/yazilimprojesii";
  
     try{
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     }catch(ClassNotFoundException ex){
      System.out.println("Driver Bulunamadı");
     }
  
     try {
         con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databasename=yazilimprojesii; user=sa ; password=Szb0804. ;");
         System.out.println("Bağlantı başarılı");
     } catch (SQLException ex) {
         //System.out.println("Bağlantı başarısız");
         ex.printStackTrace();
     }
    
 
}
 public static void main(String[] args){
     
     Baglanti b=new Baglanti();
     //System.out.println("silmedem önce");
     //b.calisanArama();
     //b.calisanSil();
     //System.out.println("sildikten sonra");
     //b.calisanArama();
     //b.preparedCalisanGetir(5);
     
     
 }
    
 }



