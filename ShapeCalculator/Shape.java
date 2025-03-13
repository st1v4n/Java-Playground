package ShapeCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Shape{
    private List<Point> points = new ArrayList<Point>();
    public Shape(Point... newPoints){
        for(Point p:newPoints){
            points.add(p);
        }
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract boolean isPointIn(Point p);
    protected Point getPointAtIndex(int index){
        if(index >= points.size() || index < 0 )throw new ArrayIndexOutOfBoundsException("");
        return points.get(index);
    }
    public boolean equals(Shape other){
        if(other==null)return false;
        for(int i=0;i<points.size();++i){
            if(!getPointAtIndex(i).equals(other.getPointAtIndex(i))){
                return false;
            }
        }
        return true;
    }
    public int hashCode(){
        return Objects.hash(points);
    }
    public String toString(){
        String result = new String("");
        for(int i=0;i<points.size();++i){
            String current = points.get(i).toString();
            result = result.concat(current + "\n");
        }
        return result;
    }
}
