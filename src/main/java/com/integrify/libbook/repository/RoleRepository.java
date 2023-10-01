package com.integrify.libbook.repository;

import java.util.Optional;

import com.integrify.libbook.bean.ERole;
import com.integrify.libbook.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}