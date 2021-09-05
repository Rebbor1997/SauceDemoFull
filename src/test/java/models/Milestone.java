package models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Milestone {
    private int id;
    private String name;
    private int due_on;
}
