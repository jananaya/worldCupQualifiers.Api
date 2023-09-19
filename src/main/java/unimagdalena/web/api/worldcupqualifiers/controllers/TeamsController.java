package unimagdalena.web.api.worldcupqualifiers.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.CreateTeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.TeamDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.UpdateTeamDto;
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
}
