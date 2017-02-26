package tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import experiment.BoardCell;
import experiment.IntBoard;

public class IntBoardTest {
	IntBoard board;
	@Before
	public void BuildBoard(){
		board = new IntBoard();
	}

	@Test
	public void testAdjacency0_0() {
		BoardCell cell = board.getCell(0, 0);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(1, 0)));
		assertTrue(testList.contains(board.getCell(0, 1)));
		assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacency3_3() {
		BoardCell cell = board.getCell(3, 3);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertTrue(testList.contains(board.getCell(3, 2)));
		assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacency1_3() {
		BoardCell cell = board.getCell(1, 3);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(0, 3)));
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertEquals(3, testList.size());
}
	@Test
	public void testAdjacency3_0() {
		BoardCell cell = board.getCell(3, 0);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(2, 0)));
		assertTrue(testList.contains(board.getCell(3, 1)));	
		assertEquals(2, testList.size());
	}
	@Test
	public void testAdjacency1_1() {
		BoardCell cell = board.getCell(1, 1);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(0, 1)));
		assertTrue(testList.contains(board.getCell(1, 0)));
		assertTrue(testList.contains(board.getCell(2, 1)));
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertEquals(4, testList.size());
	}
	@Test
	public void testAdjacency2_2() {
		BoardCell cell = board.getCell(2, 2);
		Set<BoardCell> testList = board.getAdjList(cell);
		assertTrue(testList.contains(board.getCell(1, 2)));
		assertTrue(testList.contains(board.getCell(3, 2)));
		assertTrue(testList.contains(board.getCell(2, 1)));
		assertTrue(testList.contains(board.getCell(2, 3)));
		assertEquals(4, testList.size());
	}
	@Test
	public void testTarget1(){
	BoardCell cell = board.getCell(0, 0);
	board.calcTargets(cell, 3);
	Set targets = board.getTargets();
	assertEquals(6, targets.size());
	assertTrue(targets.contains(board.getCell(3, 0)));
	assertTrue(targets.contains(board.getCell(2, 1)));
	assertTrue(targets.contains(board.getCell(0, 1)));
	assertTrue(targets.contains(board.getCell(1, 2)));
	assertTrue(targets.contains(board.getCell(0, 3)));
	assertTrue(targets.contains(board.getCell(1, 0)));
	}
	@Test
	public void testTarget2(){
	BoardCell cell = board.getCell(3, 2);
	board.calcTargets(cell, 4);
	Set targets = board.getTargets();
	assertEquals(7, targets.size());
	assertTrue(targets.contains(board.getCell(0,1)));
	assertTrue(targets.contains(board.getCell(0,3)));
	assertTrue(targets.contains(board.getCell(1,0)));
	assertTrue(targets.contains(board.getCell(1,2)));
	assertTrue(targets.contains(board.getCell(2,1)));
	assertTrue(targets.contains(board.getCell(3,0)));
	assertTrue(targets.contains(board.getCell(3,2)));
	}
	@Test
	public void testTarget3(){
	BoardCell cell = board.getCell(1, 2);
	board.calcTargets(cell, 2);
	Set targets = board.getTargets();
	assertEquals(4, targets.size());
	assertTrue(targets.contains(board.getCell(0,0)));
	assertTrue(targets.contains(board.getCell(1,1)));
	assertTrue(targets.contains(board.getCell(2,2)));
	assertTrue(targets.contains(board.getCell(3,1)));

	}
	@Test
	public void testTarget4(){
	BoardCell cell = board.getCell(0, 3);
	board.calcTargets(cell, 2);
	Set targets = board.getTargets();
	assertEquals(3, targets.size());
	assertTrue(targets.contains(board.getCell(0,1)));
	assertTrue(targets.contains(board.getCell(1,2)));
	assertTrue(targets.contains(board.getCell(2,3)));

	}
	@Test
	public void testTarget5(){
	BoardCell cell = board.getCell(1, 1);
	board.calcTargets(cell, 2);
	Set targets = board.getTargets();
	assertEquals(5, targets.size());
	assertTrue(targets.contains(board.getCell(0,0)));
	assertTrue(targets.contains(board.getCell(0,2)));
	assertTrue(targets.contains(board.getCell(2,0)));
	assertTrue(targets.contains(board.getCell(2,2)));
	assertTrue(targets.contains(board.getCell(3,1)));

	}
	@Test
	public void testTarget6(){
	BoardCell cell = board.getCell(2, 2);
	board.calcTargets(cell, 3);
	Set targets = board.getTargets();
	assertEquals(8, targets.size());
	assertTrue(targets.contains(board.getCell(0,1)));
	assertTrue(targets.contains(board.getCell(1,0)));
	assertTrue(targets.contains(board.getCell(2,1)));
	assertTrue(targets.contains(board.getCell(3,0)));
	assertTrue(targets.contains(board.getCell(3,2)));
	assertTrue(targets.contains(board.getCell(1,2)));
	assertTrue(targets.contains(board.getCell(0,3)));
	assertTrue(targets.contains(board.getCell(2,3)));
	}
	
}
