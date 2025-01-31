package com.brasileirao.championship.Controllers;

import com.brasileirao.championship.Entities.Brasileirao;
import com.brasileirao.championship.Services.BrasileiraoService;
import com.brasileirao.championship.dto.BrasileiraoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/brasileirao")
public class BrasileiraoController {

    @Autowired
    private BrasileiraoService service;

    @GetMapping
    public ResponseEntity<List<BrasileiraoDto>> findBrasileiraoAll() {
        List<Brasileirao> entity = service.findAll();
        List<BrasileiraoDto> dto = entity.stream().map(BrasileiraoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BrasileiraoDto> findById(@PathVariable Long id) {
        BrasileiraoDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/team/{team}")
    public ResponseEntity<List<BrasileiraoDto>> findAllByTeam(@PathVariable String team) {
        List<BrasileiraoDto> dto = service.findAllByTeam(Character.toUpperCase(team.charAt(0)) + team.substring(1).toLowerCase());
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<BrasileiraoDto> updateBrasileirao(@PathVariable Long id, @RequestBody BrasileiraoDto body) {
        BrasileiraoDto obj = service.updateBrasileirao(id, body);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<BrasileiraoDto> insertBrasileirao(@RequestBody BrasileiraoDto body) {
        BrasileiraoDto obj = service.insertBrasileirao(body);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BrasileiraoDto> deleteBrasileirao(@PathVariable Long id) {
        service.deleteBrasileirao(id);
        return ResponseEntity.noContent().build();
    }
}
