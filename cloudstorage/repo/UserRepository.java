package com.udacity.jwdnd.course1.cloudstorage.repo;

import com.udacity.jwdnd.course1.cloudstorage.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}