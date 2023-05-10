import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Auto;
import registration.BlueJurisdiction;
import registration.Boat;
import registration.GreenJurisdiction;
import registration.Motorcycle;
import registration.RedJurisdiction;

/**
 * A Junit test class for the Blue Jurisdiction class.
 */
public class TestJurisdiction {
  private BlueJurisdiction myJurisdiction;
  private GreenJurisdiction myGreenJurisdiction;
  private RedJurisdiction myRedJurisdiction;
  private Boat myBoat;
  private Auto myAuto;
  private Motorcycle myMotorcycle;

  /**
   * Method to set up objects to test.
   */
  @Before
  public void setUp() {
    myJurisdiction = new BlueJurisdiction();
    myGreenJurisdiction = new GreenJurisdiction();
    myRedJurisdiction = new RedJurisdiction();

    myBoat = new Boat("Boat","Kia", 2020, 150.00);
    myAuto = new Auto("Auto", "Kia", 2012, 600.00);
    myMotorcycle = new Motorcycle("Motorcycle", "Harley", 2022,
            200.00);
  }

  /**
   * Method to test exciseTax method.
   */
  @Test
  public void testexciseTax() {
    assertEquals(4.5, myJurisdiction.exciseTax(myBoat), 0.01);
    assertEquals(524.0, myGreenJurisdiction.exciseTax(myAuto), 0.01);
    assertEquals(10.0, myRedJurisdiction.exciseTax(myMotorcycle), 0.01);
  }

  /**
   * Method to test toString method.
   */
  @Test
  public void testtoString() {
    assertEquals("Blue Jurisdiction", myJurisdiction.toString());
    assertNotEquals("Red Jurisdiction", myGreenJurisdiction.toString());
  }
}
