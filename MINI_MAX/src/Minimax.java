public class Minimax {
    public int count = 0;

    public int minimax(Node node, boolean isMax){
        count++;

        if(node.isLeaf()){
            return node.value;
        }

        if(isMax){
            int best = Integer.MIN_VALUE;
            for(var child : node.getChildren()){
                int val = minimax(child, false);
                best = Math.max(best, val);
            }
            return best;
        }else{
            int best = Integer.MAX_VALUE;
            for(var child : node.getChildren()){
                int val = minimax(child, true);
                best = Math.min(best, val);
            }
            return best;
        }
    }
}
