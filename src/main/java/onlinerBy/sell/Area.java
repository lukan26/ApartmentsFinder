package onlinerBy.sell;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Area {

    @JsonProperty("total")
    private double total;
    @JsonProperty("living")
    private double living;
    @JsonProperty("kitchen")
    private double kitchen;

    @JsonProperty("total")
    public double getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(double total) {
        this.total = total;
    }

    @JsonProperty("living")
    public double getLiving() {
        return living;
    }

    @JsonProperty("living")
    public void setLiving(double living) {
        this.living = living;
    }

    @JsonProperty("kitchen")
    public double getKitchen() {
        return kitchen;
    }

    @JsonProperty("kitchen")
    public void setKitchen(double kitchen) {
        this.kitchen = kitchen;
    }

}