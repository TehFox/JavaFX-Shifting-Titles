import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import javax.swing.JOptionPane;

//	Pilinhas e coninhas

//Public class
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
		grid.setPrefSize(500, 00);
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
	 
	     
	     
		/*
		titulo.setLayoutX(90);
		titulo.setLayoutY(30);
		titulo.setStyle("-fx-font-family:verdana;-fx-font-size:25px;-fx-text-fill:Blue;-fx-font-weight:bold;");
		root.getChildren().add(titulo);


			/*-----------------------------------jogo-----------------------------------------*/

				//primeira linha
				/*Button b1= new Button();
				b1.setLayoutX(30);
				b1.setLayoutY(70);
				b1.setPrefWidth(100);
				b1.setPrefHeight(100);
				b1.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:white;;");//definir edição da botão
				b1.setOnAction(new EventHandler <ActionEvent>(){
							public void handle(ActionEvent e){
								if(a1==0)
								{
								if(vez==true)
										{
										b1.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:green;");
										vez=false;
										a1=1;
										}
										else
										{
										b1.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:red;;");
										vez=true;
										a1=2;
										}verifica();
									}
								}});
				root.getChildren().add(b1);

				Button b2= new Button();
				b2.setLayoutX(150);
				b2.setLayoutY(70);
				b2.setPrefWidth(100);
				b2.setPrefHeight(100);
				b2.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:white;;");//definir edição da botão
				b2.setOnAction(new EventHandler <ActionEvent>(){
								public void handle(ActionEvent e){
									if(a2==0)
									{
									if(vez==true)
									{

									b2.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:green;");
									vez=false;
									a2=1;
									}
									else
									{
										a2=2;
									b2.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:red;;");
									vez=true;
								}verifica();}

								}});
				root.getChildren().add(b2);

				Button b3= new Button();
				b3.setLayoutX(270);
				b3.setLayoutY(70);
				b3.setPrefWidth(100);
				b3.setPrefHeight(100);
				b3.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:blue;-fx-background-color:white;");//definir edição da botão
				b3.setOnAction(new EventHandler <ActionEvent>(){
								public void handle(ActionEvent e){
									if(a3==0)
									{
									if(vez==true)
									{
									b3.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:green;;");
									vez=false;
									a3=1;
									}
									else
									{
									b3.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:red;;");
									vez=true;
									a3=2;
										}verifica();}

								}});
				root.getChildren().add(b3);
				//end primeira linha

				//segunda linha
								Button b4= new Button();
								b4.setLayoutX(30);
								b4.setLayoutY(190);
								b4.setPrefWidth(100);
								b4.setPrefHeight(100);
								b4.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:white;;");//definir edição da botão
								b4.setOnAction(new EventHandler <ActionEvent>(){
											public void handle(ActionEvent e){
												if(a4==0)
												{
												if(vez==true)
														{
														b4.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:green;");
														vez=false;
														a4=1;
														}
														else
														{
														b4.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:red;;");
														vez=true;
														a4=2;
														}verifica();
													}
												}});
								root.getChildren().add(b4);

								Button b5= new Button();
								b5.setLayoutX(150);
								b5.setLayoutY(190);
								b5.setPrefWidth(100);
								b5.setPrefHeight(100);
								b5.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:white;;");//definir edição da botão
								b5.setOnAction(new EventHandler <ActionEvent>(){
												public void handle(ActionEvent e){
													if(a5==0)
													{
													if(vez==true)
													{

													b5.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:green;");
													vez=false;
													a5=1;
													}
													else
													{
														a5=2;
													b5.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:red;;");
													vez=true;
												}verifica();}

												}});
								root.getChildren().add(b5);

								Button b6= new Button();
								b6.setLayoutX(270);
								b6.setLayoutY(190);
								b6.setPrefWidth(100);
								b6.setPrefHeight(100);
								b6.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:blue;-fx-background-color:white;");//definir edição da botão
								b6.setOnAction(new EventHandler <ActionEvent>(){
												public void handle(ActionEvent e){
													if(a6==0)
													{
													if(vez==true)
													{
													b6.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:green;;");
													vez=false;
													a6=1;
													}
													else
													{
													b6.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:red;;");
													vez=true;
													a6=2;
														}verifica();}

												}});
								root.getChildren().add(b6);
				//end segunda linha

				//terceira linha
												Button b7= new Button();
												b7.setLayoutX(30);
												b7.setLayoutY(310);
												b7.setPrefWidth(100);
												b7.setPrefHeight(100);
												b7.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:white;;");//definir edição da botão
												b7.setOnAction(new EventHandler <ActionEvent>(){
															public void handle(ActionEvent e){
																if(a7==0)
																{
																if(vez==true)
																		{
																		b7.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:green;");
																		vez=false;
																		a7=1;
																		}
																		else
																		{
																		b7.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:red;;");
																		vez=true;
																		a7=2;
																		}verifica();
																	}
																}});
												root.getChildren().add(b7);

												Button b8= new Button();
												b8.setLayoutX(150);
												b8.setLayoutY(310);
												b8.setPrefWidth(100);
												b8.setPrefHeight(100);
												b8.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:white;;");//definir edição da botão
												b8.setOnAction(new EventHandler <ActionEvent>(){
																public void handle(ActionEvent e){
																	if(a8==0)
																	{
																	if(vez==true)
																	{

																	b8.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:green;");
																	vez=false;
																	a8=1;
																	}
																	else
																	{
																	a8=2;
																	b8.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:red;;");
																	vez=true;
																}

																verifica();}

																}});
												root.getChildren().add(b8);

												Button b9= new Button();
												b9.setLayoutX(270);
												b9.setLayoutY(310);
												b9.setPrefWidth(100);
												b9.setPrefHeight(100);
												b9.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:blue;-fx-background-color:white;");//definir edição da botão
												b9.setOnAction(new EventHandler <ActionEvent>(){
																public void handle(ActionEvent e){
																	if(a9==0)
																	{
																	if(vez==true)
																	{
																	b9.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:green;;");
																	vez=false;
																	a9=1;
																	}
																	else
																	{
																	b9.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:red;;");
																	vez=true;
																	a9=2;
																		}
																		verifica();
																		}

																}});
												root.getChildren().add(b9);
				//end terceira linha










			/*--------------------------------------------------------------------------------*/

		/*Button bt1= new Button();
		bt1.setText("Jogar");
		bt1.setLayoutX(60);
		bt1.setLayoutY(300);
		bt1.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:blue;-fx-background-color:white;");//definir edição da botão
		bt1.setOnAction(new EventHandler <ActionEvent>(){
						public void handle(ActionEvent e){


						}});
		root.getChildren().add(bt1);

		Button bt2= new Button();
				bt2.setText("Novo");
				bt2.setLayoutX(150);
				bt2.setLayoutY(300);
				bt2.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:blue;-fx-background-color:white;;");//definir edição da botão
				bt2.setOnAction(new EventHandler <ActionEvent>(){
					public void handle(ActionEvent e){



						}});

		root.getChildren().add(bt2);

		Button bt3= new Button();
						bt3.setText("Sair");
						bt3.setLayoutX(240);
						bt3.setLayoutY(300);
						bt3.setStyle("-fx-font-family:verdana;-fx-font-size:14px;-fx-text-fill:Blue;-fx-background-color:white;;");//definir edição da botão
						bt3.setOnMouseClicked(actionEvent -> Platform.exit());
		root.getChildren().add(bt3);*/


		myStage.setScene(myScene);
		myStage.show();
	}

