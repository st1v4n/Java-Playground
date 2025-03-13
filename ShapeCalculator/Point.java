package ShapeCalculator;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Point {
    public double x;
    public double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getDist(Point point){
        double dx = point.x - this.x;
        double dy = point.y - this.y;
        return sqrt(dx*dx + dy*dy);
    }
    public boolean equals(Object other){
        if(this==other)return true;
        if(other==null || this.getClass() != other.getClass())return false;
        Point new_other = (Point) other;
        return (this.x==new_other.x) && (this.y==new_other.y);
    }
    public int hashCode(){
        return Objects.hash(x, y);
    }
    public String toString(){
        return "x:" + x + " y:" + y;
    }
}
