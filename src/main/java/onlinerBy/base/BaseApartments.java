package onlinerBy.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseApartments {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("page")
    private Page page;

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("page")
    public Page getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Page page) {
        this.page = page;
    }

}
