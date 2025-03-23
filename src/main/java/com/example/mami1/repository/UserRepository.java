package com.example.mami1.repository;

import com.example.mami1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Spring'e bunun bir repository bileşeni olduğunu bildiriyoruz
public interface UserRepository extends JpaRepository<User, Long> {

    // 📌 Spring Data JPA, isme dayalı sorgular oluşturabilir
    Optional<User> findByEmail(String email);

    // 📌 Eğer belirli bir adı taşıyan kullanıcıları çekmek istiyorsak
    Optional<User> findByName(String name);
}
