package AnimalFarm;
import java.util.Vector;

public class Farm {
    private Vector<Animal> animals;
    public Farm(){
        animals = new Vector<Animal>();
    }
    public void roar_all(){
        for(Animal animal:this.animals){
            animal.roar();
        }
    }
    public void describe_all(){
        for(Animal animal:this.animals){
            animal.describe();
        }
    }
    public void addAnimal(Animal animal){
        this.animals.addElement(animal);
    }
    public void addAnimal(String animalName, int mass){
        if(mass < 0){
            throw new RuntimeException("Invalid mass!");
        }
        this.animals.addElement(AnimalFactory.createAnimal(animalName, mass));
    }
    public int getTotalMass(){
        int total = 0;
        for(Animal animal:this.animals){
            total += animal.getMass();
        }
        return total;
    }
}
