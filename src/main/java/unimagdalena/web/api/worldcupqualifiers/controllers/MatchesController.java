package unimagdalena.web.api.worldcupqualifiers.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
