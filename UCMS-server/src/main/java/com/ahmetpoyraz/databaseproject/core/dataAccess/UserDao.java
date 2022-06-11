package com.ahmetpoyraz.databaseproject.core.dataAccess;

import com.ahmetpoyraz.databaseproject.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
        User findByEmail(String email);

        User getByUserId(int userId);
        }