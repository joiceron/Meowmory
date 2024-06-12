
public class Level {
	
	
	
	private  int points = 0;                                                                 // Initializes integers called points
	private  int level = 1;                                                                  // Initializes integers called level
	private  int numOfColors = 3;                                                            // Initializes integers called numOfColors
	
	private int pointsGiven = 10;
	private int pointsDeducted = 20;																					 
																							 
																							 
	public int getPoints() {                                                                 // Creates getter for points
		return points;                                                                       
	}                                                                                        
	public void setPoints(int points) {                                                      // Creates setter for points
		this.points = points;                                                    
	}                                                                            
	public int getLevel() {                                                                  // Creates getter for level
		return level;                                                               
	}                                                                               
	public void setLevel(int level) {                                                        // Creates setter for level
		this.level = level;                                                         
	}                                                                               
	public int getNumOfColors() {                                                            // Creates getter for NumOfColors
		return numOfColors;                                                                
	}                                                                                      
	public void setNumOfColors(int numOfColors) {                                            // Creates setter for NumOfColors
		this.numOfColors = numOfColors;                                                      
	}
	public int getPointsDeducted() {                                     				     // Creates getter for PointsDeducted
		return pointsDeducted;
	}
	public void setPointsDeducted(int pointsDeducted) {                                      // Creates setter for PointsDeducted
		this.pointsDeducted = pointsDeducted;
	}
	public int getPointsGiven() {                                          					// Creates setter for PointsGiven
		return pointsGiven;
	}
	public void setPointsGiven(int pointsGiven) {                                          	// Creates setter for PointsGiven
		this.pointsGiven = pointsGiven;
	}                                                                                        
			
}
