package factory;

import animals.Animals;
import animals.bird.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;



public class AnimalFactory {

    public  Animals create(AnimalData animalData) {
        switch (animalData) {
            case CAT:
                new Cat();
            case DOG:
                new Dog();
            default:
                return new Duck();
        }

    }

}
