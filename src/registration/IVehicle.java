package registration;

/**
 * This is an interface which represents a vehicle.
 */
public interface IVehicle {
  /**
   * Getter method for the kind of vehicle.
   *
   * @return the kind of vehicle
   */
  String getKind();

  /**
   * Getter method for the make of the vehicle.
   *
   * @return the make of the vehicle
   */
  String getMake();

  /**
   * Getter method for the production year of the vehicle.
   *
   * @return the year the vehicle was produced
   */
  int getProductionYear();

  /**
   * Getter method for the purchase price of the vehicle.
   *
   * @return the purchase price of the vehicle
   */
  double getPurchasePrice();

  /**
   * Method to get the max passengers of the vehicle.
   *
   * @return the maximum number of passengers for the vehicle
   */
  int getMaxPassengers();
}
