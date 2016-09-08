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
    static Button botao;
    private int c;
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
					 ;
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
			           
			                String aux= botao.getId();
			                
			                
			                for(c=0;c<MAXCELULAS;c++)
			                {
			                	if(botao.getId().equals("16"))
			                	{
			                		botao.setId(aux);
			                		System.out.println("id(" + botao.getId() + ") =  " + numButton);
			                	}
			                		break;
			                }
			                
			                botao.setId("16");
			                System.out.println("id(" + botao.getId() + ") =  " + numButton);
			            	/*listacelulas[c].setPos(16);
			            	
			            	listacelulas[16].setPos(c);
			            	atualizar();*/
			                
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
    
    private void atualizar()
    {
    	for(int i=0;i<contador;i++)
    	{
    		switch (listacelulas[i].getPos()) {
			case 1:{
				gridpane.setColumnIndex(botao, 0);
				gridpane.setRowIndex(botao, 0);
				break;
			}
			case 2:{
				gridpane.setColumnIndex(botao, 0);
				gridpane.setRowIndex(botao, 1);
				break;
			}
			case 3:{
				gridpane.setColumnIndex(botao, 0);
				gridpane.setRowIndex(botao, 2);
				break;
			}
			case 4:{
				gridpane.setColumnIndex(botao, 0);
				gridpane.setRowIndex(botao, 3);
				break;
			}
			case 5:{
				gridpane.setColumnIndex(botao, 1);
				gridpane.setRowIndex(botao, 0);
				break;
			}
			case 6:{
				gridpane.setColumnIndex(botao, 1);
				gridpane.setRowIndex(botao, 1);
				break;
			}
			case 7:{
				gridpane.setColumnIndex(botao, 1);
				gridpane.setRowIndex(botao, 2);
				break;
			}
			case 8:{
				gridpane.setColumnIndex(botao, 1);
				gridpane.setRowIndex(botao, 3);
				break;
			}
			case 9:{
				gridpane.setColumnIndex(botao, 2);
				gridpane.setRowIndex(botao, 0);
				break;
			}
			case 10:{
				gridpane.setColumnIndex(botao, 2);
				gridpane.setRowIndex(botao, 1);
				break;
			}
			case 11:{
				gridpane.setColumnIndex(botao, 2);
				gridpane.setRowIndex(botao, 2);
				break;
			}
			case 12:{
				gridpane.setColumnIndex(botao, 2);
				gridpane.setRowIndex(botao, 3);
				break;
			}
			case 13:{
				gridpane.setColumnIndex(botao, 3);
				gridpane.setRowIndex(botao, 0);
				break;
			}
			case 14:{
				gridpane.setColumnIndex(botao, 3);
				gridpane.setRowIndex(botao, 1);
				break;
			}
			case 15:{
				gridpane.setColumnIndex(botao, 3);
				gridpane.setRowIndex(botao, 2);
				break;
			}
			case 16:{
				gridpane.setColumnIndex(botao, 3);
				gridpane.setRowIndex(botao, 3);
				break;
			}

			default:
				break;
			}
    	}
    }

    public static void main(String[] args) {
        launch(args);
    }
}