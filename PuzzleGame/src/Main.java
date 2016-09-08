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
    private GridPane gridpane = new GridPane();
    private static celula [] listacelulas;
    private static final int MAXCELULAS=16;
    String valor;
    @Override
    public void start(Stage stage) throws Exception {
    	listacelulas= new celula[MAXCELULAS];
    	
		MenuBar menuBar = new MenuBar();
        Pane root = new Pane();
         BorderPane border = new BorderPane();
         Menu fileMenu = new Menu("File");
		    MenuItem binarioMenuItem = new MenuItem("Binario");
		    MenuItem letraMenuItem = new MenuItem("Letras");
		    MenuItem romanoMenuItem = new MenuItem("Romano");
		    fileMenu.getItems().addAll(binarioMenuItem, letraMenuItem,
        new SeparatorMenuItem(), romanoMenuItem);

	Menu inforMenu = new Menu("Informação");
		MenuItem classifiMenuItem = new MenuItem("Classificação");
		inforMenu.getItems().addAll(classifiMenuItem);


		 for(int i=0;i<4;i++)//Coluna
			{
				for(int a=0;a<4;a++)
				{
					contador++;
					final Button botao;
					if(contador!=16)
						botao = new Button("" + contador);
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