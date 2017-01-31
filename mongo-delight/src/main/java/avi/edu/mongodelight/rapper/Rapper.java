package avi.edu.mongodelight.rapper;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Rapper {
    @Id
    private String id;
    private String name;

    public Rapper(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Rapper[id=%s, name=%s]",
                id, name);
    }
}
