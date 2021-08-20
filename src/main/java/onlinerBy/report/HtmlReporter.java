package onlinerBy.report;

import onlinerBy.coordinates.Feature;
import onlinerBy.rent.RentApartment;
import onlinerBy.sell.SellApartment;

import java.awt.*;
import java.io.*;
import java.util.List;

public class HtmlReporter implements HtmlMarkup, HtmlImg, HtmlRef {

    public void createAllRentApartmentsHtmlReport(List<RentApartment> apartments) {
        StringBuilder allApartmentsHtmliew = new StringBuilder();

        String refTag = addAttribute(A_OPEN, HREF, "rent_apartments_map.html");
        refTag = addAttribute(refTag, TARGET, "_blank");
        refTag = addAttribute(refTag, REL, "noopener");
        refTag=  refTag + "Посмотреть на карте" + CLOSE_A;

        allApartmentsHtmliew.append(addHeader("Квартиры в аренду (" + "найдено: " + apartments.size() + ")     " + refTag))
                .append(EMPTY_STRING);
        for (RentApartment apartment : apartments) {
            allApartmentsHtmliew.append(createOneRentFlatHtmlView(apartment));
        }
        createHtmlViewToFile(allApartmentsHtmliew.toString(), "rent_apartments.html");
        System.out.println();
    }

    public void createAllSellApartmentsHtmlReport(List<SellApartment> apartments) {
        StringBuilder allApartmentsHtmliew = new StringBuilder();

        String refTag = addAttribute(A_OPEN, HREF, "sell_apartments_map.html");
        refTag = addAttribute(refTag, TARGET, "_blank");
        refTag = addAttribute(refTag, REL, "noopener");
        refTag=  refTag + "Посмотреть на карте" + CLOSE_A;

        allApartmentsHtmliew.append(addHeader("Квартиры на продажу (" + "найдено: " + apartments.size() + ")     " + refTag))
                .append(EMPTY_STRING);
        for (SellApartment apartment : apartments) {
            allApartmentsHtmliew.append(createOneSellFlatHtmlView(apartment));
        }
        createHtmlViewToFile(allApartmentsHtmliew.toString(), "sell_apartments.html");
        System.out.println();
    }

    public String createOneRentFlatHtmlView(RentApartment apartment) {

        StringBuilder htmlView = new StringBuilder();
        htmlView.append(TABLE_OPEN)
                .append(TBODY_OPEN)
                .append(TR_OPEN)
                .append(TD_OPEN);
        String imgTag = addAttribute(IMG_OPEN, STYLE_ATTRIBUTE, "margin: 0 0 5px 20px; float: right;");
        imgTag = addAttribute(imgTag, SRC, apartment.getPhoto());
        imgTag = addAttribute(imgTag, WIDTH, "300");
        imgTag = addAttribute(imgTag, HEIGHT, "200");

        htmlView.append(imgTag)
                .append(CLOSE_TD)
                .append(TD_OPEN);

        String priceTag = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");
        priceTag = priceTag + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN
                + "Цена: " + CLOSE_STRONG + apartment.getPrice().getAmount() + "$ (" + apartment.getPrice().getConverted().getBYN().getAmount() + " р.)"
                + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(priceTag);

        String amountOfRooms = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");

        String rentType = apartment.getRentType();
        if (rentType.contains("_room")) {
            apartment.setRentType(rentType.replace("_room", ""));
        }
        if (rentType.contains("_rooms")) {
            apartment.setRentType(rentType.replace("_rooms", ""));
        }
        amountOfRooms = amountOfRooms + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN
                + "Комнат: " + CLOSE_STRONG + apartment.getRentType().replace("_room", "")
                + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(amountOfRooms);

        String address = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");
        address = address + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN
                + "Адрес: " + CLOSE_STRONG + apartment.getLocation().getAddress()
                + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(address);

        String detailed = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");
        detailed = detailed + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN;

        String refTag = addAttribute(A_OPEN, HREF, apartment.getUrl());
        refTag = addAttribute(refTag, TARGET, "_blank");
        refTag = addAttribute(refTag, REL, "noopener");
        detailed = detailed + refTag + "Подробнее" + CLOSE_A
                + CLOSE_STRONG + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(detailed);
        htmlView.append(CLOSE_TD)
                .append(CLOSE_TR)
                .append(CLOSE_TBODY)
                .append(CLOSE_TABLE)
                .append(EMPTY_STRING)
                .append(EMPTY_STRING);

        return htmlView.toString();
    }

