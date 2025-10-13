import java.util.ArrayList;
import java.util.List;

public class Simulation {
    List<Fish> fishList = new ArrayList<>();
    List<Obstacle> obstacles = new ArrayList<>();
    Operations op = new Operations();
    int width;
    int height;

    public Simulation(int width, int height, int numFish) {
        this.width = width;
        this.height = height;
        for (int i = 0; i < numFish; i++) {
            fishList.add(new Fish(Math.random() * width, Math.random() * height));
        }
    }

    public void addObstacle(Obstacle o) {
        obstacles.add(o);
    }

    public void step() {
        for (Fish f : fishList) {
            List<Fish> neighbors = findNeighbors(f, 50);
            f.applyRules(neighbors, obstacles, 2.0, 2.0, 3.0, 5.0); // увеличенные веса для заметного движения
        }

        for (Fish f : fishList) {
            f.update();
        }
    }

    private List<Fish> findNeighbors(Fish f, double radius) {
        List<Fish> neighbors = new ArrayList<>();
        for (Fish other : fishList) {
            if (other != f && op.distance(f.position, other.position) < radius) {
                neighbors.add(other);
            }
        }
        return neighbors;
    }

    public void printState(int stepNumber) {
        System.out.println("------ Шаг " + stepNumber + " ------");
        for (int i = 0; i < fishList.size(); i++) {
            Fish f = fishList.get(i);
            System.out.printf("Рыба %d: pos(%.2f, %.2f) vel(%.2f, %.2f)%n",
                    i, f.position.x, f.position.y, f.velocity.x, f.velocity.y);
        }
        System.out.println("Препятствия:");
        for (int i = 0; i < obstacles.size(); i++) {
            Obstacle o = obstacles.get(i);
            System.out.printf("Obstacle %d: pos(%.2f, %.2f) radius %.2f%n",
                    i, o.position.x, o.position.y, o.radius);
        }
        System.out.println("-----------------------------");
    }
}