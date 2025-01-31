package com.brasileirao.championship.Services;

import com.brasileirao.championship.Entities.Teams;
import com.brasileirao.championship.Repositories.TeamsRepository;
import com.brasileirao.championship.Services.Exceptions.ResourceNotFoundException;
import com.brasileirao.championship.dto.TeamsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        Teams teams = obj.orElseThrow(() -> new ResourceNotFoundException("Id not found: " + id));
        return new TeamsDto(teams);
    }

    @Transactional(readOnly = true)
    public TeamsDto findAllByTeam(String team) {
        Optional<Teams> obj = repository.findAllByTeam(team);
        Teams teamObj = obj.orElseThrow(() -> new ResourceNotFoundException("Team not found: " + team));
        return new TeamsDto(teamObj);
    }

    @Transactional
    public TeamsDto updateTeams(Long id, TeamsDto teams) {
        String team = teams.getTeam();
        Teams entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + id + " - " + team));
        entity.setTeam(teams.getTeam());
        entity.setCity(teams.getCity());
        entity.setFullName(teams.getFullName());
        entity.setAcronym(teams.getAcronym());
        entity.setRegion(teams.getRegion());
        entity.setState(teams.getState());
        entity.setStadium(teams.getStadium());
        entity = repository.save(entity);
        return new TeamsDto(entity);
    }

    @Transactional(readOnly = true)
    public TeamsDto insertTeams(TeamsDto entity) {
        Teams teams = new Teams();
        teams.setTeam(entity.getTeam());
        teams.setAcronym(entity.getAcronym());
        teams.setFullName(entity.getFullName());
        teams.setFounded(entity.getFounded());
        teams.setStadium(entity.getStadium());
        teams.setCity(entity.getCity());
        teams.setRegion(entity.getRegion());
        teams.setState(entity.getState());
        teams = repository.save(teams);

        return new TeamsDto(teams);
    }

    public void deleteTeam(Long id) {
        boolean existsTeam = repository.existsById(id);
        if (!existsTeam) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
        repository.deleteById(id);
    }
}