    public String createOneSellFlatHtmlView(SellApartment apartment) {

        StringBuilder htmlView = new StringBuilder();
        htmlView.append(TABLE_OPEN)
                .append(TBODY_OPEN)
                .append(TR_OPEN)
                .append(TD_OPEN);
        String imgTag = addAttribute(IMG_OPEN, STYLE_ATTRIBUTE, "margin: 0 0 5px 20px; float: right;");
        imgTag = addAttribute(imgTag, SRC, apartment.getPhoto());
        imgTag = addAttribute(imgTag, WIDTH, "460");
        imgTag = addAttribute(imgTag, HEIGHT, "280");

        htmlView.append(imgTag)
                .append(CLOSE_TD)
                .append(TD_OPEN);

        String priceTag = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");
        priceTag = priceTag + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN
                + "Цена: " + CLOSE_STRONG + apartment.getPrice().getAmount() + "$ (" + apartment.getPrice().getConverted().getBYN().getAmount() + " р.)"
                + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(priceTag);

        String amountOfRooms = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");
        amountOfRooms = amountOfRooms + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN
                + "Комнат: " + CLOSE_STRONG + apartment.getNumberOfRooms()
                + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(amountOfRooms);

        String area = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");
        area = area + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN
                + "Площадь: " + CLOSE_STRONG + apartment.getArea().getTotal() + "/" + apartment.getArea().getLiving() + "/" + apartment.getArea().getKitchen()
                + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(area);

        String floor = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");
        floor = floor + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN
                + "Этаж: " + CLOSE_STRONG + apartment.getFloor() + "/" + apartment.getNumberOfFloors()
                + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(floor);

        String address = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");
        address = address + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN
                + "Адрес: " + CLOSE_STRONG + apartment.getLocation().getAddress()
                + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(address);

        String detailed = addAttribute(P_OPEN, STYLE_ATTRIBUTE, "padding-left: 30px;");
        detailed = detailed + BIG_OPEN + BIG_OPEN + BIG_OPEN + STRONG_OPEN;

        String refTag = addAttribute(A_OPEN, HREF, apartment.getUrl());
        refTag = addAttribute(refTag, TARGET, "_blank");
        refTag = addAttribute(refTag, REL, "noopener");
        detailed = detailed + refTag + "Подробнее" + CLOSE_A
                + CLOSE_STRONG + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_P;
        htmlView.append(detailed);
        htmlView.append(CLOSE_TD)
                .append(CLOSE_TR)
                .append(CLOSE_TBODY)
                .append(CLOSE_TABLE)
                .append(EMPTY_STRING)
                .append(EMPTY_STRING);

        return htmlView.toString();
    }

    public String addHeader(String text) {
        String header = addAttribute(H1_OPEN, STYLE_ATTRIBUTE, "color: #5e9ca0;");
        return header + BIG_OPEN + BIG_OPEN + BIG_OPEN + text + CLOSE_BIG + CLOSE_BIG + CLOSE_BIG + CLOSE_H1;

    }

    public String addAttribute(String tag, String attributeName, String attributeValue) {
        tag = tag.replace(">", " ");
        tag = tag + attributeName + "=\"" + attributeValue + "\">";

        return tag;
    }

