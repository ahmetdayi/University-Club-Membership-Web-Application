package com.ahmetpoyraz.databaseproject.business.concretes;

import com.ahmetpoyraz.databaseproject.business.abstracts.UserService;
import com.ahmetpoyraz.databaseproject.core.dataAccess.UserDao;
import com.ahmetpoyraz.databaseproject.core.entities.User;
import com.ahmetpoyraz.databaseproject.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        if(userDao.findByEmail(user.getEmail())!=null) {
            return new ErrorResult("Aynı email var");
        }

            this.userDao.save(user);
            return new SuccessResult("Kullanici eklendi");




    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email)
                ,"Kullanıcı bulundu");
    }

    @Override
    public DataResult<User> getByUserId(int userId) {
        return new SuccessDataResult<User>
                (this.userDao.getByUserId(userId)
                ,"Kullanıcı bulundu");
    }

}