/*public static void verifica()
{
	if(a1==1 && a2==1 && a3==1 || a4==1 && a5==1 && a6==1 || a7==1 && a8==1 && a9==1)//jogador 1 ganhar linhas
	{
		JOptionPane.showMessageDialog(null,"Ganhou o Jogador 1");
	}else if(a1==2 && a2==2 && a3==2 || a4==2 && a5==2 && a6==2 || a7==2 && a8==2 && a9==2)//jogador 2 ganhar linhas
	{
		JOptionPane.showMessageDialog(null,"Ganhou o Jogador 2");
	}else if(a1==1 && a4==1 && a7==1 || a2==1 && a5==1 && a8==1 || a3==1 && a7==1 && a9==1)//jogador 1 ganhar colunas
	{
		JOptionPane.showMessageDialog(null,"Ganhou o Jogador 1");
	}else if(a1==2 && a4==2 && a7==2 || a2==2 && a5==2 && a8==2 || a3==2 && a7==2 && a9==2)//jogador 2 ganhar colunas
	{
		JOptionPane.showMessageDialog(null,"Ganhou o Jogador 2");
	}else if(a1==1 && a5==1 && a9==1 || a3==1 && a5==1 && a7==1 )//jogador 1 ganhar cruzadas
	{
		JOptionPane.showMessageDialog(null,"Ganhou o Jogador 1");
	}else if(a1==2 && a5==2 && a9==2 || a3==2 && a5==2 && a7==2 )//jogador 2 ganhar cruzadas
	{
		JOptionPane.showMessageDialog(null,"Ganhou o Jogador 2");
	}
}*/

}//end Public Class