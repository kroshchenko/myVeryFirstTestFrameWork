package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public abstract class WebUtils {

    public static int getRandomInt() {
        return new Random().nextInt(1000);
    }

    public static String getDate() {
        return new SimpleDateFormat("HHmmss").format(new Date());
    }
}
