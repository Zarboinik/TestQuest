import com.google.common.collect.ImmutableList;
import service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import service.CsvSuggestionConverter;
import service.CsvSuggestionWriter;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;


@SpringBootApplication
@ComponentScan(value = "service")
public class Application implements CommandLineRunner {
    @Autowired
    private CsvSuggestionWriter csvSuggestionWriter;
    @Autowired
    private SuggestionService suggestionService;
    @Autowired
    private CsvSuggestionConverter csvSuggestionConverter;

    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class)
                .bannerMode(Banner.Mode.LOG)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        String type = args[0].trim();
        String fileName = type + ".csv";

        csvSuggestionWriter.write(fileName, suggestionService.findSuggestionsByType(type).stream()
                .map(csvSuggestionConverter::toCsvSuggestionDto)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf)));
    }
}
