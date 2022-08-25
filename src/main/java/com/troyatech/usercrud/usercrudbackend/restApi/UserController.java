package com.troyatech.usercrud.usercrudbackend.restApi;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.WriteResult;
import com.troyatech.usercrud.usercrudbackend.business.IUserService;
import com.troyatech.usercrud.usercrudbackend.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    public IUserService userManager;

    public UserController(IUserService userManager) {
        this.userManager = userManager;
    }


    @GetMapping("/getAll")
    public List<MyUser> getAllUser() throws InterruptedException, ExecutionException {
        return userManager.getAllUser();
    }


    @GetMapping("/get")
    public MyUser getById(@RequestParam String documentId)throws InterruptedException, ExecutionException{
        return userManager.getById(documentId);
    }


    @PostMapping("/create")
    public String createMyUser(@RequestBody MyUser myUser)throws InterruptedException, ExecutionException{
        return userManager.createMyUser(myUser);
    }


    @PutMapping("/update")
    public String updateMyUser(@RequestBody MyUser myUser) throws ExecutionException, InterruptedException {
        return userManager.updateMyUser(myUser);
    }

    @PutMapping("/delete")
    public String deleteMyUser(@RequestParam String documentId){
        return userManager.deleteMyUser(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() { return ResponseEntity.ok("hibernateAndJpa_v3 Test Get Endpoint is Working");}

}
