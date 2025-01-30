package com.brasileirao.championship.Services;

import com.brasileirao.championship.Entities.Brasileirao;
import com.brasileirao.championship.Entities.Teams;
import com.brasileirao.championship.Repositories.BrasileiraoRepository;
import com.brasileirao.championship.Services.Exceptions.ResourceNotFoundException;
import com.brasileirao.championship.dto.BrasileiraoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrasileiraoService {

    @Autowired
    private BrasileiraoRepository repository;

    @Transactional(readOnly = true)
    public List<Brasileirao> findAll() {
        return repository.findAll();
    }

    public BrasileiraoDto findById(Long id) {
        Optional<Brasileirao> obj = repository.findById(id);
        Brasileirao brasileirao = obj.orElseThrow(() -> new ResourceNotFoundException("Search not found !"));
        return new BrasileiraoDto(brasileirao);
    }

    public List<BrasileiraoDto> findAllByTeam(String team) {
        List<Brasileirao> obj = repository.findAllByTeam(team);
        if (obj.isEmpty()) {
            throw new ResourceNotFoundException("team not found!" + team);
        }
        return obj.stream().map(BrasileiraoDto::new).collect(Collectors.toList());
    }

    public BrasileiraoDto updateBrasileirao(Long id, BrasileiraoDto body) {
        try {
            Brasileirao dto = repository.getReferenceById(id);
            dto.setSeason(body.getSeason());
            dto.setPlace(body.getPlace());
            dto.setTeam(body.getTeam());
            dto.setPoints(body.getPoints());
            dto.setPlayed(body.getPlayed());
            dto.setWon(body.getWon());
            dto.setDraw(body.getDraw());
            dto.setLoss(body.getLoss());
            dto.setGoals(body.getGoals());
            dto.setGoalsTaken(body.getGoalsTaken());
            dto.setGoalsDiff(body.getGoalsDiff());
            dto = repository.save(dto);
            return new BrasileiraoDto(dto);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
