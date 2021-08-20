package onlinerBy.api;

import onlinerBy.config.SellConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SellParamsTest {
    @Test(description = "OutermostFloor parameter for sell flats uri")
    public void outermostFloorTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setOutermostFloor(false);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?outermost_floor=false&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Resale parameter for sell flats uri")
    public void resaleTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setResale(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?resale=1&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "New flat parameter for sell flats uri")
    public void newFlatTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setNewFlat(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?resale=0&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Panel wall parameter for sell flats uri")
    public void panelWallTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setPanelWall(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?walling[]=panel&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Brick wall parameter for sell flats uri")
    public void brickWallTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setBrickWall(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?walling[]=brick&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Block wall parameter for sell flats uri")
    public void blockWallTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setBlockWall(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?walling[]=block&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Monolith wall parameter for sell flats uri")
    public void monolithWallTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setMonolitWall(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?walling[]=monolith&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Panel and momolith walls parameter for sell flats uri")
    public void panelMonolithWallTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setPanelWall(true);
        config.setMonolitWall(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?walling[]=panel&walling[]=monolith&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }

    @Test(description = "Brick and block walls parameter for sell flats uri")
    public void brickBlockWallTest() {
        RequestBuilder requestBuilder = new RequestBuilder();
        SellConfig config = new SellConfig();
        config.setBrickWall(true);
        config.setBlockWall(true);
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);

        String uri = requestBuilder.createSellApartmentRequest(config);

        Assert.assertEquals(uri, "?walling[]=brick&walling[]=block&bounds[lb][lat]=53.82274641107382&bounds[lb][long]=27.28900909423828&bounds[rt][lat]=53.97789721409897&bounds[rt][long]=27.83248901367188");
    }
}
