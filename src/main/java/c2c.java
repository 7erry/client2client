import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.ConcurrentMap;

public class c2c extends ClassLoader {
    String libPath="/Users/twal7ers/Documents/projects/client2client/lib/";
    String libold=libPath+"hazelcast-all-3.12.5.jar";
    String libnew=libPath+"hazelcast-all-4.0-BETA-2.jar";

    public static void main(String[] args) {

        c2c clients = new c2c();
        clients.testMaps("my-distributed-map");
    }

    public void testMaps(String mapName){
        try {

            // old cluster
            Class clientoldconfig = loadClass("com.hazelcast.client.config.ClientConfig",libold);
            Object clientoldConfig = clientoldconfig.newInstance();
            Class clientoldhazelcast = loadClass("com.hazelcast.client.HazelcastClient",libold);
            Method Hold = clientoldhazelcast.getMethod("newHazelcastClient");
            Object hold = Hold.invoke(clientoldConfig);
            Method getMapold = hold.getClass().getMethod("getMap", String.class);
            ConcurrentMap<String, String> mapold = (ConcurrentMap<String, String>) getMapold.invoke(hold, mapName);

            for (int i = 0; i < 10000; i++) {
                mapold.put("Terry"+i,"Dynamic Class Loading Example: "+i);
            }


            // new cluster
            Class clientnewconfig = loadClass("com.hazelcast.client.config.ClientConfig",libnew);
            Object clientnewConfig = clientoldconfig.newInstance();
            Class clientnewhazelcast = loadClass("com.hazelcast.client.HazelcastClient",libnew);
            Method Hnew = clientnewhazelcast.getMethod("newHazelcastClient");
            Object hnew = Hnew.invoke(clientnewConfig);
            Method getMapnew = hnew.getClass().getMethod("getMap", String.class);
            ConcurrentMap<String, String> mapnew = (ConcurrentMap<String, String>) getMapnew.invoke(hnew, mapName);

            mapnew.putAll(mapold);
            System.out.println(mapnew.size());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Class loadClass(String name, String jarPath) throws ClassNotFoundException, MalformedURLException{
        try {

            URLClassLoader child = new URLClassLoader (new URL[] {new File(jarPath).toURI().toURL()}, this.getClass().getClassLoader());
            return Class.forName (name, true, child);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}