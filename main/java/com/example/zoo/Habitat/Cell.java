package com.example.zoo.Habitat;

import com.example.zoo.Movement.Flyable;
import com.example.zoo.Movement.Movable;

import java.util.ArrayList;

public class Cell <T extends Flyable> extends Habitat{
    public Cell(int availableSpace) {
        super(availableSpace);
        setAnimals(new ArrayList<T>());
    }

    @Override
    public void addAnimal(Movable animal) throws Exception{
        if(!(animal instanceof Flyable))
            throw new Exception("Only flying animals are accepted.");

        if(animal.getComfortableSpace() > super.getAvailableSpace())
            throw new Exception("Not enough space.");

        super.getAnimals().add(animal);
        super.takeSpace(animal.getComfortableSpace());
    }

    @Override
    public String toString() {
        return "This cell contains " + super.getAnimals().toString();
    }
}
