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

public class Main extends Application {

    private int contador = 0;
    private GridPane gridpane = new GridPane();
    Button botao;
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        
        for(int i=0;i<4;i++)//Coluna
		{
			for(int a=0;a<4;a++)
			{
				contador++;
				if(contador!=16)
					botao = new Button("" + contador);
				else
					botao = new Button("");
		        final int numButton= contador;
		        botao.setId("" + contador);
		        
		        botao.setPrefSize(150, 150);
		        botao.setStyle("-fx-font-size:42px");
		        botao.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent e) {
		                System.out.println("id(" + botao.getId()  + ") =  " + numButton);
		            }
		        });
		        gridpane.add(botao, i, a);
			}
		}
        root.getChildren().add(gridpane);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
  
    public static void main(String[] args) {
        launch(args);
    }
}