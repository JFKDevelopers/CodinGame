//JFKDevelopers Solution
import java.util.*;

class Node{
   String ID;
   ArrayList<Node> children;
   public Node(String n){
       this.ID = n;
       children = new ArrayList<>();
   }
   public void addChild(Node n){
       children.add(n);
   }
   public ArrayList<String> getChildIDs(){
       ArrayList<String> out = new ArrayList<>();
       for(Node n: children){
           out.add(n.ID);
       }
       return out;
   }
}

class Solution {
    public static void main(String args[]) {
        Node root = new Node("");
        ArrayList<Node> graph = new ArrayList<>();
        graph.add(root);
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String telephone = in.next();
            Node current = root;
            for(int j=0;j<telephone.length();j++){
                String tmp = telephone.substring(j,j+1);
                if(current.getChildIDs().indexOf(tmp)==-1){
                    Node temp = new Node(tmp);
                    current.addChild(temp);
                    graph.add(temp);
                    current = temp;
                }
                else{
                    current = current.children.get(current.getChildIDs().indexOf(tmp));
                }
            }
        }
        // The number of elements (referencing a number) stored in the structure.
        System.out.println(graph.size()-1);
    }
}