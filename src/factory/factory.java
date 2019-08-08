package factory;

import java.util.ResourceBundle;

public class factory {
    private static ResourceBundle bundle;

    static {
        bundle = ResourceBundle.getBundle("instance");
    }

    public static <T> T getInstance(String key, Class<T> classType) {
        String className = bundle.getString(key);
        try {
            return (T) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
