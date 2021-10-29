import com.sun.jdi.Value;

import java.util.*;

public class GraphImpl  implements   Graph{
    private  final List<Vertex> vertexList;
    private  final int[][] adjMatrix;
    private  ArrayList<Integer> min =  new ArrayList<>();
    private  boolean r =false;
    private  String answerWay="";
    private  ArrayList<String> way =  new ArrayList<>();
    private  ArrayList<Integer> waySum =  new ArrayList<>();
    private int  numberWay = 0;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix =  new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result =addEdge(startLabel,secondLabel);

        for(String other: others){
            result &= addEdge(startLabel,other);
        }
        return result;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel , int weight) {

        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if((startIndex==-1) || (endIndex==-1)){
            return false;
        }
        adjMatrix[startIndex][endIndex] = weight;
      //  adjMatrix[endIndex][startIndex] = true;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if(vertexList.get(i).getLabel().equals(label)){
                return  i;
            }
        }
        return  -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < vertexList.size(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if(adjMatrix[i][j]>0){
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }

    }

    @Override
    public void dfs(String startLabel, String endLabel) { // в глубину
        int checkmini=0;
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
         if((startIndex == -1) || (endIndex==-1)){
             throw  new IllegalArgumentException("Неверная вершина" + startLabel);
         }

        Stack<Vertex> stack  = new Stack<>();
         Vertex vertex  = vertexList.get(startIndex);
        Vertex vertexEND  = vertexList.get(endIndex);
        Vertex vertexEnd;
        visitedVertex(stack, vertex,startLabel);
        while (!stack.isEmpty()){
            vertexEnd = vertex;
        vertex = getNearUnvisitedVertex(stack.peek());
        if(vertex!=null){
            if( vertexEnd==null){
                vertexEnd = vertexList.get(startIndex);
                vertexEND.setVisited(false);
            }


            checkmini = checkmini + adjMatrixFind(vertex, vertexEnd);
            visitedVertex(stack,vertex,startLabel);
        } else {
            if(checkmini>0){
            way.add("Москва"+answerWay);
            waySum.add(checkmini);
            answerWay="";
            System.out.println(checkmini+" км.");
            }
            checkmini=0;
            stack.pop();

        }
        }
        Integer MIN = null;
        Integer min = MIN.MAX_VALUE ;
        Integer index = 0;
        for (int i = 0; i < waySum.size(); i++) {
            if(waySum.get(i) <min){
                min=waySum.get(i);
                index= i;
            }
        }
       System.out.println("Самый короткий путь: "+way.get(index) +" -> "+waySum.get(index)+" км.") ;

      //
    }

    private int adjMatrixFind(Vertex vertex,Vertex vertexEnd) {
        int i = indexOf(vertex.getLabel());
        int j = indexOf(vertexEnd.getLabel());
        return   adjMatrix[j][i];
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int  currentIndex  = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if(adjMatrix[currentIndex][i]>0 && !vertexList.get(i).getIsVisited()){
            return vertexList.get(i);
            }
        }
        return  null;
    }

    private void visitedVertex(Stack<Vertex> stack, Vertex vertex, String startLabel) {
        System.out.print(vertex.getLabel() + " -> ");
        stack.add(vertex);
        if (vertex.getLabel()!=startLabel)
        answerWay = answerWay +" -> "+vertex.getLabel();
        vertex.setVisited(true);
    }

    private void visitedVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) { // в ширину
        int startIndex = indexOf(startLabel);
        if(startIndex == -1){
            throw  new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Queue<Vertex> queue  = new LinkedList<>();
        Vertex vertex  = vertexList.get(startIndex);
        visitedVertex(queue, vertex);
        while (!queue.isEmpty()){
            vertex = getNearUnvisitedVertex(queue.peek());
            if(vertex!=null){
                visitedVertex(queue,vertex);
            } else
            {
                queue.remove();
            }
        }
        System.out.println();
    }
}
