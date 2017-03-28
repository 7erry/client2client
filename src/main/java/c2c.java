import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.ConcurrentMap;

public class c2c extends ClassLoader {
    String libPath="/Users/terrywalters/Documents/projects/client2client/lib/";
    String lib36=libPath+"hazelcast-3.6/lib/hazelcast-all-3.6.jar";
    String lib38=libPath+"hazelcast-3.8/lib/hazelcast-all-3.8.jar";

    public static void main(String[] args) {

        c2c clients = new c2c();
        clients.testMaps("my-distributed-map");
    }

    public void testMaps(String mapName){
        try {

            // 36 cluster
            Class client36config = loadClass("com.hazelcast.client.config.ClientConfig",lib36);
            Object client36Config = client36config.newInstance();
            Class client36hazelcast = loadClass("com.hazelcast.client.HazelcastClient",lib36);
            Method H36 = client36hazelcast.getMethod("newHazelcastClient");
            Object h36 = H36.invoke(client36Config);
            Method getMap36 = h36.getClass().getMethod("getMap", String.class);
            ConcurrentMap<String, String> map36 = (ConcurrentMap<String, String>) getMap36.invoke(h36, mapName);

            for (int i = 0; i < 1000; i++) {
                map36.put("Terry"+i,"Dynamic Class Loading Example: "+i);
            }


            // 38 cluster
            Class client38config = loadClass("com.hazelcast.client.config.ClientConfig",lib38);
            Object client38Config = client38config.newInstance();
            Class client38hazelcast = loadClass("com.hazelcast.client.HazelcastClient",lib38);
            Method H38 = client38hazelcast.getMethod("newHazelcastClient");
            Object h38 = H38.invoke(client38Config);
            Method getMap38 = h38.getClass().getMethod("getMap", String.class);
            ConcurrentMap<String, String> map38 = (ConcurrentMap<String, String>) getMap38.invoke(h38, mapName);

            map38.putAll(map36);
            System.out.println(map38.size());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
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