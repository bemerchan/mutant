package co.com.dna.service.impl;

import co.com.dna.domains.DnaEntity;
import co.com.dna.domains.MutantIdentifier;
import co.com.dna.domains.dto.DnaRequest;
import co.com.dna.domains.dto.StatisticsResponse;
import co.com.dna.exception.DnaException;
import co.com.dna.repository.DnaRepository;
import co.com.dna.service.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DnaServiceImpl implements DnaService {

    @Autowired
    private DnaRepository dnaRepository;

    @Override
    public String isMutant(DnaRequest dto) throws DnaException {
        boolean isMutant = MutantIdentifier.isMutant(dto.getDna());
        String dna = serialize(dto.getDna());
        if(isMutant) {
            saveDna(dna, true);
            return "is mutant";
        } else {
            saveDna(dna, false);
            throw new DnaException("he is not a mutant");
        }
    }

    @Override
    public StatisticsResponse stats() {
        StatisticsResponse response = new StatisticsResponse();
        response.setCountHumanDna(dnaRepository.countMutant(false));
        response.setCountMutantDna(dnaRepository.countMutant(true));
        response.setRatio(((double) response.getCountMutantDna()) / ((double) response.getCountHumanDna()));
        return response;
    }

    private void saveDna(String dna, boolean mutant) {
        List<DnaEntity> listDna = dnaRepository.findByDna(dna);
        if(listDna.isEmpty()) {
            DnaEntity dnaEntity = new DnaEntity();
            dnaEntity.setDna(dna);
            dnaEntity.setMutant(mutant);
            dnaRepository.save(dnaEntity);
        }
    }

    private String serialize(String[] dna){
        StringBuilder response = new StringBuilder();
        Arrays.stream(dna).forEach(value -> response.append(value));
        return response.toString();
    }
}
