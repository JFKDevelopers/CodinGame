import java.util.*;
import java.io.*;
import java.math.*;

class Node{
	int ID;
	LinkedList<Node> neighb;
	int distance;
	Node parent;
	
	public Node(int n){
		this.ID = n;
		neighb = new LinkedList<Node>();
		distance = Integer.MAX_VALUE;
		parent = null;
	}
	
	public void addNeighb(Node m){
		neighb.add(m);
	}
	
	public void removeNeighb(Node m){
		neighb.remove(m);
	}
	
	public Node[] neighb(){
	return neighb.toArray(new Node[neighb.size()]);
	}
	
	public int ID(){
		return ID;
	}
}

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        Node[] nodes = new Node[N];
        for(int i=0;i<N;i++)
            nodes[i] = new Node(i);
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            nodes[N1].addNeighb(nodes[N2]);
            nodes[N2].addNeighb(nodes[N1]);
        }
        Node[] exits = new Node[E];
        for (int i = 0; i < E; i++) {
            exits[i] = nodes[in.nextInt()]; // the index of a gateway node
        }
            
        // game loop
        while (true) {
            for(int i=0;i<nodes.length;i++){
                nodes[i].distance = Integer.MAX_VALUE;
            }
            
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            
            //Breadth first search start
            Queue q = new LinkedList();
            nodes[SI].distance = 0;
            q.add(nodes[SI]);
            
            while(!q.isEmpty()){
                Node current = (Node)q.remove();
                Node [] children = current.neighb();
                for(int i=0;i<children.length;i++){
                    if(children[i].distance==Integer.MAX_VALUE){
                        nodes[children[i].ID()].distance = current.distance+1;
                        nodes[children[i].ID()].parent = current;
                        q.add(nodes[children[i].ID()]);
                    }
                }
            }
            // Breadth first search end // 
            int min = Integer.MAX_VALUE;
            Node ex = null;
            for(int i=0;i<exits.length;i++){
                int temp = nodes[exits[i].ID()].distance;
                if(temp<min){
                    min = temp;
                    ex = nodes[exits[i].ID()];
                    while(ex.parent!=nodes[SI])
                    {
                        ex=ex.parent;
                    }
                }
            }
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            System.out.println(ex.ID()+" "+ex.parent.ID());
        }
    }
}