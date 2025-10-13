import java.util.Random;

/**
 * класс, хранящий само дерево
 */

public class Tree {
    public int depth = 7;
    public int branching = 2;
    public int[] values;
    public int leafStartIdx;

    public Tree(){
        int size = (int) Math.pow(branching, depth+1) - 1;
        values = new int[size];
        leafStartIdx = (int) Math.pow(branching, depth) - 1;
    }

    public void generateLeaves(int min,int max){
        Random rnd = new Random();
        for(int i = 0; i < values.length; i++){
            values[i] = rnd.nextInt(min, max+1);
        }
    }

    public void setPartialEqualLeaves(int percentage){
        int totalLeaves = values.length - leafStartIdx;
        int count = totalLeaves * percentage / 100;
        Random rnd = new Random();
        int valueToSet = rnd.nextInt(-20, 21);
        for(int i = leafStartIdx; i < leafStartIdx + count; i++){
            values[i] = valueToSet;
        }
    }

    public int getLeavesValue(int id){
        return values[id];
    }

    public boolean isLeaf(int index) {
        return index >= leafStartIdx;
    }

    public int size(){
        return values.length;
    }
}
