package onlinerBy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import logging.CustomLogger;
import onlinerBy.base.BaseConfig;
import org.apache.logging.log4j.Level;

import java.io.FileReader;
import java.io.IOException;

public class RentConfig extends BaseConfig {

    private String rootEndpoint;
    private Boolean room = false;
    private Boolean oneRoom = false;
    private Boolean twoRoom = false;
    private Boolean threeRoom = false;
    private Boolean fourPlusRoom = false;
    private long priceMin;
    private long priceMax;
    private String currency;
    private Boolean onlyOwner = false;
    private String metro = "";
    private double lbLat;
    private double rtLat;
    private double lbLong;
    private double rtLong;

    public Boolean getRoom() {
        return room;
    }

    public void setRoom(Boolean room) {
        this.room = room;
    }

    public Boolean getOnlyOwner() {
        return onlyOwner;
    }

    public void setOnlyOwner(Boolean onlyOwner) {
        this.onlyOwner = onlyOwner;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public RentConfig getRentConfig(String configFilePath) {

        ObjectMapper mapper = new ObjectMapper();
        RentConfig rentConfig = new RentConfig();
        try {
            rentConfig = mapper.readValue(new FileReader(configFilePath), RentConfig.class);
            CustomLogger.logger.log(Level.INFO, "Configuration has been successfully read from \"" + configFilePath + "\" file");
        } catch (IOException e) {
            CustomLogger.logger.log(Level.ERROR, "Configuration can't be read from \"" + configFilePath + "\" file");
            e.printStackTrace();
        }

        return rentConfig;
    }
}
