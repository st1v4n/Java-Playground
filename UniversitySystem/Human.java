package UniversitySystem;

import java.util.Objects;

public class Human {
    private String name="";
    private int age=0;
    private boolean validateName(String name){
        if(name.length()<2)return false;
        if(name.charAt(0) <'A' && name.charAt(0)>'Z'){
            return false;
        }
        for(int i=1;i<name.length();++i){
            if(name.charAt(i)<'a' && name.charAt(i)>'z'){
                return false;
            }
        }
        return true;
    }
    public void setName(String _name){
        if(!validateName(_name)){
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = _name;
    }
    public void setAge(int _age){
        if(_age < 18){
            throw new IllegalArgumentException("Invalid age!");
        }
        this.age=_age;
    }
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public boolean isValidHuman(){
        return validateName(this.name) && this.age>18;
    }
    public Human(){
        name = "";
        age = 0;
    }
    public Human(String _name, int _age){
        try {
            setName(_name);
            setAge(_age);
        }
        catch(IllegalAccessError e){
            System.out.println("Human could not be created successfully!");
        }
    }
    @Override
    public String toString(){
        return this.name + " " + Integer.toString(this.age);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Human result = (Human)super.clone();
        result.name = this.name;
        result.age = this.age;
        return result;
    }
    @Override
    public boolean equals(Object other){
        if(this==other)return true;
        if(other==null || this.getClass() != other.getClass())return false;
        Human helper = (Human)other;
        return this.name.equals(helper.name) && this.age == helper.age;
    }
}
