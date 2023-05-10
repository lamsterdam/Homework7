package registration;

import java.util.List;

/**
 * This is an interface which represents a registration for a vehicle.
 */
public interface IRegistration {

  /**
   * Getter method for the registration year of the vehicle.
   *
   * @return the year the vehicle was registered
   */
  public int getRegistrationYear();

  /**
   * Getter method for the production year of the vehicle.
   *
   * @return the year the vehicle was produced
   */
  public int getProductionYear();

  /**
   * Getter method for the jurisdiction year of the vehicle.
   *
   * @return the jurisdiction of the vehicle
   */
  public IJurisdiction getJurisdiction();

  /**
   * Getter method for the owners of a specific vehicle.
   *
   * @return the list of owners of a vehicle
   */
  public List<Person> getOwners();      // return NON-MUTABLE list

  /**
   * Method to get the max passengers of the vehicle.
   *
   * @return the maximum number of passengers for the vehicle
   */
  public int getMaxPassengers();

  /**
   * Method to calculate the excise tax on a vehicle.
   *
   * @return the excise tax on the vehicle
   */
  public double calculateExciseTax();
}