    public void createHtmlViewToFile(String htmlView, String reportFilePath) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(reportFilePath))) {
            bw.write(htmlView);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public String htmlReader(String htmlFilePath) {

        String htmlDoc = "";

        try (BufferedReader br = new BufferedReader(new FileReader(htmlFilePath))) {
            //чтение построчно
            String s;
            while ((s = br.readLine()) != null) {
                htmlDoc = htmlDoc + s;
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        return htmlDoc;
    }


    public void openHTML(String htmlFilePath) {
        File htmlFile = new File(htmlFilePath);
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createSellApartmentsHtmlMap(List<SellApartment> apartments, List<Feature> featureList) {
        StringBuilder mapView = new StringBuilder();
        mapView.append(addHeaderToHtmlMap(mapView));

        for (int i = 0; i < featureList.size(); i++) {
            for (int j = 0; j < apartments.size(); j++) {
                long pointId = featureList.get(i).getId();
                long apartmentId = apartments.get(j).getId();
                if (apartmentId == pointId) {
                    mapView.append(placeOneSellPlacemark(featureList.get(i), apartments.get(j), i));
                }
            }
        }

        for (int i = 0; i < featureList.size(); i++) {
            mapView.append(addFeatureToGeoObjects(i));
        }
        mapView.append(addFooterToHtmlMap(mapView));
        createHtmlViewToFile(mapView.toString(), "sell_apartments_map.html");
        System.out.println();

    }

    public String placeOneSellPlacemark(Feature feature, SellApartment apartment, int counter) {
        StringBuilder placemark = new StringBuilder();
        placemark.append("\n\n" +
                "        var myPlacemark" + counter + " = new ymaps.Placemark(" + feature.getGeometry().getCoordinates() + ", {\n" +
                "        balloonContent: '<a href=\"" + apartment.getUrl() + "\"><img src=\"" + apartment.getPhoto() + "\" width=\"150\" height=\"100\"/></a>',\n" +
                "        balloonContentHeader: '" + apartment.getNumberOfRooms() + "к  " + " " + apartment.getPrice().getAmount() + "$ (" + apartment.getPrice().getConverted().getBYN().getAmount() + " р.)',\n" +
                "        balloonContentFooter: '" + apartment.getArea().getTotal() + "/" + apartment.getArea().getLiving() + "/" + apartment.getArea().getKitchen() + " м2 Этаж " + apartment.getFloor() + "/" + apartment.getNumberOfFloors() + " " + apartment.getLocation().getAddress() + "',\n" +
                "        }, {\n" +
                "        preset: \"islands#redStretchyIcon\",\n" +
                "        hideIconOnBalloonOpen: false\n" +
                "        });");

        return placemark.toString();
    }

    public String placeOneRentPlacemark(Feature feature, RentApartment apartment, int counter) {
        StringBuilder placemark = new StringBuilder();

        String rentType = apartment.getRentType();
        if (rentType.contains("_room")) {
            apartment.setRentType(rentType.replace("_room", ""));
        }
        if (rentType.contains("_rooms")) {
            apartment.setRentType(rentType.replace("_rooms", ""));
        }

        placemark.append("\n\n" +
                "        var myPlacemark" + counter + " = new ymaps.Placemark(" + feature.getGeometry().getCoordinates() + ", {\n" +
                "        balloonContent: '<a href=\"" + apartment.getUrl() + "\"><img src=\"" + apartment.getPhoto() + "\" width=\"150\" height=\"100\"/></a>',\n" +
                "        balloonContentHeader: '" + apartment.getRentType() + "к  " + " " + apartment.getPrice().getAmount() + "$ (" + apartment.getPrice().getConverted().getBYN().getAmount() + " р.)',\n" +
                "        balloonContentFooter: '" + apartment.getLocation().getAddress() + "',\n" +
                "        }, {\n" +
                "        preset: \"islands#redStretchyIcon\",\n" +
                "        hideIconOnBalloonOpen: false\n" +
                "        });");

        return placemark.toString();
    }

    public String addFeatureToGeoObjects(int counter) {
        StringBuilder placemark = new StringBuilder();
        placemark.append("\n" +
                "        myMap.geoObjects.add(myPlacemark" + counter + ");");

        return placemark.toString();
    }

    public void createRentApartmentsHtmlMap(List<RentApartment> apartments, List<Feature> featureList) {
        StringBuilder mapView = new StringBuilder();
        mapView.append(addHeaderToHtmlMap(mapView));

        for (int i = 0; i < featureList.size(); i++) {
            for (int j = 0; j < apartments.size(); j++) {
                long pointId = featureList.get(i).getId();
                long apartmentId = apartments.get(j).getId();
                if (apartmentId == pointId) {
                    mapView.append(placeOneRentPlacemark(featureList.get(i), apartments.get(j), i));
                }
            }
        }

        for (int i = 0; i < featureList.size(); i++) {
            mapView.append(addFeatureToGeoObjects(i));
        }
        mapView.append(addFooterToHtmlMap(mapView));

        createHtmlViewToFile(mapView.toString(), "rent_apartments_map.html");
        System.out.println();

    }

    public StringBuilder addHeaderToHtmlMap(StringBuilder view) {
        view.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "    <script src=\"https://api-maps.yandex.ru/2.1/?apikey=17ec5e9a-963a-4a79-914c-2a8dc713c981&lang=ru_RU\" type=\"text/javascript\"/></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "        ymaps.ready(init);\n" +
                "        function init(){\n" +
                "            var myMap = new ymaps.Map(\"map\", {\n" +
                "                center: [53.902496, 27.561481],\n" +
                "                zoom: 11\n" +
                "            }, {\n" +
                "            searchControlProvider: 'yandex#search'\n" +
                "        });\n");

        return view;
    }

    public StringBuilder addFooterToHtmlMap(StringBuilder view) {
        view.append("\n" +
                "        }\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
               // "    <div id=\"map\" style=\"width: 1200px; height: 800px\"></div>\n" +
                "    <div id=\"map\" style=\"position:absolute;width:100%;height:100%;\"" +
                "</body>\n" +
                "</html>");

        return view;
    }

}
