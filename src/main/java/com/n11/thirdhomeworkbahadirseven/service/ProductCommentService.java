package com.n11.thirdhomeworkbahadirseven.service;

import com.n11.thirdhomeworkbahadirseven.dto.ProductCommentDTO;
import com.n11.thirdhomeworkbahadirseven.entity.ProductComment;
import com.n11.thirdhomeworkbahadirseven.exception.NoEntityFoundException;
import com.n11.thirdhomeworkbahadirseven.repository.ProductCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCommentService {
    private final ProductCommentRepository productCommentRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public ProductCommentDTO saveProductComment(ProductCommentDTO productCommentDTO) {
        Long nextId = sequenceGeneratorService.getSequenceNumber("comments");
        ProductComment productComment = ProductCommentDTO.fromProductCommentDTO(nextId,productCommentDTO);
        ProductComment savedProductComment = productCommentRepository.save(productComment);
        return ProductCommentDTO.fromProductComment(savedProductComment);
    }

    public void deleteProductCommentById(Long id) {
        productCommentRepository.deleteById(id);
    }

    public ProductCommentDTO findProductById(Long id) {
        ProductComment productComment = productCommentRepository.findById(id).orElseThrow(() -> new NoEntityFoundException("Comment not found."));
        return ProductCommentDTO.fromProductComment(productComment);
    }

    public List<ProductCommentDTO> findAllProductComment(){
        List<ProductComment> productCommentList = productCommentRepository.findAll();
        return productCommentList.stream().map(ProductCommentDTO::fromProductComment).collect(Collectors.toList());
    }
}
