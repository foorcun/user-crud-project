package com.troyatech.usercrud.usercrudbackend.dataAccess;

import com.troyatech.usercrud.usercrudbackend.entity.MyUser;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IUserDal {
    List<MyUser> getAllUser() throws ExecutionException, InterruptedException;

}
