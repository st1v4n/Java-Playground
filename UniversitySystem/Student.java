package UniversitySystem;

import java.util.Objects;

public class Student extends Human{
    private int fn;
    public Student(){
        super();
    }
    public Student(String _name, int _age){
        super(_name, _age);
        fn=FacultyNumberGenerator.getFacultyNumber();
    }
    public int getFN(){
        return this.fn;
    }
    @Override
    public String toString(){
        return super.toString() + " fn: " + Integer.toString(this.fn) + '\n';
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.getName(), this.getAge(), this.fn);
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Student result = (Student)super.clone();
        result.fn = this.fn;
        return result;
    }
    @Override
    public boolean equals(Object other){
        if(this==other)return true;
        if(other==null || this.getClass()!=other.getClass())return false;
        Student helper = (Student)other;
        return helper.getName().equals(this.getName()) && helper.getAge() == this.getAge() && this.fn==helper.fn;
    }
}
