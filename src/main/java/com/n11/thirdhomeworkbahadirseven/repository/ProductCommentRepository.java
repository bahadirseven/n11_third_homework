package com.n11.thirdhomeworkbahadirseven.repository;

import com.n11.thirdhomeworkbahadirseven.entity.ProductComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentRepository extends MongoRepository<ProductComment, Long> {

}
