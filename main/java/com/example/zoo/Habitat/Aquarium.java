package com.example.zoo.Habitat;

import com.example.zoo.Animals.Penguin;
import com.example.zoo.Movement.Movable;
import com.example.zoo.Movement.Swimmable;

import java.util.ArrayList;

public class Aquarium <T extends Swimmable> extends Habitat{

    public Aquarium(int availableSpace) {
        super(availableSpace);
        setAnimals(new ArrayList<T>());
    }

    @Override
    public void addAnimal(Movable animal) throws Exception {

        if(!(animal instanceof Swimmable) || (animal instanceof Penguin))
            throw new Exception("Only swimming animals are accepted.");

        if(animal.getComfortableSpace() > super.getAvailableSpace())
            throw new Exception("Not enough space.");

        super.getAnimals().add(animal);
        super.takeSpace(animal.getComfortableSpace());
    }

    @Override
    public String toString() {
        return "This aquarium contains " + super.getAnimals().toString();
    }
}
