package registration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This is the RegistrationSystem class.
 */
public class RegistrationSystem {
  // make this a Singleton
  private static final RegistrationSystem INSTANCE = new RegistrationSystem();
  private HashSet<Registration> registrations = new HashSet<>();

  /**
   * This is the constructor of the RegistrationSystem class.
   */
  private RegistrationSystem() {
  }

  /**
   * Method to get an instance of the Registration System.
   *
   * @return a Registration System instance
   */
  public static RegistrationSystem getInstance() {
    return INSTANCE;
  }

  /**
   * Method to create a vehicle.
   *
   * @param kind           the type of vehicle
   * @param make           the make of the vehicle
   * @param productionYear the year the vehicle was produced
   * @param purchasePrice  the purchase price of the vehicle
   * @return a new vehicle object
   * @throws IllegalArgumentException for invalid inputs
   */
  public IVehicle createVehicle(String kind, String make, int productionYear, double purchasePrice)
          throws IllegalArgumentException {
    if (kind == null || kind.equals("")) {
      throw new IllegalArgumentException("Cannot have empty kind");
    }
    if (make == null || make.equals("")) {
      throw new IllegalArgumentException("Cannot have empty make");
    }

    if (productionYear < 1900 || productionYear > 2023) {
      throw new IllegalArgumentException("Invalid production year");
    }
    if (purchasePrice < 0) {
      throw new IllegalArgumentException("Cannot have negative purchase price");
    }

    if (kind.equalsIgnoreCase("Boat")) {
      return new Boat(kind, make, productionYear, purchasePrice);
    }
    if (kind.equalsIgnoreCase("Auto")) {
      return new Auto(kind, make, productionYear, purchasePrice);
    }
    if (kind.equalsIgnoreCase("Motorcycle")) {
      return new Motorcycle(kind, make, productionYear, purchasePrice);
    }
    return null;
  }

  /**
   * Method to register a vehicle in the registration system.
   *
   * @param vehicle          the vehicle to be registered
   * @param jurisdiction     the jurisdiction of the vehicle
   * @param registrationYear the year the vehicle was registered
   * @param owners           the list of persons that owned the vehicle
   */
  public void register(IVehicle vehicle, IJurisdiction jurisdiction, int registrationYear,
                       List<Person> owners) {
    Registration newReg = new Registration(vehicle, jurisdiction, registrationYear, owners);
    if (!registrations.contains(newReg)) {
      registrations.add(newReg);
    }
  }


  /**
   * Method to get all registrations in the system.
   *
   * @return an unmodifiable list of all registrations in the system
   */
  // answer an unmodifiable list!
  public List<IRegistration> getAllRegistrations() {
    List<IRegistration> newList;
    newList = Collections.unmodifiableList(new ArrayList<>(RegistrationSystem.getInstance()
            .registrations));
    return newList;
  }


  /**
   * Method to get a list of registrations filtered based on the predicate.
   *
   * @param query the predicate to filter the list of registrations
   * @return an unmodifiable list of filtered registrations based on predicate
   */
  // answer an unmodifiable list
  public List<IRegistration> getFilteredList(Predicate<IRegistration> query) {
    if (query == null) {
      throw new IllegalArgumentException("Cannot have empty query");
    }

    List<IRegistration> updatedList = getAllRegistrations().stream().filter(query)
            .collect(Collectors.toList());
    return Collections.unmodifiableList(updatedList);
  }


  /**
   * Method to reset the system and remove all registrations.
   */
  // reset the system to initial "start state"
  public void reboot() {
    registrations.clear();
  }
}
