package com.troyatech.usercrud.usercrudbackend.business;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.troyatech.usercrud.usercrudbackend.dataAccess.IUserDal;
import com.troyatech.usercrud.usercrudbackend.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
//@DependsOn("fCMInitializer")
public class UserManager implements IUserService {

    @Autowired
    private IUserDal userDal;

    public UserManager(IUserDal userDal) {
        this.userDal = userDal;
    }



    @Override
    public List<MyUser> getAllUser() throws ExecutionException, InterruptedException {
     return   userDal.getAllUser();
    }
}
