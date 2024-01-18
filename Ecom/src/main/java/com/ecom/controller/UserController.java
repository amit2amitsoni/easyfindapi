package com.ecom.controller;

import com.ecom.modal.UserModal;
import com.ecom.request.LoginReqest;
import com.ecom.response.LoginDTO;
import com.ecom.service.UserService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public ResponseEntity<Object> register(@RequestBody  UserModal userModal){
        String msg = userService.addUser(userModal);
        Map<String, String> map = new HashMap<>();
        map.put("msg", "User Successfully Saved!");
        return ResponseEntity.ok(map);

    }

    @RequestMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginReqest userModal){
        Map<String, String> map= new HashMap<>();
        System.out.println(userModal.toString());
        LoginDTO resp=userService.login(userModal);

        return ResponseEntity.ok(resp);
    }
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserList(){
       List<UserModal> userModalList =  userService.getUserList();
       return ResponseEntity.ok(userModalList);
    }

    @RequestMapping("/approveUser")
    public ResponseEntity<Object> approveUser(UserModal userModal){
        Map<String, String> map= new HashMap<>();
        return ResponseEntity.ok(map);
    }
}
