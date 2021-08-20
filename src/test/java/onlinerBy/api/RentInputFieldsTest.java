package onlinerBy.api;

import onlinerBy.config.RentConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RentInputFieldsTest {
    @Test(description = "Min price of renting flats")
    public void minPriceTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setPriceMin(222);
        config.setCurrency("usd");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?price[min]=222&currency=usd&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Max price of renting flats")
    public void maxPriceTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setPriceMax(333);
        config.setCurrency("usd");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?price[max]=333&currency=usd&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");

    }

    @Test(description = "Min and max price of renting flats")
    public void minMaxPriceTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setPriceMin(99);
        config.setPriceMax(177);
        config.setCurrency("usd");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri,"?price[min]=99&price[max]=177&currency=usd&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }
}
