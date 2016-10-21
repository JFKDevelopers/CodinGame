import java.util.*;

class Node{
    int ID;
    LinkedList<Node> neighb;
    boolean visited;
    Node parent;
    int distance;
    
    public Node(int id){
        this.ID = id;
        neighb = new LinkedList<Node>();
        this.visited = false;
        parent = null;
        distance = 0;
    }
    
    public void addNeighb(Node m){
		neighb.add(m);
	}
    
    public ArrayList<Node> getNeighb(){
        ArrayList<Node> t = new ArrayList<>();
        t.addAll(neighb);
	    return t;
	}
}
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of relationships of influence
        
        HashMap<Integer, Node> graph = new HashMap<>();
        Node root = null;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(); // a relationship of influence between two people (x influences y)
            int y = in.nextInt();
            if(!graph.containsKey(x)) graph.put(x,new Node(x));
            if(!graph.containsKey(y)) graph.put(y,new Node(y));
            graph.get(y).addNeighb(graph.get(x));
            graph.get(x).parent = graph.get(y);
        }
        int maxDist = 0;
        //DFS
         for(Integer key:graph.keySet()){
             if(graph.get(key).parent==null) root=graph.get(key);
             else root = null;
             if(root!=null){
                Stack <Node> stack = new Stack<Node>();
                stack.add(root);
                for(Integer key2:graph.keySet()){
                    graph.get(key2).visited=false;
                }
                root.visited = true;
                int dist = 0;
                while(!stack.isEmpty()){
                    Node element = stack.pop();
                    dist++;
                    ArrayList<Node> neighbors = element.getNeighb();
                    //System.err.println(element.ID+"\t"+neighbors.size()+" dist: "+dist);
                    if(neighbors.size()==0) {
                        if(dist>element.distance) element.distance = dist;
                        if(dist > maxDist) maxDist = dist;
                        dist = 1;
                    }
                    for(int i=0;i<neighbors.size();i++){
                        Node tmp = neighbors.get(i);
                        if(tmp!=null && !tmp.visited){
                            stack.add(tmp);
                            tmp.visited = true;
                        }
                    }
                }
        }
        }
        // The number of people involved in the longest succession of influences
        System.out.println(maxDist);
    }
 
}
