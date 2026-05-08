package domain;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Map {

	private int[][] mapTileNum;
	private Figure polygon;
	
	public Map(int level) {
		mapTileNum = new int[DimensionGame.MAXWORLDROW][DimensionGame.MAXWORLDCOL];
		loadMap(level);
	}
	
	public String getPathLevel(int currentLevel) {
		return "/level/level"+currentLevel+".txt";
	}

	public int[][] loadMap(int currentLevel) {
		try {
			String filePathMap = getPathLevel(currentLevel);
			InputStream is = getClass().getResourceAsStream(filePathMap);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			
			while (col < DimensionGame.MAXWORLDCOL && row < DimensionGame.MAXWORLDROW) {
				String line = br.readLine();
				
				while (col < DimensionGame.MAXWORLDCOL) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[row][col] = num;
					col++;
				}
				if (col == DimensionGame.MAXWORLDCOL) {
					col = 0;
					row++;
				}
			}
			br.close();
		
		} catch (Exception e){
			e.printStackTrace();
		}
		return mapTileNum;
	}
	
	public int[][] getMapTileNum() {
		return mapTileNum;
	}
	
}
