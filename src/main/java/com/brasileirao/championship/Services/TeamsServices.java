package com.brasileirao.championship.Services;

import com.brasileirao.championship.Entities.Teams;
import com.brasileirao.championship.Repositories.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamsServices {

    @Autowired
    private TeamsRepository repository;

    @Transactional(readOnly = true)
    public List<Teams> findAll() {
        return repository.findAll();
    }
}
