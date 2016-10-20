import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        // game loop
        while (true) {
            int maxM = 0;
            int maxInd = 0;
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                if (mountainH > maxM){
                    maxM = mountainH;
                    maxInd = i;
                }
            }

            System.out.println(maxInd); // The index of the mountain to fire on.
        }
    }
}