package onlinerBy.base;

public abstract class BaseConfig {
    private String rootEndpoint;
    private Boolean oneRoom = false;
    private Boolean twoRoom = false;
    private Boolean threeRoom = false;
    private Boolean fourPlusRoom = false;
    private long priceMin;
    private long priceMax;
    private String currency;
    private double lbLat;
    private double rtLat;
    private double lbLong;
    private double rtLong;

    public String getRootEndpoint() {
        return rootEndpoint;
    }

    public void setRootEndpoint(String rootEndpoint) {
        this.rootEndpoint = rootEndpoint;
    }

    public Boolean getOneRoom() {
        return oneRoom;
    }

    public void setOneRoom(Boolean oneRoom) {
        this.oneRoom = oneRoom;
    }

    public Boolean getTwoRoom() {
        return twoRoom;
    }

    public void setTwoRoom(Boolean twoRoom) {
        this.twoRoom = twoRoom;
    }

    public Boolean getThreeRoom() {
        return threeRoom;
    }

    public void setThreeRoom(Boolean threeRoom) {
        this.threeRoom = threeRoom;
    }

    public Boolean getFourPlusRoom() {
        return fourPlusRoom;
    }

    public void setFourPlusRoom(Boolean fourPlusRoom) {
        this.fourPlusRoom = fourPlusRoom;
    }

    public long getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(long priceMin) {
        this.priceMin = priceMin;
    }

    public long getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(long priceMax) {
        this.priceMax = priceMax;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getLbLat() {
        return lbLat;
    }

    public void setLbLat(double lbLat) {
        this.lbLat = lbLat;
    }

    public double getRtLat() {
        return rtLat;
    }

    public void setRtLat(double rtLat) {
        this.rtLat = rtLat;
    }

    public double getLbLong() {
        return lbLong;
    }

    public void setLbLong(double lbLong) {
        this.lbLong = lbLong;
    }

    public double getRtLong() {
        return rtLong;
    }

    public void setRtLong(double rtLong) {
        this.rtLong = rtLong;
    }
}
