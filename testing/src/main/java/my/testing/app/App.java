package my.testing.app;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LogManager.getLogger();
    public static void main( String[] args )
    {
        try {
            logger.info("App started");
        } catch (RuntimeException err) {
            logger.error(err.toString());
        } finally {
            logger.info("App terminated");
        }
    }
}
