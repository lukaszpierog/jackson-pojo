import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.*;
import com.fasterxml.jackson.module.paramnames.*;

import static com.fasterxml.jackson.databind.cfg.ConstructorDetector.*;

public final class Example {
    private final String field;
    private final String text;

    public Example(String field, String text) {
        this.field = field;
        this.text = text;
    }

    public String getField() {
        return field;
    }

    public String getText() {
        return text;
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new ParameterNamesModule())
                .constructorDetector(USE_PROPERTIES_BASED)
                .build();

        Example obj = mapper.readValue("{\n" +
                "  \"field\": \"email\",\n" +
                "  \"text\": \"some text\"\n" +
                "}", Example.class);

        System.out.println(obj);
    }
}
