package blobCounting;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
/** A class which is involved representing the state of the Blob board. 
 * 
 * @author Jordan
 *
 */
public class DrawingLogic {
	
	public static final double CANVASSIZE = 500;
	
	private Canvas primaryCanvas = new Canvas(CANVASSIZE, CANVASSIZE);
	
	private BlobBoard currentBoard;
	
	private GraphicsContext g = primaryCanvas.getGraphicsContext2D();
	
	private double squareSize; 
	
	
	public void setBlobBoard(int size, double probability) {
		
	  currentBoard = new BlobBoard(size, probability);
		
	  squareSize = CANVASSIZE/ currentBoard.getBoardOfBlobs().length;
	}
	

	
	public Canvas getPrimaryCanvas() {
		return primaryCanvas;
	}
	
	public BlobBoard getBlobBoard() {
		return this.currentBoard;
	}
	



	private void drawGridLines() {
		
		g.setStroke(Color.BLACK);
		g.setLineWidth(2);
		
		for(int i = 0; i <= currentBoard.getBoardOfBlobs().length; i++) {
			
			g.strokeLine(i*squareSize, 0, i*squareSize, CANVASSIZE);
		}
		
       for(int j = 0; j <= currentBoard.getBoardOfBlobs().length; j++) {
			
			g.strokeLine(0, j*squareSize, CANVASSIZE, j*squareSize);
		}
		
	}
	
	private void drawSquares() {
		
		
		for(int i = 0; i < currentBoard.getBoardOfBlobs().length; i++) {
			
			for(int j = 0; j < currentBoard.getBoardOfBlobs()[0].length; j++) {
				
				if(currentBoard.getBoardOfBlobs()[i][j] == false) {
					
					g.setFill(Color.WHITE);
					
				} else {
					
					if(currentBoard.getVisitedMatrix()[i][j] == true) {
						
						g.setFill(Color.BLACK);
						
					} else {
						
						g.setFill(Color.GRAY);
					}
					
				}
				
				g.fillRect(i*squareSize, j*squareSize, squareSize, squareSize);
			}
			
			
			
		}
	}
	
	public void drawCurrent() {
	
	  drawSquares();
	  drawGridLines();

}

public void doMouseEvent(double x, double y) {
	
	currentBoard.resetVisitedMatrix();
	
	int rowNumber = convertToCoord(x); 
	int colNumber = convertToCoord(y);
	
	currentBoard.findBlobAt(rowNumber, colNumber);
	
	drawCurrent();
}
	
public int convertToCoord(double input){
	
	return
			(int)(((input+0.1) - input%squareSize)/squareSize);
	
	
	
}	
	
	
	
	

}
