import java.util.Random;

/**
 * Структура дерева
 */
public class GameTree {

    Random random = new Random();
    private boolean equalLeaves = false;
    private int equalLeafValue = 0;
    private double equalLeavesPercentage = 0.3;

    public Node generateTree(int depth, int width, boolean isMax){
        if(depth == 0){
            Node root = new Node();
            root.value = generateLeafValue();
            root.isMax = isMax;
            return root;
        }else{
            Node node = new Node();
            for (int i = 0; i < width; i++) {
                var child = generateTree(depth-1, width, !isMax);
                node.addChild(child);
            }
            node.getChildren().sort((a, b) -> node.isMax ? b.value - a.value : a.value - b.value);
            return node;
        }
    }

    private int generateLeafValue(){

        if(random.nextDouble() < equalLeavesPercentage) {
            return 15;
        }
        return random.nextInt(101) - 50;
    }

    public void setEqualLeaves(boolean enable, int value, double percentage) {
        this.equalLeaves = enable;
        this.equalLeafValue = value;
        this.equalLeavesPercentage = percentage;
    }
}
