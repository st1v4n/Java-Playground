package AnimalFarm;

public class Cow extends Animal{
    public Cow(){
        super();
    }
    public Cow(int mass){
        super(mass);
    }
    @Override
    public void describe(){
        System.out.println("I am a cow!");
    }
    @Override
    public void roar(){
        System.out.println("Moo Moo");
    }
}
