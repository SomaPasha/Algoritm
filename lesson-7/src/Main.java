public class Main {
    public static void main(String[] args) {

        testGraph();
    }

    private static void testGraph() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");


        graph.addEdge("Москва","Тула", 10);
        graph.addEdge("Москва","Рязань", 12);
        graph.addEdge("Москва","Калуга", 10);
        graph.addEdge("Тула","Липецк",12);
        graph.addEdge("Рязань","Тамбов",6);
        graph.addEdge("Калуга","Орел",8);
        graph.addEdge("Липецк", "Воронеж",11);
        graph.addEdge("Тамбов","Саратов",3);
        graph.addEdge("Орел","Курск",4);
        graph.addEdge("Саратов","Воронеж", 5);
        graph.addEdge("Курск","Воронеж",10);

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
        graph.dfs("Москва", "Воронеж");





    }
}
