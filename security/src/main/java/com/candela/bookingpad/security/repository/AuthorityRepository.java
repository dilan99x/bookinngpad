package com.candela.bookingpad.security.repository;


import com.candela.bookingpad.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
