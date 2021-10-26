import java.util.ArrayList;

public class Main {
      static final float sizeTree  = 20;
      public static ArrayList<Tree> listTree = new ArrayList<>();
      private static float answerTrue =0;
    private static float answer =0;

    private static final int start= -25;
      private static final int end=25;
    public static void main(String[] args) {
        for (int i = 0; i < sizeTree; i++) {
           Tree <Integer> tree = new TreeImpl<>();
            for (int j = 0; j < 15; j++) {
                int random = start + (int) (Math.random() * end);
                   tree.add(random);
            }
            listTree.add(tree);
        }
        for (int i = 0; i < sizeTree; i++) {
            listTree.get(i).display();
           System.out.println( isBalanced(listTree.get(i).getRoot()));
           if(isBalanced(listTree.get(i).getRoot())==true){
               answerTrue++;
           }
        }
        answer =  (answerTrue/sizeTree)*100;
        System.out.println("Процент  деревьев несбалансированные: "+(100-answer));
     /*   tree.display();
        tree.traverse(Tree.TraversMode.PRE_ORDER);
        System.out.println();
tree.traverse(Tree.TraversMode.IN_ORDER);
        System.out.println();
        tree.traverse(Tree.TraversMode.POST_ORDER);*/

    }
    public static boolean isBalanced(Node node){
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

}
