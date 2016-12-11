package io.falcon.pipeline.dao;

import io.falcon.pipeline.domain.Request;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestRepositoryTest {

    @Autowired
    private RequestRepository requestRepository;

    @Before
    public void setUp() throws Exception {
        requestRepository.deleteAll();
    }

    @Test
    public void shouldSaveRequest() throws Exception {
        String json = "{\"message\" : \"Hello world!\"}";

        Request request = new Request(json);
        requestRepository.save(request);

        List<Request> saved = requestRepository.findAll();
        assertThat(saved.get(0).getContent()).isEqualTo(json);
    }
}
