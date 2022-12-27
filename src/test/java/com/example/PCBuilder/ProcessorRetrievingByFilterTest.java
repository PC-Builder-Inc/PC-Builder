package com.example.PCBuilder;


import com.example.PCBuilder.repository.ProcessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;

@DisplayName("Processor retrieving by filter tests")
@AutoConfigureMockMvc
class ProcessorRetrievingByFilterTest {

    @Autowired
    private ProcessorRepository processorRepository;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;

    @Value("classpath:processor/request/valid-processor-dto.json")
    Resource validProcessorResource;
    @Value("classpath:processor/expected/create-processor.json")
    Resource expectedProcessorResource;

    private final String BASE_PATH = "http://localhost:8080/api/processor";

    @Test
    @DisplayName("POST - 200 - Should get processors by filter successfully")
    @SneakyThrows
    void shouldGetProcessorsByFilterSuccessfully() {
        // Given
//        ProcessorDto dto = mapper.readValue(ResourceReader.asString(validProcessorResource), new TypeReference<>() {});
//        // When
//        String responseId = testRestTemplate.postForObject(BASE_PATH, dto, String.class);
//        testRestTemplate.
//        // Then
//        Processor actual = processorRepository.findById(responseId).orElse(null);
//        Processor expected = mapper.readValue(
//                ResourceReader.asString(expectedProcessorResource),
//                new TypeReference<>() {}
//        );
//        assertNotNull(actual);
//        Assertions.assertEquals(expected, actual);

    }

}
