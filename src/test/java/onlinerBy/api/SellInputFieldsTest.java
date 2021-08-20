package onlinerBy.api;

import onlinerBy.config.SellConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SellInputFieldsTest {
    @Test(description = "Min price of selling flats")
    public void minPriceTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setPriceMin(132);
        config.setCurrency("usd");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?price[min]=132&currency=usd&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Max price of selling flats")
    public void maxPriceTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setPriceMax(46000);
        config.setCurrency("usd");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?price[max]=46000&currency=usd&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");

    }

    @Test(description = "Min and max price of selling flats")
    public void minMaxPriceTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setPriceMin(10000);
        config.setPriceMax(55000);
        config.setCurrency("usd");
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri,"?price[min]=10000&price[max]=55000&currency=usd&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Min area of selling flats")
    public void minAreaTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setAreaMin(81);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri,"?area[min]=81&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Max area of selling flats")
    public void maxAreaTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setAreaMax(256);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?area[max]=256&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Min and max area of selling flats")
    public void minMaxAreaTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setAreaMin(42);
        config.setAreaMax(192);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?area[min]=42&area[max]=192&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Min building year of selling flats")
    public void minBuildingTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setBuildingYearMin(1950);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?building_year[min]=1950&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Max building year of selling flats")
    public void maxBuildingTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setBuildingYearMax(1999);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?building_year[max]=1999&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Min and max building year of selling flats")
    public void minMaxBuildingTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setBuildingYearMin(1900);
        config.setBuildingYearMax(2015);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?building_year[min]=1900&building_year[max]=2015&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }
}
