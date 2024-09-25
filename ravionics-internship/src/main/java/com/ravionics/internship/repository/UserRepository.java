package com.ravionics.internship.repository;

import com.ravionics.internship.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User getByUsernameAndPassword(String userName, String password);
}
