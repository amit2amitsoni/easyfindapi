package com.ecom.service.impl;

import com.ecom.entity.User;
import com.ecom.modal.UserModal;
import com.ecom.repo.UserRepo;
import com.ecom.request.LoginReqest;
import com.ecom.response.LoginDTO;
import com.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public String addUser(UserModal userModal) {
        User user = new User();
        user.setUsername(userModal.getUsername());
        user.setPassword(userModal.getPassword());
        user.setDob(userModal.getDob());
        user.setMobile(userModal.getMobile());
        user.setType(userModal.getType());
        userRepo.save(user);
        System.out.println(user);
        return "User Successfully Saved!";
    }

    @Override
    public LoginDTO login(LoginReqest userModal) {
        String username = userModal.getUsername();
        String password = userModal.getPassword();
        User user = userRepo.findByUsername(username);
        LoginDTO resp = new LoginDTO();
        if (username.equals(user.getUsername())) {
            if (password.equals(user.getPassword())) {
                resp.setUserModel(user);
                resp.setMsg("Login Success");
                resp.setStaus("200");
            } else {
                resp.setUserModel(null);
                resp.setMsg("Login Fail");
                resp.setStaus("501");
            }
        } else {
            resp.setUserModel(null);
            resp.setMsg("Login Fail");
            resp.setStaus("501");
        }
        return resp;
    }

    @Override
    public List<UserModal> getUserList() {
        List<User> users = userRepo.findAll();
        List<UserModal> userModalList = new ArrayList<>();
        for (User user : users) {
            UserModal userModal = new UserModal();
            userModal.setUsername(user.getUsername());
            userModal.setPassword(user.getPassword());
            userModal.setMobile(user.getMobile());
            userModal.setIsverified(user.getIsverified());
            userModalList.add(userModal);
        }
        return userModalList;
    }

    @Override
    public boolean approveUser(UserModal userModal) {
        return false;
    }
}
