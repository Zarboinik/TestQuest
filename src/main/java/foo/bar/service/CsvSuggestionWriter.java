package foo.bar.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import foo.bar.dto.CsvSuggestionDto;
import lombok.Cleanup;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@Component
public class CsvSuggestionWriter {
    private CsvMapper csvMapper = new CsvMapper();
    private CsvSchema schema = csvMapper
            .schemaFor(CsvSuggestionDto.class)
            .withHeader()
            .sortedBy("id", "type", "manufacturer", "numberOfItems");

    public void write(@NonNull String fileName, @NonNull List<CsvSuggestionDto> data){
        try {
            @Cleanup Writer writer = new PrintWriter(new FileWriter(fileName));
            doWritte(writer, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doWritte(@NonNull Writer writer, @NonNull List<CsvSuggestionDto> data) throws IOException {
        csvMapper.writer().with(schema).writeValues(writer).writeAll(data);
    }
}
