import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = in.nextInt();
        }
        
        int max = 0;
        int peakIndex =0;
        for(int i=0;i<n;i++){
            int gainOrLoss = vals[i] - vals[peakIndex];
            if (gainOrLoss < 0 && gainOrLoss < max){
                max = gainOrLoss;
            }
            else if(gainOrLoss > 0){
                peakIndex = i;
            }
        }
        System.out.println(max);
    }
}
