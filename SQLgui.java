import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.*;
import java.util.*;
 //System.out.println("ok1");
 
public class SQLgui extends Application{
//---------------------------------------------------------------------------//     
                                //START MAIN
//---------------------------------------------------------------------------//     
	public static void main(String [] args){		
		launch(args);
	} 
	
  @Override
    public void start(Stage primaryStage) {
		
		createSQLgui app = new createSQLgui();	
	    Scene scene  = new Scene(app.layout, 500,355);  			//add the layout to the scene	
 
		primaryStage.setMaximized(true);
		primaryStage.setFullScreen(true); 
        primaryStage.setTitle("DB app");         					//add a title
        primaryStage.setScene(scene);                       		//add the scene to the stage
        primaryStage.show();  
    }	
//---------------------------------------------------------------------------//     
                                //START MAIN
//---------------------------------------------------------------------------//  
}