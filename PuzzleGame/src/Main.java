import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import javax.swing.JOptionPane;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;


//Public class
@SuppressWarnings("unused")

public class Main extends Application{

	private static boolean vez=true;
	int numero=0;
	GridPane grid;
	Button button;

	//main
	public static void main(String [] args)
	{
		Application.launch(args);
	}//end main

	@Override
	//metodo start
	public void start(Stage myStage)
	{


		myStage.setTitle("JavaFX");
		Group root= new Group();
		Scene myScene = new Scene(root,500,500,Color.LIGHTBLUE);//definir tamanho da frame

		grid= new GridPane();
	 	MenuBar menuBar = new MenuBar();
	 	//menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
  		//.setTop(menuBar);

  		 Menu fileMenu = new Menu("File");
		    MenuItem newMenuItem = new MenuItem("New");
		    MenuItem saveMenuItem = new MenuItem("Save");
		    MenuItem exitMenuItem = new MenuItem("Exit");
		    exitMenuItem.setOnAction(actionEvent -> Platform.exit());

		    fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
		        new SeparatorMenuItem(), exitMenuItem);



		//grid.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		//grid.setMaxSize(500, 500);

		for(int i=0;i<4;i++)//Coluna
		{
			ColumnConstraints coluna = new ColumnConstraints();
			coluna.setPercentWidth(50);
			coluna.setFillWidth(true);
			RowConstraints linha = new RowConstraints(50);
			linha.setFillHeight(true);
			for(int a=0;a<4;a++)
			{
				numero++;
				button= new Button();
				button.setLayoutX(270);
				button.setLayoutY(70);
				button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				//button.setPrefWidth(200);
				//button.setPrefHeight(200);

				if(numero!=16)
					button.setText(""+numero);
				else
					button.setText("");

				button.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:blue;-fx-background-color:white;-fx-border-color:black;");
				 grid.add(button, i, a);
			     //grid.getChildren().add(button);
			}
			grid.getColumnConstraints().add(coluna);
			 grid.getRowConstraints().add(linha);
		}

		root.getChildren().add(grid);


		/*PROGRAMAÇÃO*/






		myStage.setScene(myScene);
		myStage.show();
	}



}//end Public Class