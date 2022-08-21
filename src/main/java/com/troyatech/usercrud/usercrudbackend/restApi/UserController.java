package com.troyatech.usercrud.usercrudbackend.restApi;

import com.troyatech.usercrud.usercrudbackend.business.IUserService;
import com.troyatech.usercrud.usercrudbackend.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin
@RestController
public class UserController {

    public IUserService userManager;

    public UserController(IUserService userManager) {
        this.userManager = userManager;
    }


    @GetMapping("/getAll")
    public List<MyUser> getCRUD() throws InterruptedException, ExecutionException {
        return userManager.getAllUser();
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() { return ResponseEntity.ok("hibernateAndJpa_v3 Test Get Endpoint is Working");}

}
