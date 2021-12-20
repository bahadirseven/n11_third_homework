package com.n11.thirdhomeworkbahadirseven.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "product-comment")
public class ProductComment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String comment;
    private Date date;
    private Long productId;
    private Long userId;
}
