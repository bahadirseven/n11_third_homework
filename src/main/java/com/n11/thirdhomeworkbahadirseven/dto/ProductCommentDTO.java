package com.n11.thirdhomeworkbahadirseven.dto;

import com.n11.thirdhomeworkbahadirseven.entity.ProductComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductCommentDTO {
    @Id
    private Long id;
    private String comment;
    private Date date;
    private Long productId;
    private Long userId;

    public static ProductCommentDTO fromProductComment(ProductComment productComment){
        return new ProductCommentDTO(
                productComment.getId(),
                productComment.getComment(),
                productComment.getDate(),
                productComment.getProductId(),
                productComment.getUserId());
    }

    public static ProductComment fromProductCommentDTO(Long nextId, ProductCommentDTO productCommentDTO){
        return new ProductComment(
                nextId,
                productCommentDTO.getComment(),
                Calendar.getInstance().getTime(),
                productCommentDTO.getProductId(),
                productCommentDTO.getUserId());
    }
}
