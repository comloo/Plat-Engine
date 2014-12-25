import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.Icon;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.filechooser.*;

/**
 * This program creates a panel that welcomes the user. 
 * 
 * @author Wendy Fu and Simon Yuan
 * @version 4.0, June 7, 2014      
 */
public class WelcomeScreen extends JPanel// implements ActionListener
{
  
  /**
   * @param saveLabel create a new label.
   */  
  JLabel saveLabel = new JLabel();
  /**
   * @param backgroundLabel create the background.
   */  
  
  JLabel backgroundLabel;
  /**
   * @param welcomeBackgroundLabel creates a new label.
   */  
  JLabel welcomeBackgroundLabel = new JLabel();
  /**
   * @param toolBackgroundLabel creates a new label.
   */  
  JLabel toolBackgroundLabel = new JLabel();
  /**
   * @param sideToolBackgroundLabel creates a new label.
   */  
  JLabel sideToolBackgroundLabel = new JLabel();
  /**
   * @param createLabel create a new JLabel.
   */
  JLabel createLabel = new JLabel();
  /**
   * @param createLabel create a new JLabel.
   */
  JLabel manageLabel = new JLabel();
  /**
   * @param createLabel create a new JLabel.
   */
  JLabel viewLabel = new JLabel();
  /**
   * @param createLabel create a new JLabel.
   */
  JLabel accountLabel = new JLabel();
  /**
   * @param mS create a new MainScreen instance.
   */
  MainScreen mS;
  /**
   * @param vS create a new ViewScreen instance.
   */
  static ViewScreen vS = new ViewScreen();
  /**
   * @param cS Access CreateScreen
   */ 
  static CreateScreen cS = new CreateScreen();
  /**
   * @param aS Access AccountScreen
   */
  AccountScreen aS;
  /**
   * @param maS creates a new ManageScreen instance.
   */
  ManageScreen maS = new ManageScreen();
  /*
   * @param jTextField1 user type on the jTextField and search games.
   */
  JTextField jTextField1;
  /**
   * @param toolBarPanel creates a new JPanel.
   */
  JPanel toolBarPanel = new JPanel();
  JPanel sideToolBarPanel = new JPanel();
  /**
   * @param hS creates a new JPanel.
   */
  JPanel hS = new JPanel();
  /**
   * @param cards creates a new JPanel.
   */
  static JPanel cards;
  /**
   * @param cards creates a new Card Layout.
   */
  static CardLayout cl;
  
  /**
   * The WelcomeScreen constructor calls a method to create the components of the panel.
   */
  public WelcomeScreen (){
    
    cS.saved=true;
    initComponents();
    aS = new AccountScreen();  
    addButtons(Login.getInstance().user);
    hS.setSize(1200,600);
    
    hS.setBounds(0,0,1200,650);
    welcomeBackgroundLabel.setIcon(new ImageIcon("graphics/welcomescreenbackground.png"));
    hS.add(welcomeBackgroundLabel);
    welcomeBackgroundLabel.setBounds(0,0, 1200, 750);
    
    cards = new JPanel(new CardLayout());
    cl = (CardLayout)(cards.getLayout());
    cS.setBounds(0,0,1200,650);
    cS.setSize(1200,600);
    vS.setBounds(0,-30,1200,700);
    vS.setSize(1200,600);
    hS.setBounds(0,-30,1200,700);
    hS.setSize(1200,600);
    aS.setBounds(0,-30,1200,700);
    aS.setSize(1200,600);
    maS.setBounds(0,-30,1200,700);
    maS.setSize(1200,600);
    cards.add(cS,"Create Screen");
    cards.add(vS, "View Screen");
    cards.add(hS, "Home Screen");
    cards.add(aS, "Account Screen");
    cards.add(maS, "Manage Screen");
    cards.setBounds(0,-30,1200,700); //controls the bgimg
    add(cards);
    cl.show(cards,"Home Screen");
    setVisible(true);
    validate();
    invalidate();
    repaint();
    
  }
  /**
   * This method creates the background and the user interface through buttons, textfields, labels and images.
   */
  public void initComponents(){   
    setLayout(null);
    setVisible (true);
  }
  
  /**
   * This method creates the buttons at the bottom of the screen.
   * 
   * @param blah passes the username through.
   */
  public void addButtons(final String blah)
  {
    toolBarPanel.setLayout(null);
    toolBarPanel.setSize(1200,100);
    add(toolBarPanel,BorderLayout.SOUTH);
    toolBarPanel.setBounds(0,619,1200,600);
    
    createLabel.setIcon(new ImageIcon("graphics/createText.png")); 
    toolBarPanel.add(createLabel);
    createLabel.setBounds(80,30, 167, 40);
    createLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        createLabel.setIcon(new ImageIcon("graphics/createtextglow.png")); 
      }
      @Override
      public void mouseExited(MouseEvent e) {
        createLabel.setIcon(new ImageIcon("graphics/createText.png"));
      }  
      
      @Override
      public void mouseClicked(MouseEvent e) {
        if (!cS.isVisible() || cS.saved==true)
        {
          cS.saved=false;
          cS.newRec();
          cl.show(cards,"Create Screen");
          setVisible(true);
          validate();
          invalidate();
          repaint();
        }
      }
    });
    
    manageLabel.setIcon(new ImageIcon("graphics/manageText.png")); 
    toolBarPanel.add(manageLabel);
    manageLabel.setBounds(300,32, 229, 49);
    manageLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        manageLabel.setIcon(new ImageIcon("graphics/managetextglow.png")); 
      }
      @Override
      public void mouseExited(MouseEvent e) {
        manageLabel.setIcon(new ImageIcon("graphics/manageText.png")); 
      }   
      @Override
      public void mouseClicked(MouseEvent e) {
        if (MainScreen.gSP.size() > 0)
        {
          cS.reload();
          maS.reload();
          cS.saved=false;
          cl.show(cards,"Manage Screen");
          setVisible(true);
          validate();
          revalidate();
          repaint();
        }
      } 
      
    });
    
    viewLabel.setIcon(new ImageIcon("graphics/viewText.png")); 
    toolBarPanel.add(viewLabel);
    viewLabel.setBounds(575,21, 128, 49);
    viewLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        viewLabel.setIcon(new ImageIcon("graphics/viewtextglow.png")); 
      }
      @Override
      public void mouseExited(MouseEvent e) {
        viewLabel.setIcon(new ImageIcon("graphics/viewText.png")); 
      }   
      @Override
      public void mouseClicked(MouseEvent e) {
        
        cl.show(cards, "View Screen");
        vS.CreateData();
        validate();
        revalidate();
        repaint();
      } 
    });
    
    accountLabel.setIcon(new ImageIcon("graphics/accountText.png")); 
    toolBarPanel.add(accountLabel);
    accountLabel.setBounds(750,26, 225, 45);
    accountLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        accountLabel.setIcon(new ImageIcon("graphics/accounttextglow.png"));
      }
      @Override
      public void mouseExited(MouseEvent e) {
        accountLabel.setIcon(new ImageIcon("graphics/accountText.png"));
      }    
      @Override
      public void mouseClicked(MouseEvent e) {
        
        cl.show(cards, "Account Screen");
        
        validate();
        revalidate();
        repaint();
      } 
    });
    
    toolBackgroundLabel.setIcon(new ImageIcon("graphics/toolbarbackground.jpg")); 
    toolBarPanel.add(toolBackgroundLabel);
    toolBackgroundLabel.setBounds(0, -30, 1200, 150);
    
    toolBarPanel.setVisible (true);
  }
}  

