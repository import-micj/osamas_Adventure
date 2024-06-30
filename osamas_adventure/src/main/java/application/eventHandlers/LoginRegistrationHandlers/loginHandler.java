package application.eventHandlers.LoginRegistrationHandlers;

// --- Components --- //
import java.io.IOException;
import application.Main;
import application.eventHandlers.LobbyHandlers.lobbyHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class loginHandler 
{
    @FXML
    TextField usernameClientInput, passwordClientInput;

    private static boolean key1 = false, key2 = false, key3 = false, key4 = false, key5 = false;

    private Main main;
    private Parent root;
    private FXMLLoader loader;

    public void setMain(Main main)
    {
        this.main = main;
    }

    public void LoginButton(ActionEvent event) throws IOException
    {  
        if ("michael".equals(usernameClientInput.getText()) && "josh".equals(passwordClientInput.getText()))
        {
            // root = FXMLLoader.load(getClass().getResource("/sceneLayouts/lobbyScenes/lobbyScene_main.fxml"));
            // main.updateScene(root);

            loader = new FXMLLoader(getClass().getResource("/sceneLayouts/lobbyScenes/lobbyScene_main.fxml"));
            root = loader.load();
            lobbyHandler lobby = loader.getController();
            lobby.setMain(main);
            main.updateScene(root);            
        }
    }

    public void RegisterButton(ActionEvent event) throws IOException
    {
        loader = new FXMLLoader(getClass().getResource("/sceneLayouts/registrationScenes/registerUserPass.fxml"));
        root = loader.load();
        registrationHandler reg = loader.getController();
        reg.setMain(main);
        main.updateScene(root);
    }

    public void clearUsernameTextField(ActionEvent event)
    {
        usernameClientInput.setText("");
        usernameClientInput.requestFocus();
    }

    public void clearPasswordTextField(ActionEvent event)
    {
        passwordClientInput.setText("");
        passwordClientInput.requestFocus();
    }

    
    public void adminLogin(Scene windowScene) throws IOException
    {
        windowScene.setOnKeyPressed(new EventHandler<KeyEvent>() 
        {
            @Override
            public void handle(KeyEvent e) 
            {
                if (e.getCode() == KeyCode.SHIFT)
                {
                    key1 = true;
                }

                if (e.getCode() == KeyCode.CONTROL)
                {
                    key2 = true;
                }

                if (e.getCode() == KeyCode.BACK_SPACE)
                {
                    key3 = true;
                }

                if (e.getCode() == KeyCode.ALT)
                {
                    key4 = true;
                }

                if (e.getCode() == KeyCode.M)
                {
                    key5 = true;
                }

                if (key1 && key2 && key3 && key4 && key5 && "admin".equals(usernameClientInput.getText()) && "admin".equals(passwordClientInput.getText()))
                {
                    try {
                        root = FXMLLoader.load(getClass().getResource("/sceneLayouts/adminPanel/adminPanel.fxml"));
                    } catch (IOException e1) {
                        
                        e1.printStackTrace();
                    }
                    main.updateScene(root);
                }

            }
        });

        windowScene.setOnKeyReleased(new EventHandler<KeyEvent>() 
        {

            @Override
            public void handle(KeyEvent e) 
            {
                if (e.getCode() == KeyCode.SHIFT)
                {
                    key1 = false;
                }

                if (e.getCode() == KeyCode.CONTROL)
                {
                    key2 = false;
                }

                if (e.getCode() == KeyCode.BACK_SPACE)
                {
                    key3 = false;
                }

                if (e.getCode() == KeyCode.ALT)
                {
                    key4 = false;
                }

                if (e.getCode() == KeyCode.M)
                {
                    key5 = false;
                }
            }
        });

       

        
    }
}
