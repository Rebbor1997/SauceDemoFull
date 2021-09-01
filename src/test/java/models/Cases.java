package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cases {
    private int id;
    private int suiteID;
    private String title;
    private int sectionID;
    private String case_ids;

}

