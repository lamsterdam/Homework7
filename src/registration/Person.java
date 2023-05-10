package registration;

/**
 * This is the Person class.
 */
public class Person {
  private String name;
  private String address;

  /**
   * This is the constructor of the Person class.
   *
   * @param name    the name of the person
   * @param address the address where the person lives
   */
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  /**
   * Getter method for the name of the person.
   *
   * @return the name of the person
   */
  public String getName() {
    return this.name;
  }

  /**
   * Getter method for the address of the person.
   *
   * @return the address of the person
   */
  public String getAddress() {
    return this.address;
  }

  /**
   * To String method for the person.
   *
   * @return a string representation of the person name and address
   */
  @Override
  public String toString() {
    return name + ", " + address;
  }
}
