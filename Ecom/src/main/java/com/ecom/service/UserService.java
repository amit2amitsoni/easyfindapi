package com.ecom.service;

import com.ecom.modal.UserModal;
import com.ecom.request.LoginReqest;
import com.ecom.response.LoginDTO;

import java.util.List;

public interface UserService {
    String addUser(UserModal userModal);

    LoginDTO login(LoginReqest userModal);
    List<UserModal> getUserList();
    boolean approveUser(UserModal userModal);
}
