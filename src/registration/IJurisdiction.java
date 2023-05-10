package registration;

/**
 * This is an interface which represents a jurisdiction.
 */
public interface IJurisdiction {

  /**
   * Method to calculate the excise tax on a vehicle.
   *
   * @return the excise tax on the vehicle
   */
  default double exciseTax(IVehicle vehicle) {
    return 0.0;
  }
}
