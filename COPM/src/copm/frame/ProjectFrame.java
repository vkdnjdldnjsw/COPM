/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.frame;

import copm.COPM;
import copm.container.Page;
import copm.container.Project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arsene holmes
 */
public class ProjectFrame extends javax.swing.JFrame {

    
    private final static Color colorList[] = {
        Color.BLACK, Color.BLUE, Color.GREEN, Color.GRAY,
        Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW 
    };
    COPM manager;
    Page nowPage = null;
    /**
     * Creates new form ProjectFrame
     */
    public ProjectFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        objectGroup = new javax.swing.ButtonGroup();
        pageGroup = new javax.swing.ButtonGroup();
        popupCreatePage = new javax.swing.JPopupMenu();
        newPage = new javax.swing.JMenuItem();
        jToolBar2 = new javax.swing.JToolBar();
        saveButton = new java.awt.Button();
        TextBox = new javax.swing.JToggleButton();
        rect = new javax.swing.JToggleButton();
        oval = new javax.swing.JToggleButton();
        filled = new javax.swing.JToggleButton();
        colorComboBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        PageList = new javax.swing.JToolBar();

        newPage.setText("new Page");
        newPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newPageMouseClicked(evt);
            }
        });
        newPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPageActionPerformed(evt);
            }
        });
        popupCreatePage.add(newPage);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jToolBar2.setRollover(true);

        saveButton.setLabel("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(saveButton);

        objectGroup.add(TextBox);
        TextBox.setSelected(true);
        TextBox.setText("TextBox");
        TextBox.setFocusable(false);
        TextBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TextBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextBoxActionPerformed(evt);
            }
        });
        jToolBar2.add(TextBox);

        objectGroup.add(rect);
        rect.setText("Rectangle");
        rect.setFocusable(false);
        rect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectActionPerformed(evt);
            }
        });
        jToolBar2.add(rect);

        objectGroup.add(oval);
        oval.setText("Oval");
        oval.setFocusable(false);
        oval.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oval.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        oval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovalActionPerformed(evt);
            }
        });
        jToolBar2.add(oval);

        filled.setText("Filled");
        filled.setFocusable(false);
        filled.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        filled.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        filled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filledActionPerformed(evt);
            }
        });
        jToolBar2.add(filled);

        colorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BLACK", "BLUE", "GREEN", "GRAY", "ORANGE", "PINK", "RED", "WHITE", "YELLOW" }));
        colorComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                colorComboBoxItemStateChanged(evt);
            }
        });
        jToolBar2.add(colorComboBox);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        PageList.setBackground(new java.awt.Color(204, 204, 204));
        PageList.setFloatable(false);
        PageList.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PageList.setRollover(true);
        PageList.setAutoscrolls(true);
        PageList.setMaximumSize(null);
        PageList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PageListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PageListMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PageListMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PageList, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PageList, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectActionPerformed
        System.out.println("rect");
        nowPage.setShape(1);
    }//GEN-LAST:event_rectActionPerformed

    private void colorComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_colorComboBoxItemStateChanged
        System.out.println(colorComboBox.getSelectedItem());
        nowPage.setSelectedColor(colorList[colorComboBox.getSelectedIndex()]);
    }//GEN-LAST:event_colorComboBoxItemStateChanged

    private void ovalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovalActionPerformed
        System.out.println("oval");
        nowPage.setShape(2);
    }//GEN-LAST:event_ovalActionPerformed

    private void TextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBoxActionPerformed
       System.out.println("TextBox");
        nowPage.setShape(0);
    }//GEN-LAST:event_TextBoxActionPerformed

    private void filledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filledActionPerformed
        System.out.println("filled : "+ filled.isSelected());
        nowPage.setFilled(filled.isSelected());
    }//GEN-LAST:event_filledActionPerformed

    private void PageListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PageListMouseClicked

    }//GEN-LAST:event_PageListMouseClicked

    private void PageListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PageListMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_PageListMousePressed

    private void PageListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PageListMouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger()){
            System.out.printf("x %d y %d\n", evt.getX(), evt.getY());
            popupCreatePage.show(jToolBar2, evt.getX(),jToolBar2.HEIGHT + evt.getY());
        }
    }//GEN-LAST:event_PageListMouseReleased

    private void newPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPageMouseClicked

    }//GEN-LAST:event_newPageMouseClicked

    private void newPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPageActionPerformed
        // TODO add your handling code here:
         String s = (String)JOptionPane.showInputDialog(
                    this,"Enter title of the page:\n"
                    ,"Create new Page",JOptionPane.PLAIN_MESSAGE,
                    null, null, "");
        if(s != null && s.length() > 0){
            System.out.println(s);
            manager.newPage(s);
        }
    }//GEN-LAST:event_newPageActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        manager.saveProject();
    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectFrame().setVisible(true);
            }
        });
    }
    public void loadPage(Page page){
        if(nowPage != null){
            BorderLayout layout = (BorderLayout) getContentPane().getLayout();
            getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
        }
        this.nowPage = page;
        setObjectsButton(page.getSelectedShape());
        colorComboBox.setSelectedIndex(getNumberFromColor(page.getSelectedColor()));
        this.filled.setSelected(page.isItFilled());
        add(page,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(this);
    }
    public int getNumberFromColor(Color color){
        System.out.println(color);
        for(int i = 0; i<colorList.length; i++){
            if(colorList[i] == color){
                System.out.println("find");
                return i;
            }
        }
        return 0;
    }
    public void setObjectsButton(int num){
        switch(num){
            case 0:
                TextBox.setSelected(true);
                break;
            case 1:
                rect.setSelected(true);
                break;
            case 2:
                oval.setSelected(true);
                break;
        }
    }
    
    public void init(Project project, COPM manager){
        this.manager = manager;
        for(int i = 0; i< project.getList().size(); i++){
            if(i == 0){
                loadPage(project.getList().get(0));
            }
            addPageList(project.getList().get(i));
        }
    }
    public void addPageList(Page page){
        System.out.println("addPagelist");
        pageListButton tmp = new pageListButton(page, this);
        pageGroup.add(tmp);
        tmp.setSelected(true);
        loadPage(page);
        PageList.add(tmp);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar PageList;
    private javax.swing.JToggleButton TextBox;
    private javax.swing.JComboBox<String> colorComboBox;
    private javax.swing.JToggleButton filled;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem newPage;
    private javax.swing.ButtonGroup objectGroup;
    private javax.swing.JToggleButton oval;
    private javax.swing.ButtonGroup pageGroup;
    private javax.swing.JPopupMenu popupCreatePage;
    private javax.swing.JToggleButton rect;
    private java.awt.Button saveButton;
    // End of variables declaration//GEN-END:variables
}
