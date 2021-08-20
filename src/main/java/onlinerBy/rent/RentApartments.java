package onlinerBy.rent;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import onlinerBy.base.BaseApartments;

public class RentApartments extends BaseApartments {

    @JsonProperty("apartments")
    private List<RentApartment> apartments = null;

    @JsonProperty("apartments")
    public List<RentApartment> getApartments() {
        return apartments;
    }

    @JsonProperty("apartments")
    public void setApartments(List<RentApartment> apartments) {
        this.apartments = apartments;
    }

}