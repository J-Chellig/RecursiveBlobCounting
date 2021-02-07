package blobCounting;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;






public class GUI extends Application {
	
	DrawingLogic mainDrawing = new DrawingLogic();
	
	
	Button redraw = new Button("Redraw");
	
	
	Label stateProb = new Label("Fill Probability:");
	Label squareNo = new Label("No of Rows:");
	Label details = new Label("Click a Square");
	
	
	TextField probInput = new TextField();
	TextField squareInput = new TextField();
	
	private double width = 600;
	private double height = 600;
	
	public void start(Stage stage) {
	   
	   mainDrawing.setBlobBoard(20, 0.5);
	   mainDrawing.drawCurrent();
	  
	   //Mouse click Logic
	   mainDrawing.getPrimaryCanvas().setOnMousePressed(evt -> onMouseClick(evt));
	   
	   //Logic for the reDraw Button
	   redraw.setDefaultButton(true);
	   
	   redraw.setOnAction(e -> {
		   
		  reDrawBoard();
		  });
	   
	  //Location of objects in the scene.
	  HBox buttonBar = new HBox(20, redraw, stateProb, probInput, squareNo, squareInput);
	  Pane root = new Pane(mainDrawing.getPrimaryCanvas(), buttonBar, details);
	
	  mainDrawing.getPrimaryCanvas().relocate(width/2 - 250, 10);
	  buttonBar.relocate(width/2 - 285, height - 50);
	  details.relocate(width/2 - 100, height - 80);
	  
	  
	  //Generate Scene
	   Scene scene = new Scene(root, width, height);
	   stage.setScene(scene);
	   stage.setResizable(false);
	   stage.setTitle("Blob Counting");
	   stage.show();
	   
   }
	

	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	//Get's the Coords of the MouseEvent, and sends it to the DrawingLogic object.
	public void onMouseClick(MouseEvent evt) {
		
		mainDrawing.doMouseEvent(evt.getX(), evt.getY());
		updateBlobLabel(evt.getX(), evt.getY());
	
	}
	
	//Initialises a new board, based on the textfield inputs.
	public void reDrawBoard() {
		
		mainDrawing.setBlobBoard(textFieldInt(), textFieldInput());
		mainDrawing.getBlobBoard().resetVisitedMatrix();
		mainDrawing.drawCurrent();
		details.setText("Click a Square!");
		
		
	}
	
	
	
	//Handles Validation of textInput
	public double textFieldInput() {
		
		try {
			
			double output = Double.parseDouble(probInput.getText());
			
			if(output >= 1) { return 1;}
			if(output <= 0) {return 0;}
			else { return output;}
			
			
		} catch(NumberFormatException e) {
			
			return 0;
		}
		
	}
	public int textFieldInt() {
		
       try {
			
			int output = Integer.parseInt(squareInput.getText());
			
			if(output <= 0) {return 1;}
			else { return output;}
			
			
		} catch(NumberFormatException e) {
			
			return 1;
		}
	}	
	
	
	//Uses data from mouse click to update label
	public void updateBlobLabel(double x, double y) {
		
		int rowNo = mainDrawing.convertToCoord(x);
		int colNo = mainDrawing.convertToCoord(y);
		
		int blobcount = mainDrawing.getBlobBoard().countBlobSize();
		
		details.setText("For the Blob at" + " (" + rowNo + ", " + colNo + "), there are " + blobcount + " square(s)!");
		
		
		
	}
       
		
		
		
		
		
		
		
		
		
		
		
	
	

}
