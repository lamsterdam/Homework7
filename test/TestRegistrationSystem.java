import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import registration.Auto;
import registration.BlueJurisdiction;
import registration.Boat;
import registration.GreenJurisdiction;
import registration.Motorcycle;
import registration.Person;
import registration.RedJurisdiction;
import registration.Registration;
import registration.RegistrationSystem;

/**
 * A junit test class for the Registration System class.
 */
public class TestRegistrationSystem {
  private RegistrationSystem myRegistrationSystem;
  private Registration myRegistration;
  private Registration myRegistration2;
  private Registration myRegistration3;
  private Registration myRegistration4;
  private Registration myRegistration5;
  private Boat myBoat;
  private Auto myAuto;
  private Motorcycle myMotorcycle;
  private BlueJurisdiction blueJurisdiction;
  private RedJurisdiction redJurisdiction;
  private GreenJurisdiction greenJurisdiction;
  private List<Person> myOwner;
  private List<Person> myOwner2;
  private List<Person> myOwner3;
  private Person myPerson;
  private Person myPerson2;
  private Person myPerson3;


  /**
   * Method to set up objects to test.
   */
  @Before
  public void setUp() {
    myBoat = new Boat("Boat","Filippi", 2020, 150.00);
    myAuto = new Auto("Auto", "Toyota", 2010, 150.00);
    myMotorcycle = new Motorcycle("Motorcycle", "Harley", 2005,
            600);
    blueJurisdiction = new BlueJurisdiction();
    redJurisdiction = new RedJurisdiction();
    greenJurisdiction = new GreenJurisdiction();

    myPerson = new Person("leigh-Riane", "Boston");
    myPerson2 = new Person("Jane", "New York");
    myPerson3 = new Person("Tim", "California");

    myOwner = new ArrayList<>();
    myOwner2 = new ArrayList<>();
    myOwner3 = new ArrayList<>();

    myRegistration = new Registration(myBoat, blueJurisdiction, 2021, myOwner);
    myRegistration2 = new Registration(myBoat, blueJurisdiction, 2021, myOwner);
    myRegistration3 = new Registration(myAuto, blueJurisdiction, 2010, myOwner2);
    myRegistration4 = new Registration(myAuto, redJurisdiction, 2010, myOwner2);
    myRegistration5 = new Registration(myMotorcycle, greenJurisdiction, 2008, myOwner3);

    myRegistrationSystem = RegistrationSystem.getInstance();
  }

  /**
   * Method test exceptions are thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIsillegal() {
    myRegistrationSystem.createVehicle("", "Kia", 2020, 150.00);
    myRegistrationSystem.createVehicle("Boat", "", 2019, 1000.00);

    myRegistrationSystem.createVehicle("Boat", "Filippi", 1899,
            1000.00);
    myRegistrationSystem.createVehicle("Auto", "Kia", 2025,
            500.00);
    myRegistrationSystem.createVehicle("Motorcycle", "Harley", 2005,
            -500.00);

  }

  /**
   * Method to test createVehicle method.
   */
  @Test
  public void testcreateVehicle() {
    assertEquals("Motorcycle", myRegistrationSystem.createVehicle("Motorcycle",
            "Harley", 2015, 600.00).getKind());
    assertNotEquals("Auto", myRegistrationSystem.createVehicle("Boat","Kia",
            2020, 150.00).getKind());

  }

  /**
   * Method to test register method.
   */
  @Test
  public void testRegister() {
    myRegistrationSystem.register(myBoat, blueJurisdiction, 2021, myOwner);
    assertTrue(myRegistrationSystem.getAllRegistrations().contains(myRegistration));

    myRegistrationSystem.register(myBoat, blueJurisdiction, 2021, myOwner);
    assertEquals(1,myRegistrationSystem.getAllRegistrations().size());

    myRegistrationSystem.register(myAuto, blueJurisdiction, 2010, myOwner2);
    myRegistrationSystem.register(myAuto, redJurisdiction, 2010, myOwner2);
    assertEquals(2, myRegistrationSystem.getAllRegistrations().size());
  }

  /**
   * Method tp test getAllRegistrations method.
   */
  @Test
  public void testgetAllRegistrtaions() {
    myRegistrationSystem.register(myBoat, blueJurisdiction, 2021, myOwner);
    myRegistrationSystem.register(myAuto, blueJurisdiction, 2010, myOwner2);

    assertTrue(myRegistrationSystem.getAllRegistrations().contains(myRegistration));
    assertTrue(myRegistrationSystem.getAllRegistrations().contains(myRegistration3));
    assertFalse(myRegistrationSystem.getAllRegistrations().contains(myRegistration5));
  }

  /**
   * Method to test getFilteredList method.
   */
  @Test
  public void testgetFilteredList() {
    myRegistrationSystem.register(myBoat, blueJurisdiction, 2021, myOwner);
    myRegistrationSystem.register(myAuto, blueJurisdiction, 2010, myOwner2);
    //assertTrue(myRegistrationSystem.getFilteredList(myRegistration);

  }

  /**
   * Method to test reboot method.
   */
  @Test
  public void testreboot() {
    myRegistrationSystem.register(myBoat, blueJurisdiction, 2021, myOwner);
    myRegistrationSystem.register(myAuto, blueJurisdiction, 2010, myOwner2);
    assertTrue(myRegistrationSystem.getAllRegistrations().contains(myRegistration));
    assertTrue(myRegistrationSystem.getAllRegistrations().contains(myRegistration3));

    myRegistrationSystem.reboot();

    assertFalse(myRegistrationSystem.getAllRegistrations().contains(myRegistration));
    assertFalse(myRegistrationSystem.getAllRegistrations().contains(myRegistration3));
    assertEquals(0, myRegistrationSystem.getAllRegistrations().size());
  }
}
