public class  search_BST{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            //left subtree
           root.left= insert(root.left,val);
        }
        else{
            root.right = insert(root.right,val);
        }
        return root;
    }


    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data>key){ //Left subtree
            return search(root.left,key); 
        }
        else if(root.data==key){
            return true;
        }
        else{ //(root.data<key) //right subtree
            return search(root.right,key);
        }
    }
    public static void main(String args[]){
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root= null;

        inorder(root);
        System.out.println();

        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }

        if(search(root,7)){
            System.out.println("found");
        }
        else{
            System.out.println("Not found");
        }
    }
}