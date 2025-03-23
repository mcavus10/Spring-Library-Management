package com.example.mami1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 📌 Kullanıcı verilerini dış dünyaya açmak için DTO sınıfı.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;

}
