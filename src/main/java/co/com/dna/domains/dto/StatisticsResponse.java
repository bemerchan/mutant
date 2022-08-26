package co.com.dna.domains.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class StatisticsResponse {

    private int countMutantDna;
    private int countHumanDna;
    private double ratio;
}
