import java.awt.*;
import javax.swing. *;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.filechooser.*;
/**
 * This program creates a panel that allows the user to create a new entry. 
 * 
 * @author Wendy Fu and Simon Yuan
 * @version 4.0, June 7, 2014     
 */
public class CreateScreen extends JPanel //implements ActionListener
{
    /**
   * @param saved creates a new boolean.
   */
  boolean saved=false;
   /**
   * @param maS creates a new reference to ManageScreen class.
   */
   ManageScreen maS = new ManageScreen();
    JTextField gameNameTextField ;
  /**
   * Create textfield.
   */ 
  JTextField gameCompanyTextField;
  /**
   * Create textfield.
   */ 
  JTextField gamesizeTextField;
  /**
   * Create ComboBox 
   */ 
  JComboBox releaseDateYComboBox;
  /**
   * Create ComboBox 
   */ 
  JComboBox releaseDateMComboBox;
  /**
   * Create ComboBox 
   */ 
  JComboBox releaseDateDComboBox;
  /**
   * Create ComboBox 
   */ 
  JComboBox genreComboBox;
  /**
   * Stores types
   */ 
  String [] types = {"N/A","Action","Adventure","RPG","Simulation","Strategy","Casual","Other"};
    /**
   * Stores dates
   */ 
  String [] dates = {"N/A","January", "February", "March", "April", "May","June","July","August","September","October","November","December"};
    /**
   * Stores day
   */ 
  String [] day = {"N/A","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    /**
   * Stores year
   */ 
  String [] year = { "N/A","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
  /**
   * Create introPane.
   */ 
  JScrollPane introPane;
  /**
   * Create the IntroTextArea.
   */ 
  JTextArea introTextArea;
  /**
   * @param searchButton user will search game by using this button.
   */ 
  JButton searchButton;
  /**
   * @param createButton user will create his/her own game list by using this button.
   */
  JButton createNewButton;
  /**
   * @param randomButton user will random a game.
   */  
  JButton randomButton;
  /**
   * @param greetingLabel the welcome sign.
   */  
  JLabel greetingLabel;
  
  
  JLabel saveLabel = new JLabel();
  
  Font font1 = new Font("SansSerif", Font.BOLD, 20);
  /**
   * The CreateScreen constructor that calls the initComponents method to create the UI.
   */
  public CreateScreen() {    
    MainScreen.gSP.add(new GameSetPersonal ());
    ManageScreen.currentRecord = (MainScreen.gSP.size()-1);
    askData();
    initComponents();    
  }
    /**
   * This method creates a new database entry.
   */
  public void newRec()
  {
   if (!(gameNameTextField.getText ().isEmpty() && gameCompanyTextField.getText ().isEmpty() && gamesizeTextField.getText ().isEmpty() && introTextArea.getText ().isEmpty()))
      {
        ManageScreen.currentRecord = MainScreen.gSP.size();
        MainScreen.gSP.add (new GameSetPersonal());

        reload ();
        releaseDateYComboBox.setSelectedItem ("N/A");
        releaseDateMComboBox.setSelectedItem ("N/A");
        releaseDateDComboBox.setSelectedItem ("N/A");
        genreComboBox.setSelectedItem ("N/A");
      } 
  }
    /**
   * This method sets the locations of the text fields.
   */
   public void askData ()
  {
     gameNameTextField = new JTextField (500);
  
   add (gameNameTextField);
    gameNameTextField.setFont(font1);
    gameNameTextField.setBounds(240,80,300,40);
     gameCompanyTextField = new JTextField (500);
      gameCompanyTextField.setFont(font1);
    gameCompanyTextField.setBounds(300,150,300,40);
    add (gameCompanyTextField); 

        releaseDateMComboBox = new JComboBox (dates);
    add (releaseDateMComboBox);
      releaseDateMComboBox.setFont(font1);
    releaseDateMComboBox.setBounds(380,220,150,40);
 
    releaseDateDComboBox = new JComboBox (day);
   add (releaseDateDComboBox);
         releaseDateDComboBox.setFont(font1);
    releaseDateDComboBox.setBounds(550,220,60,40);
    
    releaseDateYComboBox = new JComboBox (year);
   add (releaseDateYComboBox);
         releaseDateYComboBox.setFont(font1);
    releaseDateYComboBox.setBounds(640,240,125,40);
    
    gamesizeTextField = new JTextField (25);
   add (gamesizeTextField);
           gamesizeTextField.setFont(font1);
    gamesizeTextField.setBounds(300,300,125,40);
    
    genreComboBox = new JComboBox (types);
    this.add (genreComboBox);
     genreComboBox.setFont(font1);
genreComboBox.setBounds(240,370,125,40);

 introPane = new JScrollPane ();
    introTextArea = new JTextArea ();
    introTextArea.setColumns (20);
    introTextArea.setRows (5);
    introPane.setViewportView (introTextArea);
    add (introPane);
     introPane.setFont(font1);
 introPane.setBounds(300,440,600,150);
   }
  
   /**
   * This method saves the information in the textfields into the database.
   * 
   * @param filled creates a new boolean.
   */
   private void saveRecord (String gameName, String gameCompany,String releaseDateY,String releaseDateM,String releaseDateD, String gameSize, String genre,String gameIntro)
  {
    boolean filled = false;
    if (!gameName.isEmpty())
    {   
      MainScreen.gSP.get(ManageScreen.currentRecord).setGameName (gameName);
      filled = true;
    }
    if (!gameCompany.isEmpty())
    {
      MainScreen.gSP.get(ManageScreen.currentRecord).setGameCompany (gameCompany);
    }
    if (!gameSize.isEmpty())
    {
      MainScreen.gSP.get(ManageScreen.currentRecord).setGameSize (gameSize);
    }
    if (!gameIntro.isEmpty())
    {
      MainScreen.gSP.get(ManageScreen.currentRecord).setGameIntro (gameIntro);      
    }
    MainScreen.gSP.get(ManageScreen.currentRecord).setReleaseDateY(releaseDateY);
    MainScreen.gSP.get(ManageScreen.currentRecord).setReleaseDateM(releaseDateM);
    MainScreen.gSP.get(ManageScreen.currentRecord).setReleaseDateD(releaseDateD);
     MainScreen.gSP.get(ManageScreen.currentRecord).setGenre(genre);
    if (filled == false)
    {
      JOptionPane.showMessageDialog (this, "Please fill the game name", "EMPTY FIELDS", JOptionPane.INFORMATION_MESSAGE);
    }
    reload ();
  }
     /**
   * This method compresses the data into one line, separated by ;;;.
   * 
   * @param gameName creates a new String.
   * @param gameCompany creates a new String.
   * @param releaseDateY creates a new String.
   * @param releaseDataM creates a new String.
   * @param releaseDateD creates a new String.
   * @param gameSize creates a new String.
   * @param gameGenre creates a new String.
   * @param gameIntro creates a new String.
   * @param wholeEntry creates a new String.
   */
    public String compressToLine (int recordNum)
  {
    String gameName = ("" + MainScreen.gSP.get(recordNum).getGameName());
    String gameCompany = ("" + MainScreen.gSP.get(recordNum).getGameCompany());
    String releaseDateY = (""+MainScreen.gSP.get (recordNum).getReleaseDateY());
    String releaseDateM = (""+MainScreen.gSP.get (recordNum).getReleaseDateM());
    String releaseDateD = (""+MainScreen.gSP.get (recordNum).getReleaseDateD());
    String gameSize = ("" + MainScreen.gSP.get(recordNum).getGameSize());
    String gameGenre = (""+MainScreen.gSP.get(recordNum).getGenre());
    String gameIntro = ("" + MainScreen.gSP.get(recordNum).getGameIntro());
    String wholeEntry =  gameName + ";;;" + gameCompany + ";;;" + releaseDateY + ";;;" + releaseDateM + ";;;" + releaseDateD + ";;;" + gameSize + ";;;" + gameGenre + ";;;" + gameIntro;
    if (wholeEntry.equals ("null;;;null;;;Unknown;;;Unknown;;;Unknown;;;null;;;Unknown;;;null"))
      wholeEntry = "";
    return wholeEntry;
  }
      /**
   * This method refreshes / reloads the program.
   */
   public void reload ()
  {
    gameNameTextField.setText (MainScreen.gSP.get(ManageScreen.currentRecord).getGameName());
    gameCompanyTextField.setText (MainScreen.gSP.get(ManageScreen.currentRecord).getGameCompany());
    releaseDateYComboBox.setSelectedItem (MainScreen.gSP.get(ManageScreen.currentRecord).getReleaseDateY());
    releaseDateMComboBox.setSelectedItem (MainScreen.gSP.get(ManageScreen.currentRecord).getReleaseDateM());
    releaseDateDComboBox.setSelectedItem (MainScreen.gSP.get(ManageScreen.currentRecord).getReleaseDateD());
    gamesizeTextField.setText (MainScreen.gSP.get(ManageScreen.currentRecord).getGameSize());
    genreComboBox.setSelectedItem(MainScreen.gSP.get(ManageScreen.currentRecord).getGenre());
    introTextArea.setText (MainScreen.gSP.get(ManageScreen.currentRecord).getGameIntro());
  }  
  @SuppressWarnings("unchecked")
   /**
   * This method creates the background and the user interface through buttons, textfields, labels and images.
   * 
   * @param backgroundLabel creates a new JLabel.
   * @param ge creates a reference to the GraphicsEnvironment class
   * @param font1 creates a new Font.
   */
    private void initComponents() {   
    setLayout(null);
    saveLabel.setIcon(new ImageIcon("graphics/saveText.png"));// probably an ImageIcon
    add(saveLabel);
    saveLabel.setBounds(1050,350, 225, 45);
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
        saved = true;
        saveRecord (gameNameTextField.getText (), gameCompanyTextField.getText (), releaseDateYComboBox.getSelectedItem().toString(),releaseDateMComboBox.getSelectedItem().toString(),releaseDateDComboBox.getSelectedItem().toString(),gamesizeTextField.getText (),genreComboBox.getSelectedItem().toString(), introTextArea.getText ());
      String abc = introTextArea.getText ();

      } 
    });

    JLabel backgroundLabel = new JLabel();    
    backgroundLabel.setIcon(new ImageIcon("graphics/createscreenbackground.png")); // NOI18N
    add(backgroundLabel);
    backgroundLabel.setBounds(0, 30, 1200, 700);
    setVisible (true);
  }
}

