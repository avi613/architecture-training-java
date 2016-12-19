package avi.edu.rappersdelight.repository;

import avi.edu.rappersdelight.rapper.Delight;
import avi.edu.rappersdelight.rapper.Rapper;
import com.google.common.collect.ImmutableList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class RapperRepositoryTest {
    private RapperRepository rapperRepository = new RapperRepository();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_return_rapper_by_id() {
        Rapper redMan = new Rapper("1", "Red Man", ImmutableList.of(
                new Delight("Not your mom's food"), new Delight("sugar 'n' cream")));

        assertThat(rapperRepository.getRapperById("1")).isEqualTo(redMan);
    }

    @Test
    public void should_throw_a_rapper_not_found_exception() {
        thrown.expect(RapperNotFoundException.class);
        thrown.expectMessage("Rapper with id: 3 not found");
        rapperRepository.getRapperById("3");
    }
}
