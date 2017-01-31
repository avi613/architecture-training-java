package avi.edu.mongodelight.repository;

import avi.edu.mongodelight.rapper.Rapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class MongoRepositoryIT {
    @Autowired
    private RapperRepository repository;

    @Before
    public void setUp() {
        setUpMongo();
    }

    @Test
    public void should_find_rapper_by_name() {
        assertThat(repository.findByName("Red Man")).isEqualToIgnoringGivenFields(new Rapper("Red Man"), "id");
    }

    @Test
    public void should_find_all_rappers() {
        List<Rapper> rappers = of(new Rapper("Red Man"), new Rapper("Method Man"));

        rappers.forEach(rapper ->
                assertThat(repository.findAll()).usingElementComparatorIgnoringFields("id").contains(rapper));
    }

    private void setUpMongo() {
        repository.deleteAll();

        repository.save(new Rapper("Red Man"));
        repository.save(new Rapper("Method Man"));
    }
}
