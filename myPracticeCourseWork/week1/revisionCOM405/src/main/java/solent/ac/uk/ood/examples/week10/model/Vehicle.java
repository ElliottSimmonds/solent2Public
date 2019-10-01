package solent.ac.uk.ood.examples.week10.model;

public abstract class Vehicle {

    private double weight;

    private String registration;

    public abstract Double calculateFee();
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void setRegistration (String registration) {
        this.registration = registration;
    }
    
    public double getWeight() {
        return this.weight;
    }
    
    public String getRegistration () {
        return this.registration;
    }
    
}
