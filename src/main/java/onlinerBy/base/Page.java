package onlinerBy.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "limit",
        "items",
        "current",
        "last"
})
public class Page {

    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("items")
    private Integer items;
    @JsonProperty("current")
    private Integer current;
    @JsonProperty("last")
    private Integer last;

    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty("items")
    public Integer getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Integer items) {
        this.items = items;
    }

    @JsonProperty("current")
    public Integer getCurrent() {
        return current;
    }

    @JsonProperty("current")
    public void setCurrent(Integer current) {
        this.current = current;
    }

    @JsonProperty("last")
    public Integer getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(Integer last) {
        this.last = last;
    }

}