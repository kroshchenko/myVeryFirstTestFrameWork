package propertiesTest;

import org.junit.Test;
import selenideTest.BaseSelenideTest;

import java.io.IOException;

public class PropertiesTest extends BaseSelenideTest {

    /**
     * Чтение конфигов из application.properties
     * @throws IOException
     */
    @Test
    public void readProperties() throws IOException {
        System.getProperties()
                .load(ClassLoader.getSystemResourceAsStream("application.properties"));

        String urlFromProps = System.getProperty("url");
        System.out.println(urlFromProps);
    }


    /**
     * Чтение конфигов из application.conf
     * @throws IOException
     */
    @Test
    public void readPropertiesFromConf() throws IOException {
        String urlFromProps = ConfigProvider.URL;
        System.out.println(urlFromProps);

        if (ConfigProvider.config.getBoolean("usersParams.admin.isAdmin")) {
            System.out.println("Admin is admin");
        } else {
            System.out.println("Admin is not admin");
        }

        System.out.println(ConfigProvider.AGE);
        System.out.println(ConfigProvider.IS_DEMO_ADMIN);
    }
}
