import java.util.*;

class Node {
    int ID;
    LinkedList <Node> neighbs;
    
    public Node(int id){
        this.ID = id;
        neighbs = new LinkedList<Node>();
    }
    
    public void addNeighb(Node m){
        neighbs.add(m);
    }
    
    public void removeNeighb(Node m){
        neighbs.remove(m);
    }
    
    public LinkedList<Node> getNeighbs(){
        return neighbs;
    }
    
    public int neighbCount(){
        return neighbs.size();
    }
}
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt(); // the number of adjacency relations
        Map <Integer, Node> graph = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(); // the ID of a person which is adjacent to yi
            int yi = in.nextInt(); // the ID of a person which is adjacent to xi
            System.err.println(xi+" "+yi);
            if(!graph.containsKey(xi)){
                graph.put(xi,new Node(xi));
            }
            if(!graph.containsKey(yi)){
                graph.put(yi,new Node(yi));
            }
            graph.get(xi).addNeighb(graph.get(yi));
            graph.get(yi).addNeighb(graph.get(xi));
        }
        
        int minSteps = 0;
        while(graph.size() > 1){
            minSteps++;
            
            ArrayList<Integer> keys=new ArrayList<>();
            
            for(int key : graph.keySet()){
                if(graph.get(key).neighbCount()==1){
                    keys.add(key);
                }
            }

            for(int key:keys){
                for(Node tmp: graph.get(key).getNeighbs()){
                    tmp.removeNeighb(graph.get(key));
                    graph.get(key).removeNeighb(tmp);
                }
                graph.remove(key);
            }
        }
        
        // The minimal amount of steps required to completely propagate the advertisement
        System.out.println(minSteps);
    }
}