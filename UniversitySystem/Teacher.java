package UniversitySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Human{
    private List<Subject> subjects = null;
    public Teacher(){
        subjects = new ArrayList<Subject>();
    }
    public Teacher(String _name, int _age){
        super(_name, _age);
        subjects = new ArrayList<Subject>();
    }
    public List<Subject> getSubjects(){
        return this.subjects;
    }
    public void addSubject(Subject subject){
        subjects.add(subject);
    }
    public Subject getSubjectAtIndex(int index){
        if(index > this.subjects.size())throw new ArrayIndexOutOfBoundsException("");
        return subjects.get(index);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Subject s:subjects){
            sb.append(s.toString() + " ");
        }
        return super.toString() + " : " + sb + "\n";
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.getName(), this.getAge(), this.subjects);
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Teacher result = (Teacher)super.clone();
        result.subjects = new ArrayList<>();
        for(Subject s:this.subjects){
            result.addSubject(s);
        }
        return result;
    }
    @Override
    public boolean equals(Object other){
        if(this==other)return true;
        if(other==null || this.getClass()!=other.getClass())return false;
        Teacher helper = (Teacher)other;
        try{
            for(int i=0;i<subjects.size();++i){
                if(!subjects.get(i).equals(helper.getSubjectAtIndex(i)))return false;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return helper.getName().equals(this.getName()) && helper.getAge() == this.getAge();
    }
}
