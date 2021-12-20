package com.n11.thirdhomeworkbahadirseven.repository;

import com.n11.thirdhomeworkbahadirseven.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
