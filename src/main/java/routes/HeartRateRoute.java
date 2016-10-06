package routes;

import java.util.HashMap;
import java.util.Map;

public class HeartRateRoute {

    private static Map<String, String> routes;

    public static final String base = "/heartRate";
    public static final String withId = base + "/{:id}";

    private static void setRoute() {

        if (routes == null) {
            routes = new HashMap<String, String>();
            routes.put("base", base);
            routes.put("withId", withId);
        }
    }

    public static Map<String, String> getRoutes() {
        setRoute();
        return routes;
    }
    public static String getRoute(String destination) {
        setRoute();
        return routes.get(destination);
    }
}
