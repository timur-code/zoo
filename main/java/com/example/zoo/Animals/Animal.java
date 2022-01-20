package com.example.zoo.Animals;

import com.example.zoo.Movement.Movable;

public abstract class Animal implements Movable {
    private int size;

    public Animal(int size) {
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    @Override
    public int getComfortableSpace(){
        return size * 2;
    }
}
