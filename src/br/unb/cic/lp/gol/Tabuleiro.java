package br.unb.cic.lp.gol;

public class Tabuleiro {
	private int height;
	private int width;
	private Cell[][] cells;
	
	private int windowX;
	private int windowY;
	
	
	
	/**
	 * @return the windowX
	 */
	public int getWindowX() {
		return windowX;
	}

	/**
	 * @param windowX the windowX to set
	 */
	public void setWindowX(int windowX) {
		this.windowX = windowX;
	}

	/**
	 * @return the windowY
	 */
	public int getWindowY() {
		return windowY;
	}

	/**
	 * @param windowY the windowY to set
	 */
	public void setWindowY(int windowY) {
		this.windowY = windowY;
	}
	
	private TemplateRegraGoL regra;

	public Tabuleiro(int initialHeight, int initalWidth, TemplateRegraGoL regra)
	{
		this.height = initialHeight;
		this.width = initalWidth;
		this.regra = regra;
		this.windowX = 0;
		this.windowY = 0;
		
		cells = new Cell[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[i][j] = new Cell(j, i, cells, width, height, regra);
			}
		}
	}
	
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	public Cell getCell(int y, int x)
	{
		return this.cells[y][x];
	}
	
	
	
	public void checarCrescimento()
	{
		boolean deveCrescer = false;
		for (int i = 0; i < getWidth(); i++)
		{
			if (! (cells[0][i].getEstado() instanceof EstadoMorto)) {
				deveCrescer = true;
			}
		}
		for (int i = 0; i < getWidth(); i++)
		{
			if (! (cells[getHeight()-1][i].getEstado() instanceof EstadoMorto)) {
				deveCrescer = true;
			}
		}
		for (int i = 0; i < getHeight(); i++)
		{
			if (! (cells[i][0].getEstado() instanceof EstadoMorto)) {
				deveCrescer = true;
			}
		}
		for (int i = 0; i < getHeight(); i++)
		{
			if (! (cells[i][getWidth()-1].getEstado() instanceof EstadoMorto)) {
				deveCrescer = true;
			}
		}
		
		if (deveCrescer)
		{
			Cell[][] tmp = this.cells;
			this.cells = new Cell[this.getHeight() + 10][this.getWidth() + 10];
			
			for (int i = 0; i < this.getHeight() + 10; i++) {
				for (int j = 0; j < this.getWidth() + 10; j++) {
					this.cells[i][j] = new Cell(j, i, this.cells, this.getWidth() + 10, this.getHeight() + 10, regra);
				}
			}
			
			
			
			for (int i = 5; i < this.getHeight()+5;i++)
			{
				for (int j = 5; j < this.getWidth()+5;j++)
				{
					this.cells[i][j] = tmp[i-5][j-5];
					this.cells[i][j].setTabuleiro(this.cells);
					this.cells[i][j].setX(j);
					this.cells[i][j].setY(i);
					this.cells[i][j].setHeight(this.getHeight() + 10);
					this.cells[i][j].setWidth(this.getWidth() + 10);
				}
			}
			
			this.setWindowX(this.getWindowX() + 5);
			this.setWindowY(this.getWindowY() + 5);
			
			this.setHeight(this.getHeight() + 10);
			this.setWidth(this.getWidth() + 10);
			
		}
	}
	
	/**
	 * @param height the height to set
	 */
	private void setHeight(int height) {
		this.height = height;
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
	private void setWidth(int width) {
		this.width = width;
	}

	
	
}
