package com.troyatech.usercrud.usercrudbackend.dataAccess;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.troyatech.usercrud.usercrudbackend.entity.MyUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class FirebaseUserDal implements IUserDal{
    Firestore dbFirestore = FirestoreClient.getFirestore();

    @Override
    public List<MyUser> getAllUser() throws ExecutionException, InterruptedException {
        CollectionReference collectionReference = dbFirestore.collection("crud_user");

//        ApiFuture<DocumentSnapshot> future = documentReference.get();
        Iterable<DocumentReference> listDoc = collectionReference.listDocuments();

        List<MyUser> listMyUser = new ArrayList<>();
        for(DocumentReference d: listDoc){
            ApiFuture<DocumentSnapshot> future = d.get();
            DocumentSnapshot document = future.get();

            MyUser myUser;
            if(document.exists()){
                myUser = document.toObject(MyUser.class);
                listMyUser.add(myUser);
            }

//                listMyUser.add(d.get().get());
        }
        if(!listMyUser.isEmpty()){
            return listMyUser;
        }

        return null;
    }
}
