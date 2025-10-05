public class Main {
    public static void main(String[] ar){
        Tree tree = new Tree();
        tree.generateLeaves(-20, 20);
        tree.setPartialEqualLeaves(50);

        MiniMax miniMax = new MiniMax(tree);
        long startMM = System.nanoTime();
        miniMax.run(0, tree.depth, true);
        long endMM = System.nanoTime();
        long durationMM =(endMM - startMM);


        AlphaBetaPrune alphaBeta = new AlphaBetaPrune();
        alphaBeta.tree = tree;
        long startAB = System.nanoTime();
        alphaBeta.run(0, tree.depth, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        long endAB = System.nanoTime();
        long durationAB = ((endAB - startAB));

        System.out.println("===== MiniMax =====");
        System.out.println("кол-во посещённых узлов: " + miniMax.visited);
        System.out.println("время выполнения: " + durationMM + " мс");

        System.out.println("\n===== Alpha-Beta =====");
        System.out.println("кол-во посещённых узлов: " + alphaBeta.visited);
        System.out.println("время выполнения: " + durationAB + " мс");
    }
}
