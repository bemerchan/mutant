package co.com.dna.service;

import co.com.dna.domains.dto.DnaRequest;
import co.com.dna.domains.dto.StatisticsResponse;
import co.com.dna.exception.DnaException;

public interface DnaService {
    
    String isMutant(DnaRequest dto) throws DnaException;
    StatisticsResponse stats();
}
