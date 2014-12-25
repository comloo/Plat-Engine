import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.security.*;
import java.io.*;
import javax.swing.Icon;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * This program creates a login algorithm that encrypts and saves user account information. 
 * 
 * @author Wendy Fu and Lucy Liu
 * @version 4.0, June 7, 2014      
 */
public class Login extends JFrame 
{
  /**
   * @param dialog creates a new reference to the JDialog class.
   */
  JDialog dialog;
  /**
   * @param username creates a new pointer to reference the JTextField class.
   */
  final 
    JTextField username= new JTextField (25);
  /**
   * @param password creates a new pointer to reference the JPasswordField class.
   */
  final JPasswordField password= new JPasswordField (25);
  /**
   * @param name creates a new pointer to reference the JLabel class.
   */
  JLabel name = new JLabel();
  /**
   * @param cancel creates a new pointer to reference the JButton class.
   */
  JButton cancel;
  /**
   * @param log creates a new pointer to reference the JButton class.
   */
  JButton log;
  /**
   * @param register creates a new pointer to reference the JButton class.
   */
  JButton register;
  /**
   * @param backgroundLabel creates a new pointer to reference the JLabel class.
   */
  JLabel backgroundLabel=new JLabel();
  /**
   * @param loginLabel creates a new pointer to reference the JLabel class.
   */
  JLabel loginLabel= new JLabel();
  /**
   * @param registerLabel creates a new pointer to reference the JLabel class.
   */
  JLabel registerLabel= new JLabel();
  /**
   * @param guestLabel creates a new pointer to reference the JLabel class.
   */
  JLabel guestLabel= new JLabel();
  /**
   * @param exitLabel creates a new pointer to reference the JLabel class.
   */
  JLabel exitLabel= new JLabel();
  /**
   * @param errorLabel creates a new pointer to reference the JLabel class.
   */
  public static JLabel errorLabel=new JLabel("Invalid login info.");
  static Login login;
  String u;
  static String user = "guest";
  /**
   * The Login constructor sets the layout of the panel and outputs the images and sets them on the panel. 
   * The mouse listener is added to the buttons created.
   * 
   * @param layout creates a new reference to the SpringLayout class.
   */
  public Login ()
  {
    super ("Login");
    
    SpringLayout layout = new SpringLayout();
    
    log = new JButton ("Log in");
    register = new JButton ("Register");
    cancel = new JButton ("Cancel");
    dialog = new JDialog (this,"Log In");
    dialog.setUndecorated(true);
dialog.add(backgroundLabel);
    
   dialog.setBounds(0, 0, 450, 250);
    backgroundLabel.setLayout(layout);
    backgroundLabel.setIcon(new ImageIcon("graphics/loginback.png")); // NOI18N
    layout.putConstraint(SpringLayout.EAST, username, 400, SpringLayout.EAST, this);
    layout.putConstraint(SpringLayout.NORTH, username, 68, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.EAST, password, 400, SpringLayout.EAST, this);
    layout.putConstraint(SpringLayout.NORTH, password, 17, SpringLayout.SOUTH, username);
    
    backgroundLabel.add (username);
    backgroundLabel.add (password);
    backgroundLabel.setSize (450,230);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    dialog.setLocation(dim.width/2-200-this.getSize().width/2, dim.height/2-200-this.getSize().height/2);    
    loginLabel.setIcon(new ImageIcon("graphics/loginText1.png"));// probably an ImageIcon
    backgroundLabel.add(loginLabel);
    layout.putConstraint(SpringLayout.EAST, loginLabel, 100, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, loginLabel, 175, SpringLayout.NORTH, this);
    loginLabel.setVisible(true);
    loginLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        loginLabel.setIcon(new ImageIcon("graphics/logintextglow1.png"));// probably an ImageIcon
      }
      @Override
      public void mouseExited(MouseEvent e) {
        loginLabel.setIcon(new ImageIcon("graphics/loginText1.png"));// probably an ImageIcon
      }   
      @Override
      public void mouseClicked(MouseEvent e) {
        u = username.getText();
        String p = encrypt(String.valueOf(password.getPassword()));
        if (p != null && isValid(u, p)) {
          user = u;          
          MainScreen mS = new MainScreen();         
          backgroundLabel.setVisible(false);
          dispose();
        
        } else {

          backgroundLabel.add(errorLabel);
          errorLabel.setVisible(true);
                    errorLabel.setBounds(0,0,100,20);

          errorLabel.setText("Invalid login info.");

          errorLabel.setForeground(Color.red);
          
        } 
      }
    });
    
    
    registerLabel.setIcon(new ImageIcon("graphics/registerText.png"));// probably an ImageIcon
    backgroundLabel.add(registerLabel);
    layout.putConstraint(SpringLayout.EAST, registerLabel, 240, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, registerLabel, 175, SpringLayout.NORTH, this);
    registerLabel.setVisible(true);
    registerLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        registerLabel.setIcon(new ImageIcon("graphics/registertextglow.png"));// probably an ImageIcon
      }
      @Override
      public void mouseExited(MouseEvent e) {
        registerLabel.setIcon(new ImageIcon("graphics/registerText.png"));// probably an ImageIcon
      }   
      @Override
      public void mouseClicked(MouseEvent e) {
        u = username.getText();
        String p = encrypt(String.valueOf(password.getPassword()));
        if (newUser(u, p)) {
          File dir = new File("data/"+u);
          dir.mkdir();
        } 
        else {
          backgroundLabel.remove(errorLabel);
          backgroundLabel.add(errorLabel);
          errorLabel.setForeground(Color.red);
          errorLabel.setText("Username exists/Null entries!");
          errorLabel.setBounds(230,130,100,20);
          errorLabel.setVisible(true);
        }
      }
    });
    
    guestLabel.setIcon(new ImageIcon("graphics/guestText.png"));// probably an ImageIcon
    backgroundLabel.add(guestLabel);
    layout.putConstraint(SpringLayout.EAST, guestLabel, 420, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, guestLabel, 175, SpringLayout.NORTH, this);
    guestLabel.setVisible(true);
    guestLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        guestLabel.setIcon(new ImageIcon("graphics/guesttextglow.png"));// probably an ImageIcon
      }
      @Override
      public void mouseExited(MouseEvent e) {
        guestLabel.setIcon(new ImageIcon("graphics/guestText.png"));// probably an ImageIcon
      }   
      @Override
      public void mouseClicked(MouseEvent e) {
     
          dialog.setVisible(false);
          File dir = new File("data/guest");
          dir.mkdir();
          dialog.dispose();
        MainScreen mS = new MainScreen();
      }
    });
    
    exitLabel.setIcon(new ImageIcon("graphics/exitText.png"));// probably an ImageIcon
    backgroundLabel.add(exitLabel);
    layout.putConstraint(SpringLayout.EAST, exitLabel, 435, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.NORTH, exitLabel, 7, SpringLayout.NORTH, this);
    exitLabel.setVisible(true);
    exitLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        exitLabel.setIcon(new ImageIcon("graphics/exittextglow.png"));// probably an ImageIcon
      }
      @Override
      public void mouseExited(MouseEvent e) {
        exitLabel.setIcon(new ImageIcon("graphics/exitText.png"));// probably an ImageIcon
      }   
      @Override
      public void mouseClicked(MouseEvent e) {
        System.exit(0);
      }
    });    
    backgroundLabel.setVisible (true);
        dialog.setVisible (true);
    password.setActionCommand("Log in");
   
    
  }
  
  public static Login getInstance() {
    return login;
  }
  
  /**
   * This method returns the encrypted password.
   * 
   * @param key creates a new String.
   * @param md5 creates a new instance of the MessageDigest class.
   * @param bytes creates a new 2D byte array.
   * @param string creates a new instance of StringBuilder class.
   */
  public static String encrypt(String pass) {
    String key = "dfajsdfasldkfjlksadjgtpwajflksdg" + Math.sin(1367*54);
    if (!pass.isEmpty()) {
      try {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update((pass + key).getBytes());
        byte[] bytes = md5.digest();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
          string.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return string.toString();
      } catch (Exception e) {}
    }
    return null;
  }
  
  /**
   * This method checks if the user input is valid.
   * 
   * @param f creates a new instance of the File class.
   * @param in creates a new instance of the FileInputStream class.
   * @param output creates a new String.
   * @param c creates a new integer.
   * @param vals creates a new 2D String array.
   * @param fu creates a new String.
   * @param fp creates a new String.
   */
  public static boolean isValid(String u, String p) {
    File f = new File("users/" + u);
    if (f.exists()) {
      try {
        FileInputStream in = new FileInputStream(f);
        String output = "";
        int c;
        while ((c = in.read()) != -1) {
          output += (char) c;
        }
        in.close();
        String[] vals = output.replace(System.getProperty("line.separator"), ":").split(":");
        String fu = vals[1];
        String fp = vals[3];
        if (fu.equalsIgnoreCase(u) && fp.equals(p)) {
          return true;
        }
      } catch (Exception e) {}
    }
    return false;
  }
  
  /**
   * This method creates a new user in the record and stores the info in a subfolder.
   * 
   * @param f creates a instance of the File class.
   * @param out creates a new instance of the FileOutputStream class.
   * @param o creates a new String.
   */
  public static boolean newUser(String u, String p) {
    File f = new File("users/" + u);
    if (!f.exists()) {
      try {
        f.getParentFile().mkdir();
        f.createNewFile();
        FileOutputStream out = new FileOutputStream(f);
        String o = "username:" + u + System.getProperty("line.separator") + "password:" + p;
        out.write(o.getBytes());
        out.flush();
        out.close();
        return true;
      } catch (Exception e) {
      }
    }
    return false;
  }
   /**
   * This method replaces the data of an existing user in the record and stores the info in a subfolder.
   * 
   * @param f creates a instance of the File class.
   * @param out creates a new instance of the FileOutputStream class.
   * @param o creates a new String.
   */
  public static boolean replaceUser(String u, String p) {
    File f = new File("users/" + u);
    
      try {
        f.getParentFile().mkdir();
        f.createNewFile();
        FileOutputStream out = new FileOutputStream(f);
        String o = "username:" + u + System.getProperty("line.separator") + "password:" + p;
        out.write(o.getBytes());
        out.flush();
        out.close();
        return true;
      } catch (Exception e) {
     
      }
    return true;
    
  }
  
  {
    login = this;
  }
  
}