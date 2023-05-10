package registration;

import java.text.DecimalFormat;

/**
 * This is the Red Jurisdiction class.
 */
public class RedJurisdiction implements IJurisdiction {
  private static final DecimalFormat df = new DecimalFormat("$0.00");
  protected IVehicle vehicle;

  /**
   * Method to calculate the excise tax on a vehicle.
   *
   * @return the excise tax on the vehicle
   */
  public double exciseTax(IVehicle vehicle) {
    return 0.05 * vehicle.getPurchasePrice();
  }

  /**
   * To String method for Blue Jurisdiction.
   * @return a string representation of the name of the jurisdiction
   */
  @Override
  public String toString() {
    return "Red Jurisdiction";
  }
}
