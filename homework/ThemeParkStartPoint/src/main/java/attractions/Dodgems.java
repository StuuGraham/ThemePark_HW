package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    private double price;

    public Dodgems(String name, int rating, double price) {
        super(name, rating);
        this.price = price;
    }

    @Override
    public double defaultPrice() {
        return price;
    }

    public void priceFor(Visitor visitor){
        if(visitor.getAge() < 12){
            this.price /= 2;
        }
        else this.price *= 1;
    }
}
