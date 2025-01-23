package com.brasileirao.championship.Controllers;

import com.brasileirao.championship.Entities.Teams;
import com.brasileirao.championship.Services.TeamsServices;
import com.brasileirao.championship.dto.TeamsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
