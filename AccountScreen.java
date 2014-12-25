import java.awt.*;
import javax.swing. *;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;

/**
 * This program creates a panel that allows the user to create a new entry. 
 * 
 * @author Wendy Fu and Simon Yuan
 * @version 4.0, June 7, 2014     
 */
public class AccountScreen extends JPanel //implements ActionListener
{
  /**
   * @param accountLabel creates a new JLabel.
   */  
  JLabel accountLabel;
  /**
   * @param saveLabel creates a new JLabel.
   */  
  JLabel saveLabel = new JLabel();
  /**
   * @param oldTextField creates a new JTextField.
   */
  JTextField oldTextField = new JTextField ();
  /**
   * @param newTextField creates a new JTextField.
   */
  JTextField newTextField = new JTextField ();
  /**
   * @param confirmTextField creates a new JTextField.
   */
  JTextField confirmTextField = new JTextField ();
  /**
   * @param user creates a new String.
   */
  String user;
  /**
   * @param log creates a new reference to the Login class.
   */
  Login log;
  
  
  /**
   * The AccountScreen constructor that calls the initComponents method to create the UI.
   */
  public AccountScreen() {
    
    log = Login.getInstance();
    initComponents(Login.getInstance().user);
    
  }
  /**
   * This method allows users to change their password.
   * 
   * @param oldPass creates a new String.
   * @param newPass creates a new String.
   * @param confirmPass creates a new String.
   * @param p creates a new String.
   */ 
  public void savePass (String blah)
  {                                        
    if (!blah.equals("guest"))
    {
      String oldPass = oldTextField.getText();
      String newPass = newTextField.getText();
      String confirmPass = confirmTextField.getText();
      
      if (newPass.equals(confirmPass))
      {
        
        String p = log.encrypt(String.valueOf(oldPass));
        System.out.println(p);
        
        if (p != null && log.isValid(blah, p)) 
        {
          
          String q = log.encrypt(String.valueOf(newPass));
          
          log.replaceUser(blah,q);
          
        }
        else
          JOptionPane.showMessageDialog(this,"Current password is incorrect!","Error!", JOptionPane.ERROR_MESSAGE); 
      }
      else
        JOptionPane.showMessageDialog(this,"Passwords do not match!","Error!", JOptionPane.ERROR_MESSAGE); 
    }
    else
      JOptionPane.showMessageDialog(this,"Currently logged in as guest! Log out and register to change passwords.", "Error!", JOptionPane.ERROR_MESSAGE); 
  }
  @SuppressWarnings("unchecked")
  /**
   * This method creates the background and the user interface through buttons, textfields, labels and images.
   * 
   * @param backgroundLabel creates a new JLabel.
   * @param ge creates a reference to the GraphicsEnvironment class
   * @param font1 creates a new Font.
   */
    public void initComponents(final String blah) {   
    removeAll();
    setLayout(null);
    
    oldTextField = new JTextField (500);
    add (oldTextField);
    oldTextField.setBounds(600,320,500,40);
    
    newTextField = new JTextField (500);
    add (newTextField);
    newTextField.setBounds(600,375,500,40);
    
    confirmTextField = new JTextField (500);
    add (confirmTextField);
    confirmTextField.setBounds(600,430,500,40);
    
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    try{
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("graphics/SansationLight.tff")));
    }
    catch(IOException|FontFormatException ex)
    {
    }
    
    Font font1 = new Font("Sansation", Font.BOLD, 40);
    user=blah;
    accountLabel = new JLabel (blah);
    
    add (accountLabel);
    accountLabel.setFont(font1);
    accountLabel.setForeground(Color.white);
    accountLabel.setBounds(50,90,300,80);
    
    
    saveLabel.setIcon(new ImageIcon("graphics/saveText.png"));// probably an ImageIcon
    add(saveLabel);
    saveLabel.setBounds(1050,520, 225, 45);
    saveLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        
        saveLabel.setIcon(new ImageIcon("graphics/savetextglow.png"));// probably an ImageIcon
      }
      @Override
      public void mouseExited(MouseEvent e) {
        
        saveLabel.setIcon(new ImageIcon("graphics/saveText.png"));// probably an ImageIcon
      }    
      @Override
      public void mouseClicked(MouseEvent e) {
        
        savePass(blah);
      } 
    });    
    JLabel backgroundLabel = new JLabel();    
    backgroundLabel.setIcon(new ImageIcon("graphics/accountscreenbackground.png")); // NOI18N
    add(backgroundLabel);
    backgroundLabel.setBounds(0, 30, 1200, 700);
    setVisible (true);                
  }
}

