package co.com.dna.controller;

import co.com.dna.domains.dto.DnaRequest;
import co.com.dna.exception.DnaException;
import co.com.dna.service.DnaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DnaController.class)
public class DnaControllerTest extends AbstractController {

    @MockBean
    DnaService dnaService;


    @Test
    void mutantWhenIsMutantTest() throws Exception {

        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaRequest request = new DnaRequest();
        request.setDna(dna);

        givenController().perform(MockMvcRequestBuilders.post("/mutant").contentType(MediaType.APPLICATION_JSON)
                        .content(getObjectMapper().writeValueAsString(request)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void mutantWhenIsNotMutantTest() throws Exception {

        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DnaRequest request = new DnaRequest();
        request.setDna(dna);

        when(dnaService.isMutant(any())).thenThrow(DnaException.class);

        givenController().perform(MockMvcRequestBuilders.post("/mutant").contentType(MediaType.APPLICATION_JSON)
                        .content(getObjectMapper().writeValueAsString(request)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    void statsTest() throws Exception {
        givenController().perform(MockMvcRequestBuilders.get("/stats").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private ObjectMapper getObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }
}
