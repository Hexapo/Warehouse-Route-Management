
package projectmain;

import javax.swing.UIManager;

 class ProjectMain 
 {

   
    public static void main(String[] args) 
    {
        
         try 
         { 
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
         } 
         catch(Exception ignored){}
        
       LoginGui frame = new LoginGui();
       frame.setVisible(true);
       frame.setTitle("Εφαρμογή Διαχείρισης Δρομολογίων");
       frame.setResizable(true);
       frame.setLocationRelativeTo(null); 
        
    }
    
}
