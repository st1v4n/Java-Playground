package ShapeCalculator;

import java.util.Objects;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Rectangle extends Shape{
    public Rectangle(Point TopLeft, Point BotRight){
        super(TopLeft, BotRight);
    }
    private double xSide(){
        return abs(super.getPointAtIndex(1).x - super.getPointAtIndex(0).x);
    }
    private double ySide(){
        return abs(super.getPointAtIndex(1).y - super.getPointAtIndex(0).y);
    }
    @Override
    public double getArea(){
        return xSide()*ySide();
    }
    @Override
    public double getPerimeter(){
        return (2*xSide())+(2*ySide());
    }
    @Override
    public boolean isPointIn(Point p){
        return (p.x >= super.getPointAtIndex(0).x && p.x <= super.getPointAtIndex(1).x) && (p.y >= super.getPointAtIndex(0).y && p.y <= super.getPointAtIndex(1).y);
    }
}
