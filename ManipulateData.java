import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class ManipulateData
{
  boolean match;
  String searchStr;
  
//Sequential Search mehtod
  public int[] sequentialSearch (String[] inputArray, String searchStr)
  {                   
    int index=0; 
    int location[];
    int tempLoc[]=new int[inputArray.length];
    
    if (match==true)
    {
      for (int counter = 0; counter < inputArray.length; counter++)
      {
        if (inputArray[counter].equals(searchStr))
        {
          tempLoc[index] = counter;
          index++;
        }
      }
      location = new int[index];
      for (int counter = 0; counter < index; counter++)
      {
        location [counter] = tempLoc[counter];
      }
    }
    else
    {
      for (int counter = 0; counter < inputArray.length; counter++)
      {
        if (inputArray[counter].equalsIgnoreCase(searchStr) || (inputArray[counter].toLowerCase()).indexOf(searchStr.toLowerCase())!=-1)
        {
          tempLoc[index] = counter;
          index++;
        }
      }
      location = new int[index];
      for (int counter = 0; counter < index; counter++)
      {
        location [counter] = tempLoc[counter];
      }
    }
    
    if(location.length==0)
    { 
      JOptionPane.showMessageDialog(null, "Sorry, this item was not found!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    match=false;
    return location;
  }
}