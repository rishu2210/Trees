public class countOfNodes{
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

    public static int count(Node root){
        if(root==null){
            return 0;
        }

        int leftNodes = count(root.left);
        int rightNodes = count(root.right);

        return leftNodes + rightNodes + 1; 
    }

    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinTree tree = new BinTree();
        Node root= tree.buildTree(nodes);

        System.out.println(count(root));
          
    }
}
