import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Game {
  int[][] grid = new int[12][12];
	public Game(){
		
	}
	
	public void addCell(int x, int y){
		grid[x][y] = 1;
	}

	public void update(){
		int newgrid[][] = new int[12][12];
		for(int i = 1; i < 11; i++){
			for(int j = 1; j < 11; j++){
				if(grid[i][j] == 1){
					int neighbors = grid[i-1][j] + grid[i+1][j] + grid[i][j-1] + grid[i][j+1];
					neighbors += grid[i-1][j-1] + grid[i+1][j-1] + grid[i-1][j+1] + grid[i+1][j+1];
					if(neighbors == 2 || neighbors == 3){
						newgrid[i][j] = 1;
					}
				} else{
					int neighbors = grid[i-1][j] + grid[i+1][j] + grid[i][j-1] + grid[i][j+1];
					neighbors += grid[i-1][j-1] + grid[i+1][j-1] + grid[i-1][j+1] + grid[i+1][j+1];
					if(neighbors == 3){
						newgrid[i][j] = 1;
					}
				}
			}
		}
		grid = newgrid;
	}
}