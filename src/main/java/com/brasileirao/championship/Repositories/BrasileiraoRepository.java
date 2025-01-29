package com.brasileirao.championship.Repositories;

import com.brasileirao.championship.Entities.Brasileirao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrasileiraoRepository extends JpaRepository<Brasileirao, Long> {

    List<Brasileirao> findAllByTeam(String team);
}
