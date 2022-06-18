package utils;

import java.util.logging.Logger;

public class Log {

    private static Logger log = Logger.getLogger(Log.class.getName());
    public static void info(String message) {

        log.info(message);

    }

    public static void warn(String message) {

        log.warning(message);

    }

}
