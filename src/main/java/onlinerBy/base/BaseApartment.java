package onlinerBy.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseApartment {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("last_time_up")
    private String lastTimeUp;
    @JsonProperty("up_available_in")
    private Integer upAvailableIn;
    @JsonProperty("url")
    private String url;


    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("photo")
    public String getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("last_time_up")
    public String getLastTimeUp() {
        return lastTimeUp;
    }

    @JsonProperty("last_time_up")
    public void setLastTimeUp(String lastTimeUp) {
        this.lastTimeUp = lastTimeUp;
    }

    @JsonProperty("up_available_in")
    public Integer getUpAvailableIn() {
        return upAvailableIn;
    }

    @JsonProperty("up_available_in")
    public void setUpAvailableIn(Integer upAvailableIn) {
        this.upAvailableIn = upAvailableIn;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}