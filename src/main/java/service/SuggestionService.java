package service;

import domain.Suggestion;
import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class SuggestionService {
    private List<Suggestion> shop = Arrays.asList(
            new Suggestion(123, "Laptop", "China", 28),
            new Suggestion(312, "HD", "Russia", 3),
            new Suggestion(222, "Monitor", "USA",1),
            new Suggestion(3222, "Monitor", "China",3),
            new Suggestion(456, "Monitor", "Japan",6)
    );

    public List<Suggestion> findSuggestionsByType(@NonNull String type){
        return shop.stream().filter(t -> t.getType().equals(type)).collect(Collectors.toList());
    }
}
