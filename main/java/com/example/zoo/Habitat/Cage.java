package com.example.zoo.Habitat;

import com.example.zoo.Movement.Flyable;
import com.example.zoo.Movement.Movable;
import com.example.zoo.Movement.Walkable;

import java.util.ArrayList;

public class Cage <T extends Walkable> extends Habitat{

    public Cage(int availableSpace) {
        super(availableSpace);
        setAnimals(new ArrayList<T>());
    }

    @Override
    public void addAnimal(Movable animal) throws Exception{
        if(!(animal instanceof Walkable))
            throw new Exception("Only walking animals are accepted.");

        if(animal.getComfortableSpace() > super.getAvailableSpace())
            throw new Exception("Not enough space.");

        super.getAnimals().add(animal);
        super.takeSpace(animal.getComfortableSpace());
    }

    @Override
    public String toString() {
        return "This cage contains " + super.getAnimals().toString();
    }
}
