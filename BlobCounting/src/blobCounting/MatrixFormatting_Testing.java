package blobCounting;

/**A class which is used to check the output of the grids. Mainly used for testing purposes.
 * 
 * 
 */

public class MatrixFormatting_Testing {

	public static void printMatrix(Boolean[][] input) {
		
		for(int i = 0; i < input.length; i++) {
			
			System.out.println();
			
			for(int j = 0; j < input[0].length; j++) {
				
				System.out.print(input[i][j] + " ");
				
			}
			
			
			
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		BlobBoard test = new BlobBoard(5, 0.8);
		
		printMatrix(test.getBoardOfBlobs());
		
		test.findBlobAt(2, 3);
		
		System.out.println();
		System.out.println("Blob Identified");
		
		printMatrix(test.getVisitedMatrix());
		
		
		
	}
	
}
