/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.frame;

import copm.gui.component.pageListButton;
import copm.gui.component.PagePanel;
import copm.model.container.Page;
import copm.gui.event.PageEvent;
import copm.manager.control.Client;
import copm.manager.data.AuthorityData;
import copm.manager.data.NetworkData;
import copm.manager.data.NewPageData;
import copm.manager.data.ReleaseAuthorityData;
import copm.model.component.Objects;
import copm.manager.data.ProjectData;
import copm.manager.data.SaveData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arsene holmes
 */
public class ClientFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form ProjectFrame
     */
    public ClientFrame() {
        initComponents();
    }
    
    private final static Color colorList[] = {
        Color.BLACK, Color.BLUE, Color.GREEN, Color.GRAY,
        Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW 
    };
    private int selectedShape = Objects.TEXTBOX;
    private Color selectedColor = colorList[0];
    private boolean filled = false;
    private PagePanel nowPage = null;
    private Client manager;
    private boolean authority = false;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shapeButtonGroup = new javax.swing.ButtonGroup();
        pageListButtonGroup = new javax.swing.ButtonGroup();
        popupCreatePage = new javax.swing.JPopupMenu();
        newPage = new javax.swing.JMenuItem();
        pageListPanel = new javax.swing.JPanel();
        pageListBar = new javax.swing.JToolBar();
        toolPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        serverSaveButton = new javax.swing.JButton();
        localSaveButton = new javax.swing.JButton();
        textBoxButton = new javax.swing.JToggleButton();
        ovalButton = new javax.swing.JToggleButton();
        rectangleButton = new javax.swing.JToggleButton();
        lineButton = new javax.swing.JToggleButton();
        filledButton = new javax.swing.JToggleButton();
        colorButton = new javax.swing.JButton();
        authorityButton = new javax.swing.JButton();
        authorityToLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        newPage.setText("NewPage");
        newPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPageActionPerformed(evt);
            }
        });
        popupCreatePage.add(newPage);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pageListPanel.setBackground(new java.awt.Color(204, 204, 204));

        pageListBar.setBackground(new java.awt.Color(255, 255, 255));
        pageListBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pageListBar.setFloatable(false);
        pageListBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pageListBar.setRollover(true);
        pageListBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pageListBarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pageListBarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pageListPanelLayout = new javax.swing.GroupLayout(pageListPanel);
        pageListPanel.setLayout(pageListPanelLayout);
        pageListPanelLayout.setHorizontalGroup(
            pageListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageListPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pageListBar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pageListPanelLayout.setVerticalGroup(
            pageListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pageListBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );

        getContentPane().add(pageListPanel, java.awt.BorderLayout.LINE_START);

        toolPanel.setBackground(new java.awt.Color(255, 255, 255));
        toolPanel.setLayout(new javax.swing.BoxLayout(toolPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("굴림", 0, 33)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("COPM");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setMaximumSize(new java.awt.Dimension(110, 37));
        jLabel1.setMinimumSize(new java.awt.Dimension(110, 18));
        jPanel3.add(jLabel1);

        toolPanel.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 235, 59));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        serverSaveButton.setBackground(new java.awt.Color(255, 235, 59));
        serverSaveButton.setText("serverSave");
        serverSaveButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        serverSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverSaveButtonActionPerformed(evt);
            }
        });
        jPanel4.add(serverSaveButton);

        localSaveButton.setBackground(new java.awt.Color(255, 235, 59));
        localSaveButton.setText("localSave");
        localSaveButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        localSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localSaveButtonActionPerformed(evt);
            }
        });
        jPanel4.add(localSaveButton);

        textBoxButton.setBackground(new java.awt.Color(255, 235, 59));
        shapeButtonGroup.add(textBoxButton);
        textBoxButton.setSelected(true);
        textBoxButton.setText("TextBox");
        textBoxButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textBoxButton.setFocusable(false);
        textBoxButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textBoxButton.setOpaque(true);
        textBoxButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        textBoxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBoxButtonActionPerformed(evt);
            }
        });
        jPanel4.add(textBoxButton);

        ovalButton.setBackground(new java.awt.Color(255, 235, 59));
        shapeButtonGroup.add(ovalButton);
        ovalButton.setText("Oval");
        ovalButton.setToolTipText("");
        ovalButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ovalButton.setFocusable(false);
        ovalButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ovalButton.setOpaque(true);
        ovalButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ovalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovalButtonActionPerformed(evt);
            }
        });
        jPanel4.add(ovalButton);

        rectangleButton.setBackground(new java.awt.Color(255, 235, 59));
        shapeButtonGroup.add(rectangleButton);
        rectangleButton.setText("Rectangle");
        rectangleButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        rectangleButton.setFocusable(false);
        rectangleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rectangleButton.setOpaque(true);
        rectangleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });
        jPanel4.add(rectangleButton);

        lineButton.setBackground(new java.awt.Color(255, 235, 59));
        shapeButtonGroup.add(lineButton);
        lineButton.setText("Line");
        lineButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lineButton.setFocusable(false);
        lineButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lineButton.setOpaque(true);
        lineButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineButtonActionPerformed(evt);
            }
        });
        jPanel4.add(lineButton);

        filledButton.setBackground(new java.awt.Color(255, 235, 59));
        filledButton.setText("Filled");
        filledButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        filledButton.setFocusable(false);
        filledButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        filledButton.setOpaque(true);
        filledButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        filledButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filledButtonActionPerformed(evt);
            }
        });
        jPanel4.add(filledButton);

        colorButton.setBackground(new java.awt.Color(255, 235, 59));
        colorButton.setText("Color");
        colorButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        colorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorButtonActionPerformed(evt);
            }
        });
        jPanel4.add(colorButton);

        authorityButton.setBackground(new java.awt.Color(255, 235, 59));
        authorityButton.setText("getAuthority");
        authorityButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        authorityButton.setFocusable(false);
        authorityButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        authorityButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        authorityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorityButtonActionPerformed(evt);
            }
        });
        jPanel4.add(authorityButton);
        jPanel4.add(authorityToLabel);

        toolPanel.add(jPanel4);

        getContentPane().add(toolPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2312, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textBoxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBoxButtonActionPerformed
        // TODO add your handling code here:
        selectedShape = Objects.TEXTBOX;
        filledButton.setVisible(false);
        colorButton.setVisible(false);
    }//GEN-LAST:event_textBoxButtonActionPerformed

    private void ovalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovalButtonActionPerformed
        // TODO add your handling code here:
        selectedShape = Objects.OVAL;
        filledButton.setVisible(true);
        colorButton.setVisible(true);
    }//GEN-LAST:event_ovalButtonActionPerformed

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButtonActionPerformed
        // TODO add your handling code here:
        selectedShape = Objects.RECTANGLE;
        filledButton.setVisible(true);
        colorButton.setVisible(true);
    }//GEN-LAST:event_rectangleButtonActionPerformed

    private void filledButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filledButtonActionPerformed
        // TODO add your handling code here:
        filled = filledButton.isSelected();
    }//GEN-LAST:event_filledButtonActionPerformed

    private void newPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPageActionPerformed
        // TODO add your handling code here:
        String s = (String)JOptionPane.showInputDialog(
                    this,"Enter title of the page:\n"
                    ,"Create new Page",JOptionPane.PLAIN_MESSAGE,
                    null, null, "");
        if(s != null && s.length() > 0){
            System.out.println(s);
            manager.sendData(new NewPageData(s));
        }
    }//GEN-LAST:event_newPageActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void authorityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorityButtonActionPerformed
        // TODO add your handling code here:
        if(nowPage == null){
            System.out.println("now page is null");
            return;
        }
        System.out.println("clicked : " + authorityButton.getText());
        if(authorityButton.getText().compareTo("getAuthority") == 0){
            manager.sendData(new AuthorityData(nowPage.getID(), manager.getNickName()));
            System.out.println("send get authority");
        }
        else{
            manager.sendData(new ReleaseAuthorityData(nowPage.getID()));
        }
    }//GEN-LAST:event_authorityButtonActionPerformed

    private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineButtonActionPerformed
        // TODO add your handling code here:
        selectedShape = Objects.LINE;
        filledButton.setVisible(false);
        colorButton.setVisible(true);
    }//GEN-LAST:event_lineButtonActionPerformed

    private void serverSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverSaveButtonActionPerformed
        // TODO add your handling code here:
        String s = (String)JOptionPane.showInputDialog(
            this,"Enter file Name:\n"
            ,"Save project in server",JOptionPane.PLAIN_MESSAGE,
            null, null, "");
        if(s != null && s.length() > 0){
            System.out.println(s);
            manager.sendData(new SaveData(s));
        }
    }//GEN-LAST:event_serverSaveButtonActionPerformed

    private void localSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localSaveButtonActionPerformed
        // TODO add your handling code here:
        manager.sendData(new ProjectData());
    }//GEN-LAST:event_localSaveButtonActionPerformed

    private void colorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorButtonActionPerformed
        // TODO add your handling code here:
        selectedColor = new JColorChooser().showDialog(null, "Select Color", selectedColor);
        newPage.repaint();
    }//GEN-LAST:event_colorButtonActionPerformed

    private void pageListBarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pageListBarMouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger()){
            popupCreatePage.show(pageListPanel, evt.getX(),HEIGHT + evt.getY());
        }
    }//GEN-LAST:event_pageListBarMouseReleased

    private void pageListBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pageListBarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pageListBarMousePressed

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
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientFrame().setVisible(true);
            }
        });
    }
    public void setAuthority(boolean authority){
        System.out.println("Authority : " + authority);
        if(authority){
            authorityButton.setText("releaseAuthority");
        }
        else{
            if(nowPage.getFocuseObjects() != null){
                nowPage.getFocuseObjects().setFocuse(false);
            }
            authorityButton.setText("getAuthority");
        }
        this.authority = authority;
    }
    public void authorityTo(String nickName){
        System.out.println("authority to : " + nickName);
        if(nickName == null){
            authorityToLabel.setText("");
        }
        else{
            authorityToLabel.setText("Authority To : " + nickName);
        }
    }
    public boolean getAuthority(){
        return authority;
    }
    
    public void init(Client manager){
        this.manager = manager;
        textBoxButton.setSelected(true);
        filledButton.setVisible(false);
        colorButton.setVisible(false);
    }
    
    public void setText(UUID objectID, String text){
        nowPage.setText(objectID, text);
    }
    
    public void removeObject(UUID id){
        nowPage.removeObjects(id);
    }
    
    public void loadPage(Page page){
        if(nowPage != null){
            BorderLayout layout = (BorderLayout) getContentPane().getLayout();
            getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
        }
        nowPage = new PagePanel(page, manager);
        add(nowPage ,BorderLayout.CENTER);
        this.revalidate();
        //SwingUtilities.updateComponentTreeUI(this);
        System.out.println("loadPage");
        nowPage.repaint();
        
    }
    
    public PagePanel getNowPage(){
        return nowPage;
    }
    
    public void addPageList(String title, UUID id){
        pageListButton tmp = new pageListButton(id, title, manager);
        pageListButtonGroup.add(tmp);
        pageListBar.add(tmp);
        System.out.println("addPagelist");
        if(nowPage != null){
            nowPage.repaint();
        }
        pageListPanel.repaint();
    }
    public int getSelectedShape(){
        return selectedShape;
    }
    public Color getSelectedColor(){
        return selectedColor;
    }
    public boolean isItFilled(){
        return filled;
    }
    public void addNewObject(Objects tmp){
        nowPage.addNewObjects(tmp, manager);
        nowPage.revalidate();
        nowPage.repaint();
        this.revalidate();
        System.out.println("add Object");
    }
    public void reviseObject(UUID objectID, int[] reviseData){
        System.out.println("repaint");
        nowPage.revise(objectID, reviseData);
        nowPage.repaint();
    }
    public void showFrame(){
//        setResizable(false);
        setVisible(true);
        jLabel1.setSize(pageListBar.getWidth(), jPanel4.getWidth());
        setBackground(new Color(63,81,181));
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                manager.close();
                System.exit(0);//cierra aplicacion
            }
        });
        setTitle("COPM - Client");
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authorityButton;
    private javax.swing.JLabel authorityToLabel;
    private javax.swing.JButton colorButton;
    private javax.swing.JToggleButton filledButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton lineButton;
    private javax.swing.JButton localSaveButton;
    private javax.swing.JMenuItem newPage;
    private javax.swing.JToggleButton ovalButton;
    private javax.swing.JToolBar pageListBar;
    private javax.swing.ButtonGroup pageListButtonGroup;
    private javax.swing.JPanel pageListPanel;
    private javax.swing.JPopupMenu popupCreatePage;
    private javax.swing.JToggleButton rectangleButton;
    private javax.swing.JButton serverSaveButton;
    private javax.swing.ButtonGroup shapeButtonGroup;
    private javax.swing.JToggleButton textBoxButton;
    private javax.swing.JPanel toolPanel;
    // End of variables declaration//GEN-END:variables
}
