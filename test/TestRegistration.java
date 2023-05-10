import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import registration.Auto;
import registration.BlueJurisdiction;
import registration.Boat;
import registration.GreenJurisdiction;
import registration.Person;
import registration.Registration;

/**
 * A Junit test class for the Registration class.
 */
public class TestRegistration {
  private Registration myRegistration;
  private Registration myRegistration2;
  private Registration myRegistration3;
  private Registration myRegistration4;
  private Boat myBoat;
  private Auto myAuto;
  private BlueJurisdiction blueJurisdiction;
  private GreenJurisdiction greenJurisdiction;
  private List<Person> myOwner;
  private Person myPerson;

  /**
   * Method to set up objects to test.
   */
  @Before
  public void setUp() {
    myBoat = new Boat("Boat","Kia", 2020, 150.00);
    myAuto = new Auto("Auto", "Kia", 2012, 600.00);

    blueJurisdiction = new BlueJurisdiction();
    greenJurisdiction = new GreenJurisdiction();

    myPerson = new Person("Leigh-Riane", "Boston");
    myOwner = new ArrayList<>();

    myRegistration = new Registration(myBoat, blueJurisdiction, 2021, myOwner);
    myRegistration2 = new Registration(myBoat, blueJurisdiction, 2021, myOwner);
    myRegistration3 = new Registration(myBoat, blueJurisdiction, 2020, myOwner);
    myRegistration4 = new Registration(myBoat, greenJurisdiction, 2021, myOwner);
  }

  /**
   * Method to test getRegistrationYear method.
   */
  @Test
  public void testRegistrationYear() {
    assertEquals(2021, myRegistration.getRegistrationYear());
  }

  /**
   * Method to test getProductionYear method.
   */
  @Test
  public void testgetProductionYear() {
    assertEquals(2020,myRegistration.getProductionYear());
  }

  /**
   * Method to test getJurisdiction method.
   */
  @Test
  public void testgetJurisdiction() {
    assertEquals("Blue Jurisdiction", myRegistration.getJurisdiction().toString());
    assertEquals("Green Jurisdiction", myRegistration4.getJurisdiction().toString());
  }

  /**
   * Method to test getOwners method.
   */
  @Test
  public void testgetOwners() {
    myOwner.add(myPerson);
    assertEquals(Arrays.asList(myPerson), myRegistration.getOwners());
  }

  /**
   * Method to test getMaxPassengers method.
   */
  @Test
  public void testgetMaxPassengers() {
    assertEquals(10, myRegistration.getMaxPassengers());
  }

  /**
   * Method to test calculateExciseTax method.
   */
  @Test
  public void testcalculateExciseTax() {
    assertEquals(4.5, myRegistration.calculateExciseTax(), 0.01);
  }

  /**
   * Method to test toString method.
   */
  @Test
  public void testtoString() {
    myOwner.add(myPerson);
    assertEquals("Registration:  " + "\n"
            + "BOAT: Kia Year2020 Price = $150.00" + "\n"
            + "Owned By: [Leigh-Riane, Boston]" + "\n"
            + "Year: 2021" + "\n"
            + "Excise Tax: $4.50", myRegistration.toString());
  }

  /**
   * Method to test equals method.
   */
  @Test
  public void testequals() {
    assertEquals(myRegistration, myRegistration2);
    assertNotEquals(myRegistration, myRegistration3);
    assertEquals(myRegistration, myRegistration4);
  }
}
