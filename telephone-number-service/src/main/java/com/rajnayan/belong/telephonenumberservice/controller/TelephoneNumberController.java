package com.rajnayan.belong.telephonenumberservice.controller;

/**
 * Author: Rajnayan Palav
 */

import com.rajnayan.belong.telephonenumberservice.impl.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phonenumber")
public class TelephoneNumberController {

    @Autowired
    private NumberServiceImpl numberServiceImpl;

    /**
     *
     * @param userName
     * @return
     */
    @GetMapping("/byname/{userName}")
    public List<Long> getPhoneNumbersByName(@PathVariable("userName") String userName){
        return numberServiceImpl.getPhoneNumbersByName(userName);

    }

    /**
     *
     * @return
     */
    @GetMapping("/allnumbers")
    public List<Long> getPhoneNumbers(){
        return numberServiceImpl.getAllPhoneNumbers();
    }

    @GetMapping("/numberstatus/{number}")
    public String getPhoneNumbersStatus(@PathVariable("number") Long number){
        return numberServiceImpl.getPhoneNumberStatus(number);

    }

    @PatchMapping("/activateNumber/{number}")
    public ResponseEntity<Object> activatePhoneStatus(@PathVariable("number") Long number){
        if (numberServiceImpl.updatePhoneNumberStatus(number)){
            return ResponseEntity.ok("Phone Number Activated");
        }else{
            return ResponseEntity.ok("Phone Number Not Found");
        }

    }
}
