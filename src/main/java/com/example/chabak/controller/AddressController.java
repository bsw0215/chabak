package com.example.chabak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class AddressController {


    //@Secured("ROLE_MANAGER")
    @GetMapping("/map")
    public String insertPage(){
        return "map";
    }

}
