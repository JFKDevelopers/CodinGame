import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] horses = new int[N];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) horses [i] = in.nextInt();
        Arrays.sort(horses);
        for(int i=horses.length-1;i>0;i--){
            min=horses[i]-horses[i-1]<min ? horses[i]-horses[i-1]:min;
        }
        System.out.print(min);
    }
     
}