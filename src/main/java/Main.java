import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));
        primaryStage.setTitle("ApartmentsFinder");
        primaryStage.setScene(new Scene(root, 413, 581));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }


//        public static void main(String[] args) {
//
//
//        //command line arguments check
//        CommandLine cmd = new OptionsChecker().check(args);
//
//        String configFilePath = cmd.getOptionValue("c");
//        String searchType = cmd.getOptionValue("t");
//
//        if (searchType.equals("sell")) {
//            SellConfig config = new SellConfig().getSellConfig(configFilePath);
//
//            String uri = new RequestBuilder().createSellApartmentRequest(config);
//            List<SellApartment> apartmentList = getSellApartments(uri, config);
//            System.out.println("");
//        } else if (searchType.equals("rent")) {
//            RentConfig config = new RentConfig().getRentConfig(configFilePath);
//
//            String uri = new RequestBuilder().createRentApartmentRequest(config);
//            List<RentApartment> apartmentList = getRentApartments(uri, config);
//
//            HtmlReporter htmlReporter = new HtmlReporter();
//            htmlReporter.createAllRentApartmentsHtmlReport(apartmentList);
//            htmlReporter.openHTML("rent_apartments.html");
//
////            HtmlReporter2 reporter = new HtmlReporter2();
////            reporter.createAllRentApartmentsHtmlReport(apartmentList);
//
//            System.out.println();
//        }
//    }
}
