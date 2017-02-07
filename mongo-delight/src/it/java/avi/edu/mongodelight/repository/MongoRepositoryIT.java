package avi.edu.mongodelight.repository;

import avi.edu.mongodelight.rapper.Delight;
import avi.edu.mongodelight.rapper.Rapper;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableList.of;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class MongoRepositoryIT {
    @Autowired
    private RapperRepository repository;
    private Map<String, Rapper> mockedRappers;

    @Before
    public void setUp() {
        setUpMockedRappers();
        setUpMongo();
    }

    @Test
    public void should_find_rapper_by_name() {
        assertThat(repository.findByName("Red Man"))
                .isEqualToIgnoringGivenFields(mockedRappers.get("Red Man"), "id");
    }

    @Test
    public void should_find_all_rappers() {
        List<Rapper> rappers = of(mockedRappers.get("Red Man"), mockedRappers.get("Method Man"));

        rappers.forEach(rapper ->
                assertThat(repository.findAll()).usingElementComparatorIgnoringFields("id").contains(rapper));
    }

    private void setUpMongo() {
        repository.deleteAll();

        repository.save(mockedRappers.get("Red Man"));
        repository.save(mockedRappers.get("Method Man"));
    }

    private void setUpMockedRappers() {
        Rapper redMan = new Rapper("Red Man", of(new Delight("Not your mom\'s food")));
        Rapper methodMan = new Rapper("Method Man", of(new Delight("Whatever man"), new Delight("Fresh doughnuts")));
        mockedRappers = ImmutableMap.of(
                "Red Man", redMan,
                "Method Man", methodMan
        );
    }
}
