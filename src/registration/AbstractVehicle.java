package registration;

/**
 * This is the AbstractVehicle class.
 */
public abstract class AbstractVehicle implements IVehicle {
  protected String kind;
  protected String make;
  protected int productionYear;
  protected double purchasePrice;
  protected int maxPassengers;

  /**
   * This is the constructor for the abstract vehicle class.
   *
   * @param kind           the type of vehicle
   * @param make           the make of the vehicle
   * @param productionYear the year the vehicle was produced
   * @param purchasePrice  the purchase price of the vehicle
   */
  public AbstractVehicle(String kind, String make, int productionYear, double purchasePrice) {
    this.kind = kind;
    this.make = make;
    this.productionYear = productionYear;
    this.purchasePrice = purchasePrice;
  }

  /**
   * Getter method for the kind of vehicle.
   *
   * @return the kind of vehicle
   */
  @Override
  public String getKind() {
    return this.kind;
  }

  /**
   * Getter method for the make of the vehicle.
   *
   * @return the make of the vehicle
   */
  @Override
  public String getMake() {
    return this.make;
  }

  /**
   * Getter method for the production year of the vehicle.
   *
   * @return the year the vehicle was produced
   */
  @Override
  public int getProductionYear() {
    return this.productionYear;
  }

  /**
   * Getter method for the purchase price of the vehicle.
   *
   * @return the purchase price of the vehicle
   */
  @Override
  public double getPurchasePrice() {
    return this.purchasePrice;
  }

  /**
   * Method to get the max passengers of the vehicle.
   *
   * @return the maximum number of passengers for the vehicle
   */
  @Override
  public int getMaxPassengers() {
    return this.maxPassengers;
  }


}
