package io.falcon.pipeline.domain;

/**
 * Created by anton on 12/5/16.
 */
public class PizzaOrder {
    private final String dow;
    private final String topping;
    private final String sauce;

    public PizzaOrder(String dow, String topping, String sauce) {
        this.dow = dow;
        this.topping = topping;
        this.sauce = sauce;
    }

    public String getDow() {
        return dow;
    }

    public String getTopping() {
        return topping;
    }
    public String getSauce() {
        return sauce;
    }
}
