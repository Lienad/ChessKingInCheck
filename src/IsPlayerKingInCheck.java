
public class IsPlayerKingInCheck {
	
	private ChessBoard chessBoard;
	private BoardPiece playerKingPiece;
	private String playerColor;
	
	public IsPlayerKingInCheck(String playerColor, String[] boardPieces){
		this.playerColor = playerColor;
		chessBoard = new ChessBoard(boardPieces);
		try{
			playerKingPiece = chessBoard.getPlayerKing(playerColor);
		}catch (Exception e){}
	}
	
	public boolean isPlayerKingPieceInCheck(){
		if (isPlayerKingInCheckFromPieceVerticallyUp()
				|| isPlayerKingInCheckFromPieceVerticallyDown()
				|| isPlayerKingInCheckFromPieceHorizontallyLeft()
				|| isPlayerKingInCheckFromPieceHorizontallyRight()
				|| isPlayerKingInCheckFromPieceDiagonallyUpLeft()
				|| isPlayerKingInCheckFromPieceDiagonallyUpRight()
				|| isPlayerKingInCheckFromPieceDiagonallyDownLeft()
				|| isPlayerKingInCheckFromPieceDiagonallyDownRight()
				|| isPlayerKingInCheckByOpponentKnight()){
			return true;
		}
		
		return false;
	}
	
