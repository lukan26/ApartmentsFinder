package onlinerBy.sell;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import onlinerBy.base.BaseApartment;
import onlinerBy.base.Location;
import onlinerBy.base.Price;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SellApartment extends BaseApartment {

    @JsonProperty("author_id")
    private long authorId;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("resale")
    private Boolean resale;
    @JsonProperty("number_of_rooms")
    private int numberOfRooms;
    @JsonProperty("floor")
    private int floor;
    @JsonProperty("number_of_floors")
    private int numberOfFloors;
    @JsonProperty("area")
    private Area area;
    @JsonProperty("seller")
    private Seller seller;
    @JsonProperty("auction_bid")
    private AuctionBid auctionBid;

    @JsonProperty("author_id")
    public long getAuthorId() {
        return authorId;
    }

    @JsonProperty("author_id")
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("resale")
    public Boolean getResale() {
        return resale;
    }

    @JsonProperty("resale")
    public void setResale(Boolean resale) {
        this.resale = resale;
    }

    @JsonProperty("number_of_rooms")
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    @JsonProperty("number_of_rooms")
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @JsonProperty("floor")
    public int getFloor() {
        return floor;
    }

    @JsonProperty("floor")
    public void setFloor(int floor) {
        this.floor = floor;
    }

    @JsonProperty("number_of_floors")
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    @JsonProperty("number_of_floors")
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @JsonProperty("area")
    public Area getArea() {
        return area;
    }

    @JsonProperty("area")
    public void setArea(Area area) {
        this.area = area;
    }

    @JsonProperty("seller")
    public Seller getSeller() {
        return seller;
    }

    @JsonProperty("seller")
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @JsonProperty("auction_bid")
    public AuctionBid getAuctionBid() {
        return auctionBid;
    }

    @JsonProperty("auction_bid")
    public void setAuctionBid(AuctionBid auctionBid) {
        this.auctionBid = auctionBid;
    }

}