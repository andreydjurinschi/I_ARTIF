import java.util.ArrayList;
import java.util.List;

/**
 * Узел дерева
 */
public class Node {
    int value;
    List<Node> children = new ArrayList<>();
    boolean isMax;

    public void addChild(Node child){
        children.add(child);
    }

    public boolean isLeaf(){
        return children.isEmpty();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public boolean isMax() {
        return isMax;
    }

    public void setMax(boolean max) {
        isMax = max;
    }
}
