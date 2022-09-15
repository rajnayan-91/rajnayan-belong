package com.rajnayan.belong.telephonenumberservice.impl;

import com.rajnayan.belong.telephonenumberservice.model.Customer;
import com.rajnayan.belong.telephonenumberservice.model.PhoneNumber;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NumberServiceImpl {

    List<PhoneNumber> numbers= new ArrayList<>();
    List<Customer> customers= new ArrayList<>();

    @PostConstruct
    public void initCustomerPhone(){
        PhoneNumber phoneNumber1 = new PhoneNumber(96969696,"Active");
        PhoneNumber phoneNumber2 = new PhoneNumber(86868686,"Active");
        PhoneNumber phoneNumber3 = new PhoneNumber(76767676,"Active");
        PhoneNumber phoneNumber4 = new PhoneNumber(56565656,"Active");
        PhoneNumber phoneNumber5 = new PhoneNumber(65656565,"InActive");

        numbers= Arrays.asList(phoneNumber1,phoneNumber2, phoneNumber3,phoneNumber4,phoneNumber5);

        Customer customer1= new Customer("Ryan",Arrays.asList(phoneNumber1,phoneNumber3));
        Customer customer2= new Customer("Nayan",Arrays.asList(phoneNumber2));
        Customer customer3= new Customer("Amit",Arrays.asList(phoneNumber4));
        Customer customer4= new Customer("Raj",Arrays.asList(phoneNumber5));

        customers= Arrays.asList(customer1,customer2,customer3,customer4);
    }


    public List<Long> getAllPhoneNumbers(){
        return numbers.stream().map(number -> number.getPhone()).collect(Collectors.toList());
    }

    public List<Long> getPhoneNumbersByName(String name) {
        List<Long> customerNumbers = new ArrayList<>();
        List<Customer> cust = customers.stream().filter(customer -> customer.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (!cust.isEmpty()){
            for (Customer customer : cust) {
                List<Long> numbers = customer.getPhoneNumbers().stream().map(num -> num.getPhone()).collect(Collectors.toList());
                customerNumbers.addAll(numbers);
            }
    }
        return customerNumbers;
    }

    public boolean updatePhoneNumberStatus(Long num) {

        numbers.stream().filter(n-> num.equals(n.getPhone())).findFirst().ifPresent(s->s.setStatus("Active"));

        return true;
    }

    public String getPhoneNumberStatus(Long num) {
        String status=null;
        Optional<PhoneNumber> contactNum= numbers.stream().filter(n-> num.equals(n.getPhone())).findFirst();
        if(contactNum.isPresent())
        {
            status= contactNum.get().getStatus();
        }
        return status;
    }
}
