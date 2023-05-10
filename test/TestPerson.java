import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Person;

/**
 * A Junit test class for the Person class.
 */
public class TestPerson {
  private Person myPerson;

  /**
   * Method to set up objects to test.
   */
  @Before
  public void setUp() {
    myPerson = new Person("Dave", "Boston");
  }

  /**
   * Method to test getName method.
   */
  @Test
  public void testgetName() {
    assertEquals("Dave", myPerson.getName());
  }

  /**
   * Method to test getAddress method.
   */
  @Test
  public void testgetAddress() {
    assertEquals("Boston", myPerson.getAddress());
  }

  /**
   * Method to test toString method.
   */
  @Test
  public void testtoString() {
    assertEquals("Dave, Boston", myPerson.toString());
  }
}
