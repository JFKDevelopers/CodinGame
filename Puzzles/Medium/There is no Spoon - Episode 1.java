import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axisint
        String [][] xy = new String[width][height];
        //int [] y = new int[width*height];
        in.nextLine();
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            for(int j =0; j<width;j++){
                xy[j][i]=line.substring(j,j+1);
            }
        }

        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if(xy[i][j].equals("0")){
                    System.out.print(i+" "+j+" "); //print coordinates of node
                    int temp = thisRowNode(width,i,j,xy); //checks for the next node in the same row
                    int temp2 = thisColNode(height,i,j,xy); //checks for the next node in the same column
                    if(temp>=0){
                        System.out.print(temp+" "+j+" ");
                    }
                    else{
                        System.out.print("-1 -1 ");
                    }
                    if(temp2>=0){
                        System.out.print(i+" "+temp2+" ");
                    }
                    else{
                        System.out.print("-1 -1 ");
                    }
                    System.out.println();
                }
            }
        }

    }
    
    public static int thisRowNode(int w, int x, int y, String [][] grid){
        int row = -1;
        for(int i=w-1;i>x;i--){
                if(grid[i][y].equals("0")){
                    row = i;
                }
        }
        return row;
    }
    public static int thisColNode(int h, int x, int y, String [][] grid){
        int col=-1;
        for(int j=h-1;j>y;j--){
            if(grid[x][j].equals("0")){
                col = j;
            }
        }
        return col;
    }
}