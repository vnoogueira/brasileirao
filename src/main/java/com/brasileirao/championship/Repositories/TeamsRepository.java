package com.brasileirao.championship.Repositories;

import com.brasileirao.championship.Entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {

    Optional<Teams> findAllByTeam(String teams);
}
