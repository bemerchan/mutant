package co.com.dna.controller;

import co.com.dna.domains.dto.DnaRequest;
import co.com.dna.domains.dto.StatisticsResponse;
import co.com.dna.exception.DnaException;
import co.com.dna.service.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @PostMapping("/mutant")
    public ResponseEntity<String> mutant(@RequestBody final DnaRequest dto) {
        try {
            return new ResponseEntity<>(dnaService.isMutant(dto), HttpStatus.OK);
        } catch (DnaException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage(), e);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<StatisticsResponse> stats () {
        return new ResponseEntity<>(dnaService.stats(), HttpStatus.OK);
    }
}
