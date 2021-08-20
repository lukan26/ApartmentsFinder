package onlinerBy.api;

import onlinerBy.config.RentConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RentParamsTest {
    @Test(description = "Only owner checkbox of rent flats uri")
    public void onlyOwnerTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setOnlyOwner(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?only_owner=true&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Red line of metro for rent flats uri")
    public void redLineOfMetroTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setMetro("Автозаводская линия");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?metro[]=red_line&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Blue line of metro for rent flats uri")
    public void blueLineOfMetroTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setMetro("Московская линия");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?metro[]=blue_line&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Both lines of metro for rent flats uri")
    public void bothLinesOfMetroTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setMetro("Возле метро");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?metro[]=red_line&metro[]=blue_line&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }
}
