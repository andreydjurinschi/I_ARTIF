import java.util.List;

public class Fish {
    public Vector position;
    public Vector velocity;

    public double maxSpeed = 3.0;
    public double turbo = 0.7;

    Operations op = new Operations();

    public Fish(double x, double y){
        position = new Vector(x, y);
        velocity = new Vector(x-1, y-1);
    }

    public Vector toCenter(List<Fish> fishList){
        if(fishList.isEmpty()){
            return new Vector(0,0);
        }
        Vector v = new Vector(0,0);
        for(var f : fishList){
            v = op.add(v, f.position);
        }
        v = op.scale(v, 1.0 / fishList.size());
        return op.normalize(op.subtract(v, position));
    }
    private Vector calculateSeparation(List<Fish> neighbors){
        Vector force = new Vector(0,0);
        for(var a : neighbors){
            double dist = op.distance(position, a.position);
            if(dist > 0 && dist < 20){
                Vector diff = op.subtract(position, a.position);
                diff = op.normalize(diff);
                force = op.add(force, op.scale(diff, 1.0/dist));
            }
        }
        return op.normalize(force);
    }

    private Vector avoidObstacles(List<Obstacle> obstacles){
        Vector force = new Vector(0,0);
        for(Obstacle o : obstacles){
            double dist = op.distance(position, o.position);
            if(dist < o.radius + 10){
                Vector diff = op.subtract(position, o.position);
                diff = op.normalize(diff);
                force = op.add(force, op.scale(diff, 1.0/(dist*dist)));
            }
        }
        return op.normalize(force);
    }

    private Vector calculateAlignment(List<Fish> neighbors){
        if(neighbors.isEmpty()) return new Vector(0,0);
        Vector avgVelocity = new Vector(0,0);
        for(var a : neighbors) avgVelocity = op.add(avgVelocity, a.velocity);
        avgVelocity = op.scale(avgVelocity, 1.0 / neighbors.size());
        return op.normalize(avgVelocity);
    }

    public void update(){
        // обновляем позицию на основе скорости
        position = op.add(position, velocity);
    }

    public void applyRules(List<Fish> neighbors, List<Obstacle> obstacles,
                           double cohesionWeight, double alignmentWeight, double separationWeight, double obstacleWeight){
        Vector cohesionVec = toCenter(neighbors);
        cohesionVec = op.scale(cohesionVec, cohesionWeight);

        Vector alignmentVec = calculateAlignment(neighbors);
        alignmentVec = op.scale(alignmentVec, alignmentWeight);

        Vector separationVec = calculateSeparation(neighbors);
        separationVec = op.scale(separationVec, separationWeight);

        Vector obstacleVec = avoidObstacles(obstacles);
        obstacleVec = op.scale(obstacleVec, obstacleWeight);

        // итоговое ускорение
        Vector acceleration = op.add(op.add(cohesionVec, alignmentVec), op.add(separationVec, obstacleVec));
        acceleration = op.limit(acceleration, turbo);

        // обновляем скорость
        velocity = op.add(velocity, acceleration);
        velocity = op.limit(velocity, maxSpeed);
    }


}
