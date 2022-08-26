package co.com.dna.service;

import co.com.dna.domains.dto.DnaRequest;
import co.com.dna.exception.DnaException;
import co.com.dna.repository.DnaRepository;
import co.com.dna.service.impl.DnaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DnaServiceTest {

    @InjectMocks
    DnaServiceImpl dnaService;

    @Mock
    DnaRepository dnaRepository;


    @Test
    void isMutantTest() throws DnaException {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaRequest request = new DnaRequest();
        request.setDna(dna);

        when(dnaRepository.findByDna(any())).thenReturn(Collections.emptyList());

        assertEquals("is mutant" , dnaService.isMutant(request));
    }

    @Test
    void dnaInvalidTest() {
        String[] dna = {"HTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaRequest request = new DnaRequest();
        request.setDna(dna);
        DnaException exception = Assertions.assertThrows(DnaException.class, () -> {
            dnaService.isMutant(request);
        });
        Assertions.assertEquals("'H' must be a DNA nitrogenous base", exception.getMessage());
    }

    @Test
    void matrixInvalidTest() {
        String[] dna = {"HTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG","TCACTG"};
        DnaRequest request = new DnaRequest();
        request.setDna(dna);
        DnaException exception = Assertions.assertThrows(DnaException.class, () -> {
            dnaService.isMutant(request);
        });
        Assertions.assertEquals("DNA must be a square matrix", exception.getMessage());
    }

    @Test
    void isNotMutant() {
        String[] dna = {"CTGCAA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaRequest request = new DnaRequest();
        request.setDna(dna);
        DnaException exception = Assertions.assertThrows(DnaException.class, () -> {
            dnaService.isMutant(request);
        });
        Assertions.assertEquals("he is not a mutant", exception.getMessage());
    }

    @Test
    void statsTest() throws DnaException {
        when(dnaRepository.countMutant(true)).thenReturn(10);
        when(dnaRepository.countMutant(false)).thenReturn(10);
        assertEquals(1 , dnaService.stats().getRatio());
    }
}
