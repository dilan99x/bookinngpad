package com.candela.bookingpad.security.repository;

import com.candela.bookingpad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    User findByUsernameCaseInsensitive(@Param("username") String username);

    @Query
    User findByEmail(String email);

    @Query
    User findByEmailAndOtpCode(String email, String otpCode);

    @Query
    User findByEmailAndPasswordResetToken(String email, String passwordResetToken);

}