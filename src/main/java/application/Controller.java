package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import logging.CustomLogger;
import onlinerBy.api.RequestBuilder;
import onlinerBy.base.BaseConfig;
import onlinerBy.config.RentConfig;
import onlinerBy.config.SellConfig;
import onlinerBy.coordinates.Feature;
import onlinerBy.coordinates.Features;
import onlinerBy.rent.RentApartment;
import onlinerBy.rent.RentApartments;
import onlinerBy.report.HtmlReporter;
import onlinerBy.sell.SellApartment;
import onlinerBy.sell.SellApartments;
import org.apache.logging.log4j.Level;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab sellTab;

    @FXML
    private AnchorPane sellAnchorPane;

    @FXML
    private Pane sellPane;

    @FXML
    private Label priceLabel;

    @FXML
    private TextField minSellPriceTextField;

    @FXML
    private TextField maxSellPriceTextfield;

    @FXML
    private Label priceFromLabel;

    @FXML
    private Label priceToLabel;

    @FXML
    private ToggleButton oneRoomSellFlatButton;

    @FXML
    private ToggleButton twoRoomSellFlatButton;

    @FXML
    private ToggleButton threeRoomSellFlatButton;

    @FXML
    private ToggleButton fourPlusRoomSellFlatButton;

    @FXML
    private Label areaLabel;

    @FXML
    private TextField minAreaTextField;

    @FXML
    private TextField maxAreaTextField;

    @FXML
    private Label areaFromLabel;

    @FXML
    private Label areaToLabel;

    @FXML
    private ToggleButton resaleButton;

    @FXML
    private ToggleButton newFlatButton;

    @FXML
    private Label buildingYearLabel;

    @FXML
    private TextField minBuildingYearTextField;

    @FXML
    private TextField maxBuildingYearTextField;

    @FXML
    private Label buildingYearFromLabel;

    @FXML
    private Label buildingYearToLabel;

    @FXML
    private Button searchSellFlatButton;

    @FXML
    private MenuButton walling;

    @FXML
    private RadioMenuItem panel;

    @FXML
    private RadioMenuItem brick;

    @FXML
    private RadioMenuItem monolit;

    @FXML
    private RadioMenuItem block;

    @FXML
    private Button searchRentFlatButton;

    @FXML
    private Label rentFromLabel;

    @FXML
    private Label rentPriceLabel;

    @FXML
    private TextField maxRentPriceTextField;

    @FXML
    private TextField minRentPriceTextField;

    @FXML
    private Label rentToLabel;

    @FXML
    private ToggleButton oneRentRoomButton;

    @FXML
    private ToggleButton twoRentRoomButton;

    @FXML
    private ToggleButton threeRentRoomButton;

    @FXML
    private ToggleButton fourPlusRentRoomButton;

    @FXML
    private ToggleButton flatButton;

    @FXML
    private ToggleButton roomButton;

    @FXML
    private CheckBox ownerOnly;

    @FXML
    private MenuButton metro;

    @FXML
    private RadioMenuItem nearbySubway;

    @FXML
    private RadioMenuItem blueLine;

    @FXML
    private RadioMenuItem redLine;

    @FXML
    private CheckBox outermostFloor;


    @FXML
    void initialize() {
        flatButton.setSelected(true);

        flatButton.setOnAction(event -> {
            disableRentRoomButtons(false);
        });

        roomButton.setOnAction(event -> {
            selectRentRoomButtons(false);
            disableRentRoomButtons(true);
        });

        searchRentFlatButton.setOnAction(event -> {
            hataBy.config.RentConfig hConfig = new hataBy.config.RentConfig();
            hataBy.api.RequestBuilder builder = new hataBy.api.RequestBuilder();

            hConfig.setTwoRoom(true);
            hConfig.setThreeRoom(true);
            hConfig.setCurrency(840);
            hConfig.setPriceMin(1);
            hConfig.setPriceMax(1500);
            hConfig.setTotalSquareFrom(1);
            hConfig.setTotalSquareTo(100);
            hConfig.setLivingSquareFrom(2);
            hConfig.setLivingSquareTo(99);
            hConfig.setKitchenSquareFrom(3);
            hConfig.setKitchenSquareTo(98);
            hConfig.setCityCode("5000000000");
            hConfig.setDistrictNumbers("698,699");
            hConfig.setMetroStationNumbers("214,213,201,212");
            hConfig.setNoFirstFloor(true);
            hConfig.setNoLastFloor(true);
            hConfig.setBuildingYear(2000);
            hConfig.setOfferType("agent");

            String hataByUri = builder.createRentApartmentRequest(hConfig);

            RentConfig config = new RentConfig();

            config.setRootEndpoint("https://ak.api.onliner.by");

            readDataFromRentSectionFields(config);

            config.setCurrency("usd");
            config.setOnlyOwner(ownerOnly.isSelected());
            if (nearbySubway.isSelected() || (redLine.isSelected() && blueLine.isSelected())) {
                config.setMetro("Автозаводская линия,Московская линия");
            } else if (redLine.isSelected()) {
                config.setMetro("Автозаводская линия");
            } else if (blueLine.isSelected()) {
                config.setMetro("Московская линия");
            } else {
                config.setMetro("");
            }

            if (roomButton.isSelected()) {
                config.setRoom(true);
            }

            if (oneRentRoomButton.isSelected()) {
                config.setOneRoom(true);
            }

            if (twoRentRoomButton.isSelected()) {
                config.setTwoRoom(true);
            }

            if (threeRentRoomButton.isSelected()) {
                config.setThreeRoom(true);
            }

            if (fourPlusRentRoomButton.isSelected()) {
                config.setFourPlusRoom(true);
            }

            setCoordinatesToConfig(config);

            String uri = new RequestBuilder().createRentApartmentRequest(config);
            List<RentApartment> apartmentList = getRentApartments("/search/apartments" + uri, config);
            List<Feature> featureList = getApartmentsCoordinates("/search/points" + uri, config);


            HtmlReporter htmlReporter = new HtmlReporter();
            htmlReporter.createRentApartmentsHtmlMap(apartmentList, featureList);
            htmlReporter.createAllRentApartmentsHtmlReport(apartmentList);
            htmlReporter.openHTML("rent_apartments.html");


            System.out.println();
        });

        searchSellFlatButton.setOnAction(event -> {
            SellConfig config = new SellConfig();
            config.setRootEndpoint("https://pk.api.onliner.by");
            config.setCurrency("usd");

            readDataFromSellSectionFields(config);

            if (oneRoomSellFlatButton.isSelected()) {
                config.setOneRoom(true);
            }
            if (twoRoomSellFlatButton.isSelected()) {
                config.setTwoRoom(true);
            }
            if (threeRoomSellFlatButton.isSelected()) {
                config.setThreeRoom(true);
            }
            if (fourPlusRoomSellFlatButton.isSelected()) {
                config.setFourPlusRoom(true);
            }


            if (resaleButton.isSelected()) {
                config.setResale(true);
            }
            if (newFlatButton.isSelected()) {
                config.setNewFlat(true);
            }
            if (panel.isSelected()) {
                config.setPanelWall(true);
            }
            if (brick.isSelected()) {
                config.setBrickWall(true);
            }
            if (monolit.isSelected()) {
                config.setMonolitWall(true);
            }
            if (block.isSelected()) {
                config.setBlockWall(true);
            }

            if (outermostFloor.isSelected()) {
                config.setOutermostFloor(false);
            }

            setCoordinatesToConfig(config);

            String uri = new RequestBuilder().createSellApartmentRequest(config);
            List<SellApartment> apartmentList = getSellApartments("/search/apartments" + uri, config);
            List<Feature> featureList = getApartmentsCoordinates("/search/points" + uri, config);

            HtmlReporter htmlReporter = new HtmlReporter();
            htmlReporter.createSellApartmentsHtmlMap(apartmentList, featureList);
            htmlReporter.createAllSellApartmentsHtmlReport(apartmentList);
            htmlReporter.openHTML("sell_apartments.html");
        });
    }

    private void setCoordinatesToConfig(BaseConfig config) {
        config.setLbLat(53.82274641107382);
        config.setRtLat(53.97789721409897);
        config.setLbLong(27.28900909423828);
        config.setRtLong(27.83248901367188);
    }

    private void disableRentRoomButtons(Boolean value) {
        oneRentRoomButton.setDisable(value);
        twoRentRoomButton.setDisable(value);
        threeRentRoomButton.setDisable(value);
        fourPlusRentRoomButton.setDisable(value);
    }

    private void selectRentRoomButtons(Boolean value) {
        oneRentRoomButton.setSelected(value);
        twoRentRoomButton.setSelected(value);
        threeRentRoomButton.setSelected(value);
        fourPlusRentRoomButton.setSelected(value);
    }

    private void readDataFromSellSectionFields(SellConfig config) {
        try {
            config.setPriceMin(Long.parseLong(minSellPriceTextField.getText()));
            CustomLogger.logger.log(Level.DEBUG, "Minimum price is set as " + minSellPriceTextField.getText());
        } catch (Exception e) {
            CustomLogger.logger.log(Level.WARN, "Minimum price is not set");
        }

        try {
            config.setPriceMax(Long.parseLong(maxSellPriceTextfield.getText()));
            CustomLogger.logger.log(Level.DEBUG, "Maximum price is set as " + maxSellPriceTextfield.getText());
        } catch (Exception e) {
            CustomLogger.logger.log(Level.WARN, "Maximum price is not set");
        }

        try {
            config.setAreaMin(Integer.parseInt(minAreaTextField.getText()));
            CustomLogger.logger.log(Level.DEBUG, "Minimum area is set as " + minAreaTextField.getText());
        } catch (Exception e) {
            CustomLogger.logger.log(Level.WARN, "Minimum area is not set");
        }

        try {
            config.setAreaMax(Integer.parseInt(maxAreaTextField.getText()));
            CustomLogger.logger.log(Level.DEBUG, "Maximum area is set as " + maxAreaTextField.getText());
        } catch (Exception e) {
            CustomLogger.logger.log(Level.WARN, "Maximum area is not set");
        }

        try {
            config.setBuildingYearMin(Short.parseShort(minBuildingYearTextField.getText()));
            CustomLogger.logger.log(Level.DEBUG, "Minimum build year is set as " + minBuildingYearTextField.getText());
        } catch (Exception e) {
            CustomLogger.logger.log(Level.WARN, "Minimum build year is not set");
        }

        try {
            config.setBuildingYearMax(Short.parseShort(maxBuildingYearTextField.getText()));
            CustomLogger.logger.log(Level.DEBUG, "Maximum build year is set as " + maxBuildingYearTextField.getText());
        } catch (Exception e) {
            CustomLogger.logger.log(Level.WARN, "Maximum build year is not set");
        }
    }

    private void readDataFromRentSectionFields(RentConfig config) {
        try {
            config.setPriceMin(Long.parseLong(minRentPriceTextField.getText()));
            CustomLogger.logger.log(Level.DEBUG, "Minimum price is set as " + minRentPriceTextField.getText());
        } catch (Exception e) {
            CustomLogger.logger.log(Level.WARN, "Minimum price is not set");
        }

        try {
            config.setPriceMax(Long.parseLong(maxRentPriceTextField.getText()));
            CustomLogger.logger.log(Level.DEBUG, "Maximum price is set as " + maxRentPriceTextField.getText());
        } catch (Exception e) {
            CustomLogger.logger.log(Level.WARN, "Maximum price is not set");
        }
    }

    public List<SellApartment> getSellApartments(String uri, SellConfig sellConfig) {

        RequestBuilder requestBuilder = new RequestBuilder();
        SellApartments apartments = new SellApartments();
        List<SellApartment> apartmentsList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        int i = 1;

        do {
            uri = requestBuilder.nextPage(uri, i);
            String responseBody = requestBuilder.sendRequest(sellConfig.getRootEndpoint(), uri);

            try {
                apartments = mapper.readValue(responseBody, SellApartments.class);
                CustomLogger.logger.log(Level.INFO, "Apartments have been successfully saved");
            } catch (
                    IOException e) {
                CustomLogger.logger.log(Level.ERROR, "Apartments haven't been saved");
                e.printStackTrace();
            }
            apartmentsList.addAll(apartments.getApartments());
        } while (i++ < apartments.getPage().getLast());

        return apartmentsList;
    }

    public List<RentApartment> getRentApartments(String uri, RentConfig rentConfig) {

        RequestBuilder requestBuilder = new RequestBuilder();
        RentApartments apartments = new RentApartments();
        List<RentApartment> apartmentsList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        int i = 1;

        do {
            uri = requestBuilder.nextPage(uri, i);
            String responseBody = requestBuilder.sendRequest(rentConfig.getRootEndpoint(), uri);

            try {
                apartments = mapper.readValue(responseBody, RentApartments.class);
                CustomLogger.logger.log(Level.INFO, "Apartments have been successfully saved");
            } catch (
                    IOException e) {
                CustomLogger.logger.log(Level.ERROR, "Apartments haven't been saved");
                e.printStackTrace();
            }
            apartmentsList.addAll(apartments.getApartments());
        } while (i++ < apartments.getPage().getLast());

        return apartmentsList;
    }

    public static List<Feature> getApartmentsCoordinates(String uri, BaseConfig config) {

        RequestBuilder requestBuilder = new RequestBuilder();
        Features features = new Features();
        List<Feature> featureList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        String responseBody = requestBuilder.sendRequest(config.getRootEndpoint(), uri);

        try {
            features = mapper.readValue(responseBody, Features.class);
            CustomLogger.logger.log(Level.INFO, "Coordinates have been successfully saved");
        } catch (IOException e) {
            CustomLogger.logger.log(Level.ERROR, "Coordinates haven't been saved");
            e.printStackTrace();
        }
        featureList.addAll(features.getFeatures());

        return featureList;
    }
}
