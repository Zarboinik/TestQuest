package dto;

import lombok.Data;

@Data
public class CsvSuggestionDto {
    private long id;
    private String type;
    private String manufacturer;
    private int numberOfItems;
}
