package registration;


/**
 * This is the Blue Jurisdiction class.
 */
public class BlueJurisdiction implements IJurisdiction {
  protected IVehicle vehicle;

  /**
   * Method to calculate the excise tax on a vehicle.
   *
   * @return the excise tax on the vehicle
   */
  public double exciseTax(IVehicle vehicle) {
    if (vehicle.getProductionYear() < 2000) {
      return (0.03 * vehicle.getPurchasePrice()) + 99;
    } else {
      return 0.03 * vehicle.getPurchasePrice();
    }
  }

  /**
   * To String method for Blue Jurisdiction.
   *
   * @return a string representation of the name of the jurisdiction
   */
  @Override
  public String toString() {
    return "Blue Jurisdiction";
  }
}
