public class Obstacle {
    public Vector position;
    public double radius;

    public Obstacle(double x, double y, double radius){
        position = new Vector(x, y);
        this.radius = radius;
    }
}
