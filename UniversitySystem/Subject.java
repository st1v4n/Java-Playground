package UniversitySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subject {
    private String name;
    private Teacher teacher;
    private List<Student> students;
    public void setName(String _name){
        if(_name.length()<2)throw new IllegalArgumentException("");
        this.name=_name;
    }
    public String getName(){
        return this.name;
    }
    public void setTeacher(Teacher _teacher){
            this.teacher = _teacher; //aggregation
    }
    public Teacher getTeacher(){
        return this.teacher;
    }
    public void addStudent(Student s){
        students.add(s);
    }
    public List<Student> getStudents(){
        return students;
    }
    public Student getStudentAtIndex(int index){
        if(index < 0 || index > students.size())throw new ArrayIndexOutOfBoundsException("");
        return students.get(index);
    }
    public Subject(){}
    public Subject(String _name, Teacher _teacher){
        try{
            setName(_name);
            setTeacher(_teacher);
            students = new ArrayList<Student>();
        }
        catch(IllegalArgumentException e){
            System.out.println("Couldnt create Subject!");
        }
    }
    public Subject(String _name, Teacher _teacher, Student... _students){
        try{
            setName(_name);
            setTeacher(_teacher);
            students = new ArrayList<Student>();
            for(Student s:_students){
                this.students.add(s); //aggregation
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Couldnt create Subject!");
        }
    }
    @Override
    public String toString(){
        return this.name;
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.getName());
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Subject result = (Subject)super.clone();
        result.name = this.name;
        result.teacher = this.teacher;
        result.students = new ArrayList<>();
        for(Student s:this.students){
            result.students.add(s);
        }
        return result;
    }
    @Override
    public boolean equals(Object other){
        if(this==other)return true;
        if(other==null || this.getClass()!=other.getClass())return false;
        Subject helper = (Subject)other;
        return helper.getName().equals(this.getName());
    }
}
