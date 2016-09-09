import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.SeparatorMenuItem;



public class Main extends Application {

	private int contador = 0;
	private String []Romano= {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI"};
	private String []Letra={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
	private GridPane gridpane = new GridPane();
	private static ArrayList<celula> listacelulas= new ArrayList<celula>();
	// private static final int MAXCELULAS=16;
	private Button [] botao= new Button[16];
	String valor;
	boolean letra=false;
	boolean romano=false;
	boolean valid=false;
	int ok=0;
	@Override
	public void start(Stage stage) throws Exception {

		MenuBar menuBar = new MenuBar();
		Pane root = new Pane();
		BorderPane border = new BorderPane();
		Menu fileMenu = new Menu("File");
		MenuItem letraMenuItem = new MenuItem("Letras");
		letraMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				letra=true;
				valid=false;
				root.getChildren().remove(gridpane);
				botoes();
			}
		});
		MenuItem romanoMenuItem = new MenuItem("Romano");
		romanoMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				romano=true;
				root.getChildren().remove(gridpane);
				botoes();

			}
		});

		MenuItem numeroMenuItem = new MenuItem("Numero");
		numeroMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				romano=false;
				letra=false;
				root.getChildren().remove(gridpane);
				botoes();

			}
		});

		botoes();

		/*for(ok=0;ok<16;ok++){
System.out.println(listacelulas.get(ok).getNum());
			botao[ok].setOnAction(new EventHandler<ActionEvent>() {
				public void handle (ActionEvent t){
					System.out.print(listacelulas.get(ok).getPos());

				}
			});
		}*/


		fileMenu.getItems().addAll(letraMenuItem,numeroMenuItem,
				new SeparatorMenuItem(), romanoMenuItem);
		Menu inforMenu = new Menu("Informação");
		MenuItem classifiMenuItem = new MenuItem("Classificação");
		inforMenu.getItems().addAll(classifiMenuItem);
		menuBar.getMenus().addAll(fileMenu,inforMenu);
		border.setTop(menuBar);
		border.setCenter(gridpane);
		root.getChildren().add(border);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	void botoes(){
		contador=0;
		for(int i=0;i<4;i++)//Coluna
		{
			for(int a=0;a<4;a++)
			{
				contador++;
				if(contador<16){
					if(romano==true){
						botao[contador-1] = new Button("" + Romano[contador-1]);
						celula cel= new celula((contador-1), Romano[contador-1], false, false);
						listacelulas.add(cel);
					}

					if(letra==true){
						botao[contador-1] = new Button("" + Letra[contador-1]);
						celula cel1= new celula((contador-1), Letra[contador-1], false, false);
						listacelulas.add(cel1);
					}

					if(romano==false&&letra==false){
						botao[contador-1] = new Button("" + contador);
						celula cel2= new celula((contador-1), String.valueOf(contador), false, false);
						listacelulas.add(cel2);
					}
				}
				else
				{
					botao[contador-1] = new Button("");
					celula cel2= new celula((contador-1), String.valueOf(contador), false, true);
					listacelulas.add(cel2);
				}



				final int numButton= contador;
				final String numero;
				numero="" + contador;
				botao[contador-1].setPrefSize(150, 150);
				botao[contador-1].setStyle("-fx-font-size:42px");
				
				
				/*TENTATIVA DE BOTOES EM ARRAY COM ACTION HANDLER
				 * for(ok=0;ok<16;ok++){
							botao[ok].setOnAction(new EventHandler<ActionEvent>() {
								public void handle (ActionEvent t){
									System.out.print(listacelulas.get(ok).getPos());

								}
							});
						}
				*/
				
				/*				botao[contador-1].setOnAction(new EventHandler<ActionEvent>() {
					public void handle (ActionEvent t){
							System.out.print(listacelulas.get(contador-1).getNum());

					}
				});*/

				gridpane.add(botao[contador-1], i, a);
			}
		}
		letra=false;
		romano=false;
	}




	void verificacao() {

		if(!listacelulas.get(contador-1).isHole()){

		}



	}


}