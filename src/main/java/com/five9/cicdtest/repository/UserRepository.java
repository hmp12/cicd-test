package com.five9.cicdtest.repository;

import com.five9.cicdtest.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query(value = "SELECT u FROM UserEntity u " +
            "WHERE (u.username LIkE %?1%) " +
            "AND (u.email LIKE %?2%) " +
            "AND (u.phone LIKE %?3%) " +
            "AND (?4 = -1 OR u.role = ?4) " +
            "AND (?5 = -1 OR u.status = ?5)")
    Page<UserEntity> findUserByFilter(String username, String email, String phone, int role, int status, Pageable pageable);

    @Query("SELECT u FROM UserEntity u WHERE id = ?1")
    UserEntity findUserById(int id);

    @Query("SELECT u FROM UserEntity u WHERE username = ?1")
    UserEntity findUserByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE email = ?1")
    UserEntity findUserByEmail(String email);

    @Query("SELECT u from UserEntity u WHERE username = ?1")
    UserEntity getUserDetails(String username);
}
