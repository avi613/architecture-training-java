package avi.edu.mongodelight.rapper;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Rapper {
    @Id
    private String id;
    private String name;
    private List<Delight> delights;

    public Rapper(String name, List<Delight> delights) {
        this.name = name;
        this.delights = delights;
    }
}
