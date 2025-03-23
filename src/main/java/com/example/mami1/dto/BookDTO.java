package com.example.mami1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 📌 Kitap bilgilerini taşımak için kullanılan DTO sınıfı.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private String author;
    private String category;
}
