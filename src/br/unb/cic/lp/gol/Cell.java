package br.unb.cic.lp.gol;

public class Cell {
	private EstadoAbstrato estado;

	public boolean tentarMudarEstado() {		
		return estado.tentarMudarEstado(this);
	}
		
	public void setEstado(EstadoAbstrato proximoEstado)
	{
		estado = proximoEstado;
	}
	
	public Cell(int x, int y, Cell[][] tabuleiro, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.tabuleiro = tabuleiro;
		this.setWidth(width);
		this.setHeight(height);
		this.setEstado(new EstadoMorto());
	}
	
	private int x;
	private int y;
	private int width;
	private int height;
	private Cell[][] tabuleiro;

	/**
	 * @return the x ( largura [j] )
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y ( altura [i] )
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the tabuleiro
	 */
	public Cell[][] getTabuleiro() {
		return tabuleiro;
	}

	/**
	 * @param tabuleiro the tabuleiro to set
	 */
	public void setTabuleiro(Cell[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public EstadoAbstrato getEstado() {
		return this.estado;
	}
	
	
}
