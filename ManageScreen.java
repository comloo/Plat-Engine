import java.awt.*;
import javax.swing. *;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.filechooser.*;
/**
 * This program creates a panel that allows the user toedit existing entries. 
 * 
 * @author Wendy Fu
 * @version 4.0, June 7, 2014       
 */
public class ManageScreen extends JPanel //implements ActionListener
{
  /**
   * @param currentRecord creates a new int.
   */ 
  static int currentRecord=0;
  /**
   * @param gameNameTextField creates a new JTextField.
   */
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
  /**
   * @param saveLabel creates a new JLabel.
   */ 
  JLabel saveLabel = new JLabel();
  /**
   * @param prevLabel creates a new JLabel.
   */ 
  JLabel prevLabel = new JLabel();
  /**
   * @param nextLabel creates a new JLabel.
   */ 
  JLabel nextLabel = new JLabel();
  /**
   * @param deleteLabel creates a new JLabel.
   */ 
  JLabel deleteLabel = new JLabel();
  /**
   * @param font1 creates a new Font.
   */ 
  Font font1 = new Font("SansSerif", Font.BOLD, 20);
  /**
   * The ManageScreen constructor that calls the initComponents method to create the UI.
   */
  public ManageScreen() {
    GameSetPersonal.numRecords=0;
    askData();
    initComponents();
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
      System.out.print("size"+MainScreen.gSP.size());
      System.out.println("  cr"+currentRecord);
      
      MainScreen.gSP.get(currentRecord).setGameName (gameName);
      filled = true;
    }
    if (!gameCompany.isEmpty())
    {
      MainScreen.gSP.get(currentRecord).setGameCompany (gameCompany);
    }
    if (!gameSize.isEmpty())
    {
      MainScreen.gSP.get(currentRecord).setGameSize (gameSize);
    }
    if (!gameIntro.isEmpty())
    {
      MainScreen.gSP.get(currentRecord).setGameIntro (gameIntro);      
    }
    MainScreen.gSP.get(currentRecord).setReleaseDateY(releaseDateY);
    MainScreen.gSP.get(currentRecord).setReleaseDateM(releaseDateM);
    MainScreen.gSP.get(currentRecord).setReleaseDateD(releaseDateD);
    MainScreen.gSP.get(currentRecord).setGenre(genre);
    if (filled == false)
    {
      JOptionPane.showMessageDialog (this, "Please fill the game name", "EMPTY FIELDS", JOptionPane.INFORMATION_MESSAGE);
    }
    reload ();
  }
  /**
   * This method shows the previous record.
   */
  private void prevRecord ()
  {
    if (currentRecord == 0)
    {    
      currentRecord = (MainScreen.gSP.size() - 1);
    }
    else 
    {
      currentRecord --; 
    }
    reload ();
  }
  /**
   * This method deletes the record currently in view.
   */
  public void deleteRecord()
  {
    MainScreen.gSP.remove (currentRecord); 
    if (MainScreen.gSP.size () == 0)
    {       
      MainScreen.gSP.add (new GameSetPersonal ());
    }
    if (currentRecord != 0)
      prevRecord (); 
    reload();
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
    String releaseDateY = (""+ MainScreen.gSP.get (recordNum).getReleaseDateY());
    String releaseDateM = (""+ MainScreen.gSP.get (recordNum).getReleaseDateM());
    String releaseDateD = (""+ MainScreen.gSP.get (recordNum).getReleaseDateD());
    String gameSize = ("" + MainScreen.gSP.get(recordNum).getGameSize());
    String gameGenre = (""+ MainScreen.gSP.get(recordNum).getGenre());
    String gameIntro = ("" + MainScreen.gSP.get(recordNum).getGameIntro());
    String wholeEntry =  gameName + ";;;" + gameCompany + ";;;" + releaseDateY + ";;;" + releaseDateM + ";;;" + releaseDateD + ";;;" + gameSize + ";;;" + gameGenre + ";;;" + gameIntro;
    if (wholeEntry.equals ("null;;;null;;;Unknown;;;Unknown;;;Unknown;;;null;;;Unknown;;;null"))
      wholeEntry = "";
    return wholeEntry;
  }
  /**
   * This method adds a database to the program.
   */
  public void addDatabase ()
  {
    MainScreen.gSP.clear ();
    MainScreen.gSP.add(new GameSetPersonal ()); 
    currentRecord = 0;
    reload ();
  }
  /**
   * This method opens up a file and separates the data into an array.
   * 
   * @param marker creates a new int.
   * @param temp creates a new String array.
   */
  public void openRec (String line, int number)
  {
    int marker = 0, entryComponent = 1;
    String [] temp = line.split (";;;");
    MainScreen.gSP.add(new GameSetPersonal (temp[0],temp[1] ,temp[2] ,temp[3] ,temp[4] ,temp[5] ,temp[6] ,temp[7] ));
    currentRecord = number;
    reload();
  }
  /**
   * This method refreshes / reloads the program.
   */
  public void reload ()
  {
    if (MainScreen.gSP.size() > currentRecord) {
      gameNameTextField.setText (MainScreen.gSP.get(currentRecord).getGameName());
      gameCompanyTextField.setText (MainScreen.gSP.get(currentRecord).getGameCompany());
      releaseDateYComboBox.setSelectedItem (MainScreen.gSP.get(currentRecord).getReleaseDateY());
      releaseDateMComboBox.setSelectedItem (MainScreen.gSP.get(currentRecord).getReleaseDateM());
      releaseDateDComboBox.setSelectedItem (MainScreen.gSP.get(currentRecord).getReleaseDateD());
      gamesizeTextField.setText (MainScreen.gSP.get(currentRecord).getGameSize());
      genreComboBox.setSelectedItem(MainScreen.gSP.get(currentRecord).getGenre());
      introTextArea.setText (MainScreen.gSP.get(currentRecord).getGameIntro());
    }
  }
  /**
   * This method refreshes / reloads the program and gets the chart data.
   */
  public void reloadGetChartData ()
  {
    try{
      reload();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog (null,e);
    }
  }
  public boolean checkBlank()
  {
    if (gameNameTextField.getText().isEmpty()&& gameCompanyTextField.getText().isEmpty()&&gamesizeTextField.getText().isEmpty()&&introTextArea.getText().isEmpty())
      return true;
    else
      return false;
    
  }
  
  
  @SuppressWarnings("unchecked")
  /**
   * This method creates the background and the user interface through buttons, textfields, labels and images.
   * 
   * @param backgroundLabel creates a new JLabel.
   */
    private void initComponents() {
    
    setLayout(null);
    saveLabel.setIcon(new ImageIcon("graphics/saveText.png"));// probably an ImageIcon
    add(saveLabel);
    saveLabel.setBounds(1050,400, 225, 45);
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
        
        saveRecord (gameNameTextField.getText (), gameCompanyTextField.getText (), releaseDateYComboBox.getSelectedItem().toString(),releaseDateMComboBox.getSelectedItem().toString(),releaseDateDComboBox.getSelectedItem().toString(),gamesizeTextField.getText (),genreComboBox.getSelectedItem().toString(), introTextArea.getText ());
        String abc = introTextArea.getText ();
      } 
    });
    
    prevLabel.setIcon(new ImageIcon("graphics/prevText.png"));// probably an ImageIcon
    add(prevLabel);
    prevLabel.setBounds(1050,300, 225, 45);
    prevLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        prevLabel.setIcon(new ImageIcon("graphics/prevtextglow.png"));// probably an ImageIcon
      }
      @Override
      public void mouseExited(MouseEvent e) {
        prevLabel.setIcon(new ImageIcon("graphics/prevText.png"));// probably an ImageIcon
      }    
      @Override
      public void mouseClicked(MouseEvent e) {
        
        prevRecord ();
      } 
    });
    nextLabel.setIcon(new ImageIcon("graphics/nextText.png"));// probably an ImageIcon
    add(nextLabel);
    nextLabel.setBounds(1050,350, 225, 45);
    nextLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        nextLabel.setIcon(new ImageIcon("graphics/nexttextglow.png"));// probably an ImageIcon
      }
      @Override
      public void mouseExited(MouseEvent e) {
        nextLabel.setIcon(new ImageIcon("graphics/nextText.png"));// probably an ImageIcon
      }    
      @Override
      public void mouseClicked(MouseEvent e) {
        
        if (currentRecord == (MainScreen.gSP.size() - 1))
        {
          currentRecord = 0;
        }
        else 
        {
          currentRecord ++;
        }
        reload ();
      } 
    });
    deleteLabel.setIcon(new ImageIcon("graphics/deleteText.png"));// probably an ImageIcon
    add(deleteLabel);
    deleteLabel.setBounds(1050,450, 225, 45);
    deleteLabel.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseEntered(MouseEvent e) {
        deleteLabel.setIcon(new ImageIcon("graphics/deletetextglow.png"));// probably an ImageIcon
      }
      @Override
      public void mouseExited(MouseEvent e) {
        deleteLabel.setIcon(new ImageIcon("graphics/deleteText.png"));// probably an ImageIcon
      }    
      @Override
      public void mouseClicked(MouseEvent e) {
        
        deleteRecord();
      }
    });
    
    JLabel backgroundLabel = new JLabel();    
    backgroundLabel.setIcon(new ImageIcon("graphics/managescreenbackground.png")); // NOI18N
    add(backgroundLabel);
    backgroundLabel.setBounds(0, 30, 1200, 700);
    setVisible (true);
  }
}

