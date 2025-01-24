package com.brasileirao.championship.Services;

import com.brasileirao.championship.Entities.Brasileirao;
import com.brasileirao.championship.Repositories.BrasileiraoRepository;
import com.brasileirao.championship.dto.BrasileiraoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BrasileiraoService {

    @Autowired
    private BrasileiraoRepository repository;

    @Transactional(readOnly = true)
    public List<Brasileirao> findAll() {
        return repository.findAll();
    }

}
