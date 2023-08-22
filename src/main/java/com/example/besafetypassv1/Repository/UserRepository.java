package com.example.besafetypassv1.Repository;

import com.example.besafetypassv1.Model.AccountUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AccountUserEntity, Long> {
    AccountUserEntity findAccountUserEntitiesByIdAndEmail(Long id, String email);
}
