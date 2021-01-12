package behaviours;

import people.Visitor;

public interface ITicketed {

    double defaultPrice();

    void priceFor(Visitor visitor);
}
