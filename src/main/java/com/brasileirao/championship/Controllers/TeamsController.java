package com.brasileirao.championship.Controllers;

import com.brasileirao.championship.Entities.Teams;
import com.brasileirao.championship.Services.TeamsServices;
import com.brasileirao.championship.dto.TeamsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/teams")
public class TeamsController {

    @Autowired
    private TeamsServices services;

    @GetMapping
    public ResponseEntity<List<TeamsDto>> findAll() {
        List<Teams> teams = services.findAll();
        List<TeamsDto> dto = teams.stream().map(TeamsDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeamsDto> findTeamsById(@PathVariable Long id) {
        TeamsDto dto = services.findTeamById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/team/{team}")
    public ResponseEntity<TeamsDto> findAllByTeams(@PathVariable String team) {
        TeamsDto dto = services.findAllByTeam(Character.toUpperCase(team.charAt(0)) + team.substring(1).toLowerCase());
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<TeamsDto> updateTeams(@PathVariable Long id, @RequestBody TeamsDto teams) {
        TeamsDto dto = services.updateTeams(id, teams);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<TeamsDto> insertTeams(@RequestBody TeamsDto entity) {
        TeamsDto dto = services.insertTeams(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<TeamsDto> deleteTeam(@PathVariable Long id) {
        services.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
