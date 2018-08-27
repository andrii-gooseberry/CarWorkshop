package fxml;

import controllers.ScreenController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.DataCreater;
import utils.ExtensionUtility;

import java.io.File;

public class Main extends Application {

    private static String pathToExtensionMap = "extensionMap.txt";
    private static String pathToParent1 = "choose_client_view.fxml";
    private static String pathToParent2 = "choose_car_view.fxml";
    private static String pathToParent3 = "choose_mechanic_view.fxml";
    private static String pathToParent4 = "add_car_form_view.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent parent1 = FXMLLoader.load(getClass().getResource(pathToParent1));
        Parent parent2 = FXMLLoader.load(getClass().getResource(pathToParent2));
//        Parent parent3 = FXMLLoader.load(getClass().getResource(pathToParent3));
 //       Parent parent4 = FXMLLoader.load(getClass().getResource(pathToParent4));
        primaryStage.setTitle("Car Workshop");

        Scene scene = new Scene(parent1);
        scene.getStylesheets().add("main.css");
        ScreenController screenController = new ScreenController(scene, "Choose client" , parent1);

        screenController.addScreen("Choose car", parent2);
        //screenController.addScreen("Choose mechanic", parent3);
        //screenController.addScreen("Add car", parent4);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) throws Exception {

        if (new File(pathToExtensionMap).isFile()) {
            ExtensionUtility.readExtensionMap(pathToExtensionMap);
        }else{
            DataCreater.createData();
        }

        launch(args);
    }

    public static void saveAndFinish(){
        ExtensionUtility.writeExtensionMap(pathToExtensionMap);
        Platform.exit();
    }
}