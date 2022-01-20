package com.example.zoo.Service;

import com.example.zoo.Animals.*;
import com.example.zoo.Habitat.*;
import com.example.zoo.Movement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ZooService {
    private final HashMap<Integer, Habitat<Movable>> habitatList;
    private Integer counter;

    @Autowired
    public ZooService() {
        this.habitatList = new HashMap<>();
        counter = 0;
    }

    public ArrayList<Habitat<Movable>> getHabitats() {
        return  new ArrayList<Habitat<Movable>>(habitatList.values());
    }

    public String getHabitatList() {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            info.append(habitatList.get(i).toString()).append("\n");
        }

        return info.toString();
    }

    public void addHabitat(int option, int size) {
        switch(option) {
            case 1:
                habitatList.put(counter, new Cage<Tiger>(size));
                break;
            case 2:
                habitatList.put(counter, new Cage<Wolf>(size));
                break;
            case 3:
                habitatList.put(counter, new Cell<Flyable>(size));
                break;
            case 4:
                habitatList.put(counter, new Aquarium<Fish>(size));
                break;
            case 5:
                habitatList.put(counter, new Aquarium<Turtle>(size));
                break;
            case 6:
                habitatList.put(counter, new Aquarium<Swimmable>(size));
                break;
            default:
                return;
        }

        counter++;
    }

    public void addAnimalToHabitat(int animalOption, int size, int cageNumber) {
        try {
            Movable animal = createAnimal(animalOption, size);
            Habitat<Movable> cage = chooseHabitat(cageNumber);

            cage.addAnimal(animal);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Habitat<Movable> chooseHabitat(int number) {
        return habitatList.get(number);
    }

    public Movable createAnimal(int option, int size) throws Exception {
        switch (option) {
            case 1:
                return new Crow(size);
            case 2:
                return new Penguin(size);
            case 3:
                return new Ostrich(size);
            case 4:
                return new Sparrow(size);
            case 5:
                return new Tiger(size);
            case 6:
                return new Turtle(size);
            case 7:
                return new Wolf(size);
            case 8:
                return new Fox(size);
            case 9:
                return new Pike(size);
            case 10:
                return new Shark(size);
            default:
                throw new Exception("Can't create animal of this type.");
        }
    }
}
