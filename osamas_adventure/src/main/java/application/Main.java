package application;

// --- Components --- //
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;

// --- Class --- //
import application.eventHandlers.LoginRegistrationHandlers.loginHandler;
//import application.eventHandlers.LoginRegistrationHandlers.registrationHandler;

public class Main extends Application
{
    private Parent root;
    public Scene windowScene;
    private Stage windowFrame;
    private FXMLLoader fxmlLoader;

    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception 
    { 
        windowFrame = primaryStage;
        fxmlLoader = new FXMLLoader(getClass().getResource("/sceneLayouts/loginScenes/loginScene.fxml"));
        root = fxmlLoader.load();
        
        windowScene = new Scene(root);

        // --------------- Pass on Existing Instance -------------------//
        loginHandler loginController = fxmlLoader.getController();
        loginController.setMain(this);
        loginController.adminLogin(windowScene);
        // ------------------------------------------------------------//


        windowScene.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) 
            {
                if (event.getButton() == MouseButton.PRIMARY)
                {
                    root.requestFocus();
                }
            }
        });

       
        root.requestFocus();

        windowFrame.setScene(windowScene);
        windowFrame.setResizable(false);
        //windowFrame.setFullScreen(true);
        windowFrame.show();
    }

    public void updateScene(Parent root)
    {
        windowScene = new Scene(root);
        windowFrame.setScene(windowScene);
        windowFrame.show();
    }
}
