import java.util.*;
public class Binary_tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        //preorder
        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        //inorder
        public static void inorder(Node root) {
            //base case
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        //postorder
        public static void postorder(Node root) {
            //base case
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        //level order
        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

    }

    //height of tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount+1;
    }
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum+rightSum+root.data;
    }
        //diameter of tree
       public static int diameter2(Node root){
        if(root==null){
            return 0;
        }
        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);

        int selfDiam = leftHt+rightHt+1;
        return Math.max(selfDiam,Math.max(leftDiam,rightDiam));

       }
       static class Info{
        int diam;
        int ht;

        public Info(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }
       }
       public static Info diameter(Node root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+ rightInfo.ht+1);

        int ht = Math.max(leftInfo.ht,rightInfo.ht+1);

        return new Info(diam,ht);
       }

       //subtree of another tree
        public static boolean isIdentical(Node node,Node subroot){
        if(node==null && subroot==null){
            return true;
        }else if(node==null || subroot==null || node.data != subroot.data){
            return false;
        }
        if(!isIdentical(node.left,subroot.left)){
            return false;
        }
            if(!isIdentical(node.right,subroot.right)){
                return false;
            }
            return true;
        }
        public static boolean isSubtree(Node root,Node subroot){
        if(root==null){
            return false;
        }
        if(root.data==subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        return isSubtree(root.left,subroot)|| isSubtree(root.right,subroot);
        }

        //top view of tree
        static class info{
        Node node;
        int hd;

        public info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
        }
        public static void topView(Node root){
        //level order
            Queue<info>q = new LinkedList<>();
            HashMap<Integer,Node>map = new HashMap<>();

            int min =0,max=0;
            q.add(new info(root,0));
            q.add(null);

            while(!q.isEmpty()){
                info curr = q.remove();
                if(curr ==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd,curr.node);
                    }
                    if(curr.node.left != null){
                        q.add(new info(curr.node.left,curr.hd-1));
                        min = Math.min(min,curr.hd-1);
                    }
                    if(curr.node.right != null){
                        q.add(new info(curr.node.right,curr.hd+1));
                        max = Math.max(max,curr.hd+1);
                    }
                }
            }
            for(int i=min; i<=max; i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
        }

        //kth level of tree
    public static void klevel(Node root,int level,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        klevel(root.left,level+1,k);
        klevel(root.right,level+1,k);
    }

        //lowest common ancestor
       public static Node lca(Node root,int n1,int n2) {
           ArrayList<Node> path1 = new ArrayList<>();
           ArrayList<Node> path2 = new ArrayList<>();

           getPath(root, n1, path1);
           getPath(root, n2, path2);
           if (root == null) {;
           }
       }
        public static boolean getPath(Node root,int n, ArrayList<Node>path){

    }
        public static void main(String[] args) {
           // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
           // BinaryTree tree = new BinaryTree();
          //  Node root = tree.buildTree(nodes);
            // System.out.println(root.data);
            // tree.preorder(root);
            // tree.inorder(root);
            //  tree.postorder(root);
           // tree.levelorder(root);

            Node root = new Node(1);
            root.left=new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

            //System.out.println(height(root));
           // System.out.println(count(root));
          //  System.out.println(sum(root));
           // System.out.println(diameter2(root));
           // System.out.println(diameter(root).diam);

           /* Node subroot = new Node(2);
            subroot.left = new Node(4);
            subroot.right = new Node(5);*/
           // System.out.println(isSubtree(root,subroot));

          //  topView(root);

            int k=2;
            klevel(root,1,k);



    }
}


