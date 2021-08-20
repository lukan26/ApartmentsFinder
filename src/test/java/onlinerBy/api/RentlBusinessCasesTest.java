package onlinerBy.api;

import onlinerBy.config.RentConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RentlBusinessCasesTest {
    @Test(description = "1 room, 4+ rooms, max price, only owner, both metro lines parameters for rent flats uri")
    public void businessCase1Test() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setOneRoom(true);
        config.setFourPlusRoom(true);
        config.setPriceMax(300);
        config.setCurrency("usd");
        config.setOnlyOwner(true);
        config.setMetro("Автозаводская линия,Московская линия");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?rent_type[]=1_room&rent_type[]=4_rooms&rent_type[]=5_rooms&rent_type[]=6_rooms&price[max]=300&currency=usd&only_owner=true&metro[]=red_line&metro[]=blue_line&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "2 rooms, 3 rooms, min price, red line metro parameters for rent flats uri")
    public void businessCase2Test() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setTwoRoom(true);
        config.setThreeRoom(true);
        config.setPriceMin(100);
        config.setCurrency("usd");
        config.setMetro("Автозаводская линия");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?rent_type[]=2_rooms&rent_type[]=3_rooms&price[min]=100&currency=usd&metro[]=red_line&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }
}
