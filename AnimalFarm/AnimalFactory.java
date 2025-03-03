package AnimalFarm;

public class AnimalFactory {
    public static Animal createAnimal(String animalName, int mass){
        if(animalName.equals("Cat")){
            return new Cat(mass);
        }
        if(animalName.equals("Cow")){
            return new Cow(mass);
        }
        if(animalName.equals("Dog")){
            return new Dog(mass);
        }
        throw new RuntimeException("Unknown animal!");
    }
}
