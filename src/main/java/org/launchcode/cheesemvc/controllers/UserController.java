package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.launchcode.cheesemvc.models.UserData;

/**
 * Created by ryanneal on 12/5/17.
 */

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayIndex(Model model) {
        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title", "Users");
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "Signup");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processUser(@RequestParam String verify, Model model,
                              @ModelAttribute @Valid User newUser,
                              Errors errors){

        if (!verify.equals(newUser.getPassword())){
            model.addAttribute("title", "Signup");
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }

        else if (errors.hasErrors()) {
            model.addAttribute("title", "Signup");
            return "user/add";
        }

        UserData.add(newUser);

        return "redirect:/user";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String displayUser(@Valid Model model, @PathVariable int userId) {

        model.addAttribute(UserData.getById(userId));

        return "user/individual";
    }

}
