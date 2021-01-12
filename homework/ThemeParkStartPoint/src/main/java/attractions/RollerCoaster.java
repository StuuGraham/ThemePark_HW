package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ISecurity, ITicketed {

    private double price;
    public RollerCoaster(String name, int rating, double price){
        super(name, rating);
        this.price = price;
    }

    public boolean isAllowedTo(Visitor visitor){
        if(visitor.getHeight() > 145.0
                && visitor.getAge() > 12){
            return true;
        }
        else return false;
    }

    @Override
    public double defaultPrice() {
        return price;
    }

    public double priceFor(Visitor visitor){
        if(visitor.getHeight() > 200.00){
            return defaultPrice() * 2;
        }
        else return defaultPrice();
    }
}
