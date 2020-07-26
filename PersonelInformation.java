
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zeynep
 */
public class PersonelInformation extends javax.swing.JFrame {

    DefaultTableModel model;
    private PreparedStatement preparedstatement=null;
   
    public PersonelInformation() {
        initComponents();
        model= new DefaultTableModel();
        model= (DefaultTableModel)personeltable.getModel();
        
        FillCombo();
    }
     public void FillCombo(){
         Baglanti a=new Baglanti();
      try{
          String sorgu="SELECT Status FROM tbPersonal GROUP BY Status";
          preparedstatement=a.con.prepareStatement(sorgu);
          ResultSet rs=preparedstatement.executeQuery();
          
          while(rs.next()){
              String status=rs.getString("Status");
              jComboBox1.addItem(status);
          }
          
          
      }catch(Exception ex){
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
             int id=rs.getInt("PersonalID");
             String nsn=rs.getString("NameSurname");
             int l=rs.getInt("Level");
             String st=rs.getString("Status");
             int i=rs.getInt("İmza");
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
       public void calisanGuncelle(int i,String a,int l,int sgn,String st,String un) throws ParseException{
         Baglanti b=new Baglanti(); 
        String sorgu="Update tbPersonal SET NameSurname=?,Level=?,İmza=?,Status=?,Username=?,CertificateDate=? WHERE PersonalID=?";
     try {
         b.preparedstatement=b.con.prepareStatement(sorgu);
         b.preparedstatement.setString(1, a);
         b.preparedstatement.setInt(2, l);
         b.preparedstatement.setInt(3, sgn);
         b.preparedstatement.setString(4, st);
         b.preparedstatement.setString(5, un);
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
         String d=sdf.format(jDateChooser1.getDate());
         b.preparedstatement.setString(6,d);
         b.preparedstatement.setInt(7, i);
         
         b.preparedstatement.executeUpdate();
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personeltable = new javax.swing.JTable();
        listBtn = new javax.swing.JButton();
        dltBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nsntxt = new javax.swing.JTextField();
        leveltxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        stxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        untxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        addBtn = new javax.swing.JButton();
        slctDatebtn = new javax.swing.JButton();
        datetxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        passtxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        personeltable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name Surname", "Level", "Signature", "Status", "Username", "Certificate Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        personeltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personeltableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(personeltable);
        if (personeltable.getColumnModel().getColumnCount() > 0) {
            personeltable.getColumnModel().getColumn(0).setResizable(false);
            personeltable.getColumnModel().getColumn(1).setResizable(false);
            personeltable.getColumnModel().getColumn(2).setResizable(false);
            personeltable.getColumnModel().getColumn(3).setResizable(false);
            personeltable.getColumnModel().getColumn(4).setResizable(false);
            personeltable.getColumnModel().getColumn(5).setResizable(false);
            personeltable.getColumnModel().getColumn(6).setResizable(false);
        }

        listBtn.setText("List");
        listBtn.setPreferredSize(new java.awt.Dimension(100, 25));
        listBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBtnActionPerformed(evt);
            }
        });

        dltBtn.setText("Delete");
        dltBtn.setPreferredSize(new java.awt.Dimension(100, 25));
        dltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Name Surname:");

        jLabel2.setText("               Level:");

        jLabel3.setText("Signature:");

        jLabel4.setText("Username:");

        untxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                untxtActionPerformed(evt);
            }
        });

        jLabel5.setText("Certificate Date:");

        jLabel6.setText("Status:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        slctDatebtn.setText("Select");
        slctDatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slctDatebtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(listBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(dltBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datetxt)
                            .addComponent(addBtn)
                            .addComponent(untxt)
                            .addComponent(stxt)
                            .addComponent(leveltxt)
                            .addComponent(nsntxt)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(slctDatebtn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dltBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nsntxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(leveltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(stxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(untxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slctDatebtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBtn)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBtnActionPerformed
      try {
           ArrayList<Personel> p=getPersonel();
           for(Personel personel:p){
               Object[] row={personel.getId(),personel.getAdsoyad(),personel.getLevel(),personel.getSignature(),personel.getSt(),personel.getUsername(),personel.getSertifika()};
               model.addRow(row);
           }
       } catch (SQLException ex) {
           Logger.getLogger(PersonelInformation.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_listBtnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        Baglanti a=new Baglanti();
        String sorgu="INSERT INTO tbPersonal(NameSurname,Level,İmza,Password,Status,Username,CertificateDate) VALUES(?,?,?,?,?,?,?)";
       try {
         preparedstatement=a.con.prepareStatement(sorgu);
         preparedstatement.setString(1,nsntxt.getText());
         preparedstatement.setInt(2, Integer.parseInt(leveltxt.getText()));
         preparedstatement.setInt(3, Integer.parseInt(stxt.getText()));
         preparedstatement.setInt(4,Integer.parseInt(passtxt.getText()));
         preparedstatement.setString(5,jComboBox1.getSelectedItem().toString());
         preparedstatement.setInt(6, Integer.parseInt(untxt.getText()));
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
         String date=sdf.format(jDateChooser1.getDate());
         preparedstatement.setString(7,date);


         
         
         int result=preparedstatement.executeUpdate();
         
           
           
       } catch (SQLException ex) {
           Logger.getLogger(PersonelInformation.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_addBtnActionPerformed

    private void slctDatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slctDatebtnActionPerformed
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
     String d=sdf.format(jDateChooser1.getDate());
     datetxt.setText(d);
     
    }//GEN-LAST:event_slctDatebtnActionPerformed

    private void dltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltBtnActionPerformed
        int SelectedRowIndex=personeltable.getSelectedRow();
        Baglanti a= new Baglanti();
        int c=Integer.parseInt(model.getValueAt(SelectedRowIndex, 3).toString());
        a.calisanSil(c);
    }//GEN-LAST:event_dltBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Baglanti b=new Baglanti();
       String nsn=nsntxt.getText();
       int level=Integer.parseInt(leveltxt.getText());
       int s=Integer.parseInt(stxt.getText());
       String st=jComboBox1.getSelectedItem().toString();
       String un=untxt.getText();
       
     int selectedrow=personeltable.getSelectedRow();
     if(selectedrow==-1){
         if(model.getRowCount()==0){
             System.out.println("Tablo boş");
         }
         else{
             System.out.println("Çalışan seçiniz");
         }
     }
     else{
           int a=(Integer)model.getValueAt(selectedrow, 0);
           try {
               calisanGuncelle(a,nsn,level, s, st, un);
           } catch (ParseException ex) {
               Logger.getLogger(PersonelInformation.class.getName()).log(Level.SEVERE, null, ex);
           }
         
     }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void personeltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personeltableMouseClicked
       int selectedrow=personeltable.getSelectedRow();
       nsntxt.setText(model.getValueAt(selectedrow, 1).toString());
       leveltxt.setText(model.getValueAt(selectedrow, 2).toString());
       stxt.setText(model.getValueAt(selectedrow, 3).toString());
       untxt.setText(model.getValueAt(selectedrow, 5).toString());
       datetxt.setText(model.getValueAt(selectedrow, 6).toString());
       jComboBox1.setSelectedItem(model.getValueAt(selectedrow, 4).toString());
    }//GEN-LAST:event_personeltableMouseClicked

    private void untxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_untxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_untxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersonelInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonelInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonelInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonelInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonelInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField datetxt;
    private javax.swing.JButton dltBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField leveltxt;
    private javax.swing.JButton listBtn;
    private javax.swing.JTextField nsntxt;
    private javax.swing.JTextField passtxt;
    private javax.swing.JTable personeltable;
    private javax.swing.JButton slctDatebtn;
    private javax.swing.JTextField stxt;
    private javax.swing.JTextField untxt;
    // End of variables declaration//GEN-END:variables
}