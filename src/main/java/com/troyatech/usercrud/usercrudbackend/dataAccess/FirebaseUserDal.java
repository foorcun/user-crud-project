package com.troyatech.usercrud.usercrudbackend.dataAccess;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.troyatech.usercrud.usercrudbackend.entity.MyUser;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class FirebaseUserDal implements IUserDal{
    Firestore dbFirestore = FirestoreClient.getFirestore();

    @Override
    @Transactional
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

    @Override
    @Transactional
    public MyUser getById(String documentId) throws ExecutionException, InterruptedException {
        //        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("crud_user").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        MyUser myUser;
        if(document.exists()){
            myUser = document.toObject(MyUser.class);
            return myUser;
        }
        return null;
    }

    @Override
    public String createMyUser(MyUser myUser) throws ExecutionException, InterruptedException { //return update time
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("crud_user").document(myUser.getDocumentId()).set(myUser);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    @Transactional
    public String updateMyUser(MyUser myUser) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("crud_user").document(myUser.getDocumentId()).set(myUser);
        return collectionsApiFuture.get().getUpdateTime().toString();

    }


    @Override
    @Transactional
    public String deleteMyUser(String documentId){
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("crud_user").document(documentId).delete();


        return "Successfully deleted " + documentId;
    }
}
