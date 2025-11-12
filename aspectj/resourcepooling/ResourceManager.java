import java.util.*;

public class ResourceManager implements ResourcePool {

    private Map<String, Set<Resource>> pool = new HashMap<>();

    @Override
    public Resource getResource(String type) {

        if (!pool.containsKey(type) || pool.get(type).isEmpty()) {
            try {
                return (Resource) Class.forName(type).getConstructor().newInstance();
            } catch (Exception e) {
                System.out.println("ERRORE");
            }
        }

        System.out.println("*** I'm pooling a " + type + " instance");

        Set<Resource> rpool = pool.get(type);
        Resource res = rpool.iterator().next();
        rpool.remove(res);
        return res;
    }

    @Override
    public void releaseResource(String type, Resource r) {
        System.out.println("*** I'm storing a " + r.getClass().getName() + " instance");

        if (!pool.containsKey(type))
            pool.put(type, new HashSet<>());
        pool.get(type).add(r);
    }

}