	private boolean isPlayerKingInCheckFromPieceVerticallyUp() {
		for (int i=playerKingPiece.pieceLine+1; i<=8; i++){
			BoardSquare boardSquare = chessBoard.getBoardSquare(i, playerKingPiece.pieceColumn);
			if (boardSquare.containsBoardPiece()){
				if (i==playerKingPiece.pieceLine+1){
					if (boardSquare.containsOpponentKing(playerColor)){
						return true;
					}
				}
				if (boardSquare.containsOpponentRookOrQueen(playerColor)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	private boolean isPlayerKingInCheckFromPieceVerticallyDown() {
		for (int i=playerKingPiece.pieceLine - 1; i>=1; i--){
			BoardSquare boardSquare = chessBoard.getBoardSquare(i, playerKingPiece.pieceColumn);
			if (boardSquare.containsBoardPiece()){
				if (i==playerKingPiece.pieceLine-1){
					if (boardSquare.containsOpponentKing(playerColor)){
						return true;
					}
				}
				if (boardSquare.containsOpponentRookOrQueen(playerColor)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	private boolean isPlayerKingInCheckFromPieceHorizontallyLeft() {
		for (int j=playerKingPiece.pieceColumn - 1; j>=1; j--){
			BoardSquare boardSquare = chessBoard.getBoardSquare(playerKingPiece.pieceLine, j);
			if (boardSquare.containsBoardPiece()){
				if (j==playerKingPiece.pieceColumn-1){
					if (boardSquare.containsOpponentKing(playerColor)){
						return true;
					}
				}
				if (boardSquare.containsOpponentRookOrQueen(playerColor)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	private boolean isPlayerKingInCheckFromPieceHorizontallyRight() {
		for (int j=playerKingPiece.pieceColumn + 1; j<=8; j++){
			BoardSquare boardSquare = chessBoard.getBoardSquare(playerKingPiece.pieceLine, j);
			if (boardSquare.containsBoardPiece()){
				if (j==playerKingPiece.pieceColumn+1){
					if (boardSquare.containsOpponentKing(playerColor)){
						return true;
					}
				}
				if (boardSquare.containsOpponentRookOrQueen(playerColor)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	private boolean isPlayerKingInCheckFromPieceDiagonallyUpLeft() {
		for (int i=playerKingPiece.pieceLine + 1, j=playerKingPiece.pieceColumn-1; i<=8 && j>=1; i++, j--){
			BoardSquare boardSquare = chessBoard.getBoardSquare(i, j);
			if (boardSquare.containsBoardPiece()){
				if (i==playerKingPiece.pieceLine+1 && j==playerKingPiece.pieceColumn-1){
					if (boardSquare.containsOpponentKing(playerColor)){
						return true;
					}
				}
				if (boardSquare.containsOpponentBishopOrQueen(playerColor)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	private boolean isPlayerKingInCheckFromPieceDiagonallyUpRight() {
		for (int i=playerKingPiece.pieceLine + 1, j=playerKingPiece.pieceColumn+1; i<=8 && j<=8; i++, j++){
			BoardSquare boardSquare = chessBoard.getBoardSquare(i, j);
			if (boardSquare.containsBoardPiece()){
				if (i==playerKingPiece.pieceLine+1 && j==playerKingPiece.pieceColumn+1){
					if (boardSquare.containsOpponentKing(playerColor)){
						return true;
					}
				}
				if (boardSquare.containsOpponentBishopOrQueen(playerColor)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	private boolean isPlayerKingInCheckFromPieceDiagonallyDownLeft() {
		for (int i=playerKingPiece.pieceLine-1, j=playerKingPiece.pieceColumn-1; i>=1 && j>=1; i--, j--){
			BoardSquare boardSquare = chessBoard.getBoardSquare(i, j);
			if (boardSquare.containsBoardPiece()){
				if (i==playerKingPiece.pieceLine-1 && j==playerKingPiece.pieceColumn-1){
					if (boardSquare.containsOpponentKing(playerColor)){
						return true;
					}
				}
				if (boardSquare.containsOpponentBishopOrQueen(playerColor)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}

	private boolean isPlayerKingInCheckFromPieceDiagonallyDownRight() {
		for (int i=playerKingPiece.pieceLine-1, j=playerKingPiece.pieceColumn+1; i>=1 && i<=8; i--, j++){
			BoardSquare boardSquare = chessBoard.getBoardSquare(i, j);
			if (boardSquare.containsBoardPiece()){
				if (i==playerKingPiece.pieceLine-1 && j==playerKingPiece.pieceColumn+1){
					if (boardSquare.containsOpponentKing(playerColor)){
						return true;
					}
				}
				if (boardSquare.containsOpponentBishopOrQueen(playerColor)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	
	private boolean isPlayerKingInCheckByOpponentKnight(){
		int kingColumn = playerKingPiece.pieceColumn;
		int kingLine = playerKingPiece.pieceLine;
		if (kingLine + 2 <= 8 && kingColumn + 3 <= 8){
			BoardSquare boardSquare = chessBoard.getBoardSquare(kingColumn + 2, kingLine + 3);
			if (boardSquare.containsOpponentKnight(playerColor)){
				return true;
			}
		}
		if (kingLine + 3 <= 8 && kingColumn + 2 <= 8){
			BoardSquare boardSquare = chessBoard.getBoardSquare(kingColumn + 3, kingLine + 2);
			if (boardSquare.containsOpponentKnight(playerColor)){
				return true;
			}
		}
		if (kingLine + 3 <= 8 && kingColumn - 2 >= 1){
			BoardSquare boardSquare = chessBoard.getBoardSquare(kingColumn + 3, kingLine - 2);
			if (boardSquare.containsOpponentKnight(playerColor)){
				return true;
			}
		}
		if (kingLine + 2 <= 8 && kingColumn - 3 >= 1){
			BoardSquare boardSquare = chessBoard.getBoardSquare(kingColumn + 2, kingLine - 3);
			if (boardSquare.containsOpponentKnight(playerColor)){
				return true;
			}
		}
		if (kingLine - 2 >= 1 && kingColumn -3 >= 1){
			BoardSquare boardSquare = chessBoard.getBoardSquare(kingColumn - 2, kingLine - 3);
			if (boardSquare.containsOpponentKnight(playerColor)){
				return true;
			}
		}
		if (kingLine - 3 >= 1 && kingColumn - 2 >= 1){
			BoardSquare boardSquare = chessBoard.getBoardSquare(kingColumn - 3, kingLine - 2);
			if (boardSquare.containsOpponentKnight(playerColor)){
				return true;
			}
		}
		if (kingLine - 3 >= 1 && kingColumn + 2 <= 8){
			BoardSquare boardSquare = chessBoard.getBoardSquare(kingColumn - 3, kingLine + 2);
			if (boardSquare.containsOpponentKnight(playerColor)){
				return true;
			}
		}
		if (kingLine - 2 >= 1 && kingColumn + 3 <= 8){
			BoardSquare boardSquare = chessBoard.getBoardSquare(kingColumn - 2, kingLine + 3);
			if (boardSquare.containsOpponentKnight(playerColor)){
				return true;
			}
		}
		return false;
	}
	
}
