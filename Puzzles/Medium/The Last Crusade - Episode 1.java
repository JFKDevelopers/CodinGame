import java.util.*;
import java.io.*;
import java.math.*;

class Player {
	public static Hashtable<String,String> grid = new Hashtable<String, String>();
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();
        for (int i = 0; i < H; i++) {
            String LINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            String [] rms = LINE.split(" "); //split lines into array of strings split by space.
            int y = i;
            for(int x=0;x<W;x++){
                String temp = x+" "+y;
                //System.err.print(rms[x]+" ");
                grid.put(temp,rms[x]);
            }
            System.err.println();
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next(); //TOP LEFT RIGHT
            String temp = XI+" "+YI;
            System.err.println("location: "+temp);
			String rmType = grid.get(temp);
			System.err.println("room type: "+rmType);
			String nxt = nextPos(XI,YI,rmType,POS);
            // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
            System.out.println(nxt);
        }
    }
    
   public static String nextPos(int x, int y, String rmType, String POS){
        if (rmType.equals("1")||rmType.equals("3")||rmType.equals("7")
            ||rmType.equals("8")||rmType.equals("9")){
            return x+" "+(y+1);}
        else if(rmType.equals("6")||rmType.equals("2")){
          if(POS.equals("LEFT")){return (x+1)+" "+y;}
          else{return (x-1)+" "+y;}
        }
         else if(rmType.equals("10")){
             return (x-1)+" "+y;
         }
         else if(rmType.equals("11")){
             return (x+1)+" "+y;
         }
         else if(rmType.equals("12")||rmType.equals("13")){
             return x+" "+(y+1);
         }
         else if(rmType.equals("4")){
             if(POS.equals("TOP")){return (x-1)+" "+y;}
             else{return x+" "+(y+1);}
         }
         else if(rmType.equals("5")){
             if(POS.equals("TOP")){return (x+1)+" "+y;}
             else{return x+" "+(y+1);}
         }
        return x+" "+y;
    }
}