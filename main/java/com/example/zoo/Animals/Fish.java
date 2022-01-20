package com.example.zoo.Animals;

import com.example.zoo.Movement.Swimmable;

public abstract class Fish extends Animal implements Swimmable {
    public Fish(int size) {
        super(size);
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public int getComfortableSpace() {
        return super.getComfortableSpace();
    }
}
