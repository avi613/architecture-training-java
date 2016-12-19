package avi.edu.rappersdelight.rapper;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Value;

import java.util.List;

@Value
public class Rapper {
    @JsonView(RapperPreview.class)
    private String id;
    @JsonView(RapperPreview.class)
    private String name;
    private List<Delight> delights;
}
