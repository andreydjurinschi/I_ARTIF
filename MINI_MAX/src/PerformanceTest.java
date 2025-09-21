public class PerformanceTest {
    public void test(Node root){
        System.out.println("=== ТЕСТИРОВАНИЕ ПРОИЗВОДИТЕЛЬНОСТИ ===\n");

        Minimax minimax = new Minimax();
        long startTime = System.nanoTime();
        int resultMinimax = minimax.minimax(root, true);
        long endTime = System.nanoTime();

        System.out.println("ОБЫЧНЫЙ MINIMAX:");
        System.out.println("Результат: " + resultMinimax);
        System.out.println("Узлов проверено: " + minimax.count);
        System.out.println("Время: " + (endTime - startTime) + " нс");
        System.out.println();

        AlphaBetaMinimax alphaBeta = new AlphaBetaMinimax();
        startTime = System.nanoTime();
        int resultAlphaBeta = alphaBeta.minimax(root, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        endTime = System.nanoTime();

        System.out.println("ALPHA-BETA MINIMAX:");
        System.out.println("Результат: " + resultAlphaBeta);
        System.out.println("Узлов проверено: " + alphaBeta.count);
        System.out.println("Отсечений произведено: " + alphaBeta.pruningCount);
        System.out.println("Время: " + (endTime - startTime) + " нс");
        System.out.println();


        System.out.println("=== АНАЛИЗ ЭФФЕКТИВНОСТИ ===");
        double nodeReduction = ((double)(minimax.count - alphaBeta.count) / minimax.count) * 100;
        System.out.printf("Сокращение узлов: %.1f%%\n", nodeReduction);
        System.out.printf("Соотношение результатов: %s\n",
                resultMinimax == resultAlphaBeta ? "ОДИНАКОВЫЕ" : "РАЗНЫЕ");
    }
}