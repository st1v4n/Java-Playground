package AnimalFarm;

public class Dog extends Animal{
    public Dog(){
        super();
    }
    public Dog(int mass){
        super(mass);
    }
    @Override
    public void describe(){
        System.out.println("I am a dog!");
    }
    @Override
    public void roar(){
        System.out.println("Bau Bau");
    }
}
