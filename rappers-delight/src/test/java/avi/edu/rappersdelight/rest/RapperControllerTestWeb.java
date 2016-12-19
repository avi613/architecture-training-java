package avi.edu.rappersdelight.rest;

import avi.edu.rappersdelight.rapper.Delight;
import avi.edu.rappersdelight.rapper.Rapper;
import avi.edu.rappersdelight.repository.RapperRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RapperControllerTestWeb {
    private RapperRepository rapperRepository = mock(RapperRepository.class);
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new RapperController(rapperRepository)).build();

    private ObjectMapper mapper = new ObjectMapper();
    private Rapper wat = new Rapper("ID", "NAME", ImmutableList.of(new Delight("DELIGHT")));
    private String watJson;

    @Before
    public void setUp() throws JsonProcessingException {
        watJson = mapper.writeValueAsString(wat);
    }

    @Test
    public void should_get_all_rappers() throws Exception {
        when(rapperRepository.getAllRappers()).thenReturn(ImmutableList.of(wat));

        mockMvc.perform(get("/rappers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":\"ID\",\"name\":\"NAME\"}]"));
    }

    @Test
    public void should_get_one_rapper() throws Exception {
        when(rapperRepository.getRapperById(anyString())).thenReturn(wat);

        mockMvc.perform(get("/rappers/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(watJson));
    }
}
