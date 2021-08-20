package hataBy.api;

import hataBy.config.RentConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    public String createRentApartmentRequest(RentConfig config) {
        String request = "";
        String tildaSign = "~";

        if (!config.isRoom()) {
            request = tildaSign + "s_what=flat";
        }

        request = addParameterWithValueToRequest(request, "currency=", config.getCurrency());
        request = addRoomsToRequest(config, request);
        request = addPriceToRequest(config, request);
        request = addSquaresToRequest(config, request);
        request = addParameterWithValueToRequest(request, "ctype=", config.getCityType());

        if (!config.getCityCode().equals("")) {
            request = addParameterWithValueToRequest(request, "ckod=", config.getCityCode());
        }

        if (!config.getDistrictNumbers().equals("")) {
            request = addParameterWithValueToRequest(request, "sregion=", config.getDistrictNumbers());
        }

        if (!config.getMetroStationNumbers().equals("")) {
            request = addParameterWithValueToRequest(request, "metro_station=", config.getMetroStationNumbers());
        }

        if (!config.getOfferType().equals("")) {
            request = addParameterWithValueToRequest(request, "offer_type=", config.getOfferType());
        }

        if (config.getBuildingYear() > 0) {
            request = addParameterWithValueToRequest(request, "godp=", config.getBuildingYear());
        }


        //request = addCoordinatesToRequest(config, request);

        request = config.getRootEndpoint() + request;

        return request;
    }

    private <T> String addParameterWithValueToRequest(String request, String parameterName, T value) {
        String tildaSign = "~";

        request = request + tildaSign + parameterName + value;

        return request;
    }

    private String addSquaresToRequest(RentConfig config, String request) {
        String tildaSign = "~";

        if (config.getTotalSquareFrom() > 0) {
            request = request + tildaSign + "sq_total_from=" + config.getTotalSquareFrom();
        }

        if (config.getTotalSquareTo() > 0) {
            request = request + tildaSign + "sq_total_to=" + config.getTotalSquareTo();
        }

        if (config.getLivingSquareFrom() > 0) {
            request = request + tildaSign + "sq_live_from=" + config.getLivingSquareFrom();
        }

        if (config.getLivingSquareTo() > 0) {
            request = request + tildaSign + "sq_live_to=" + config.getLivingSquareTo();
        }

        if (config.getKitchenSquareFrom() > 0) {
            request = request + tildaSign + "sq_dine_from=" + config.getKitchenSquareFrom();
        }

        if (config.getKitchenSquareTo() > 0) {
            request = request + tildaSign + "sq_dine_to=" + config.getKitchenSquareTo();
        }

        return request;
    }

    private String addPriceToRequest(RentConfig config, String request) {
        String tildaSign = "~";

        if (config.getPriceMin() > 0) {
            request = request + tildaSign + "cena_from=" + config.getPriceMin();
        }

        if (config.getPriceMax() > 0) {
            request = request + tildaSign + "cena_to=" + config.getPriceMax();
        }

        return request;
    }

    private String addRoomsToRequest(RentConfig config, String request) {
        String tildaSign = "~";


        if (!config.isOneRoom() && !config.isTwoRoom() && !config.isThreeRoom() && !config.isFourPlusRoom()) {
            return request;
        }

        // request = request + tildaSign;

        if (config.isOneRoom()) {
            request = addParameterWithValueToRequest(request, "rooms=", 1);
        }

        if (config.isTwoRoom()) {
            if (request.contains("rooms=")) {
                request = request + ",";
                request = request + 2;
            }else {
                request = addParameterWithValueToRequest(request, "rooms=", 2);
            }
        }

        if (config.isThreeRoom()) {
            if (request.contains("rooms=")) {
                request = request + ",";
                request = request + 3;
            } else {
                request = addParameterWithValueToRequest(request, "rooms=", 3);
            }
        }


        if (config.isFourPlusRoom()) {
            if (request.contains("rooms=")) {
                request = request + ",";
                request = request + 4;
            } else {
                request = addParameterWithValueToRequest(request, "rooms=", 4);
            }
        }

        return request;
    }

    private String addCoordinatesToRequest(RentConfig config, String request) {

        if (config.getLbLat() > 0 || config.getLbLong() > 0 ||
                config.getRtLat() > 0 || config.getRtLong() > 0) {

            request = request +
                    "bounds[lb][lat]=" + config.getLbLat() +
                    "bounds[lb][long]=" + config.getLbLong() +
                    "bounds[rt][lat]=" + config.getRtLat() +
                    "bounds[rt][long]=" + config.getRtLong();
        }

        return request;
    }

    public String nextPage(String uri, int currentPageNumber) {

        if (!uri.contains("&page=")) {
            uri = uri + "&page=" + currentPageNumber;
        } else {
            uri = uri.replace("page=" + (currentPageNumber - 1), "page=" + currentPageNumber);
        }
        return uri;
    }

    public String sendRequest(String baseURI, String uri) {

        RestAssured.baseURI = baseURI;

        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation()
                .header("Content-Type", "applicaton/json; charset=utf-8");

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = request.get(uri);

        // Now let us print the body of the message to see what response
        // we have received from the server
        return response.getBody().asString();
    }
}
