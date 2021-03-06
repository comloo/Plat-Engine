import java.awt.*;
import javax.swing. *;
import java.awt.event.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

/**
 * This program creates a panel that allows the user view the game entries in table view, and bar graph view. 
 * 
 * @author Wendy Fu and Lucy Liu
 * @version 4.0, June 7, 2014      
 */
public class ViewScreen extends JPanel //implements ActionListener
{
/**
   * @param columnNames creates a new string array.
   */  
  String columnNames[];
  /**
   * @param dataValues creates a new string array.
   */  
  String dataValues[] [];
  /**
   * @param myTable creates a new JTable.
   */  
  JTable myTable;
  /**
   * @param maS creates a new ManageScreen instance.
   */
  ManageScreen maS = new ManageScreen();
  /**
   * The ViewScreen constructor that calls the initComponents method to create the UI.
   */
  public ViewScreen() {
    getAddressBook();
  }
    /**
   * This method creates the  constructor that calls the initComponents method to create the UI.
   */
  public void getAddressBook(){
   CreateColumns (); 
setEnabled (false);
    initComponents();

   
  }
    /**
   * This method creates the columns of the table.
   */
 private void CreateColumns ()
  {
    columnNames = new String [5];
    
    columnNames [0] = "Record Number";
    columnNames [1] = "GameName";
    columnNames [2] = "GameGenre";
    columnNames [3] = "ReleaseDate";
    columnNames [4] = "GameSize";
  }
  
  
   /**
   * This method creates the data in the table.
   * 
   * @param myPanel creates a new JPanel.
   */
  public void CreateData ()
  {
    dataValues = new String [MainScreen.gSP.size()] [5];

    if (MainScreen.gSP.size() > 0) {
      try{
        for (int iY = 0 ; iY < MainScreen.gSP.size(); iY++)
        {
          if ((MainScreen.gSP.get(iY).getGameName()!=null)||
              (MainScreen.gSP.get(iY).getGenre()!="Unknown")||
              (MainScreen.gSP.get(iY).getReleaseDateY()==null||MainScreen.gSP.get(iY).getReleaseDateM()==null||MainScreen.gSP.get(iY).getReleaseDateD()==null)||
              (MainScreen.gSP.get(iY).getGameSize()!=null)){
            dataValues [iY] [0] = "" + (iY + 1);
            dataValues [iY] [1] = "" + (MainScreen.gSP.get(iY).getGameName());
            dataValues [iY] [2] = "" + (MainScreen.gSP.get(iY).getGenre());
            dataValues [iY] [3] = "" + (MainScreen.gSP.get(iY).getReleaseDateY()+"/"+MainScreen.gSP.get(iY).getReleaseDateM()+"/"+MainScreen.gSP.get(iY).getReleaseDateD());
            dataValues [iY] [4] = "" + (MainScreen.gSP.get(iY).getGameSize());
          }     
          else if (MainScreen.gSP.get(iY).getReleaseDateY()=="Unknown"&&MainScreen.gSP.get(iY).getReleaseDateM()=="Unknown"&&MainScreen.gSP.get(iY).getReleaseDateD()=="Unknown"){
            dataValues [iY] [3] = "Unknown" ;
          }
          else{
            dataValues [iY] [0] = "" + ManageScreen.currentRecord + 1;
            dataValues [iY] [1] = "" ;
            dataValues [iY] [2] = "Unknown" ;
            dataValues [iY] [4] = "Unknown" ;            
          }
        }
      }
      catch (Exception e){
      }
    }
    
    removeAll();
    JPanel myPanel = new JPanel();
    myPanel.setLayout(new BorderLayout());
    add(myPanel);
    myTable = new JTable (dataValues, columnNames);
    myTable.setColumnSelectionAllowed (true);
    myTable.setCellSelectionEnabled (true);
    myTable.setRowSelectionAllowed (true);
    myTable.setBounds(0,30,1200,700);
    myTable.setVisible(true);
    myTable.setRowHeight (20);  //works
    myTable.setShowVerticalLines (true); //works
    myTable.setShowHorizontalLines (true); //works
    myTable.setEnabled(false);
    
    myTable.setSelectionForeground (Color.green);
    myTable.setSelectionBackground (Color.yellow);
    myTable.setGridColor (Color.blue);
    
    JScrollPane scroll = new JScrollPane (myTable);
    myPanel.add (scroll, BorderLayout.CENTER);
    myPanel.setBounds(0,30,1200,700);
  }
  /** 
   * This method will sort the information in the table in alphabetical order.
   * @param temp a temperary int used for this method only.
   */
  public void sort(int num) {
    if (MainScreen.wS.cS.isVisible() && MainScreen.wS.cS.saved == false) {
      return;
    }
    int temp = 0;
    for (int i = 1; i < MainScreen.gSP.size(); i++) {
      String genre = MainScreen.gSP.get(i).getGenre();
      String name = MainScreen.gSP.get(i).getGameName();
      String intro = MainScreen.gSP.get(i).getGameIntro();
      String releaseY = MainScreen.gSP.get(i).getReleaseDateY();
      String releaseM = MainScreen.gSP.get(i).getReleaseDateM();
      String releaseD = MainScreen.gSP.get(i).getReleaseDateD();
      String size = MainScreen.gSP.get(i).getGameSize();
      String company = MainScreen.gSP.get(i).getGameCompany();
      switch(num) {
        case 1:
          for (temp = i - 1; (temp >= 0 && name.equals("")) || (temp >= 0 && MainScreen.gSP.get(temp).getGameName().charAt(0) > name.charAt(0)); temp--) {
            MainScreen.gSP.get(temp+1).setGenre(MainScreen.gSP.get(temp).getGenre());
            MainScreen.gSP.get(temp+1).setGameName(MainScreen.gSP.get(temp).getGameName());
            MainScreen.gSP.get(temp+1).setGameIntro(MainScreen.gSP.get(temp).getGameIntro());
            MainScreen.gSP.get(temp+1).setReleaseDateY(MainScreen.gSP.get(temp).getReleaseDateY());
            MainScreen.gSP.get(temp+1).setReleaseDateM(MainScreen.gSP.get(temp).getReleaseDateM());
            MainScreen.gSP.get(temp+1).setReleaseDateD(MainScreen.gSP.get(temp).getReleaseDateD());
            MainScreen.gSP.get(temp+1).setGameSize(MainScreen.gSP.get(temp).getGameSize());
            MainScreen.gSP.get(temp+1).setGameCompany(MainScreen.gSP.get(temp).getGameCompany());
          }
          break;
        case 2:
          for (temp = i - 1; (temp >= 0 && genre.equals("")) || (temp >= 0 && MainScreen.gSP.get(temp).getGenre().charAt(0) > genre.charAt(0)); temp--) {
            MainScreen.gSP.get(temp+1).setGenre(MainScreen.gSP.get(temp).getGenre());
            MainScreen.gSP.get(temp+1).setGameName(MainScreen.gSP.get(temp).getGameName());
            MainScreen.gSP.get(temp+1).setGameIntro(MainScreen.gSP.get(temp).getGameIntro());
            MainScreen.gSP.get(temp+1).setReleaseDateY(MainScreen.gSP.get(temp).getReleaseDateY());
            MainScreen.gSP.get(temp+1).setReleaseDateM(MainScreen.gSP.get(temp).getReleaseDateM());
            MainScreen.gSP.get(temp+1).setReleaseDateD(MainScreen.gSP.get(temp).getReleaseDateD());
            MainScreen.gSP.get(temp+1).setGameSize(MainScreen.gSP.get(temp).getGameSize());
            MainScreen.gSP.get(temp+1).setGameCompany(MainScreen.gSP.get(temp).getGameCompany());
          }
          break;
        case 3:
          for (temp = i - 1; (temp >= 0 && size.equals("")) || (temp >= 0 && MainScreen.gSP.get(temp).getGameSize().charAt(0) > size.charAt(0)); temp--) {
            MainScreen.gSP.get(temp+1).setGenre(MainScreen.gSP.get(temp).getGenre());
            MainScreen.gSP.get(temp+1).setGameName(MainScreen.gSP.get(temp).getGameName());
            MainScreen.gSP.get(temp+1).setGameIntro(MainScreen.gSP.get(temp).getGameIntro());
            MainScreen.gSP.get(temp+1).setReleaseDateY(MainScreen.gSP.get(temp).getReleaseDateY());
            MainScreen.gSP.get(temp+1).setReleaseDateM(MainScreen.gSP.get(temp).getReleaseDateM());
            MainScreen.gSP.get(temp+1).setReleaseDateD(MainScreen.gSP.get(temp).getReleaseDateD());
            MainScreen.gSP.get(temp+1).setGameSize(MainScreen.gSP.get(temp).getGameSize());
            MainScreen.gSP.get(temp+1).setGameCompany(MainScreen.gSP.get(temp).getGameCompany());
          }
          break;
   
      }
      MainScreen.gSP.get(temp+1).setGenre(genre);
      MainScreen.gSP.get(temp+1).setGameName(name);
      MainScreen.gSP.get(temp+1).setGameIntro(intro);
      MainScreen.gSP.get(temp+1).setReleaseDateY(releaseY);
      MainScreen.gSP.get(temp+1).setReleaseDateM(releaseM);
      MainScreen.gSP.get(temp+1).setReleaseDateD(releaseD);
      MainScreen.gSP.get(temp+1).setGameSize(size);
      MainScreen.gSP.get(temp+1).setGameCompany(company);
      
      MainScreen.wS.cl.show(MainScreen.wS.cards, "View Screen");
      CreateData();
      MainScreen.wS.validate();
      MainScreen.wS.revalidate();
      MainScreen.wS.repaint();
    }
  }

  @SuppressWarnings("unchecked")
/**
   * This method creates the background and the user interface through buttons, textfields, labels and images.
   * 
   * @param backgroundLabel creates a new JLabel.
   */
    private void initComponents() {   
    setLayout(null);
    JLabel label = new JLabel("view"); 
        add(label);
        label.setBounds(0,30,20,20);
    JLabel backgroundLabel = new JLabel();    
        backgroundLabel.setIcon(new ImageIcon("graphics/background.jpg")); // NOI18N
    add(backgroundLabel);
    backgroundLabel.setBounds(0, 30, 1200, 700);
     setVisible (true);             
}
}

