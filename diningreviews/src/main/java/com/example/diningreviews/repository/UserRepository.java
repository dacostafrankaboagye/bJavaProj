package com.example.diningreviews.repository;

import com.example.diningreviews.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

//    public User findByUserName(String userName);
//    public List<User> findByZipcode(String zipcode);
//    public User findByUserNameAndZipcode(String UserName, String zipcode);


}
