package animals.bird;

import animals.Animals;

public class Duck extends Animals implements IFly {

    public void fly(){
        System.out.println("Я лечу");
    }

    public void voice() {
        System.out.println("Кря-кря");
    }
}
