import java.awt.event.ActionListener;
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

	private String []Romano= {"","I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI"};
	private String []Letra={"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
	private GridPane gridpane = new GridPane();
	private static ArrayList<celula> listacelulas= new ArrayList<celula>();
	private Button [] botao= new Button[16];
	boolean letra=false;
	boolean romano=false;
	boolean valid=false;
	Integer[] numesc = new Integer[16];
	private boolean botaopermi;
	private int var;
	private int var50;
	private int contador1=0;
	private int contador3;
	private int contador2=16;
	private int ok;
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
				botoes1();
			}
		});
		MenuItem romanoMenuItem = new MenuItem("Romano");
		romanoMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				romano=true;
				botoes1();
			}
		});

		MenuItem numeroMenuItem = new MenuItem("Numero");
		numeroMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				romano=false;
				letra=false;
				botoes1();

			}
		});
		botoes1();
		
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

	void botoes1(){
		contador1=0;
		contador2=16;
		contador3=0;
		var50=1;
		var=0;
		boolean tt = false;
		for(int i=0;i<4;i++)//Coluna
		{
			for(int a=0;a<4;a++)
			{
				contador1++;
				tt=false;
				if(contador1==16){
					botao[contador3] = new Button("Ultimo");
					celula cel2= new celula(16, "16", false, true);
					listacelulas.add(cel2);
					gridpane.add(botao[contador3], i, a);
				}else{			
					while(tt==false){
						var = (int)(Math.random() * 16 + 1);
						if(contador1!=1){
							for(var50=1;var50<numesc.length;var50++){
								if(numesc[var50]==null){
									numesc[var50]=0;
								}
								if(var==numesc[var50]){
									botaopermi=false;
									break;
								}
								else{
									botaopermi=true;
								}
							}
						}else{
							var50++;
							botaopermi=true;
						}
						if(botaopermi==true){
							contador2--;
							contador3++;
							if(romano==true){
								botao[contador3] = new Button("" + Romano[var]);
								celula cel2= new celula(contador3, String.valueOf(var), false, false);
								listacelulas.add(cel2);
							}

							if(letra==true){
								botao[contador3] = new Button("" + Letra[var]);
								celula cel2= new celula(contador3, String.valueOf(var), false, false);
								listacelulas.add(cel2);
							}

							if(romano==false&&letra==false){
								botao[contador3] = new Button("" + var);
								celula cel2= new celula(contador3, String.valueOf(var), false, false);
								listacelulas.add(cel2);
							}			
							numesc[contador2] = var;

							/*  botao[contador3].setOnAction(new EventHandler<ActionEvent>() {
						            @Override
						            public void handle(ActionEvent e) {
						                System.out.println(listacelulas.get(contador3).getPos());
						            }
						        });

							 */
							gridpane.add(botao[contador3], i, a);
							tt=true;
						}

					}
				}
				botao[contador3].setPrefSize(150, 150);
				botao[contador3].setStyle("-fx-font-size:42px");}
		}
		letra=false;
		romano=false;
	}

	void verificacao() {


		for(ok=0;ok<contador3;ok++){
			botao[contador3].setOnAction(new EventHandler<ActionEvent>() {
				public void handle (ActionEvent t){
					System.out.println("hey");

				}
			});
		}


	}


}