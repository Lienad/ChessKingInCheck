
public class BoardSquare {
	
	private BoardPiece boardPiece;
	
	public BoardSquare(){
		
	}
	
	public void setBoardPiece(BoardPiece boardPiece){
		this.boardPiece = boardPiece;
	}
	
	public BoardPiece getBoardPiece(){
		return boardPiece;
	}
	
	public boolean containsBoardPiece(){
		if (boardPiece != null){
			return true;
		}
		return false;
	}
	
	public boolean containsOpponentPiece(String playerColor){
		if (boardPiece != null){
			if (!boardPiece.pieceColor.equals(playerColor)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsOpponentQueen(String playerColor){
		if (containsOpponentPiece(playerColor)){
			if (boardPiece.pieceType.equals(BoardPiece.TYPE_QUEEN)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsPlayerPiece(String playerColor){
		if (boardPiece != null){
			if (boardPiece.pieceColor.equals(playerColor)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsOpponentBishopOrQueen(String playerColor){
		if (containsOpponentPiece(playerColor)){
			if (boardPiece.pieceType.equals(BoardPiece.TYPE_BISHOP)
					|| boardPiece.pieceType.equals(BoardPiece.TYPE_QUEEN)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsOpponentRookOrQueen(String playerColor){
		if (containsOpponentQueen(playerColor) || boardPiece.pieceType.equals(BoardPiece.TYPE_ROOK)){
			return true;
		}
		return false;
	}
	
	public boolean containsOpponentKing(String playerColor){
		if (containsOpponentPiece(playerColor)){
			if (boardPiece.pieceType.equals(BoardPiece.TYPE_KING)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsOpponentKnight(String playerColor){
		if (containsOpponentPiece(playerColor)){
			if (boardPiece.pieceType.equals(BoardPiece.TYPE_KNIGHT)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsOpponentPawn(String playerColor){
		if (containsOpponentPiece(playerColor)){
			if (boardPiece.pieceType.equals(BoardPiece.TYPE_PAWN)){
				return true;
			}
		}
		return false;
	}
}
