
public class ChessBoard {
	
	//will assume that white starts at top of board
	//black is at bottom of board
	
	private BoardSquare[][] boardSquares = new BoardSquare[8][8];
	
	public ChessBoard(String[] boardPieces){
		initChessBoardSquares();
		for (String boardPieceInfo: boardPieces){
			BoardPiece boardPiece = new BoardPiece(boardPieceInfo);
			boardSquares[boardPiece.pieceLine-1][boardPiece.pieceColumn-1].setBoardPiece(boardPiece);
		}
		System.out.println(displayBoard());
	}
	
	private void initChessBoardSquares(){
		for (int i=0; i<boardSquares.length; i++){
			for (int j=0; j<boardSquares[i].length; j++){
				boardSquares[i][j] = new BoardSquare();
			}
		}
	}
	
	public BoardSquare getBoardSquare(int line, int column){
		return boardSquares[line-1][column-1];
	}
	
	public BoardPiece getPlayerKing(String playerColor) throws Exception{
		
		for (int i=0; i<boardSquares.length; i++){
			for (int j=0; j<boardSquares[i].length; j++){
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
	
	public String displayBoard(){
		String boardDisplay = "0 a b c d e f g h";
		
		for (int i=boardSquares.length - 1; i>=0; i--){
			boardDisplay += "\n";
			boardDisplay += i+1;
			for (int j=0; j<boardSquares[i].length; j++){
				if (boardSquares[i][j].containsBoardPiece()){
					BoardPiece boardPiece = boardSquares[i][j].getBoardPiece();
					boardDisplay += " " + boardPiece.pieceType;
				}else{
					boardDisplay += "  ";
				}
			}
		}
		
		return boardDisplay;
	}
	
}
