package com.allyson.hruser.repositories;



import com.allyson.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

User findAllByEmail(String email);


}
