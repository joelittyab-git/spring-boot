package com.example.springjpa.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

@RestController
@Component

@RequestMapping("server2/")
public class UserController {

    @Autowired
    protected UserService userService;


    @PostMapping("save-user/")
    public String saveUser(@RequestBody String body){
        userService.saveUser();
        return "success";
    }

    @PostMapping("register/")
    public HashMap<String, String> registerUser(@RequestBody User user){
        HashMap<String, String> json = new HashMap<>();

        try {
            userService.saveUser(user);
            json.put("info", "success");
        }catch (Exception ignored){
            json.put("info", "exception");
        }
        return json;
    }

    @GetMapping("get-user/")
    public String retrieveUser(
            @RequestBody User user,
            HttpServletResponse response,
            HttpServletRequest request

            ){
        JSONArray jsonArray = new JSONArray();
        HashMap<String,String> map = new HashMap<>();
        map.put("info", "success");
        try{
            System.out.println(request.getHeader("user"));
        }catch (Exception ignore){
            System.out.println("user does not exist");
        }
        JSONObject obj = new JSONObject();
        obj.put("info","success");
        jsonArray.put(map);
        var users = userService.getUser(user.getEmail());
        obj.put("users", users);
        jsonArray.put(users);
        Cookie cookie = new Cookie("Authentication","Token-helpMe");
        response.addCookie(cookie);
        return obj.toString();

    }

}
