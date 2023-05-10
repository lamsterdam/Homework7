package registration;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * This is the Registration class.
 */
public class Registration implements IRegistration {
  protected static final DecimalFormat df = new DecimalFormat("$0.00");
  protected int registrationYear;
  protected IJurisdiction jurisdiction;
  protected IVehicle vehicle;
  protected List<Person> owners;

  /**
   * This is the constructor for the Registration class.
   *
   * @param registrationYear the registration year of the vehicle
   */
  public Registration(IVehicle vehicle, IJurisdiction jurisdiction, int registrationYear,
                      List<Person> owners) {
    if (vehicle == null) {
      throw new IllegalArgumentException("Cannot have empty vehicle");
    }
    this.vehicle = vehicle;
    this.registrationYear = registrationYear;
    this.jurisdiction = jurisdiction;

    if (owners == null) {
      throw new IllegalArgumentException("Must have an owner");
    }
    this.owners = owners;
  }

  /**
   * Getter method for the registration year of the vehicle.
   *
   * @return the year the vehicle was registered
   */
  @Override
  public int getRegistrationYear() {
    return this.registrationYear;
  }

  /**
   * Getter method for the production year of the vehicle.
   *
   * @return the year the vehicle was produced
   */
  @Override
  public int getProductionYear() {
    return this.vehicle.getProductionYear();
  }

  /**
   * Getter method for the jurisdiction year of the vehicle.
   *
   * @return the jurisdiction of the vehicle
   */
  @Override
  public IJurisdiction getJurisdiction() {
    return this.jurisdiction;
  }

  /**
   * Getter method for the owners of a specific vehicle.
   *
   * @return the list of owners of a vehicle
   */
  @Override
  public List<Person> getOwners() {
    return Collections.unmodifiableList(this.owners);
  }

  /**
   * Method to get the max passengers of the vehicle.
   *
   * @return the maximum number of passengers for the vehicle
   */
  @Override
  public int getMaxPassengers() {
    return this.vehicle.getMaxPassengers();
  }

  /**
   * Method to calculate the excise tax on a vehicle.
   *
   * @return the excise tax on the vehicle
   */
  @Override
  public double calculateExciseTax() {
    return this.jurisdiction.exciseTax(vehicle);
  }

  /**
   * To string method for the Registration.
   *
   * @return a string representation of the vehicle type, make, production year, price, owners,
   *     registration year and excise tax
   */
  @Override
  public String toString() {
    return ("Registration: " + " \n" + this.vehicle.getKind().toUpperCase() + ": "
            + this.vehicle.getMake() + " " + "Year" + (this.vehicle.getProductionYear()) + " "
            + "Price = " + df.format(this.vehicle.getPurchasePrice()) + "\n" + "Owned By: "
            + this.owners + "\n" + "Year: " + this.registrationYear + "\n" + "Excise Tax: "
            + df.format(this.calculateExciseTax()));
  }

  /**
   * Method to check equality between two objects.
   * Checks if the hashcode are the same, the objects are in the same class
   * and if the object parameters are the same
   *
   * @param other the other point to be compared to
   * @return a true/false statement based on equality
   */

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (this.getClass() != other.getClass()) {
      return false;
    }
    Registration otherReg = (Registration) other;
    return this.vehicle.equals(otherReg.vehicle)
            && this.registrationYear == otherReg.registrationYear
            && this.owners.equals(otherReg.owners);
  }

  /**
   * Method to override the hashcode.
   * @return the hash of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicle, registrationYear, owners);
  }
}
