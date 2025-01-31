package com.brasileirao.championship.Services;

import com.brasileirao.championship.Entities.Brasileirao;
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
            Brasileirao obj = repository.getReferenceById(id);
            obj.setSeason(body.getSeason());
            obj.setPlace(body.getPlace());
            obj.setTeam(body.getTeam());
            obj.setPoints(body.getPoints());
            obj.setPlayed(body.getPlayed());
            obj.setWon(body.getWon());
            obj.setDraw(body.getDraw());
            obj.setLoss(body.getLoss());
            obj.setGoals(body.getGoals());
            obj.setGoalsTaken(body.getGoalsTaken());
            obj.setGoalsDiff(body.getGoalsDiff());
            obj = repository.save(obj);
            return new BrasileiraoDto(obj);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public BrasileiraoDto insertBrasileirao(BrasileiraoDto body) {
        Brasileirao obj = new Brasileirao();
        obj.setSeason(body.getSeason());
        obj.setPlace(body.getPlace());
        obj.setTeam(body.getTeam());
        obj.setPoints(body.getPoints());
        obj.setPlayed(body.getPlayed());
        obj.setWon(body.getWon());
        obj.setDraw(body.getDraw());
        obj.setLoss(body.getLoss());
        obj.setGoals(body.getGoals());
        obj.setGoalsTaken(body.getGoalsTaken());
        obj.setGoalsDiff(body.getGoalsDiff());
        obj = repository.save(obj);
        return new BrasileiraoDto(obj);
    }

    public void deleteBrasileirao(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
