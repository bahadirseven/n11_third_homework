package com.n11.thirdhomeworkbahadirseven.controller;

import com.n11.thirdhomeworkbahadirseven.dto.ProductCommentDTO;
import com.n11.thirdhomeworkbahadirseven.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class ProductCommentController {
    private final ProductCommentService productCommentService;

    @PostMapping
    public ResponseEntity<ProductCommentDTO> saveProductComment(@RequestBody ProductCommentDTO productCommentDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productCommentService.saveProductComment(productCommentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductComment(@PathVariable("id") Long id){
        productCommentService.deleteProductCommentById(id);
        return ResponseEntity.ok("Comment deleted successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCommentDTO> findUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(productCommentService.findProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductCommentDTO>> findAllUser(){
        return ResponseEntity.ok(productCommentService.findAllProductComment());
    }
}
