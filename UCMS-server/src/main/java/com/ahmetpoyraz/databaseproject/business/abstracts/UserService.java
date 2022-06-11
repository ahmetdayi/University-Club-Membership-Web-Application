package com.ahmetpoyraz.databaseproject.business.abstracts;

import com.ahmetpoyraz.databaseproject.core.entities.User;
import com.ahmetpoyraz.databaseproject.core.utilities.results.DataResult;
import com.ahmetpoyraz.databaseproject.core.utilities.results.Result;
import com.ahmetpoyraz.databaseproject.entities.concretes.Clubs;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);

    DataResult<User> getByUserId(int userId);
}
