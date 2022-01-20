package com.example.zoo.Animals;

import com.example.zoo.Movement.Swimmable;
import com.example.zoo.Movement.Walkable;

public class Penguin extends Bird implements Walkable, Swimmable {
    public Penguin(int size) {
        super(size);
    }
}
