package registration;

import java.util.Objects;

/**
 * This is the Boat Vehicle class.
 */
public class Boat extends AbstractVehicle {
  protected static final int MAX_PASSENGERS = 10;


  /**
   * This is the constructor of the Boat class.
   *
   * @param kind           the type of vehicle
   * @param make           the make of the vehicle
   * @param productionYear the year the vehicle was produced
   * @param purchasePrice  the purchase price of the vehicle
   */
  public Boat(String kind, String make, int productionYear, double purchasePrice) {
    super(kind, make, productionYear, purchasePrice);
    this.maxPassengers = MAX_PASSENGERS;
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
    Boat otherVehicle = (Boat) other;
    return this.kind.equals(otherVehicle.kind)
            && this.make.equals(otherVehicle.make)
            && this.productionYear == otherVehicle.productionYear
            && this.purchasePrice == otherVehicle.purchasePrice;
  }

  /**
   * Method to override the hashcode.
   * @return the hash of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(kind,make,productionYear,purchasePrice);
  }
}
