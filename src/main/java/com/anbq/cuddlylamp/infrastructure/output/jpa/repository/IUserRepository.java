package com.anbq.cuddlylamp.infrastructure.output.jpa.repository;

import com.anbq.cuddlylamp.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
