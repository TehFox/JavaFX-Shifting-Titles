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
    private static celula [] listacelulas;
    private static final int MAXCELULAS=16;
    private Button botao;
    String valor;
    boolean letra=false;
    boolean romano=false;
    boolean valid=false;

    @Override
    public void start(Stage stage) throws Exception {
    	listacelulas= new celula[MAXCELULAS];

		MenuBar menuBar = new MenuBar();
        Pane root = new Pane();
         BorderPane border = new BorderPane();
         Menu fileMenu = new Menu("File");
		    //MenuItem binarioMenuItem = new MenuItem("Binario");
		    MenuItem letraMenuItem = new MenuItem("Letras");
		    letraMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			    public void handle(ActionEvent t) {
			        letra=true;
			        valid=false;
			        root.getChildren().remove(botao);
			    }
});
		    //letraMenuItem.setOnAction(actionEvent -> letra=true;valid=false);
		    MenuItem romanoMenuItem = new MenuItem("Romano");
		    //romanoMenuItem.setOnAction(actionEvent -> romano=true;valid=false);
		    romanoMenuItem.setOnAction(new EventHandler<ActionEvent>() {
						    public void handle(ActionEvent t) {
						        romano=true;
						        valid=false;
						        root.getChildren().remove(botao);
						    }
});
		    fileMenu.getItems().addAll(letraMenuItem,
        new SeparatorMenuItem(), romanoMenuItem);

		Menu inforMenu = new Menu("Informação");
		MenuItem classifiMenuItem = new MenuItem("Classificação");
		inforMenu.getItems().addAll(classifiMenuItem);
System.out.println("PUTA");


		do{
		 for(int i=0;i<4;i++)//Coluna
			{
				for(int a=0;a<4;a++)
				{
					System.out.printf("CRL");
					contador++;

					if(contador!=16){
						if(romano==true){
						botao = new Button("" + Romano[contador]);}
						if(letra==true){
							botao = new Button("" + Letra[contador]);}
							if(romano==false&&letra==false){
								botao = new Button("" + contador);
							}
					}

					else
					{
						botao = new Button("");
					}
			        final int numButton= contador;
			        final String numero;
			        numero="" + contador;
			        botao.setId(""+contador);
			        celula cel= new celula(numButton, numero, false, false);
			        botao.setPrefSize(150, 150);
			        botao.setStyle("-fx-font-size:42px");
			        botao.setOnAction(new EventHandler<ActionEvent>() {
			            @Override
			            public void handle(ActionEvent e) {
			                System.out.println("id(" + botao.getId() + ") =  " + numButton);
			            }
			        });
			        gridpane.add(botao, i, a);
				}
			}

valid=true;
}while(valid==false);
			romano=false;
			letra=false;
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
}