public class Main {
    /**
     * дерево: глубина - 7, ширина - 2
     * особенность: часть листьев одинаковые для проверки равных путей
     */
    public static void main(String[] args){
        GameTree tree = new GameTree();
        Node root = tree.generateTree(7, 3, true);

        PerformanceTest test = new PerformanceTest();
        test.test(root);
    }
}
