package com.example.mami1.exception;

/**
 * 📌 Belirli bir kaynak bulunamadığında fırlatılır.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
