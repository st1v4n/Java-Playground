package ShapeCalculator;

import java.util.Objects;

public class Circle extends Shape{
    double radius;
    static final double PI = 3.14;
    public Circle(Point center, double radius){
        super(center);
        this.radius = radius;
    }
    @Override
    public double getArea(){
        return PI*(radius*radius);
    }
    @Override
    public double getPerimeter(){
        return 2*PI*radius;
    }
    @Override
    public boolean isPointIn(Point p){
        return p.getDist(super.getPointAtIndex(0)) <= radius;
    }
    @Override
    public boolean equals(Object other){
        if(!super.equals(other))return false;
        Circle new_other = (Circle) other;
        return this.radius == new_other.radius;
    }
    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public String toString(){
        return super.toString().concat(" radius: " + radius + "\n");
    }
}
