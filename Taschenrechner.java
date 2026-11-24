/*
*  Programmiert Von Mahmoud Nabat (MN)
*  Beschreibung:
*  Das ist ein einfacher taschen rechner in java im Terminal der mit split funktioniert.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Taschenrechner {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> input = new ArrayList<String>();
    String rechnung = "";
    String[] teilen = new String[2];
    String regexp = "[+]";
    String regexm = "[-]";
    String regexd = "[/]";
    String regexmal = "[*]";
    char operator = ' ';
    double[] wert = new double[2];
    double ergebnis = 0;
    
    System.out.println("[Info] Willkommen! \n[Info] Wenn sie das prgramm beenden möchten geben sie (q) ein. \n[Info] Was wollen sie rechnen?");
    sprungmarke:
    
    while (true) { 
      try{
        input.clear();
        System.out.print("[Rechnung] ");
        rechnung = scanner.nextLine();
        
        if (rechnung.contains("+")) {
          teilen = rechnung.split(regexp);
          operator = '+';
        }else if (rechnung.contains("-")) {
          teilen = rechnung.split(regexm);
          operator = '-';         
        }else if (rechnung.contains("/")) {
          teilen = rechnung.split(regexd);
          operator = '/';
        }else if (rechnung.contains("*")) {
          teilen = rechnung.split(regexmal);
          operator = '*';
        }else if (rechnung.equalsIgnoreCase("q") ) {
          System.out.println("[Info]Auf Wiedersehen");
          scanner.close();
          System.exit(0);
        }else {
          System.out.println("[Fehler] Falscher Operator! (+, -, /, *)");
          continue sprungmarke; 
        } 
        
        try {
          wert[0] = Double.parseDouble(teilen[0]);
          wert[1] = Double.parseDouble(teilen[1]);          
          
          switch (operator) {
            case '+' : 
              ergebnis = wert[0] + wert[1];
              break;
            case '-' : 
              ergebnis = wert[0] - wert[1]; 
              break;
            case '/' : 
              ergebnis = wert[0] / wert[1];
              break;
            case '*' : 
              ergebnis = wert[0] * wert[1];
              break;
            default:
              System.out.println("[Fehler] Etwas ist schief gelaufen!"); 
          } // end of switch  
          
        } catch(Exception e) {
          System.out.println("[Fehler] : Ihre Eingabe muss nur aus zahlen bestehen! \n"+ e );
          System.out.println(input.get(0)+" "+ input.get(1)+" "+ operator);
          continue sprungmarke;
        }
        
        System.out.println("[Ergebnis] " + ergebnis);
      }catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("[Fehler] Sie müssen zwei zahlen eingeben um etwas zu berechnen.");
        System.out.println(input.get(0)+" "+ input.get(1)+" "+ operator);
      }
    }
  }
}