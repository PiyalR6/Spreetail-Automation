package coreClasses;

import java.io.IOException;
import java.util.Properties;

public class spreetailProperties extends Properties{

private static  spreetailProperties props = null;

private  spreetailProperties() throws IOException
{
    load(getClass().getResourceAsStream("/spreetail.properties"));
}

public static synchronized  spreetailProperties getInstance() throws IOException
{
    if (props == null)
    {
        props = new  spreetailProperties();
    }
    return props;
}
}