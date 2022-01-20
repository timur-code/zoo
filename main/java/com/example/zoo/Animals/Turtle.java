package com.example.zoo.Animals;

import com.example.zoo.Movement.Swimmable;
import com.example.zoo.Movement.Walkable;

public class Turtle extends Animal implements Walkable, Swimmable {
    public Turtle(int size) {
        super(size);
    }
}
