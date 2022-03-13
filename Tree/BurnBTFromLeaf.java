class Distance{
    int val;
    Distance (int d) { 
        val=d;
    }
}

/*
More Solutions: https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/

    * In this question V just need to find out the Farthest node from the given leaf. All the time values at which the adjacent nodes will be burned is equals to the ditance of the given leaf to this node adjacent node. 
    In a nutshell to burn a BT V just need to find the farthest node from the given leaf and that will be the time required to burn the whole tree
    * V can reach to the farthest node only through one of the ancestors. So if V can find out the farthest node of all the ancestors and take the max of these then that will be my answer. 
    (X) => As the given leaf will be present at any one side of the root. So the farthest distance for current root = (distance of current lead to it's ancestor) + (heaight of other side of the ancestor) i.e suppose if given leaf is present at the right side of an ancestor then V need to find the distance between lead and ancestor and add it with the left height of ancestor
    * Here as the given leaf is ancestor of itself also so distance of given leaf from itself will be 0
    

    * this function mainly returns 2 things
        It returns the height of BT with given root as the root
        It sets the distance of current node to the given leaf if given leaf is a descendant and if given leaf is not a descendant than it keeps the distance as -1 or V can say that if the distance of the current node != -1 then it's ancestor and for these kind of nodes use (X)
        
        V can also say that this function TR the every node of BT and for every node it computes the above 2 values 

    this algo will work only if the given leaf is present in BT

    * this question is similar to efficient algo of Diameter of BT. 

    Algo:
        Def a class for calculating the distance 
        Def a var "maxDia" which will hold the the max Dia V have till now
        
        Method:
        check for null
            return 0
        check if the current root is the required leaf
            update the dist var 
            return 1
        Def 2 distance var of type "Distance", one for left and one for right. These will tell if the V have found the leaf or not

        call for left with (root.left, leaf, leftDistance)
        call for right with (root.right, leaf, rightDistance)

        check if the leaf is child of current node
            if present on the left of current node
                update the dist val with leftDistance+1
                update the var maxDia
            if present on the right side
                update the dist val with rightDistance+1
                update the maxDia

        return the height of the current node
*/

public class BurnBTFromLeaf {
    static int maxDia=0;

    public static int burnTime(Node root, int leaf, Distance dist){
        if(root==null)return 0;

        // if the root is the leaf
        if(root.data==leaf){
            dist.val=0;
            return 1;
        }

        Distance ldist = new Distance(-1) , rdist = new Distance(-1);

        int lh = burnTime(root.left,leaf,ldist);
        int rh = burnTime(root.right,leaf,rdist);

        // These 2 conditions will check if the given leaf node descendant of the curr node or not  
        // is the required leaf is on he left
        if(ldist.val != -1){
           dist.val=ldist.val+1;
           maxDia=Math.max(maxDia,dist.val+rh);
        }
        // is the required leaf is on he right
        else if(rdist.val != -1){
            dist.val=rdist.val+1;
            maxDia=Math.max(maxDia,dist.val+lh);
        }

        // for each node returning the height
        return Math.max(lh,rh)+1;
    }

    public static void main(String[] args) {

        Node root=new Node(10);

    	root.left=new Node(20);
    	root.right=new Node(30);

    	root.left.left=new Node(40);
    	root.left.right=new Node(50);

    	root.left.left.left=new Node(60);
	    root.left.left.left.left=new Node(70);

    	Distance dist=new Distance(-1);
        int leaf=50;
	
	    burnTime(root,leaf,dist);
	    System.out.print(maxDia);
    }

}

class Node {
    Node left;
    Node right;
    int data;
    Node (int data) {
        this.data = data;
    }
}













