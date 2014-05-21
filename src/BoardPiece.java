
public class BoardPiece {
	public static final char COLOR_WHITE = 'W';
	public static final char COLOR_BLACK = 'B';
	
	public static final String TYPE_KING = "K";
	public static final String TYPE_QUEEN = "Q";
	public static final String TYPE_ROOK = "R";
	public static final String TYPE_BISHOP = "B";
	public static final String TYPE_KNIGHT = "N";
	public static final String TYPE_PAWN = "P";
	
	public String pieceColor;
	public String pieceType;
	public int pieceColumn;
	public int pieceLine;
	
	public BoardPiece(String pieceInfo){
		pieceColor = pieceInfo.substring(0, 1);
		pieceType = pieceInfo.substring(1, 2);
		pieceColumn = getPieceColumnAsIntergerFromCharacter(pieceInfo.charAt(2));
		pieceLine = getPieceLineAsIntergerFromCharacter(pieceInfo.charAt(3));
	}
	
	private int getPieceColumnAsIntergerFromCharacter(char c){
        int offsetToStartValuesFrom1 = 96;
        int columnAsciiRepresentation = (int) c;
        return columnAsciiRepresentation - offsetToStartValuesFrom1;
	}
	
	private int getPieceLineAsIntergerFromCharacter(char c){
        int offsetToStartValuesFrom1 = 48;
        int lineAsciiRepresentation = (int) c;
        return lineAsciiRepresentation - offsetToStartValuesFrom1;
	}
}


