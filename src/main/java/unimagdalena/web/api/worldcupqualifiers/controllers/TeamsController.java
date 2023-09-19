package unimagdalena.web.api.worldcupqualifiers.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.*;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.services.interfaces.TeamsService;

@RestController
@RequestMapping("/api/equipos")
public class TeamsController {
    private final TeamsService teamsService;

    public TeamsController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TeamDto>> getAll() {
        List<TeamDto> teams = teamsService.getAll();
        return ResponseEntity.ok().body(teams);
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> findByName(@RequestParam("nombre") String name) {
        List<TeamDto> teams = teamsService.findByName(name);
        return ResponseEntity.ok().body(teams);
    }

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody CreateTeamDto createTeamDto) {
        TeamDto team = teamsService.createTeam(createTeamDto);

        String location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(team.getId())
            .toUriString();

        return ResponseEntity.created(URI.create(location)).body(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id, @RequestBody UpdateTeamDto updateTeamDto) {
        TeamDto team = teamsService.updateTeam(id, updateTeamDto);
        return ResponseEntity.ok().body(team);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamEntity(@PathVariable Long id) {
        teamsService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
