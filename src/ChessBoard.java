
public class ChessBoard {
	
	//will assume that white starts at top of board
	//black is at bottom of board
	
	private BoardSquare[][] boardSquares = new BoardSquare[9][9];
	
	public ChessBoard(String[] boardPieces){
		initChessBoardSquares();
		for (String boardPieceInfo: boardPieces){
			BoardPiece boardPiece = new BoardPiece(boardPieceInfo);
			System.out.println(boardPieceInfo);
			boardSquares[boardPiece.pieceColumn][boardPiece.pieceLine].setBoardPiece(boardPiece);
		}
	}
	
	private void initChessBoardSquares(){
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				boardSquares[i][j] = new BoardSquare();
			}
		}
	}
	
	public BoardSquare getBoardSquare(int line, int column){
		return boardSquares[line-1][column-1];
	}
	
	public BoardPiece getPlayerKing(String playerColor) throws Exception{
		
		for (int i=0; i<Math.sqrt(boardSquares.length); i++){
			for (int j=0; j<Math.sqrt(boardSquares.length); j++){
				BoardPiece boardPiece = boardSquares[i][j].getBoardPiece();
				if (boardPiece != null){
					if (boardPiece.pieceColor.equals(playerColor) && boardPiece.pieceType.equals(BoardPiece.TYPE_KING)){
						return boardPiece;
					}
				}
			}
		}
		
		throw new Exception();
	}
	
}
