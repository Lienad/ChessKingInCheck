
public class Main {
	
	public static void main(String[] args){
		System.out.println(new IsPlayerKingInCheck("W", new String[]{"WKa1", "BQc3"}).isPlayerKingPieceInCheck());
		System.out.println(new IsPlayerKingInCheck("W", new String[]{"WKa1"}).isPlayerKingPieceInCheck());
	}

}
