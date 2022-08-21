package com.troyatech.usercrud.usercrudbackend.business;

import com.troyatech.usercrud.usercrudbackend.entity.MyUser;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IUserService {
    List<MyUser> getAllUser() throws ExecutionException, InterruptedException;
}
