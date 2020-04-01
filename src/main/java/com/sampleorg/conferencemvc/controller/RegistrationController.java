package com.sampleorg.conferencemvc.controller;

import com.sampleorg.conferencemvc.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute ("registration") Registration registration) {
        return "registration";
    }

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")
                                              Registration registration,
                                  BindingResult result) {
        if(result.hasErrors()) {
            System.out.println("Validation Error seen in:"+registration.getName()+" with error="+result);
//            result.addError(new ObjectError("name","Registration name cannot be empty"));
            return "registration";
        }
        System.out.println("Registered value:"+registration.getName());
        return "redirect:registration";
    }
}
