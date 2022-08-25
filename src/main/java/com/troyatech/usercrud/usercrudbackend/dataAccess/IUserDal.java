package com.troyatech.usercrud.usercrudbackend.dataAccess;

import com.troyatech.usercrud.usercrudbackend.entity.MyUser;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IUserDal {
    List<MyUser> getAllUser() throws ExecutionException, InterruptedException;

    MyUser getById(String documentId) throws ExecutionException, InterruptedException;

    String createMyUser(MyUser myUser) throws ExecutionException, InterruptedException;

    String updateMyUser(MyUser myUser) throws ExecutionException, InterruptedException;

    @Transactional
    String deleteMyUser(String documentId);
}
