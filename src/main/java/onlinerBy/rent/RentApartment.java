package onlinerBy.rent;

import com.fasterxml.jackson.annotation.JsonProperty;
import onlinerBy.base.BaseApartment;
import onlinerBy.base.Location;

public class RentApartment extends BaseApartment {


    @JsonProperty("rent_type")
    private String rentType;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("contact")
    private Contact contact;

    @JsonProperty("rent_type")
    public String getRentType() {
        return rentType;
    }

    @JsonProperty("rent_type")
    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
