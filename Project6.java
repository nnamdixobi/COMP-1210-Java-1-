import java.text.DecimalFormat;    
   /** 
 * A complex program that defines object for 3-D geometric shape objects
 * with ten square side faces and two regular decagon caps where edge
 * and height are non-negative. 
 *
 * Project 06.
 * @author Nnamdi Ikenna-Obi - Comp 1210 - section 001.
 * @version September 17, 2021.
 */

public class DecagonalPrism {
  
   // instance variables
   private String label;
   private double edge;
   private double height;
  
   /**
   *3-arg constructor to initialize the fields to specified values.
   *@param labelIn for label
   *@param edgeIn for edge
   *@param heightIn for height
   */
   public DecagonalPrism(String labelIn, double edgeIn, double heightIn) {
       // all the setters to set the values
      setLabel(labelIn);
      setEdge(edgeIn);
      setHeight(heightIn);
   }
  
   /**
   *@return label
   */
   public String getLabel() {
      return label;
   }
  
   /**
   *sets the label. 
   *@return boolean
   *@param labelIn for label
   */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) // label is not null
      {
         label = labelIn.trim(); // trim the label and set it
         return true; // successful
      }
      
      return false; // failed
   }
  
   /**
   *@return edge.
   */
   public double getEdge() {
      return edge;
   }
  
   /**
   *sets the edge. 
   *@return boolean
   *@param edgeIn for edge
   */
   public boolean setEdge(double edgeIn) {
      if (edgeIn >= 0) // edge is non-negative
      {
         edge = edgeIn;
         return true; // successful
      }
      
      return false; // failed
   }

   /**
   *@return height
   */
   public double getHeight() {
      return height;
   }
  
   /**
   *sets height.
   *@return boolean
   *@param heightIn for height
   */
   public boolean setHeight(double heightIn) {
      if (heightIn >= 0) // height is non-negative
      {
         height = heightIn;
         return true; // successful
      }
      
      return false; // failed
   }
  
  /**
   *@return surface area
   */
   public double surfaceArea() {
      return (10 * edge * height + 5 * Math.pow(edge, 2) 
         * Math.sqrt(5 + 2 * Math.sqrt(5)));
   }
  
   /**
   *@return base area
   */

   public double baseArea() {
      return (5.0 / 2.0 * Math.pow(edge, 2) * Math.sqrt(5 + 2 * Math.sqrt(5)));
   }
  
   /**
   *@return lateral surface area
   */
   public double lateralSurfaceArea() {
      return 10 * edge * height;
   }
  
   /** 
   *@return volume
   */
   public double volume() {
      return (((5.0 / 2.0) * Math.pow(edge, 2))  
         * (Math.sqrt(5 + 2 * Math.sqrt(5))) * height);
   }
  
   /**
   *@return String representation of DecagonalPrism.
   */
   public String toString() {
   
      DecimalFormat df = new DecimalFormat("#,##0.0##");
   
      String output = "A decagonal prism \"" + label + "\" with edge = "
         + df.format(edge) + " units and height = " 
         + df.format(height) + " units, has:";
      output += "\n\tsurface area = " + df.format(surfaceArea()) 
         + " square units "; 
      output += "\n\tbase area = " + df.format(baseArea()) + " square units";
      output += "\n\tlateral surface area = " 
         + df.format(lateralSurfaceArea()) + " square units";
      output += "\n\tvolume = " + df.format(volume()) + " cubic units";       
      
      return output;
   }
  
}
//
//
//
//
//
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
*A complex program that defines DecagonalPrismList objects.
*
*Project 05.
*@author - Nnamdi Ikenna-Obi - Comp 1210 - section 001.
*@version September 24th, 2021.
*/

public class DecagonalPrismList {

//instace variable
   private String name;
   private ArrayList<DecagonalPrism> list;

//Constructor
/**
*@param nameIn for name
*@param listIn for list
*/
   public DecagonalPrismList(String nameIn, ArrayList<DecagonalPrism> listIn) {
      name = nameIn;
      list = listIn;
   }
   
   /**
   *@return name
   */
   public String getName() {
      return name;
   }
   
   /**
   *@return number of DecagonalPrism in the list
   */
   public int numberOfDecagonalPrisms() {
      return list.size();
   }
   
   /**
   *@return total surface area
   */
   public double totalSurfaceArea() {
      double total = 0;
      for (int i = 0; i < list.size(); i++) {
         total += list.get(i).surfaceArea();
      }
      return total;
   }
   
   /**
   *@return total base area
   */
   public double totalBaseArea() {
      double total = 0;
      for (int i = 0; i < list.size(); i++) {
         total += list.get(i).baseArea();
      }
      return total;
   }
   
   /**
   *@return total lateral surface area
   */
   
   public double totalLateralSurfaceArea() {
      double total = 0;
      for (int i = 0; i < list.size(); i++) {
         total += list.get(i).lateralSurfaceArea();
      }
      return total;
   }
   
