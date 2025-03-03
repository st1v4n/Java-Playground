package AnimalFarm;

public class Cat extends Animal{
    public Cat(){
        super();
    }
    public Cat(int mass){
        super(mass);
    }
    @Override
    public void describe(){
        System.out.println("I am a cat!");
    }
    @Override
    public void roar(){
        System.out.println("Meow Meow");
    }
}
