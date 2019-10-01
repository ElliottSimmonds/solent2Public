package solent.ac.uk.ood.examples.week10.model;

public class Lorry extends Vehicle {

    @Override
    public Double calculateFee() {
        if (getWeight() > 8000) {
            return 15.0;
        }
        return 10.0;
    }
}
