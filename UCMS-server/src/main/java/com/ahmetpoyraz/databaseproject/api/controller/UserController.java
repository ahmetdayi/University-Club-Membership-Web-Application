package com.ahmetpoyraz.databaseproject.api.controller;

import com.ahmetpoyraz.databaseproject.business.abstracts.UserService;
import com.ahmetpoyraz.databaseproject.core.entities.User;
import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.ErrorDataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.core.utilities.results.SuccessDataResult;
import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping(value="/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        Result res = this.userService.add(user);
        if (res.isSuccess()) return ResponseEntity.status(HttpStatus.CREATED).body(res);
        return ResponseEntity.badRequest().body(res);
    }
    @GetMapping("/getByUserId")
    public DataResult<User> getByUserId(@RequestParam int userId) {
        return this.userService.getByUserId(userId);
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        DataResult<User> res = this.userService.findByEmail(email);
        System.out.println(res.isSuccess());
        if (res.isSuccess()) return ResponseEntity.ok().body(res);

        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }



}