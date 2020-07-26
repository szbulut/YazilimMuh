
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;





public class ExcelExporting {
        
    
       public void calistir(String a,String b,String c,String d,String e,String f,String g,String h,int x,String raporno) throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Rapor");
        CreationHelper createHelper = wb.getCreationHelper();  
        Row row = sheet.createRow(x);
        row.createCell(0).setCellValue(a);
        row.createCell(1).setCellValue(b);
        row.createCell(2).setCellValue(c);
        row.createCell(3).setCellValue(d);
        row.createCell(4).setCellValue(e);
        row.createCell(5).setCellValue(f);
        row.createCell(6).setCellValue(g);
        row.createCell(7).setCellValue(h);
        

        try  (OutputStream fileOut = new FileOutputStream(new File("C:\\Users\\Zeynep\\Desktop\\projedeneme\\yeni.xls"))) {
    wb.write(fileOut);
}
        
    }
       public static void main(String[] args){
           
       }
    
    
}
