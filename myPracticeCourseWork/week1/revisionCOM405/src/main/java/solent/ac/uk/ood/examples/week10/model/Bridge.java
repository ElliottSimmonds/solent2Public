package solent.ac.uk.ood.examples.week10.model;

import java.util.ArrayList;
import solent.ac.uk.ood.examples.week10.model.Vehicle;

public class Bridge {
    
    private static final int MAX_VECHICLES = 20; // 20 vehicles
    private static final double MAX_WEIGHT = 30000; // 30000kg
    
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    public Double calcTotalWeight() {
        double totalWeight = 0;
        for (int i=0; i < vehicles.size(); i++) {
            totalWeight = vehicles.get(i).getWeight();
        }
        return totalWeight;
    }

    public boolean requestAddVechicle(Vehicle vehicle) {
        if (calcTotalWeight() + vehicle.getWeight() > MAX_WEIGHT) {
            System.out.println("Weight limit reached");
            return false;
        } else if (numberOfVehicles() >= MAX_VECHICLES) {
            System.out.println("Vehicle limit reached");
            return false;
        }
        vehicles.add(vehicle);
        return true;
    }

    public boolean removeVehicle(String registration) {
        for (int i=0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getRegistration().equals(registration)) {
                vehicles.remove(vehicles.get(i));
                return true;
            }
        }
        return false;
    }

    public int numberOfVehicles() {
        return vehicles.size();
    }

    public Double calcTotalCost() {
        double totalCost = 0;
        for (int i=0; i < vehicles.size(); i++) {
            totalCost = totalCost + vehicles.get(i).calculateFee();
        }
        return totalCost;
    }
}
