public class AlphaBetaPrune {
    public Tree tree;
    public int visited = 0;

    public int run(int nodeIdx, int depth, int alpha, int beta, boolean isMax) {
        if (tree.isLeaf(nodeIdx)) {
            System.out.println("был получен лист! " + tree.getLeavesValue(nodeIdx));
            return tree.getLeavesValue(nodeIdx);
        }

        int best;
        if (isMax) {
            best = Integer.MIN_VALUE;
            for (int i = 0; i < tree.branching; i++) {
                int childNodeIdx = tree.branching * nodeIdx + 1 + i;
                int val = run(childNodeIdx, depth - 1, alpha, beta, false);
                best = Math.max(best, val);
                alpha = Math.max(alpha, best);
                if (beta <= alpha) {
                    System.out.println("ОТСЕЧЕНИЕ на узле " + nodeIdx + " (MAX) при child " + childNodeIdx);
                    break;
                }
            }
        } else {
            best = Integer.MAX_VALUE;
            for (int i = 0; i < tree.branching; i++) {
                int childNodeIdx = tree.branching * nodeIdx + 1 + i;
                int val = run(childNodeIdx, depth - 1, alpha, beta, true);
                best = Math.min(best, val);
                beta = Math.min(beta, best);
                if (beta <= alpha) {
                    System.out.println("ОТСЕЧЕНИЕ на узле " + nodeIdx + " (MIN) при child " + childNodeIdx);
                    break;
                }
            }
        }

        visited++;
        System.out.println("_________________________________________________________");
        System.out.println("узел " + nodeIdx + " (" + (isMax ? "MAX" : "MIN") +
                ") выбирает значение " + best);
        System.out.println("кол-во пройденного пути: " + visited);
        System.out.println("_________________________________________________________");
        return best;
    }
}
