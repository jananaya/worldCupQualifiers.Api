package unimagdalena.web.api.worldcupqualifiers.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.TeamDto;
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
}
