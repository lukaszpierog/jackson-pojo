import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.*;
import com.fasterxml.jackson.module.paramnames.*;
import org.junit.*;

import static com.fasterxml.jackson.databind.cfg.ConstructorDetector.*;

public class ExampleTest {

    @Test
    public void example() throws Exception {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new ParameterNamesModule())
                .constructorDetector(USE_PROPERTIES_BASED)
                .build();

        Example obj = mapper.readValue("{\n" +
                "  \"field\": \"email\",\n" +
                "  \"text\": \"some text\"\n" +
                "}", Example.class);

        Assert.assertEquals("email", obj.getField());
        Assert.assertEquals("some text", obj.getText());
    }
}