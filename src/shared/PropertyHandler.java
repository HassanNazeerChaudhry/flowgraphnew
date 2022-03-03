package shared;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class PropertyHandler {

    private final String DEFAULT_PROP_LOCATION1 = "config.properties";
    private final String DEFAULT_PROP_LOCATION2 = "src/shared/resources/config.properties";
    static private PropertyHandler propertyHandler;
    static public AtomicInteger processes = new AtomicInteger(0);
    private Properties prop;



    public static String getProperty(String name) throws IOException {

        synchronized (processes) {
            if (propertyHandler == null) {
                propertyHandler = new PropertyHandler();
            }
        }
        return propertyHandler.prop.getProperty(name);

    }

    private PropertyHandler() throws IOException {

        prop = new Properties();
        InputStream inputStream = null;

        try{
            inputStream = new FileInputStream(Utils.getJarFolder()+DEFAULT_PROP_LOCATION1);
        } catch (FileNotFoundException ignored) {
        }


        if (inputStream == null) {

            System.out.println("config.properties not found on: " + DEFAULT_PROP_LOCATION1);

            inputStream = new FileInputStream(DEFAULT_PROP_LOCATION2);

            if (inputStream == null) {
                throw new IOException("config.properties not found on " + Utils.getJarFolder()+DEFAULT_PROP_LOCATION1 + " an not found on " + DEFAULT_PROP_LOCATION2);
            }
        }

        prop.load(inputStream);
        inputStream.close();


    }




}
