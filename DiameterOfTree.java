public class DiameterOfTree{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left= null;
            this.right= null;
        }
    }

    static class BinTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight,rightHeight)+1;

        return myHeight;
    } 

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left)+height(root.right)+1  ;
            
 
        return Math.max(diam3,Math.max(diam1,diam2));
    } 

    //approach 2 for diameter
    static class Treeinfo{
        int ht;
        int diam;

        Treeinfo(int ht, int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }

    public static Treeinfo diameter2(Node root){

        if(root==null){
            return new Treeinfo(0,0);
        }

  
        Treeinfo left = diameter2(root.left);
        Treeinfo right = diameter2(root.right);
        
        int myHeight = Math.max(left.ht,right.ht) +1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht+right.ht+1;

        int mydiam=Math.max(Math.max(diam1,diam2),diam3);

        Treeinfo myInfo = new Treeinfo(myHeight,mydiam);
        return myInfo; 
    }



    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinTree tree = new BinTree();
        Node root= tree.buildTree(nodes);

        // System.out.println(diameter(root));
        System.out.println(diameter2(root).diam);
          
    }
}
