import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Subject("the value from path #pathOnConfigFile of config yml file #configFileName")
public class TheValueFromPropConfig implements Question<String> {

    Yaml yaml = new Yaml();
    Map<String, Object> ymlConfig = null;

    private String pathOnConfigFile;
    private String configFileName;

    public TheValueFromPropConfig(String configFileName, String pathOnConfigFile) {
        this.configFileName = configFileName;
        this.pathOnConfigFile = pathOnConfigFile;
    }

    public static TheValueFromPropConfig andGet(String pathOnConfigFile) {
        return new TheValueFromPropConfig("application", pathOnConfigFile);
    }


    public static TheValueFromPropertyConfigBuilder ofFileNamed(String configFileName) {
        return new TheValueFromPropertyConfigBuilder(configFileName);
    }

    /**
     * Gets the value of property on file application.yml
     *
     * @param propertyName
     * @return
     */
    private String read(String propertyName) {
        List<String> configPath = Arrays.asList(propertyName.split("\\."));
        Object config = ymlConfig.get(configPath.get(0));
        for (int i = 1; i < configPath.size(); i++) {
            config = ((Map<String, Object>) config).get(configPath.get(i));
        }
        if (Objects.isNull(config)) config = "";
        return String.valueOf(config);
    }


    @Override
    public String answeredBy(Actor actor) {
        String applicationYamlFileName = configFileName + ".yml";
        try {
            ymlConfig = yaml.load(new FileInputStream(new File(
                    "./src/test/resources/" + applicationYamlFileName)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return read(pathOnConfigFile);

    }

    public static class TheValueFromPropertyConfigBuilder {

        private String configFileName;

        public TheValueFromPropertyConfigBuilder(String configFileName) {
            this.configFileName = configFileName;
        }

        public TheValueFromPropConfig andGetValueFromConfig(String pathOnConfigFile) {
            return new TheValueFromPropConfig(configFileName, pathOnConfigFile);
        }

    }

}