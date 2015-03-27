package DomaineRoute;

import static org.junit.Assert.*;

/**
 * Created by 21406213 on 27/03/2015.
 */
public class TestRoute {


    public void TestCreationRoute() {
        Route route = new Route(100, 700, 10, 500);

        assertEquals(100, route.getOrigineX());
        assertEquals(700, route.getOrigineY());
        assertEquals(10, route.getLargeur());
        assertEquals(500, route.getLongueur());
    }
}
