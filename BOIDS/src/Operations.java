/**
 * класс операций
 */

public class Operations {

    public Vector add(Vector to, Vector other){
        return new Vector(to.x + other.x, to.y + other.y);
    }

    public Vector subtract(Vector to, Vector other){
        return new Vector(to.x - other.x, to.y - other.y);
    }

    public Vector scale(Vector to, double factor){
        return new Vector(to.x * factor, to.y * factor);
    }

    public Vector normalize (Vector vector){
        double length = Math.sqrt(vector.x* vector.x + vector.y* vector.y);
        return length==0 ? new Vector(0,0) : new Vector(vector.x/length, vector.y / length);
    }

    public Vector limit(Vector vector, double max){
        double length = Math.sqrt(vector.x * vector.x + vector.y * vector.y);
        if(length > max){
            return new Vector(vector.x / length * max, vector.y / length * max);
        }
        return new Vector(vector.x, vector.y);
    }

    public double distance(Vector vector1, Vector vector2){
        double dis_x = vector1.x - vector2.x;
        double dis_y = vector1.y - vector2.y;
        return Math.sqrt(dis_x*dis_x + dis_y*dis_y);
    }

}
