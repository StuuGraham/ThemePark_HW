package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10, 8.40);
        visitor = new Visitor(19, 160.0, 100);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canRideRollercoaster_true(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void canRideRollercoaster_falseHeight(){
        visitor.setHeight(140.0);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void canRideRollercoaster_falseAge(){
        visitor.setAge(10);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void rollercoasterHasPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0);
    }

    @Test
    public void rollercoasterDiscriminatesAgainstTallPeople(){
        visitor.setHeight(220.0);
        rollerCoaster.priceFor(visitor);
        assertEquals(16.80, rollerCoaster.defaultPrice(), 0);
    }

    @Test
    public void rollercoasterLikesShortPeople(){
        rollerCoaster.priceFor(visitor);
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0);
    }

}
