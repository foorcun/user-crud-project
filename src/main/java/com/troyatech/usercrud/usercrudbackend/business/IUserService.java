package com.troyatech.usercrud.usercrudbackend.business;

import com.troyatech.usercrud.usercrudbackend.entity.MyUser;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IUserService {
    List<MyUser> getAllUser() throws ExecutionException, InterruptedException;

    MyUser getById(String documentId) throws ExecutionException, InterruptedException;

    String createMyUser(MyUser myUser) throws ExecutionException, InterruptedException;

    String updateMyUser(MyUser myUser) throws ExecutionException, InterruptedException;

    String deleteMyUser(String documentId);
}
