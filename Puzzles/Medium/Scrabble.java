import java.util.*;

class Solution{
    public static Hashtable<String, Integer> lettScore = new Hashtable<String, Integer>(){{
        put("e",1);put("a",1);put("i",1);put("o",1);put("n",1);put("r",1);
        put("t",1);put("l",1);put("s",1);put("u",1);put("d",2);put("g",2);
        put("b",3);put("c",3);put("m",3);put("p",3);put("f",4);put("h",4);
        put("v",4);put("w",4);put("y",4);put("k",5);put("j",8);put("x",8);
        put("q",10);put("z",10);
    }};
    public static void main(String args[]){
        Hashtable<String, Integer> dictionary = new Hashtable<String, Integer>();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String [] words = new String[N];
        for (int i = 0; i < N; i++) {
            String W = in.nextLine();
            words[i] = W;
            dictionary.put(W,getScore(W));
        }
        String [] LETTARR = in.nextLine().split("");
        ArrayList<String> LETTERS;
        int max = 0;
        String out = "";
        
        for(int i=0;i<words.length;i++){
            LETTERS = new ArrayList<String>(Arrays.asList(LETTARR));
            if(makeWord(words[i],LETTERS)){
                if(dictionary.get(words[i])>max){
                    max = dictionary.get(words[i]);
                    out = words[i];
                }
            }
        }
        
        System.out.println(out);
    }
    
    public static int getScore(String S){
        int score = 0;
        for(int i=0;i<S.length();i++){
            score+=lettScore.get(S.substring(i,i+1));
        }
        return score;
    }
    
    public static boolean makeWord(String S, ArrayList<String> lett){
        //int test = false;
        ArrayList <String> letters = lett;
        for(int i=0;i<S.length();i++){
            int temp = letters.indexOf(S.substring(i,i+1));
            if(temp>=0){
                letters.remove(temp);
            }
            else{
                return false;
            }
        }
        return true;
    }
}