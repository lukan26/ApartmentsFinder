package onlinerBy.api;

import onlinerBy.config.SellConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SellBusinessCasesTest {

        @Test(description = "Min price, 1 room, 4+ rooms, max area, resale, min building year, panel and brick wall parameters for sell flats uri")
        public void businessCase1Test() {
            RequestBuilder requestBuilder = new RequestBuilder();
            SellConfig config = new SellConfig();
            config.setPriceMin(22000);
            config.setCurrency("usd");
            config.setOneRoom(true);
            config.setFourPlusRoom(true);
            config.setAreaMax(97);
            config.setResale(true);
            config.setBuildingYearMin(1972);
            config.setPanelWall(true);
            config.setBrickWall(true);
            config.setLbLat(53.82274641107382);
            config.setRtLat(53.97789721409897);
            config.setLbLong(27.28900909423828);
            config.setRtLong(27.83248901367188);

            String uri = requestBuilder.createSellApartmentRequest(config);

            Assert.assertEquals(uri, "?price[min]=22000&currency=usd&number_of_rooms[]=1&number_of_rooms[]=4&number_of_rooms[]=5&number_of_rooms[]=6&area[max]=97&resale=1&building_year[min]=1972&walling[]=panel&walling[]=brick&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
        }

    @Test(description = "Max price, 2 rooms, 3 rooms, min area, resale, max building year, block and monolith wall parameters for sell flats uri")
    public void businessCase2Test() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setPriceMax(86000);
        config.setCurrency("usd");
        config.setTwoRoom(true);
        config.setThreeRoom(true);
        config.setAreaMin(30);
        config.setNewFlat(true);
        config.setBuildingYearMax(2016);
        config.setBlockWall(true);
        config.setMonolitWall(true);
        config.setOutermostFloor(false);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?price[max]=86000&currency=usd&number_of_rooms[]=2&number_of_rooms[]=3&area[min]=30&resale=0&building_year[max]=2016&walling[]=monolith&walling[]=block&outermost_floor=false&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }
}
