package unimagdalena.web.api.worldcupqualifiers.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
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
    public ResponseEntity<List<MatchDto>> findMatches(@ModelAttribute @Valid FindMatchesDto queryDto) {
        return ResponseEntity.ok().body(matchesService.findMatches(queryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> findMatchById(@PathVariable Long id) {
        Optional<MatchDto> match = matchesService.findMatchById(id);

        if (match.isPresent()) {
            return ResponseEntity.ok().body(match.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MatchDto> createMatch(@RequestBody @Valid CreateMatchDto createMatchDto) {
        MatchDto match = matchesService.createMatch(createMatchDto);

        String location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(match.getId())
            .toUriString();

        return ResponseEntity.created(URI.create(location)).body(match);
    }
}
