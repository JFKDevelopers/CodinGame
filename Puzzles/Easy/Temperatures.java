import java.util.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
        if (temps.equals("")) System.out.println(0);
        else{
        String [] tempArray = temps.split(" ");
        int result = Integer.MAX_VALUE;
        for (int i=0;i<tempArray.length;i++){
            if(Math.abs(Integer.parseInt(tempArray[i])) < Math.abs(result)) result = Integer.parseInt(tempArray[i]);
            else if(Integer.parseInt(tempArray[i]) == Math.abs(result)) result = Math.abs(result);
        }
        System.out.println(result);
        }
    }
}