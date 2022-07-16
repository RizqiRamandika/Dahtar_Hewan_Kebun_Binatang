package com.data.animal.animal.controller;

import com.data.animal.animal.model.Animal;
import com.data.animal.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Animal> listAnimal = service.listAll();
        model.addAttribute("listAnimal", listAnimal);

        return "index";
    }

    @RequestMapping("/add")
    public String showNewAnimalPage(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);

        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAnimal(@ModelAttribute("animal") Animal animal) {
        service.save(animal);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditAnimalPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit");
        Animal animal = service.get(id);
        mav.addObject("animal", animal);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

}
