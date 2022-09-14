package com.rajnayan.belong.telephonenumberservice.controller;

/**
 * Author: Rajnayan Palav
 */

import com.rajnayan.belong.telephonenumberservice.impl.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phonenumber")
public class TelephoneNumberController {

    @Autowired
    private NumberServiceImpl numberServiceImpl;


    @GetMapping("/byname/{userName}")
    public List<Long> getPhoneNumbers(@PathVariable("userName") String userName){
        return numberServiceImpl.getPhoneNumbersByName(userName);

    }

    @GetMapping("/allnumbers")
    public List<Long> getPhoneNumbers(){
        return numberServiceImpl.getAllPhoneNumbers();
    }
}
