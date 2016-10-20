
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt(); //length of letter (includes space after each letter)
        int H = in.nextInt(); //height of letter
        in.nextLine();
        String T = in.nextLine();//string to output in ASCII art form
        String [][] inputArr = new String[T.length()][H];
        int thisLetter=0;
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine(); //inputs A-Z and ? as ASCII art in H rows
            for(int x=0; x<T.length(); x++){
                    thisLetter = Character.getNumericValue(T.charAt(x))-10; //10 represents A in unicode
                    if(thisLetter>ROW.length()/L || thisLetter < 0){
                        thisLetter = (ROW.length()/L)-1;
                    }
                    inputArr[x][i] = ROW.substring(thisLetter*L,(thisLetter*L)+L);
                    //System.err.println(thisLetter);
            }
        }
        for(int x=0; x<H; x++){
                for(int y=0; y<T.length(); y++){
                    System.out.print(inputArr[y][x]);
            }
            System.out.println();
        }
    }
}