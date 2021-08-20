package onlinerBy.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import logging.CustomLogger;
import onlinerBy.base.BaseConfig;
import org.apache.logging.log4j.Level;

import java.io.FileReader;
import java.io.IOException;

public class SellConfig extends BaseConfig {

    private String rootEndpoint;
    private long priceMin;
    private long priceMax;
    private String currency;
    private Boolean oneRoom = false;
    private Boolean twoRoom = false;
    private Boolean threeRoom = false;
    private Boolean fourPlusRoom = false;
    private int areaMin;
    private int areaMax;
    private Boolean resale = false;
    private Boolean newFlat = false;
    private int buildingYearMin;
    private int buildingYearMax;
    private Boolean panelWall = false;
    private Boolean brickWall = false;
    private Boolean monolitWall = false;
    private Boolean blockWall = false;
    private Boolean outermostFloor = true;
    private double lbLat;
    private double rtLat;
    private double lbLong;
    private double rtLong;

    public void setPriceMin(Long priceMin) {
        this.priceMin = priceMin;
    }

    public int getAreaMin() {
        return areaMin;
    }

    public void setAreaMin(Integer areaMin) {
        this.areaMin = areaMin;
    }

    public int getAreaMax() {
        return areaMax;
    }

    public void setAreaMax(Integer areaMax) {
        this.areaMax = areaMax;
    }

    public Boolean getResale() {
        return resale;
    }

    public void setResale(Boolean resale) {
        this.resale = resale;
    }

    public Boolean getNewFlat() {
        return newFlat;
    }

    public void setNewFlat(Boolean newFlat) {
        this.newFlat = newFlat;
    }

    public int getBuildingYearMin() {
        return buildingYearMin;
    }

    public void setBuildingYearMin(int buildingYearMin) {
        this.buildingYearMin = buildingYearMin;
    }

    public int getBuildingYearMax() {
        return buildingYearMax;
    }

    public void setBuildingYearMax(int buildingYearMax) {
        this.buildingYearMax = buildingYearMax;
    }

    public Boolean getPanelWall() {
        return panelWall;
    }

    public void setPanelWall(Boolean panelWall) {
        this.panelWall = panelWall;
    }

    public Boolean getBrickWall() {
        return brickWall;
    }

    public void setBrickWall(Boolean brickWall) {
        this.brickWall = brickWall;
    }

    public Boolean getMonolitWall() {
        return monolitWall;
    }

    public void setMonolitWall(Boolean monolitWall) {
        this.monolitWall = monolitWall;
    }

    public Boolean getBlockWall() {
        return blockWall;
    }

    public void setBlockWall(Boolean blockWall) {
        this.blockWall = blockWall;
    }

    public Boolean getOutermostFloor() {
        return outermostFloor;
    }

    public void setOutermostFloor(Boolean outermostFloor) {
        this.outermostFloor = outermostFloor;
    }

    public SellConfig getSellConfig(String configFilePath) {

        ObjectMapper mapper = new ObjectMapper();
        SellConfig sellConfig = new SellConfig();
        try {
            sellConfig = mapper.readValue(new FileReader(configFilePath), SellConfig.class);
            CustomLogger.logger.log(Level.INFO, "Configuration has been successfully read from \"" + configFilePath + "\" file");
        } catch (IOException e) {
            CustomLogger.logger.log(Level.ERROR, "Configuration can't be read from \"" + configFilePath + "\" file");
            e.printStackTrace();
        }

        return sellConfig;
    }
}
