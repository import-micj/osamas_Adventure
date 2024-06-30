package application.eventHandlers.LobbyHandlers;

import application.Main;
import application.eventHandlers.LoginRegistrationHandlers.loginHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class lobbyHandler 
{
    private FXMLLoader loader;
    private Parent root;
    private Main main;

    public void setMain(Main main)
    {
        this.main = main;
    }

    public void account_Logout(ActionEvent event) throws Exception
    {
        loader = new FXMLLoader(getClass().getResource("/sceneLayouts/loginScenes/loginScene.fxml"));
        root = loader.load();
        loginHandler log = loader.getController();
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

    public void account_Delete(ActionEvent event)
    {
        System.out.println("Account Deleted");
    }
}
