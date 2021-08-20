package onlinerBy.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import onlinerBy.base.BaseConfig;
import onlinerBy.config.RentConfig;
import onlinerBy.config.SellConfig;

public class RequestBuilder {

    public String createRentApartmentRequest(RentConfig config) {
        String request = "";
        String questionSign = "?";
        String andSign = "";

        if (config.getRoom()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "rent_type[]=room";
        }

        request = addRoomsToRequest(config, request, "rent_type[]=", "_rooms");

        if (request.contains("1_rooms")) {
            request = request.replace("1_rooms", "1_room");
        }

        request = addPriceToRequest(config, request);

        if (config.getOnlyOwner() == true) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "only_owner=" + config.getOnlyOwner();
        }

        if (!config.getMetro().equals("")) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }

            if (config.getMetro().equals("Возле метро") || config.getMetro().equals("Автозаводская линия,Московская линия")) {
                request = questionSign + request + andSign + "metro[]=red_line&metro[]=blue_line";
            } else if (config.getMetro().equals("Автозаводская линия")) {
                request = questionSign + request + andSign + "metro[]=red_line";
            } else if (config.getMetro().equals("Московская линия")) {
                request = questionSign + request + andSign + "metro[]=blue_line";
            }
        }

        request = addCoordinatesToRequest(config, request);

        return request;
    }

    public String createSellApartmentRequest(SellConfig config) {
        String request = "";
        String questionSign = "?";
        String andSign = "";

        request = addPriceToRequest(config, request);
        request = addRoomsToRequest(config, request, "number_of_rooms[]=", "");

        if (config.getAreaMin() != 0) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "area[min]=" + config.getAreaMin();
        }

        if (config.getAreaMax() != 0) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "area[max]=" + config.getAreaMax();
        }

        if ((!config.getResale() && !config.getNewFlat()) || (config.getResale() && config.getNewFlat())) {

        } else if (config.getResale()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "resale=1";
        } else if (config.getNewFlat()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "resale=0";
        }

        if (config.getBuildingYearMin() > 0) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "building_year[min]=" + config.getBuildingYearMin();
        }

        if (config.getBuildingYearMax() > 0) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "building_year[max]=" + config.getBuildingYearMax();
        }


        if (config.getPanelWall()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }

            request = questionSign + request + andSign + "walling[]=panel";
        }

        if (config.getBrickWall()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }

            request = questionSign + request + andSign + "walling[]=brick";
        }

        if (config.getMonolitWall()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }

            request = questionSign + request + andSign + "walling[]=monolith";
        }

        if (config.getBlockWall()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }

            request = questionSign + request + andSign + "walling[]=block";
        }

        if (!config.getOutermostFloor()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }

            request = questionSign + request + andSign + "outermost_floor=" + config.getOutermostFloor();
        }

        request = addCoordinatesToRequest(config, request);

        return request;
    }

    private String addPriceToRequest(BaseConfig config, String request) {
        String questionSign = "?";
        String andSign = "";
        boolean value = false;

        if (config.getPriceMin() > 0) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "price[min]=" + config.getPriceMin();
            value = true;
        }

        if (config.getPriceMax() > 0) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + "price[max]=" + config.getPriceMax();
            value = true;
        }

        if (value) {
            request = request + "&currency=" + config.getCurrency();
        }

        return request;
    }

    private String addRoomsToRequest(BaseConfig config, String request, String parameterName, String postfix) {
        String questionSign = "?";
        String andSign = "";

        if (config.getOneRoom()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + parameterName + 1 + postfix;
        }

        if (config.getTwoRoom()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + parameterName + 2 + postfix;
        }

        if (config.getThreeRoom()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + parameterName + 3 + postfix;
        }

        if (config.getFourPlusRoom()) {
            if (request.contains("?")) {
                questionSign = "";
                andSign = "&";
            }
            request = questionSign + request + andSign + parameterName + 4 + postfix + "&" + parameterName + 5 + postfix +
                    "&" + parameterName + 6 + postfix;
        }

        return request;
    }

    private String addCoordinatesToRequest(BaseConfig config, String request) {

        if (config.getLbLat() > 0 || config.getLbLong() > 0 ||
                config.getRtLat() > 0 || config.getRtLong() > 0) {

            request = request +
                    "&bounds[lb][lat]=" + config.getLbLat() +
                    "&bounds[lb][long]=" + config.getLbLong() +
                    "&bounds[rt][lat]=" + config.getRtLat() +
                    "&bounds[rt][long]=" + config.getRtLong();
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
