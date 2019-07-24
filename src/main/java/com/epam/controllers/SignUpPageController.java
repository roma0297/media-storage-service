package com.epam.controllers;

import com.epam.forms.UserForm;
import com.epam.models.UserModel;
import com.epam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class SignUpPageController {
    @GetMapping("/signup")
    public ModelAndView getSignUpPage(Model model) {
        return new ModelAndView("signup");
    }

    @Autowired
    private UserService userService;

    @ModelAttribute("userForm")
    public UserForm userForm() {
        return new UserForm();
    }

    @PostMapping("/signup")
    public ModelAndView registerNewUser(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult bindingResult) {
        UserModel existing = userService.findByEmail(userForm.getEmail());
        if (existing != null){
            bindingResult.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (bindingResult.hasErrors()){
            return new ModelAndView("signup");
        }

        userService.save(userForm);
        return new ModelAndView("homepage");
    }
}
