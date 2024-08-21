package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class Newcontroller {

    @Autowired
    private Newservice userService;

    @PostMapping("/add")
    public String insertUser(@RequestBody New user) {
        userService.insertUser(user);
        return "User added successfully!";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody New user) {
        userService.updateUser(id, user);
        return "User updated successfully!";
    }

    @DeleteMapping("/del/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted successfully!";
    }
    @GetMapping("/get")
    public List<Map<String, Object>> getDetails() {
        return userService.getDetails();
    }
}
