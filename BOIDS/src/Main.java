public class Main {
    public static void main(String[] args) throws InterruptedException {
        Simulation sim = new Simulation(100, 50, 2);

        sim.addObstacle(new Obstacle(50, 20, 10));
        sim.addObstacle(new Obstacle(80, 56, 15));
        sim.addObstacle(new Obstacle(15, 15, 15));

        for (int step = 1; step <= 3; step++) {
            sim.step();
            sim.printState(step);
            Thread.sleep(1000); // 1 секунда между шагами
        }
    }
}
