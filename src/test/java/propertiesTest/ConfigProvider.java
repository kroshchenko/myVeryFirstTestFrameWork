package propertiesTest;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    private static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = config.getString("url");
    Integer AGE = config.getInt("age");
    String ADMIN_LOGIN = config.getString("usersParams.admin.login");
    String ADMIN_PASSWORD = config.getString("usersParams.admin.password");
    Boolean IS_DEMO_ADMIN = config.getBoolean("usersParams.demo.isAdmin");
}
