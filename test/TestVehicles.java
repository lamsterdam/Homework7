import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Auto;
import registration.Boat;
import registration.Motorcycle;

/**
 * A Junit test class for the Vehicles.
 */
public class TestVehicles {
  private Boat myBoat;
  private Auto myAuto;
  private Motorcycle myMotorcycle;
  private Motorcycle myMotorcycle2;


  /**
   * Method to set up new objects to test.
   */
  @Before
  public void setUp() {
    myBoat = new Boat("Boat","Filippi", 2020, 900.00);
    myAuto = new Auto("Auto", "Honda", 2012, 500.00);
    myMotorcycle = new Motorcycle("Motorcycle", "Harley", 2005,
            600.00);
    myMotorcycle2 = new Motorcycle("Motorcycle", "Harley", 2015,
            600.00 );
  }

  /**
   * Method to test getMake method.
   */
  @Test
  public void testgetMake() {
    assertEquals("Filippi", myBoat.getMake());
    assertEquals("Harley", myMotorcycle.getMake());
  }

  /**
   * Method to test getProductionYear method.
   */
  @Test
  public void testgetProductionYear() {
    assertEquals(2020, myBoat.getProductionYear());
    assertEquals(2012, myAuto.getProductionYear());
  }

  /**
   * Method to test getPurchasePrice method.
   */
  @Test
  public void testgetPurchasePrice() {
    assertEquals(900.00, myBoat.getPurchasePrice(), 0.01);
    assertEquals(600.00, myMotorcycle.getPurchasePrice(), 0.01);
  }

  /**
   * Method to test getMaxPassengers.
   */
  @Test
  public void testgetMaxPassengers() {
    assertEquals(5, myAuto.getMaxPassengers());
    assertEquals(10, myBoat.getMaxPassengers());
    assertEquals(2, myMotorcycle.getMaxPassengers());
  }

  /**
   * Method to test equals method.
   */
  @Test
  public void testequals() {
    assertNotEquals(myAuto, myMotorcycle);
    assertEquals(myBoat, myBoat);
    assertNotEquals(myMotorcycle, myMotorcycle2);
  }

}
