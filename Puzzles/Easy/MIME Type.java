import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        Hashtable<String, String> EXT = new Hashtable<String, String>();
        String result;
        String test;
        for (int i = 0; i < N; i++) {
            EXT.put(in.next().toLowerCase(),in.next()); // file extension, MIME Type
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            test=in.nextLine();
            String test2 = "";
            result="";
            if(test.indexOf(".")!=-1){test2=test.substring(test.lastIndexOf(".")+1,test.length()).toLowerCase();}
            if(EXT.containsKey(test2)){result=EXT.get(test2);} // One file name per line.
            else{result="UNKNOWN";}
            System.out.println(result);
        }
    }
}