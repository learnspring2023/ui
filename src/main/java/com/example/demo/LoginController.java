package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LoginController {

//LOgin
//Register
//POST
//GET
//PUT
//DELET
    @Autowired
    private UserRepository userRepository;

//Request Parameters
//@GetMapping("/login")
//public String login(@RequestParam String userName, @RequestParam String password) {
//    System.out.println("Inside login Method");
//    if(userName.equals("admin") && password.equals("pass")) {
//        return "Success";
//    } else {
//        return "Login Failed";
//    }
//}

//Path Variable
@GetMapping("/get-user/{id}")
public User register(@PathVariable Long id) {
    return userRepository.findById(id).get();
}

//Request Body

@GetMapping("/get-all-users")
public List<User> register() {
    return userRepository.findAll();
}

    @PostMapping("/login")
    public String login(@RequestBody User userIn) {

        List<User> users =  userRepository.findByEmailAndPassword(userIn.getEmail(),userIn.getPassword());
        System.out.println(users);
        String msg;
        if(users.size()==0) {
            msg = "Login Failed";
        } else {
            msg = "Login Success";
        }
    return msg;
}


@PostMapping("/register")
public User register(@RequestBody User userIn) {
    System.out.println("Incoming user:"+userIn);
    //Inserting to database
    User userOut = userRepository.save(userIn);
    System.out.println("Insert Success");
    return userOut;
}


}
