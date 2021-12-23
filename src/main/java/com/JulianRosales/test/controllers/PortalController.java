/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JulianRosales.test.controllers;

import com.JulianRosales.test.entities.User;
import com.JulianRosales.test.services.JsonService;
import com.JulianRosales.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalController {
    
    @Autowired
    JsonService jser;
    @Autowired
    UserService userService;
    
    @GetMapping("/")
    public String index(){
        
        return "index.html";
    }
    
    @GetMapping("/search")
    public String search(String publicID, ModelMap model){
        try {
            User user = userService.completeUserInfo(jser.getJSONObject(publicID));
            
            model.put("user", user);
            
            return "user.html";
        } catch (Exception e) {
            System.out.println(e);
            return "error.html";
        }
    }
    


}
