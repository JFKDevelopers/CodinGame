import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        int T = 0; //top
        int L = 0; //left
        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            String upDown = bombDir.substring(0,1);
            String leftRight = bombDir.substring(bombDir.length()-1,bombDir.length());

            if(upDown.equals("D")){
                T=Y0;
                Y0=(H+Y0)/2;
            }
            else if(upDown.equals("U")){
                H=Y0;
                Y0=(T+Y0)/2;
            }
            if(leftRight.equals("R")){
                L=X0;
                X0=(W+X0)/2;
            }
            else if(leftRight.equals("L")){
                W=X0;
                X0=(L+X0)/2;
            }

            // the location of the next window Batman should jump to.
            System.out.println(X0+" "+Y0);
        }
    }
}