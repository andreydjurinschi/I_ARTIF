public class AlphaBetaMinimax {
    public int count = 0;
    public int pruningCount = 0;

    public int minimax(Node node, int alpha, int beta, boolean isMax){
        count++;

        if(node.isLeaf()){
            return node.value;
        }

        if(isMax){
            int best = Integer.MIN_VALUE;
            for(Node child : node.getChildren()){
                int val = minimax(child, alpha, beta, false);
                best = Math.max(best, val);
                alpha = Math.max(alpha, best);

                if(beta <= alpha){
                    pruningCount++;
                    break;
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for(Node child : node.getChildren()){
                int val = minimax(child, alpha, beta, true);
                best = Math.min(best, val);
                beta = Math.min(beta, best);

                if(beta <= alpha){
                    pruningCount++;
                    break;
                }
            }
            return best;
        }
    }
}