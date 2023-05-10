package registration;

/**
 * This is the Green Jurisdiction class.
 */
public class GreenJurisdiction implements IJurisdiction {

  /**
   * Method to calculate the excise tax on a vehicle.
   *
   * @return the excise tax on the vehicle
   */
  public double exciseTax(IVehicle vehicle) {
    return (0.04 * vehicle.getPurchasePrice()) + (100 * vehicle.getMaxPassengers());
  }

  /**
   * To String method for Blue Jurisdiction.
   * @return a string representation of the name of the jurisdiction
   */
  @Override
  public String toString() {
    return "Green Jurisdiction";
  }
}