   /**
   *@return total volume
   */
   public double totalVolume() {
      double total = 0;
      for (int i = 0; i < list.size(); i++) {
         total += list.get(i).volume();
      }
      return total;
   }
   
   /**
   *@return average surface area
   */
   public double averageSurfaceArea() {
      if (numberOfDecagonalPrisms() > 0) {
         return totalSurfaceArea() / numberOfDecagonalPrisms();
      }
      return 0;
   }
   
   /**
   *@return average volume
   */
   public double averageVolume() {
      if (numberOfDecagonalPrisms() > 0) {
         return totalVolume() / numberOfDecagonalPrisms();
      } 
      return 0;
   }
   
   /**
   *@return String
   */
   public String toString() {
      String result = name + "\n";
      for (int i = 0; i < list.size(); i++)
      {
         result += "\n" + list.get(i).toString() + "\n";
      }
      return result;     
   }
   
   /**
   *@return String
   */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String result = "----- Summary for " + name + " -----";
      result = result + "\nNumber of Decagonal Prisms: " 
         + numberOfDecagonalPrisms()
         + "\nTotal Surface Area: " + df.format(totalSurfaceArea())
         + "\nTotal Base Area: " + df.format(totalBaseArea())
         + "\nTotal Lateral Surface Area: " 
         + df.format(totalLateralSurfaceArea())
         + "\nTotal Volume: " + df.format(totalVolume())
         + "\nAverage Surface Area: " + df.format(averageSurfaceArea())
         + "\nAverage Volume: " + df.format(averageVolume());
   
      return result;
   }
    
/**
   * The getList method returns the ArrayList of DecagonalPrism objects.
   *
   * @return list
   */
   public ArrayList<DecagonalPrism> getList() {
      return list;
   }

   /**
   * The readFile method takes a String parameter representing the file name,
   * reads in the file, storing the list name and creating an ArrayList of
   * DecagonalPrism objects, uses the list name and the ArrayList to create a
   * DecagonalPrismList object, and then returns the DecagonalPrismList object.
   *
   * @param nameIn Required for the filename to read.
   * @return dL for DecagonalPrismList
   * @throws FileNotFoundException If the file cannot be opened.
   */
   public DecagonalPrismList readFile(String nameIn) 
      throws FileNotFoundException {
      Scanner sc = new Scanner(new File(nameIn));
      ArrayList<DecagonalPrism> listIn = new ArrayList<DecagonalPrism>();
      String name1In = "";
    
      name1In = sc.nextLine();
    
      while (sc.hasNext()) {
         String label = sc.nextLine();
         double edge = Double.parseDouble(sc.nextLine());
         double height = Double.parseDouble(sc.nextLine());
       
         DecagonalPrism d = new DecagonalPrism(label, edge, height);
         listIn.add(d);
      }
      DecagonalPrismList dL = new DecagonalPrismList(name1In, listIn);
      return dL;
   }

   /**
   * The addDecagonalPrism method returns nothing but takes three parameters
   * (label, color, and edge), creates a new Dodecahedron object, and adds it
   * to the DodecahedronList object.
   *
   * @param labelIn For Label Input
   * @param edgeIn For Edge Input
   * @param heightIn For Height Input
   */
   public void addDecagonalPrism(String labelIn,
      double edgeIn, double heightIn) {
      DecagonalPrism d = new DecagonalPrism(labelIn, edgeIn, heightIn);
      list.add(d);
   }

   /**
   * takes a label of a DecagonalPrism as the String
   * parameter and returns the corresponding Dodecahedron object if found in
   * the DecagonalPrism object; otherwise returns null.
   *
   * @param labelIn For Label Input
   * @return result Returns the corresponding DecagonalPrism object; otherwise,
   *                 it returns a null value.
   */
   public DecagonalPrism findDecagonalPrism(String labelIn) {
      DecagonalPrism result = null;
    
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i).getLabel().equalsIgnoreCase(labelIn)) {
            result = list.get(i);
         }
      }
      return result;
   }

   /**
   * The deleteDecagonalPrism method takes a String as a parameter that
   * represents the label of the DecagonalPrism and returns the
   * DecagonalPrism if it is found in the DecagonalPrismList object and
   * deleted; otherwise returns null.
   *
   * @param labelIn For Label Input
   * @return Returns the DecagonalPrism if it is found in the
   * DecagonalPrismList object and deleted; otherwise,
   * returns null.
   */
   public DecagonalPrism deleteDecagonalPrism(String labelIn) {
      DecagonalPrism result = findDecagonalPrism(labelIn);
    
      if (result != null) {
         list.remove(result);
         return result;
      }
      return result;
   }

   /**
   * The editDecagonalPrism method takes three parameters (label, color,
   * and edge), uses the label to find the corresponding DecagonalPrism
   * object. If found, sets the color and edge to the values passed in
   * as parameters, and returns true. If not found, returns false.
   *
   * @param labelIn For Label Input
   * @param edgeIn For Edge Input
   * @param heightIn For Height Input
   * @return true Returns true; otherwise, it returns false.
   */
   public boolean editDecagonalPrism(String labelIn, double edgeIn, 
      double heightIn) {
      DecagonalPrism result = null;
    
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i).getLabel().equalsIgnoreCase(labelIn)) {
            result = list.get(i);
            list.get(i).setEdge(edgeIn);
            list.get(i).setHeight(heightIn);
            return true;
         }
      }
      return false;
   }

}
//
//
//
//
//
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 /** 
 * A simple program that presents a menu to the user with 
 * eight options and reads input file, prints report, print summary,
 * adds a DecagonalPrism object to the DecagonalPrismListObject, deletes
 * a DecagonalPrism object in the DecagonalPrismList, 
 *finds a DecagonalPrismObject
 * and edits a DecagonalPrism and quits the program.
 *
 * Project 06
 * @author Nnamdi Ikenna-Obi - Comp 1210 - section 001
 * @version September 30th, 2021.
 */
 
