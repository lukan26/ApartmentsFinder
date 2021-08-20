package onlinerBy.api;

import onlinerBy.config.SellConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SellRoomButtonsTest {

    @Test(description = "1 room flats uri for sell")
    public void oneRoomFlatTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setOneRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?number_of_rooms[]=1&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "2 room flats uri for sell")
    public void twoRoomsFlatTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setTwoRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?number_of_rooms[]=2&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "3 room flats uri for sell")
    public void threeRoomsFlatTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setThreeRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?number_of_rooms[]=3&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "4/4+ room flats uri for sell")
    public void fourPlusRoomsFlatTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setFourPlusRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?number_of_rooms[]=4&number_of_rooms[]=5&number_of_rooms[]=6&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "1 and 3 room flats uri for sell")
    public void oneThreeRoomsFlatsTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setOneRoom(true);
        config.setThreeRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?number_of_rooms[]=1&number_of_rooms[]=3&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "2 and 4 room flats uri for sell")
    public void twoFourPlusRoomsFlatsTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setTwoRoom(true);
        config.setFourPlusRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?number_of_rooms[]=2&number_of_rooms[]=4&number_of_rooms[]=5&number_of_rooms[]=6&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }
}
