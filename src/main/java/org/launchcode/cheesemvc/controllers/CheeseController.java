package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


/**
 * Created by ryanneal on 11/13/17.
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute(new Cheese());
        model.addAttribute("title", "Add Cheese");
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheese(Model model, @ModelAttribute @Valid Cheese newCheese,
                                   Errors errors){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }

        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model){
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Add Cheese");
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheese(@RequestParam int[] ids){

        for (int id: ids) {
            CheeseData.remove(id);
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(@Valid Model model, @PathVariable int cheeseId) {

        model.addAttribute(CheeseData.getById(cheeseId));

        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(int cheeseId, String name, String description) {

        Cheese newCheese = CheeseData.getById(cheeseId);
        newCheese.setName(name);
        newCheese.setDescription(description);


        return "redirect:/cheese";
    }

}
