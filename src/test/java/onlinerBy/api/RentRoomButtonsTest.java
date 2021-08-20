package onlinerBy.api;

import onlinerBy.config.RentConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RentRoomButtonsTest {

    @Test(description = "Only room in flat uri for rent")
    public void onlyRoomTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?rent_type[]=room&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "1 room flats uri for rent")
    public void oneRoomFlatTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setOneRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?rent_type[]=1_room&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "2 room flats uri for rent")
    public void twoRoomsFlatTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setTwoRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?rent_type[]=2_rooms&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "3 room flats uri for rent")
    public void threeRoomsFlatTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setThreeRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?rent_type[]=3_rooms&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "4/4+ room flats uri for rent")
    public void fourPlusRoomsFlatTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setFourPlusRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?rent_type[]=4_rooms&rent_type[]=5_rooms&rent_type[]=6_rooms&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "1 and 3 room flats uri for rent")
    public void oneThreeRoomsFlatsTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setOneRoom(true);
        config.setThreeRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?rent_type[]=1_room&rent_type[]=3_rooms&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "2 and 4 room flats uri for rent")
    public void twoFourPlusRoomsFlatsTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        RentConfig config = new RentConfig();
        config.setTwoRoom(true);
        config.setFourPlusRoom(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createRentApartmentRequest(config);

        Assert.assertEquals(uri, "?rent_type[]=2_rooms&rent_type[]=4_rooms&rent_type[]=5_rooms&rent_type[]=6_rooms&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }
}
