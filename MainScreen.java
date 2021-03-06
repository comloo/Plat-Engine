import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * This program creates a database for an user to access their games and info. 
 * 
 * @author Wendy Fu and Simon Yuan
 * @version 4.0, June 7, 2014    
 */
public class MainScreen extends JFrame implements ActionListener {
  

   /**
   * @param d creates a new JDialog.
   */ 
  JDialog d;
  JDialog pick;
  JDialog woof;
  JLabel backgroundLabel = new JLabel();
  /**
   * @param exitLabel creates a new JLabel.
   */ 
  JLabel exitLabel = new JLabel();
  /**
   * @param wS creates a new pointer to reference the WelcomeScreen class.
   */
  static WelcomeScreen wS;
   /**
   * @param maS creates a new pointer to reference the ManageScreen class.
   */
  ManageScreen maS = new ManageScreen();
  ManipulateData mad = new ManipulateData ();
    /**
   * @param gSP creates a ArrayList<GameSetPersonal>.
   */
  static ArrayList<GameSetPersonal> gSP = new ArrayList<GameSetPersonal>();
   /**
   * @param fileName creates a new String.
   */ 
  String fileName;
  /**
   * References the File class and stores the relevant data regarding the
   * FileIO files.
   */
  File f;
    /**
   * @param theFile References the File class and stores the relevant data regarding the FileIO files.
   */
  File theFile;
  JTextField inputField = new JTextField(10);
  /**
   * Stores the int value of the returned value from the error dialog box.
   */
  JButton ok;
    /**
   * Stores the int value of the returned value from the error dialog box.
   */
  int optionPaneResult;
  String location; 
 /**
   * The MainScreen constructor that creates the menu and the menu items.
   * 
   * @param quitItem creates a new JMenuItem "Quit".
   * @param helpItem creates a new JMenuItem "Help".
   * @param aboutItem creates a new JMenuItem "About".
   * @param logoutItem creates a new JMenuItem "Logout".
   * @param fileMenu creates a new JMenu "File".
   * @param helpMenu creates a new JMenu "Help".
   * @param aboutMenu creates a new JMenu "About".
   * @param myMenus creates a new JMenuBar.
   * @param dim creates a reference of the Dimension class.
   * @param aS creates a new reference to the AccountScreen class.
   * @param wS creates a new reference to the WelcomeScreen class.
   */
  public MainScreen() {
    super("MainScreen");  
    pick = new JDialog();
    pick.setSize (400, 150);
    pick.setLayout (new FlowLayout());
    
    woof = new JDialog ();
    woof.setSize (400, 150);
    woof.setLayout (new FlowLayout());
    JLabel woofy = new JLabel ("Please input what you would like to search.");
    JButton ok = new JButton ("Find");
    woof.add (woofy);
    woof.add (inputField);
    woof.add (ok);
    ok.addActionListener(this);
    wS = new WelcomeScreen();
    JMenuItem quitItem = new JMenuItem ("Quit");
    JMenuItem helpItem = new JMenuItem ("Help File");
    JMenuItem newItem = new JMenuItem ("New");
    JMenuItem openItem = new JMenuItem ("Open");
    JMenuItem aboutItem = new JMenuItem ("About");
    JMenuItem saveItem = new JMenuItem ("Save");
    JMenuItem saveAsItem = new JMenuItem ("Save As");
    JMenuItem sortItem = new JMenuItem ("Sort This");
    JMenuItem searchItem = new JMenuItem ("Search");
    
    JMenuItem logoutItem = new JMenuItem ("Logout");
    JMenu fileMenu = new JMenu ("File");
    JMenu helpMenu = new JMenu ("Help");
    JMenu aboutMenu = new JMenu ("About");
    JMenu sortMenu = new JMenu ("Sort");
    
    sortMenu.add (searchItem);
    sortMenu.add (sortItem);
    fileMenu.add(newItem);
    fileMenu.add(openItem);
    fileMenu.add(saveItem);
    fileMenu.add(saveAsItem);
    fileMenu.add (logoutItem);
    fileMenu.add (quitItem);
    
    aboutMenu.add (aboutItem);
    helpMenu.add (helpItem);
    
    JMenuBar myMenus = new JMenuBar ();
    
    myMenus.add (fileMenu);
    myMenus.add (aboutMenu);
    myMenus.add (helpMenu);
    myMenus.add(sortMenu);
    setJMenuBar (myMenus);
    
    
    JLabel dialogField;
    dialogField = new JLabel ("Please choose what you would like to sort by:");
    dialogField.setFont (new Font ("Serif", Font.PLAIN, 16));
    pick.add (dialogField);
    
    JButton nameButton = new JButton ("Name");
    JButton genreButton = new JButton ("Genre");
    JButton sizeButton = new JButton ("Size");
    sizeButton.addActionListener(this);
    nameButton.addActionListener(this);
    genreButton.addActionListener(this);
    pick.add (sizeButton);
    pick.add (nameButton);
    pick.add (genreButton);
    pick.setLocationRelativeTo (this);
    
    searchItem.addActionListener (this);
    sortItem.addActionListener(this);
    aboutItem.addActionListener (this);
    helpItem.addActionListener (this);
    quitItem.addActionListener (this); 
    logoutItem.addActionListener (this);
    saveItem.addActionListener(this);
    saveAsItem.addActionListener(this);
    newItem.addActionListener(this);
    openItem.addActionListener(this);
    getContentPane().add(wS);
    setSize (1200, 740);
    setUndecorated(true);
    setVisible (true);
    setResizable (false);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    setLayout(new BorderLayout());
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    
  }
  
 
  /**
   * This method uses the ActionListener to detect file menu ActionEvents and invokes
   * the appropriate methods in response.
   *
   * @param ae stores the action command.
   * @param progpath creates a new String.
   * @param log creates a new Login.
   */
  public void actionPerformed (ActionEvent ae)
  {
    if (ae.getActionCommand ().equals ("Quit"))
      System.exit (0);
    else if (ae.getActionCommand().equals("Help File"))
    {
      String progpath = new String ("hh.exe help/help.chm");
      try
      {
        Runtime.getRuntime ().exec (progpath);
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(this,"Couldn't find the Help File");
      }
    }
    else if (ae.getActionCommand().equals("Search"))
    {
      woof.setVisible(true);
      mad.searchStr = inputField.getText();
      
      if(inputField.getText().equals(""))
      {        
        JOptionPane.showMessageDialog(this, "Please input the text to search for!", "Error", JOptionPane.ERROR_MESSAGE);
      }
      
      
    }
    
    else if (ae.getActionCommand ().equals ("Sort This"))
    {
      pick.setVisible (true);
    }
    else if (ae.getActionCommand ().equals ("Size"))
    {
      WelcomeScreen.vS.sort(3);
      pick.setVisible (false);
    }
    else if (ae.getActionCommand ().equals ("Name"))
    {
      WelcomeScreen.vS.sort(1);
      pick.setVisible (false);
    }
    else if (ae.getActionCommand ().equals ("Genre"))
    {
      WelcomeScreen.vS.sort(2);
      pick.setVisible (false);
    }
    else if (ae.getActionCommand ().equals ("Logout"))
    {
      this.setVisible(false);
      Login log = new Login();
    }
    else if (ae.getActionCommand ().equals ("Save"))
    {
      save(fileName);
    }
    else if (ae.getActionCommand().equals("Save As")) {
      saveAs();
    } else if (ae.getActionCommand().equals("Open")) {
      openFile();      
    } 
    else if (ae.getActionCommand().equals("New")) {
      maS.addDatabase();
      fileName = null;
    } 
    else if (ae.getActionCommand().equals("About")) {
      
      
      dialog ("Help Me!", "Help Me!", 100, 100);
    }
  }
     /**
   * This method creates a dialog box with features depending on what passes through 
   * the parameters. 
   *
   * @param s1 stores a string that will appear in the dialog box.
   * @param s2 stores a string that will be the header of the dialog box.
   * @param x passes an int that will be the width of the box.
   * @param y passes an int that will be the height of the box.
   * @param dim creates a new reference to the Dimension class.
   */
  public void dialog (String s1, String s2, int x, int y)
  {
    SpringLayout layout = new SpringLayout();
    d = new JDialog (this, s2);
    d.setUndecorated(true);
    d.add(backgroundLabel);
    d.setBounds(0, 0, 510, 278);
    backgroundLabel.setLayout(layout);
    backgroundLabel.setIcon(new ImageIcon("graphics/aboutbackground.png")); // NOI18N
    d.setSize (510, 278);
    d.setResizable (false);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    d.setLocation(dim.width/2-200-this.getSize().width/2, dim.height/2-200-this.getSize().height/2);
    
    
    exitLabel.setIcon(new ImageIcon("graphics/exitText.png"));// probably an ImageIcon
    backgroundLabel.add(exitLabel);
    layout.putConstraint(SpringLayout.EAST, exitLabel, 500, SpringLayout.WEST, this);
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
        d.dispose();
      }
    });
    
    
    setVisible (true);
    d.setLocationRelativeTo(this);
    d.setVisible(true);
  }
   /**
   * This method saves data onto a previously existing file using FileIO operations, or creates 
   * a new file if it wasn't saved previously.
   * 
   * @param output References the PrintWriter class and makes its methods and features available.
   * @param fileName passes a string value through.
   * @e IOException catches FileIO errors.
   */
  private void save(String fileName) {
    System.out.println(fileName);
    if (fileName != null) {
      PrintWriter output;
      try {
        // location= log.u+"files/";
        f = new File("data/"+Login.getInstance().user+"/"+fileName);
        output = new PrintWriter(new FileWriter(f));
        output.println("Plat Engine");
        output.println(gSP.size());
        for (int x = 0; x < gSP.size(); x++) {
          output.println(maS.compressToLine(x));
          System.out.println(x + " " + maS.compressToLine(x));
        }
        output.close();
      } catch (IOException e) {
      }
    } else {
      saveAs();
    }
  }
   /**
   * This method creates a new file to store the current data and allows the user to properly
   * name the file using the JFileChooser class.
   * 
   * @param fileChooser references the JFileChooser class.
   * @param filter creates a new ExampleFileFilter class.
   * @param result stores the action commands of the user in the JFileChooser dialog.
   * @param input references the BufferedReader class.
   * @param e catches FileIO errors.
   */
  private void saveAs() {
    JFileChooser fileChooser = new JFileChooser("data/"+Login.getInstance().user+"/");
    fileChooser.setCurrentDirectory(new java.io.File("data/"+Login.getInstance().user+"/"));
    ExampleFileFilter filter = new ExampleFileFilter();
    filter.addExtension("plat");
    filter.setDescription("Plat Engine Files");
    fileChooser.setFileFilter(filter);
    
    int result = fileChooser.showSaveDialog(this);
    fileName = addExtension(fileChooser.getSelectedFile().getName());
    if (fileName == null || fileName.equals("")) {
      fileName = null;
    } else {
      try {
        
        BufferedReader input = new BufferedReader(new FileReader("data/"+Login.getInstance().user+"/"+fileName));
        optionPaneResult = JOptionPane.showConfirmDialog(this,
                                                         "Filename already exists. Overwrite?", "Warning",
                                                         JOptionPane.YES_NO_OPTION);
        if (optionPaneResult == 0) {
          save(fileName);
        }
        
      } catch (IOException e) {
        save(fileName);
      }
    }
  }
   /**
   * This method adds an extension to the file name the user enters.
   * 
   * @param fileNameString passes a string that is the file name.
   */
  private String addExtension(String fileName) {
    for (int x = 0; x < fileName.length() - 1; x++) {
      if (fileName.charAt(x) == '.') {
        fileName = fileName.substring(0, x);
      }
    }
    return (fileName + ".plat");
  }
    /**
   * This method opens File Chooser and allows users to select a file to open.
   * 
   * @param line1 creates a line for the header.
   * @param numRec creates a new int.
   * @param fileChooser references the JFileChooser class.
   * @param filter creates a new ExampleFileFilter class.
   * @param result stores the action commands of the user in the JFileChooser dialog.
   * @param input references the BufferedReader class.
   * @param e catches FileIO errors.
   */
  private void openFile() {
    String line1 = "";
    int numRec = 0;
    boolean validFile = true;
    
    JFileChooser fileChooser = new JFileChooser("data/"+Login.getInstance().user+"/");
    ExampleFileFilter filter = new ExampleFileFilter();
    filter.addExtension("plat");
    filter.setDescription("Plat Engine");
    fileChooser.setFileFilter(filter);
    int result = fileChooser.showOpenDialog(this);
    theFile = fileChooser.getSelectedFile();
    
    BufferedReader input;
    try {
      input = new BufferedReader(new FileReader(theFile));
      line1 = input.readLine();
      if (theFile == null || theFile.getName().equals("")
            || theFile.getName().length() > 255) {
        JOptionPane.showMessageDialog(this,
                                      "Please pick a file. Go to File > Open.",
                                      "No File Chosen", JOptionPane.ERROR_MESSAGE);
        theFile = null;
        validFile = false;
      } else if (!(filter.getExtension(theFile)).equals("plat")) {
        JOptionPane.showMessageDialog(this, "Wrong Extension",
                                      "Invalid Extension", JOptionPane.ERROR_MESSAGE);
        theFile = null;
        validFile = false;
      } else if (!line1
                   .equals("Plat Engine")) {
        JOptionPane.showMessageDialog(this, "Incorrect Header.",
                                      "Invalid Header", JOptionPane.ERROR_MESSAGE);
        theFile = null;
        validFile = false;
      }
      if (validFile == true) {
        maS.addDatabase();
        numRec = Integer.parseInt(input.readLine());
        
        for (int x = 0; x < numRec; x++) {
          maS.openRec(input.readLine(), x);
          maS.reload ();
        }
      }
    } catch (Exception e) {
    }
    maS.reload ();
  }
  /**
   * The main method that runs the program.
   * 
   * @param sp creates a new reference of the SplashScreen class.
   * @param log creates a new reference of the Login class.
   */
  public static void main(String args[]) {
    SplashScreen sp = new SplashScreen(); 
    Login log = new Login();
    
  } 
}
