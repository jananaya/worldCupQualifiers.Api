package unimagdalena.web.api.worldcupqualifiers.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.CreateMatchDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.FindMatchesDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.dtos.MatchDto;
import unimagdalena.web.api.worldcupqualifiers.infrastructure.services.interfaces.MatchesService;

@RestController
@RequestMapping("/api/partidos")
public class MatchesController {
    private final MatchesService matchesService;

    public MatchesController(MatchesService matchesService) {
        this.matchesService = matchesService;
    }

    @GetMapping
    public ResponseEntity<List<MatchDto>> findMatches(@ModelAttribute FindMatchesDto queryDto) {
        return ResponseEntity.ok().body(matchesService.findMatches(queryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> findMatchById(@PathVariable Long id) {
        MatchDto match = matchesService.findMatchById(id);

        return match == null?
            ResponseEntity.notFound().build() :
            ResponseEntity.ok().body(match);
    }

    @PostMapping
    public ResponseEntity<MatchDto> createMatch(@RequestBody CreateMatchDto createMatchDto) {
        MatchDto match = matchesService.createMatch(createMatchDto);

        String location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(match.getId())
            .toUriString();

        return ResponseEntity.created(URI.create(location)).body(match);
    }
}
