import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerKingInCheckByKnightTest {	
	
	private boolean testInCheckByKnight(String playerColor, String[] boardPieces){
		IsPlayerKingInCheck testScenario = new IsPlayerKingInCheck(playerColor, boardPieces);
		return testScenario.isPlayerKingPieceInCheck();
	}

	@Test
	public void testInCheckByKnightOneAboveTwoToTheRight() {
		String[] boardPieces = new String[]{"WKa1", "BNc2"};
		String playerColor = "W";
		boolean isKingInCheck = testInCheckByKnight(playerColor, boardPieces);
		assertTrue("knight", isKingInCheck);
	}

	@Test
	public void testInCheckByKnightTwoAboveOneToTheRight() {
		String[] boardPieces = new String[]{"WKa1", "BNb3"};
		String playerColor = "W";
		boolean isKingInCheck = testInCheckByKnight(playerColor, boardPieces);
		assertTrue("knight", isKingInCheck);
	}

	@Test
	public void testInCheckByKnightTwoAboveOneToTheLeft() {
		String[] boardPieces = new String[]{"WKd3", "BNc5"};
		String playerColor = "W";
		boolean isKingInCheck = testInCheckByKnight(playerColor, boardPieces);
		assertTrue("knight", isKingInCheck);
	}

	@Test
	public void testInCheckByKnightOneAboveTwoToTheLeft() {
		String[] boardPieces = new String[]{"WKf4", "BNd5"};
		String playerColor = "W";
		boolean isKingInCheck = testInCheckByKnight(playerColor, boardPieces);
		assertTrue("knight", isKingInCheck);
	}

	@Test
	public void testInCheckByKnightOneBelowTwoToTheLeft() {
		String[] boardPieces = new String[]{"WKe4", "BNc3"};
		String playerColor = "W";
		boolean isKingInCheck = testInCheckByKnight(playerColor, boardPieces);
		assertTrue("knight", isKingInCheck);
	}

	@Test
	public void testInCheckByKnightTwoBelowOneToTheLeft() {
		String[] boardPieces = new String[]{"WKg7", "BNf5"};
		String playerColor = "W";
		boolean isKingInCheck = testInCheckByKnight(playerColor, boardPieces);
		assertTrue("knight", isKingInCheck);
	}

}