public class DecagonalPrismListMenuApp {
 /**Method gives the user 8 options to evaluate a cone list file.
*
* @param args Command Line (not used)
* @throws FileNotFoundException for scanner file
*/
   public static void main(String[] args) 
      throws FileNotFoundException
   {
      String name = "";
             
      /**
   *creates an array list to store DecagonalPrism objects read from file
   */
      ArrayList<DecagonalPrism> list = new ArrayList<DecagonalPrism>();
      DecagonalPrismList prismList = new DecagonalPrismList(name, list);
   
      Scanner sc = new Scanner(System.in);
   
      sc = new Scanner(System.in);
      String code = "";
      String label;
      double edge = 0;
      double height = 0;
      String listName = "*** no list name assigned ***";
      System.out.println("DecagonalPrism List System Menu\n"
                       + "R - Read File and Create DecagonalPrism List\n"
                       + "P - Print DecagonalPrism List\n"
                       + "S - Print Summary\n"
                       + "A - Add DecagonalPrism\n"
                       + "D - Delete DecagonalPrism\n"
                       + "F - Find DecagonalPrism\n"
                       + "E - Edit DecagonalPrism\n"
                       + "Q - Quit");
                       
       /**
      *creates an object of DecagonalPrismList
      */
      prismList = new DecagonalPrismList(name, list);
                
    
      /*
      * Begins the selection process for the DecagonalPrism List System
      * Menu via a do-while loop.
      */
      do {
         // Code selection
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = sc.nextLine();
         code = code.toLowerCase().trim();
       
         if (code.length() == 0) {
            continue;
         }
       
       
         // A switch statement that processes the code selection
         char codeChar = code.charAt(0);
         switch (codeChar) {
            case 'r':
             
               System.out.print("\tFile name: ");
               String file = sc.nextLine();
             
               prismList = prismList.readFile(file);
             
               System.out.println("\tFile read in and DecagonalPrism "
                                + "List created\n");
               break;
                                    
            case 'p':
             
               System.out.println("\n" + prismList);
               break;
             
            
            case 's':
             
               System.out.println("\n" + prismList.summaryInfo()
                                + "\n");
               break;
          
           
            case 'a':
             
               System.out.print("\tLabel: ");
               label = sc.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(sc.nextLine());
               System.out.print("\tHeight: ");
               height = Double.parseDouble(sc.nextLine());
             
               prismList.addDecagonalPrism(label, edge, height);
               System.out.println("\t*** DecagonalPrism added ***\n");
               break;
             
            
            case 'd':
             
               System.out.print("\tLabel: ");
               label = sc.nextLine();
             
               if (prismList.findDecagonalPrism(label) == null) {
                  System.out.println("\t\"" + label + "\" not found\n");
                  break;
               }
               DecagonalPrism p = prismList.deleteDecagonalPrism(label);
               System.out.println("\t\"" + p.getLabel() + "\" deleted\n");
               
               break;
          
            
            case 'f':
             
               System.out.print("\tLabel: ");
               label = sc.nextLine();
             
               if (prismList.findDecagonalPrism(label) == null) {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               else {
                  System.out.println(prismList.findDecagonalPrism(label)
                                    .toString() + "\n");
               }
               break;
          
            
            case 'e':
             
               System.out.print("\tLabel: ");
               label = sc.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(sc.nextLine());
               System.out.print("\tHeight: ");
               height = Double.parseDouble(sc.nextLine());
            
             
               if (prismList.findDecagonalPrism(label) == null) {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               else {
                  prismList.editDecagonalPrism(label, edge, height);
                  System.out.println("\t\"" + label
                                   + "\" successfully edited\n");
               }
               break;
          
            
            case 'q':
             
               break;
             
            default:    // No match, loop again
             
               System.out.println("\t*** invalid code ***\n");
               break;
         }
      } while (!code.equalsIgnoreCase("Q"));                  
   }
 
}
