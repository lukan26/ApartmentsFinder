package hataBy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import logging.CustomLogger;
import org.apache.logging.log4j.Level;

import java.io.FileReader;
import java.io.IOException;

public class RentConfig {

    private String rootEndpoint = "https://www.hata.by/search/~s_do=rent" ;
    private boolean room = false;
    private boolean oneRoom = false;
    private boolean twoRoom = false;
    private boolean threeRoom = false;
    private boolean fourPlusRoom = false;
    private boolean noFirstFloor = false;
    private boolean noLastFloor = false;
    private int currency;
    private long priceMin;
    private long priceMax;
    private double totalSquareFrom;
    private double totalSquareTo;
    private double livingSquareFrom;
    private double livingSquareTo;
    private double kitchenSquareFrom;
    private double kitchenSquareTo;
    private String cityType = "ckod";
    private String cityCode = "5000000000";
    private String districtNumbers = "";
    private String metroStationNumbers = "";
    private String offerType = "";
    private int buildingYear;

    private double lbLat;
    private double rtLat;
    private double lbLong;
    private double rtLong;

    public boolean isNoFirstFloor() {
        return noFirstFloor;
    }

    public void setNoFirstFloor(boolean noFirstFloor) {
        this.noFirstFloor = noFirstFloor;
    }

    public boolean isNoLastFloor() {
        return noLastFloor;
    }

    public void setNoLastFloor(boolean noLastFloor) {
        this.noLastFloor = noLastFloor;
    }

    public int getBuildingYear() {
        return buildingYear;
    }

    public void setBuildingYear(int buildingYear) {
        this.buildingYear = buildingYear;
    }

    public String getRootEndpoint() {
        return rootEndpoint;
    }

    public void setRootEndpoint(String rootEndpoint) {
        this.rootEndpoint = rootEndpoint;
    }

    public boolean isRoom() {
        return room;
    }

    public void setRoom(boolean room) {
        this.room = room;
    }

    public boolean isOneRoom() {
        return oneRoom;
    }

    public void setOneRoom(boolean oneRoom) {
        this.oneRoom = oneRoom;
    }

    public boolean isTwoRoom() {
        return twoRoom;
    }

    public void setTwoRoom(boolean twoRoom) {
        this.twoRoom = twoRoom;
    }

    public boolean isThreeRoom() {
        return threeRoom;
    }

    public void setThreeRoom(boolean threeRoom) {
        this.threeRoom = threeRoom;
    }

    public boolean isFourPlusRoom() {
        return fourPlusRoom;
    }

    public void setFourPlusRoom(boolean fourPlusRoom) {
        this.fourPlusRoom = fourPlusRoom;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
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

    public double getTotalSquareFrom() {
        return totalSquareFrom;
    }

    public void setTotalSquareFrom(double totalSquareFrom) {
        this.totalSquareFrom = totalSquareFrom;
    }

    public double getTotalSquareTo() {
        return totalSquareTo;
    }

    public void setTotalSquareTo(double totalSquareTo) {
        this.totalSquareTo = totalSquareTo;
    }

    public double getLivingSquareFrom() {
        return livingSquareFrom;
    }

    public void setLivingSquareFrom(double livingSquareFrom) {
        this.livingSquareFrom = livingSquareFrom;
    }

    public double getLivingSquareTo() {
        return livingSquareTo;
    }

    public void setLivingSquareTo(double livingSquareTo) {
        this.livingSquareTo = livingSquareTo;
    }

    public double getKitchenSquareFrom() {
        return kitchenSquareFrom;
    }

    public void setKitchenSquareFrom(double kitchenSquareFrom) {
        this.kitchenSquareFrom = kitchenSquareFrom;
    }

    public double getKitchenSquareTo() {
        return kitchenSquareTo;
    }

    public void setKitchenSquareTo(double kitchenSquareTo) {
        this.kitchenSquareTo = kitchenSquareTo;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictNumbers() {
        return districtNumbers;
    }

    public void setDistrictNumbers(String districtNumbers) {
        this.districtNumbers = districtNumbers;
    }

    public String getMetroStationNumbers() {
        return metroStationNumbers;
    }

    public void setMetroStationNumbers(String metroStationNumbers) {
        this.metroStationNumbers = metroStationNumbers;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
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
