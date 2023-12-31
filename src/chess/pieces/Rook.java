package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position pos = new Position(0, 0);

		// above (cima)
		pos.setValues(position.getRow() - 1, position.getColumn());
		//enquanto a posição "pos" existir e não tiver peça lá marque a posição como verdadeira
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setRow(pos.getRow() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// left (esquerda)
		pos.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setColumn(pos.getColumn() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// right (direita)
		pos.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setColumn(pos.getColumn() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// below (abaixo)
		pos.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
			pos.setRow(pos.getRow() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		return matriz;
	}

}
