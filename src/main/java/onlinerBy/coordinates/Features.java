package onlinerBy.coordinates;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Features {

    @JsonProperty("features")
    private List<Feature> features = null;
    @JsonProperty("type")
    private String type;
    @JsonProperty("total")
    private Integer total;

    @JsonProperty("features")
    public List<Feature> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

}
