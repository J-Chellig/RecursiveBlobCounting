package blobCounting;

public class BlobBoard {
	
	private Boolean[][] boardOfBlobs;
	private Boolean[][] visitedMatrix;
	
	
	public BlobBoard(int size, double percentFill) {
		
		newBlobBoard(size, percentFill);
		
		visitedMatrix = new Boolean[size][size];
		
		resetVisitedMatrix();
	}


	
	public Boolean[][] getBoardOfBlobs() {
		return boardOfBlobs;
	}


	public Boolean[][] getVisitedMatrix() {
		return visitedMatrix;
	}
	
	
	public void newBlobBoard(int size, double probability) {
	
		boardOfBlobs = new Boolean[size][size];
		
     for(int i = 0; i < boardOfBlobs.length; i++) {
			
			{
				for(int j = 0; j < boardOfBlobs[0].length; j++) {
					
					
					if(Math.random() < probability) {
						
						boardOfBlobs[i][j] = true;
					} else {
						
						boardOfBlobs[i][j] = false;
						
					}
				}
			}
			
	}
		
	}
	public void resetVisitedMatrix() {
		
		for(int i = 0; i < visitedMatrix.length; i++) {
			
			
			for(int j = 0; j < visitedMatrix[0].length; j++) {
				
				visitedMatrix[i][j] = false;
				
				
			}
			
		}
		
		
	}
	
	
	public void findBlobAt(int row, int col) {
		
		if(row < 0 || row >= boardOfBlobs.length || col < 0 || col >= boardOfBlobs[0].length) {
			
			return;
			
		}
		
		if(boardOfBlobs[row][col] == false || visitedMatrix[row][col] == true) {
			
			return;
			
		}
		
		else {
			
			visitedMatrix[row][col] = true;
			
			findBlobAt(row + 1, col);
			findBlobAt(row - 1, col);
			findBlobAt(row, col + 1);
			findBlobAt(row, col - 1);
			}
		
		
		
		
	}
	
	public int countBlobSize() {
		
		int count = 0;
		
		for(int i = 0; i < boardOfBlobs.length; i++) {
			
			for(int j = 0; j < boardOfBlobs.length; j++) {
				
				if(visitedMatrix[i][j] == true) {count++;}
				
			}
			
		}
		
		return count;
	}

}
