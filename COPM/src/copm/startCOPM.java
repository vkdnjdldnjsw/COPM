/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm;


/**
 *
 * @author Arsene holmes
 */
public class startCOPM {
    public static void main(String[] args) {
        // TODO code application logic here
        COPM a = new COPM();
        a.initProject();
        a.showFrame();
    //            a.newPage("aaa");
    //            System.out.println("add");
    //            TextBox t = new TextBox(10,10,100,100);
    //            Rectangle d = new Rectangle(10, 10, 100, 100, a.project.getPage(0), true, Color.yellow);
    //            a.addObject(0, d);
    //            a.getMouseInput(0);
    //            
    //            for(int i = 0; i<1000; i++){
    //                a.reviseObject(0, 0, TextBox.makeReviseData(10, 10, 10 + i, 10 + i));
    //                try {
    //                    Thread.sleep(30);
    //                } catch (InterruptedException ex) {
    //                    Logger.getLogger(startCOPM.class.getName()).log(Level.SEVERE, null, ex);
    //                }
    //            }
//        try{
//            FileOutputStream fout = new FileOutputStream("C:\\Users\\Arsene holmes\\a.textBox");
//            ObjectOutputStream oos = new ObjectOutputStream(fout);
//            oos.writeObject(a);
//            oos.close();
//            System.out.println("Done");
//       }catch(Exception ex){
//               ex.printStackTrace();
//       }

//        try{
//            FileInputStream fin = new FileInputStream("C:\\Users\\Arsene holmes\\a.textBox");
//            ObjectInputStream ois = new ObjectInputStream(fin);
//            TextBox textBox = (TextBox) ois.readObject();
//            a.addObjects(0, textBox);
//            ois.close();
//        }catch(Exception ex){
//               ex.printStackTrace();
//        }
        
    }
}
