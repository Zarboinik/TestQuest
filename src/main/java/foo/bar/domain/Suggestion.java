package foo.bar.domain;

import lombok.Data;

@Data
public class Suggestion {
    private long id;
    private String type;
    private String manufacturer;
    private int numberOfItems;

    public Suggestion(long id, String type, String manufacturer, int numberOfItems) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.numberOfItems = numberOfItems;
    }
}
