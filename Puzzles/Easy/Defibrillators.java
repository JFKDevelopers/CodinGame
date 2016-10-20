//Defibrillators
/*	The Goal
The city of Montpellier has equipped its streets with defibrillators to help save victims of cardiac arrests. The data corresponding to the position of all defibrillators is available online.

Based on the data we provide in the tests, write a program that will allow users to find the defibrillator nearest to their location using their mobile phone.
 	Rules

The input data you require for your program is provided in text format.
This data is comprised of lines, each of which represents a defibrillator. Each defibrillator is represented by the following fields:
A number identifying the defibrillator
Name
Address
Contact Phone number
Longitude (degrees)
Latitude (degrees)
These fields are separated by a semicolon (;).

Beware: the decimal numbers use the comma (,) as decimal separator. Remember to turn the comma (,) into dot (.) if necessary in order to use the data in your program.
 
The program will display the name of the defibrillator located the closest to the user’s position. This position is given as input to the program.
 
Input
Line 1: User's longitude (in degrees)
Line 2: User's latitude (in degrees)
Line 3: The number N of defibrillators located in the streets of Montpellier
N next lines: a description of each defibrillator

Output
The name of the defibrillator located the closest to the user’s position.

Constraints
0 < N < 10000

Example
Input:
3,879483
43,608177
3
1;Maison de la Prevention Sante;6 rue Maguelone 340000 Montpellier;;3,87952263361082;43,6071285339217
2;Hotel de Ville;1 place Georges Freche 34267 Montpellier;;3,89652239197876;43,5987299452849
3;Zoo de Lunaret;50 avenue Agropolis 34090 Mtp;;3,87388031141133;43,6395872778854

Output:
Maison de la Prevention San
*/

//Solution by JFKDevelopers
import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();//user position
        LON = LON.replace(",",".");
        String LAT = in.next();//user position
        LAT = LAT.replace(",",".");
        int N = in.nextInt();
        double min=0;
        String minName="";
        in.nextLine();
        
        for (int i = 0; i < N; i++) {
           String DEFIB = in.nextLine();
           int count = 1;
           int index = DEFIB.indexOf(";");
           while (count <4){
           int temp = DEFIB.indexOf(";",index+1);
           index = temp;
           count++;
           }
           double d = calcDist(LON,LAT,DEFIB.substring(index+1,DEFIB.lastIndexOf(";")).replace(",","."),DEFIB.substring(DEFIB.lastIndexOf(";")+1,DEFIB.length()).replace(",","."));
           if (i==0){
               min = d;
               minName=DEFIB.substring(DEFIB.indexOf(";")+1,DEFIB.indexOf(";",DEFIB.indexOf(";")+1));
           }
           else if (d<min){
               min=d;
               minName=DEFIB.substring(DEFIB.indexOf(";")+1,DEFIB.indexOf(";",DEFIB.indexOf(";")+1));
           }
        }
        System.out.println(minName);
    }
    
    public static double calcDist(String lonAa, String latAa, String lonBb, String latBb){
        double lonA = Double.parseDouble(lonAa);
        double latA = Double.parseDouble(latAa);
        double lonB = Double.parseDouble(lonBb);
        double latB = Double.parseDouble(latBb);
        double x = (lonB-lonA)*Math.cos((latA+latB)/2);
        double y = (latB-latA);
        double d = Math.sqrt((x*x)+(y*y))*6371;
        return d;
    }
}
