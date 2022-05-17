package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/index")
public class UserController {

    @Autowired
    UserRepository user;

    @GetMapping("/")
    public String getUsers(Model model)
    {
      model.addAttribute("users", this.user.getUsers());
      return "index";
    }
    public String getUser(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("users", this.user.getUser(id));
        return "index";

    }
    @GetMapping("/add")
    public String addUser(Model model, String name, String surname)
    {
        User user=new User(name, surname);
        this.user.addUser(user);
        model.addAttribute("users", this.user.getUsers());
        return "add_user";

    }
    @GetMapping("/remove")
    public String removUser(@PathVariable Optional<Integer>id, Model model)
    {
        int iid=id.isPresent() ? id.get():0;
        this.user.removeUser(iid);
        model.addAttribute("users", this.user.getUsers());
        return "remove_user";
    }
}
