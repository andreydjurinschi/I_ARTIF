/**
 * реализация алгоритма минимакс
 */

public class MiniMax {
    public Tree tree;
    public int visited = 0;

    public MiniMax(Tree tree) {
        this.tree = tree;
    }

    public int run(int nodeIdx, int depth, boolean isMax) {

        if(tree.isLeaf(nodeIdx)){
           System.out.println("был получен лист! " + tree.getLeavesValue(nodeIdx));
           return tree.getLeavesValue(nodeIdx);
        }

        int bestVal;

        if(isMax){
            bestVal = Integer.MIN_VALUE;
            for(int i = 0; i < tree.branching; i++){
                int childNodeIdx = tree.branching * nodeIdx+1+i;
                int childVal = run(childNodeIdx, depth-1, false);
                //int childVal = tree.getLeavesValue(childNodeIdx+i);
                bestVal = Math.max(childVal, bestVal);
            }
        }else{
            bestVal = Integer.MAX_VALUE;
            for (int i = 0; i < tree.branching; i++) {
                int childNodeIdx = tree.branching * nodeIdx+1+i;
                int childVal = run(childNodeIdx, depth-1, true);
                //int childVal = tree.getLeavesValue(childNodeIdx+i);
                bestVal = Math.min(childVal, bestVal);
            }
        }
        visited++;
        if(nodeIdx == 0){
        System.out.println("___________________Ответ_________________________");
        System.out.println("узел " + nodeIdx + " (" + (isMax ? "MAX" : "MIN") +
                ") выбирает значение " + bestVal);
        System.out.println("кол-во пройденного пути: " + visited);
        System.out.println("__________________________________________________");
        return bestVal;

        }
        System.out.println("_________________________________________________________");
        System.out.println("узел " + nodeIdx + " (" + (isMax ? "MAX" : "MIN") +
                ") выбирает значение " + bestVal);
        System.out.println("кол-во пройденного пути: " + visited);
        System.out.println("_________________________________________________________");
        return bestVal;
    }
}

