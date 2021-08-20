package onlinerBy.report.html;

import logging.CustomLogger;
import onlinerBy.rent.RentApartment;
import onlinerBy.report.HtmlImg;
import onlinerBy.report.HtmlMarkup;
import onlinerBy.report.HtmlRef;
import org.apache.logging.log4j.Level;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlReporter2 implements HtmlMarkup2, HtmlImg2, HtmlRef2 {

    StringBuilder htmlView = new StringBuilder();

    public void createAllRentApartmentsHtmlReport(List<RentApartment> apartments) {

//        allApartmentsHtmliew.append(addHeader("Квартиры в аренду (" + "найдено: " + apartments.size() + ")"))
//                .append(EMPTY_STRING);
        for (RentApartment apartment : apartments) {
            createOneRentFlatHtmlView(apartment);
        }
//        createHtmlViewToFile(allApartmentsHtmliew.toString());
//        System.out.println();
    }

    public String createOneRentFlatHtmlView(RentApartment apartment) {
        Tag table = new Tag(TABLE);
        Tag tBody = new Tag(TBODY);
        Tag tr = new Tag(TR);

        Tag tdPhoto = new Tag(TD);
        Tag img = new Tag(IMG)
                .addAttribute(new Attribute().setName(STYLE).setValue("margin: 0 0 5px 20px; float: right;"))
                .addAttribute(new Attribute().setName(SRC).setValue(apartment.getPhoto()))
                .addAttribute(new Attribute().setName(WIDTH).setValue("300"))
                .addAttribute(new Attribute().setName(HEIGHT).setValue("200"));
        tdPhoto.addTag(img);


        Tag tdDescription = new Tag(TD);

        Tag pPrice = new Tag(P).addAttribute(new Attribute().setValue(STYLE).setValue("padding-left: 30px"));
        Tag big1Price = new Tag(BIG);
        Tag big2Price = new Tag(BIG);
        Tag big3Price = new Tag(BIG).addText(" " + apartment.getPrice().getAmount() + " $ (" + apartment.getPrice().getConverted().getBYN().getAmount() + " р.)");
        Tag strongPrice = new Tag(STRONG).addText("Цена:");
        big3Price.addTag(strongPrice);
        big2Price.addTag(big3Price);
        big1Price.addTag(big2Price);
        pPrice.addTag(big1Price);

        Tag tdRoomNumber = new Tag(TD);

        Tag pRoomNumber = new Tag(P).addAttribute(new Attribute().setValue(STYLE).setValue("padding-left: 30px"));

        Tag big1RoomNumber = new Tag(BIG);
        Tag big2RoomNumber = new Tag(BIG);
        Tag big3RoomNumber = new Tag(BIG).addText(" " + apartment.getRentType().replace("_room", ""));
        Tag strongRoomNumber = new Tag(STRONG).addText("Комнат:");
        big3RoomNumber.addTag(strongRoomNumber);
        big2RoomNumber.addTag(big3RoomNumber);
        big1RoomNumber.addTag(big2RoomNumber);
        pRoomNumber.addTag(big1RoomNumber);

        Tag pAddress = new Tag(P).addAttribute(new Attribute().setValue(STYLE).setValue("padding-left: 30px"));

        Tag big1Address = new Tag(BIG);
        Tag big2Address = new Tag(BIG);
        Tag big3Address = new Tag(BIG).addText(" " + apartment.getLocation().getAddress());
        Tag strongAddress = new Tag(STRONG).addText("Адрес:");
        big3Address.addTag(strongAddress);
        big2Address.addTag(big3Address);
        big1Address.addTag(big2Address);
        pAddress.addTag(big1Address);

        Tag pDetails = new Tag(P).addAttribute(new Attribute().setValue(STYLE).setValue("padding-left: 30px"));

        Tag big1Details = new Tag(BIG);
        Tag big2Details = new Tag(BIG);
        Tag big3Details = new Tag(BIG);
        Tag strongDetails = new Tag(STRONG);
        Tag a = new Tag(A)
                .addAttribute(new Attribute().setName(HREF).setValue(apartment.getUrl()))
                .addAttribute(new Attribute().setName(TARGET).setValue("_blank"))
                .addAttribute(new Attribute().setName(REL).setValue("noopener"))
                .addText("Подробнее");
        strongDetails.addTag(a);
        big3Details.addTag(strongDetails);
        big2Details.addTag(big3Details);
        big1Details.addTag(big2Details);
        pDetails.addTag(big1Details);


        tdDescription.addTag(pPrice).addTag(pRoomNumber).addTag(pAddress).addTag(pDetails);
        tdRoomNumber.addTag(tdDescription);
        tr.addTag(tdPhoto).addTag(tdDescription);
        tBody.addTag(tr);
        table.addTag(tBody);


        tdPhoto.addTag(img).addTag(tdDescription);


        return "";

    }


    public void createHtmlViewToFile(String htmlView) {

        String fileName = "rent_apartments.html";
        FileWriter fW = null;
        try {
            fW = new FileWriter(fileName);
        } catch (IOException e) {
            CustomLogger.logger.log(Level.ERROR, "");
            e.printStackTrace();
        }

        try {
            fW.write(htmlView);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
