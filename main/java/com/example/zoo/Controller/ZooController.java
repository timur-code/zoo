package com.example.zoo.Controller;

import com.example.zoo.Service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ZooController {
    @Autowired
    private ZooService zooService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("habitats", zooService.getHabitats());
        return "page";
    }

    @GetMapping("/addHabitat")
    public String getHabitat() {
        return "newHabitat";
    }

    @PostMapping("/addHabitat")
    public String addHabitat(@RequestParam(name = "option") int option, @RequestParam(name = "size") int size) {
        zooService.addHabitat(option, size);
        return "redirect:/";
    }

    @GetMapping("/addAnimal")
    public String getAddAnimal(){
        return "addAnimal";
    }

    @PostMapping("/addAnimal")
    public String addAnimal(@RequestParam(name = "animalOption") int animalOption, @RequestParam(name = "size") int size,
                            @RequestParam(name = "cageNumber") int cageNumber){
        zooService.addAnimalToHabitat(animalOption, size, cageNumber);
        return "redirect:/";
    }
}
