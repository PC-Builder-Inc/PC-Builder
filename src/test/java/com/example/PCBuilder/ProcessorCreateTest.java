package com.example.PCBuilder;

import com.example.PCBuilder.model.dto.ProcessorDto;
import com.example.PCBuilder.model.dto.filter.ProcessorFilter;
import com.example.PCBuilder.model.entity.Processor;
import com.example.PCBuilder.repository.ProcessorRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Processor api tests")
@SpringBootTest(classes = TestConfig.class)
public class ProcessorCreateTest {

    @Autowired
    private ProcessorRepository processorRepository;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Value("classpath:processor/request/valid-processor-dto.json")
    Resource validProcessorResource;
    @Value("classpath:processor/expected/create-processor.json")
    Resource expectedProcessorResource;

    private final String BASE_PATH = "http://localhost:8080/api/processor";

    @Test
    @SneakyThrows
    void shouldCreateProcessorSuccessfully() {
        // Given
        ProcessorDto dto = mapper.readValue(ResourceReader.asString(validProcessorResource), new TypeReference<>() {});
        // When
        String responseId = testRestTemplate.postForObject(BASE_PATH, dto, String.class);
        // Then
        Processor actual = processorRepository.findById(responseId).orElse(null);
        Processor expected = mapper.readValue(
                ResourceReader.asString(expectedProcessorResource),
                new TypeReference<>() {}
        );
        assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }
}
