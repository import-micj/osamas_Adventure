package application.eventHandlers.LoginRegistrationHandlers;

// --- Components --- //
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


public class registrationHandler 
{
    private Main main;
    private Parent root;
    private FXMLLoader regLoad;


    public void setMain(Main main)
    {
        this.main = main;
    }

    public void ProceedToCharacterSelection (ActionEvent event) throws Exception
    { 
        regLoad = new FXMLLoader(getClass().getResource("/sceneLayouts/registrationScenes/registerClassSelect.fxml")); 
        root = regLoad.load();
        registrationHandler reg = regLoad.getController();
        reg.setMain(main);
        main.updateScene(root);
        
        // root = FXMLLoader.load(getClass().getResource("/sceneLayouts/registrationScenes/registerClassSelect.fxml"));
        // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // stage.setScene (scene);
        // stage.show();   */ // DON"T DELETE, MIGHT USE LATER, IT"S STILL ON OBSERVATION
    }

    public void CreateAccount(ActionEvent event) throws Exception
    {
        regLoad = new FXMLLoader(getClass().getResource("/sceneLayouts/registrationScenes/creatingAccProgressScene.fxml")); 
        root = regLoad.load();
        registrationHandler reg = regLoad.getController();
        reg.setMain(main);
        main.updateScene(root);
    }

    public void ProceedToLoginPage(ActionEvent event) throws Exception
    {     
        regLoad = new FXMLLoader(getClass().getResource("/sceneLayouts/loginScenes/loginScene.fxml"));
        root = regLoad.load();
        loginHandler log = regLoad.getController();
        log.setMain(main);  // Giving the new controller a reference to Main
        main.updateScene(root);
        log.adminLogin(main.windowScene);

        root.requestFocus();

        main.windowScene.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) 
            {
                if (event.getButton() == MouseButton.PRIMARY)
                {
                    root.requestFocus();
                }
            }
        });       
    }
}
