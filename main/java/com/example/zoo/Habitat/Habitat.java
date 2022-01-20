package com.example.zoo.Habitat;

import com.example.zoo.Movement.Movable;

import java.util.ArrayList;

public abstract class Habitat <T extends Movable> {
    private int availableSpace;
    private ArrayList<? extends Movable> animals;

    public Habitat(int availableSpace) {
        this.availableSpace = availableSpace;
        this.animals = new ArrayList<>();
    }

    public abstract void addAnimal(T animal) throws Exception;

    protected void setAnimals(ArrayList<? extends Movable> animals) {
        this.animals = animals;
    }

    public ArrayList<? extends Movable> getAnimals() {
        return animals;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    protected void takeSpace(int space) {
        availableSpace -= space;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "availableSpace=" + availableSpace +
                ", animals=" + animals +
                '}';
    }
}
