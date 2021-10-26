import java.util.Stack;

public class TreeImpl<T extends Comparable<? super T>>  implements  Tree<T> {


    private Node<T> root;
    private int size;

    private  class  NodeAndParent{
        private Node<T> current;
        private  Node<T> parent;

        public int getLevel() {
            return level;
        }

        private int level;

        private NodeAndParent(Node<T> current, Node<T> parent) {
            this.current = current;
            this.parent = parent;
        }
        private NodeAndParent(Node<T> current, Node<T> parent, int level) {
            this.current = current;
            this.parent = parent;
            this.level=level;
        }
    }

    public Node<T> getRoot() {
        return root;
    }
    @Override
    public boolean add(T value) {
        NodeAndParent nodeAndParent = doFind(value);
        int limitLevel = nodeAndParent.getLevel();
        if(limitLevel>4){
        return false;
        }
        if(nodeAndParent.current!=null){
            return false;
        }
        Node<T> node = new Node<>(value);

        Node<T> parent = nodeAndParent.parent;

        if(parent ==null){
            root = node;
        } else  if(parent.isLeftChild(value)){
            parent.setLeftChild(node);
        } else {
            parent.setRightChild(node);
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(T value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current!=null;
    }

    private NodeAndParent doFind(T value) {
        Node<T> current = root;
        Node<T> parent= null;
        int level =1;
        while (current!=null){
            if(current.getValue().equals(value)){
                return  new NodeAndParent(current,parent);
            }
            parent = current;
            if(current.isLeftChild(value)){
                current = current.getLeftChild();
                level++;
            }else{
                current = current.getRightChild();
                level++;
            }
        }
        return  new NodeAndParent(null,parent, level);
    }

    @Override
    public boolean remove(T value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<T> removed = nodeAndParent.current;
        Node<T> parent = nodeAndParent.parent;
          if(removed == null){
            return false;
        }

        if(removed.isList()){
            removeNodeWithoutChild(removed, parent);
        } else if (removed.hasOnlyOneChild()){
            removeNodeWithoutOneChild(removed,parent);
        } else {
            removeNodeWithAllChildren(removed,parent);
        }
        size--;
        return true;
    }

    private void removeNodeWithAllChildren(Node<T> removed, Node<T> parent) {
        Node<T> successor = getSuccessor(removed);
        if(removed == root){
            root = successor;
        } else if (parent.isLeftChild(removed.getValue())){
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }
    }

    private Node<T> getSuccessor(Node<T> removed) {
        Node<T> successor = removed;
        Node<T> successorParent = null;
        Node<T> current =removed.getRightChild();
        while (current!=null){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if(successor!= removed.getRightChild() && successorParent!= null){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removed.getRightChild());
            successor.setLeftChild(removed.getLeftChild());
        }
        return  successor;
    }

    private void removeNodeWithoutOneChild(Node<T> removed, Node<T> parent) {
        Node<T> child = removed.getLeftChild()!=null ? removed.getLeftChild() : removed.getRightChild();

        if (removed==root){
            root = child;
        } else if (parent.isLeftChild(removed.getValue())){
            parent.setLeftChild(child);
        } else {
            parent.setRightChild(child);
        }

    }

    private void removeNodeWithoutChild(Node<T> removed, Node<T> parent) {
        if(removed== root){
            root=null;
        }
        else  if (parent.isLeftChild(removed.getValue())){
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
            Stack<Node<T>> globalstack = new Stack<>();
            globalstack.push(root);
            int nBlanks = 64;

            boolean isRowEmpty = false;
           System.out.println("........................................................................................" +
                   ".......................................");

            while (!isRowEmpty) {
                Stack<Node<T>> localStack = new Stack();
                isRowEmpty = true;
                for(int i=0;i<nBlanks;i++){
                    System.out.print(" ");
                }
                while (!globalstack.isEmpty()) {
                    Node<T> tempNode = globalstack.pop();
                    if (tempNode != null){
                      System.out.print(tempNode.getValue());
                        localStack.push(tempNode.getLeftChild());
                        localStack.push(tempNode.getRightChild());
                        if(tempNode.getLeftChild() != null || tempNode.getRightChild() != null){
                            isRowEmpty = false;
                        }
                    }else{
                        System.out.print("--");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for(int j=0; j < nBlanks * 2 - 2; j++)
                        System.out.print(' ');
                }
                System.out.println(" ");

                nBlanks = nBlanks / 2;
                while (!localStack.isEmpty()) {
                    globalstack.push(localStack.pop());
                }

            }
        System.out.println("............................................................................................" +
                "..................................");
        }


    @Override
    public void traverse(TraversMode mode) {
        switch (mode){
            case PRE_ORDER-> preOrder(root); // прямой обход
            case IN_ORDER -> inOrder(root);// центрированный обход
            case POST_ORDER-> postOrder(root);// обратный порядок
            default -> throw new RuntimeException("Unknow travers mode"+mode);
        }
    }

    private void postOrder(Node<T> current) {
        if (current==null){
            return;
        }
        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.print(current.getValue()+" ");
    }

    private void preOrder(Node<T> current) {
        if (current==null){
            return;
        }
        System.out.print(current.getValue()+" ");
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());

    }

    private void inOrder(Node<T> current) {
        if (current==null){
            return;
        }
        inOrder(current.getLeftChild());
        System.out.print(current.getValue()+" ");
        inOrder(current.getRightChild());
    }


}
