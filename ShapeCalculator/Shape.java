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
    @Override
    public boolean equals(Object other){
        if(this==other)return true;
        if(other==null || this.getClass() != other.getClass())return false;
        Shape new_other = (Shape) other;
        for(int i=0;i<points.size();++i){
            if(!getPointAtIndex(i).equals(new_other.getPointAtIndex(i))){
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode(){
        return Objects.hash(points);
    }
    @Override
    public String toString(){
        String result = new String("");
        for(int i=0;i<points.size();++i){
            String current = points.get(i).toString();
            result = result.concat(current + "\n");
        }
        return result;
    }
}
