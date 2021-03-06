package foo.bar.service;

import foo.bar.domain.Suggestion;
import foo.bar.dto.CsvSuggestionDto;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CsvSuggestionConverter {
    public CsvSuggestionDto toCsvSuggestionDto(@NonNull Suggestion input) {
        CsvSuggestionDto dto = new CsvSuggestionDto();
        dto.setId(input.getId());
        dto.setType(input.getType());
        dto.setManufacturer(input.getManufacturer());
        dto.setNumberOfItems(input.getNumberOfItems());

        return dto;
    }
}
