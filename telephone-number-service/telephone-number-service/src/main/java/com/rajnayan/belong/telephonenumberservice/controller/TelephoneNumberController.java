package com.rajnayan.belong.telephonenumberservice.controller;

import com.rajnayan.belong.telephonenumberservice.model.PhoneNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/phonenumber")
public class TelephoneNumberController {


    @GetMapping("/byname/{userName}")
    public List<PhoneNumber> getPhoneNumbers(@PathVariable("userName") String userName){

        return Collections.singletonList(
                new PhoneNumber(89966357,"Rajnayan")
        );
    }
}
