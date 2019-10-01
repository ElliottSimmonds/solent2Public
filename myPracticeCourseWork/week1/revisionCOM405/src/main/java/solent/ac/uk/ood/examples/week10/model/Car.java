package solent.ac.uk.ood.examples.week10.model;

public class Car extends Vehicle {

    @Override
    public Double calculateFee() {
        if (getWeight() > 1590) {
            double weightDiff = getWeight() - 1590; // total weight over the limit
            return 5.0 + (0.10 * Math.round(weightDiff / 100)); // adds 10p per 100kg over limit
        }
        return 5.0;
    }
}
