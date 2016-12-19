package avi.edu.rappersdelight.rest;

import avi.edu.rappersdelight.repository.RapperRepository;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RapperControllerTest {
    private RapperRepository rapperRepository = mock(RapperRepository.class);
    private RapperController rapperController = new RapperController(rapperRepository);

    @Test
    public void should_invoke_repository_on_getAllRappers() {
        // when
        rapperController.getAllRappers();

        // then
        verify(rapperRepository, times(1)).getAllRappers();
    }

    @Test
    public void should_invoke_repository_on_getRapperById() {
        // when
        rapperController.getRapperById("1");

        // then
        verify(rapperRepository, times(1)).getRapperById("1");
    }
}
