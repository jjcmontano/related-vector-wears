package com.ito5136.samplegui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SampleGui extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(SampleGui.class.getResource("Scene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("SampleGui");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}