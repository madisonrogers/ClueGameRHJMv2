package experiment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class IntBoard {
private BoardCell[][] grid;
private Map<BoardCell, Set<BoardCell>> adjMatrix;
Set<BoardCell> visited = new HashSet<BoardCell>();
Set<BoardCell> targets = new HashSet<BoardCell>();
//private Set<BoardCell> keys;

public IntBoard() {
	grid = new BoardCell[4][];
	for (int i = 0; i < 4; i++){
	grid[i] = new BoardCell[4];
	}
	adjMatrix = new HashMap<BoardCell, Set<BoardCell>>();
	//keys = new HashSet<BoardCell>();
}
public void calcAdjacencies(){
	//if new spot valid, add to set and map 
	
	for (int i = 0; i < 4; i++){//rows
		for (int j = 0; j < 4; j++){//col
			BoardCell temp = new BoardCell();
			temp.setCol(j);
			temp.setRow(i);
			Set<BoardCell> list = new HashSet();
			if ((i-1) >= 0){//test left
				
				BoardCell temp2 = new BoardCell();
				temp2.setCol(j);
				temp2.setRow(i-1);
				list.add(temp2);
			}
			if ((i+1) < 4){//test right
				
				BoardCell temp2 = new BoardCell();
				temp2.setCol(j);
				temp2.setRow(i+1);
				list.add(temp2);
			}
			if ((j-1) >= 0){//test up
				
				BoardCell temp2 = new BoardCell();
				temp2.setCol(j-1);
				temp2.setRow(i);
				list.add(temp2);
			}
			if ((j+1) < 4){//test down
			
				BoardCell temp2 = new BoardCell();
				temp2.setCol(j+1);
				temp2.setRow(i);
				list.add(temp2);
			}
			adjMatrix.put(temp, list);
		}
	}	
	
	
	
}
public void calcTargets(BoardCell p, int counter){
	
	for(BoardCell key: adjMatrix.keySet()) {
		if ((key.getCol() == p.getCol()) && (key.getRow() == p.getRow())){
			visited.add(p);
		}
		if (counter == 1) {
			targets.add(p);
		}
		else {
			calcTargets(p, counter-1);
		}
		visited.remove(p);
	}
}
public Set<BoardCell> getTargets(BoardCell b){
	for (BoardCell key: adjMatrix.keySet()) {
		if ((key.getCol() == b.getCol()) && (key.getRow() == b.getRow())) {
			return adjMatrix.get(key);
		}
	}
	
	return adjMatrix.get(b);
}
public Set<BoardCell> getAdjList(BoardCell b){
	for (BoardCell key: adjMatrix.keySet()){
		if ((key.getCol() == b.getCol()) && (key.getRow() == b.getRow())){
			return adjMatrix.get(key);
		}
	}
	return adjMatrix.get(b);

}
public BoardCell getCell(int i, int j, int x, int z){
	BoardCell b = new BoardCell();
	b.setCol(j);
	b.setRow(i);
	
	BoardCell a = new BoardCell();
	a.setCol(z);
	a.setRow(x);
	
	for (BoardCell key: adjMatrix.keySet()){
		if ((key.getCol() == a.getCol()) && (key.getRow() == a.getRow())){
			for (BoardCell cell: adjMatrix.get(key)){
				if ((cell.getCol() == b.getCol()) && (cell.getRow() == b.getRow())){
					return cell;
				}
			}
		}
	}
	return null;
}
}
