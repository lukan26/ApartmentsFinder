package onlinerBy.coordinates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "balloonContent",
        "clusterCaption",
        "hintContent"
})
public class Properties {

    @JsonProperty("balloonContent")
    private String balloonContent;
    @JsonProperty("clusterCaption")
    private String clusterCaption;
    @JsonProperty("hintContent")
    private String hintContent;

    @JsonProperty("balloonContent")
    public String getBalloonContent() {
        return balloonContent;
    }

    @JsonProperty("balloonContent")
    public void setBalloonContent(String balloonContent) {
        this.balloonContent = balloonContent;
    }

    @JsonProperty("clusterCaption")
    public String getClusterCaption() {
        return clusterCaption;
    }

    @JsonProperty("clusterCaption")
    public void setClusterCaption(String clusterCaption) {
        this.clusterCaption = clusterCaption;
    }

    @JsonProperty("hintContent")
    public String getHintContent() {
        return hintContent;
    }

    @JsonProperty("hintContent")
    public void setHintContent(String hintContent) {
        this.hintContent = hintContent;
    }

}
