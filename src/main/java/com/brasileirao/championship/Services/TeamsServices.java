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
        Teams teams = obj.orElseThrow(() -> new ResourceNotFoundException("Team not found !"));
        return new TeamsDto(teams);
    }

    @Transactional(readOnly = true)
    public TeamsDto findAllByTeam(String team) {
        Optional<Teams> obj = repository.findAllByTeam(team);
        Teams teamObj = obj.orElseThrow(() -> new ResourceNotFoundException("Team not found!"));
        return new TeamsDto(teamObj);
    }

    @Transactional
    public TeamsDto updateTeams(Long id, TeamsDto teams) {
        try {
            Teams entity = repository.getReferenceById(id);
            entity.setTeam(teams.getTeam());
            entity.setCity(teams.getCity());
            entity.setFullName(teams.getFullName());
            entity.setAcronym(teams.getAcronym());
            entity.setRegion(teams.getRegion());
            entity.setState(teams.getState());
            entity.setStadium(teams.getStadium());
            entity = repository.save(entity);
            return new TeamsDto(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
