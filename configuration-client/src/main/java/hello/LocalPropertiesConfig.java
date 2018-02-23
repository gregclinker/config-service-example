package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

//@Configuration
public class LocalPropertiesConfig {

    @Autowired
    private ConfigurableEnvironment env;

    @Autowired
    public void setConfigurableEnvironment(ConfigurableEnvironment env) {
        try {
            final Resource resource = new ClassPathResource("defaults.properties");
            env.getPropertySources().addFirst(new PropertiesPropertySource(resource.getFilename(), PropertiesLoaderUtils.loadProperties(resource)));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}