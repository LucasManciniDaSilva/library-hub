package com.allchars.repository;

import com.allchars.domain.CharDomain;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharRepositoryJpa extends JpaRepository<CharDomain, Long> {
    boolean existsByCharNameAndOrigin(String charName, String origin);

}
