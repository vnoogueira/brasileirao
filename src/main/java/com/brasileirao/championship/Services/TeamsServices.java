package com.brasileirao.championship.Services;

import com.brasileirao.championship.Entities.Teams;
import com.brasileirao.championship.Repositories.TeamsRepository;
import com.brasileirao.championship.Services.Exceptions.ResourceNotFoundException;
import com.brasileirao.championship.dto.TeamsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamsServices {

    @Autowired
    private TeamsRepository repository;

    @Transactional(readOnly = true)
    public List<Teams> findAll() {
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    public TeamsDto findTeamById(Long id) {
        Optional<Teams> obj = repository.findById(id);
        Teams teams = obj
                .orElseThrow(() -> new ResourceNotFoundException("Team not found !"));
        return new TeamsDto(teams);
    }
}
