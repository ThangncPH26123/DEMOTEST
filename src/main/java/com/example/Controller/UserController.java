package com.example.Controller;

import com.example.Model.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    int ID;

    @GetMapping("/")
    public String addUser(ModelMap model){
        User x = new User();
        model.addAttribute("USER",x);
        model.addAttribute("ACTION","/save");
        return "register";
    }

    @PostMapping("/save")
    public String save(ModelMap model, @ModelAttribute("USER") User user){
//        User x = new User();
//        model.addAttribute("USER",x);
//        model.addAttribute("ACTION","/save");
        userService.save(user);
        return "register";
    }

    @PostMapping("/saveid")
    public String saveId(@ModelAttribute("USER") User user){
        user.setId(ID);
        userService.save(user);
        return "register";
    }

    @GetMapping("/list")
    public String getList(ModelMap model){
        model.addAttribute("USERS",userService.getAllUser());
        return "views";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(ModelMap model, @PathVariable(name = "id") int id, @ModelAttribute("USER") User user){
//        Optional<User> xx = userService.findUserById(id);
//        if(xx.isPresent()){
//            model.addAttribute("USER", xx.get());
//            ID = id;
//        }else{
//            model.addAttribute("USER",new User());
//        }
        User xx = userService.findById(id);
        if(xx != null) {
            model.addAttribute("USER", xx);
            ID = id;
        }else{
            model.addAttribute("USER",new User());
        }
        model.addAttribute("ACTION","/saveid");
        return "register";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(ModelMap model , @PathVariable(name = "id") int id) {
        userService.deleteById(id);
        model.addAttribute("USERS",userService.getAllUser());
        return "views";
    }

}
