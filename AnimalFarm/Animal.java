package AnimalFarm;

public abstract class Animal {
    protected static int global_id = 0; // each animal will have an unique ID so we can easily do ==
    protected int id;
    protected int mass;
    public Animal(){
        mass = 0;
        this.id = ++global_id;
    }
    public Animal(int mass){
        this.mass = mass;
        this.id = ++global_id;
    }
    public int getMass(){
        return this.mass;
    }
    public int getId(){
        return this.id;
    }
    public void setMass(int mass){
        if(mass < 0){
            throw new RuntimeException("Invalid mass!");
        }
        this.mass = mass;
    }
    public boolean equals(Animal other){
        return this.id == other.id;
    }
    public boolean not_equals(Animal other){
        return !this.equals(other);
    }
    public static int getGlobalId(){
        return global_id;
    }
    abstract public void describe();
    abstract public void roar();
}
