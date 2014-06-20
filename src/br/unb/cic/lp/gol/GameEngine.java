package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um ambiente (environment) do jogo GameOfLife.
 * 
 * Essa implementacao eh nao inifinita, ou seja, nem todas as celulas possuem
 * oito celulas vizinhas. Por exemplo, a celula de coordenada (0,0) possui
 * apenas tres celulas vizinhas, (0,1), (1,0) e (1,1).
 * 
 * Um ambiente eh representado como um array bidimensional de celulas, com
 * altura (height) e comprimento (width).
 * 
 * @author rbonifacio
 */
public class GameEngine {
	Tabuleiro tabuleiro;
	
	private Statistics statistics;

	/**
	 * Construtor da classe Environment.
	 * 
	 * @param height
	 *            dimensao vertical do ambiente
	 * @param width
	 *            dimentsao horizontal do ambiente
	 */
	public GameEngine(int height, int width, Statistics statistics) {
		this.tabuleiro = new Tabuleiro(height, width, new RegraGoLPadrao());
		this.statistics = statistics;
	}

	public int getWindowWidth()
	{
		return 10;
	}
	
	public int getWindowHeight()
	{
		return 10;
	}
	
	public int getWindowY()
	{
		return tabuleiro.getWindowY();
	}
	
	public int getWindowX()
	{
		return tabuleiro.getWindowX();
	}
	
	public void moveUp()
	{
		if (tabuleiro.getWindowY() > 0) tabuleiro.setWindowY(tabuleiro.getWindowY()-1);
		
	}
	public void moveDown()
	{
		if (tabuleiro.getWindowY() + 10 < tabuleiro.getHeight()) tabuleiro.setWindowY(tabuleiro.getWindowY()+1);
	}
	public void moveLeft()
	{
		if (tabuleiro.getWindowX() > 0) tabuleiro.setWindowX(tabuleiro.getWindowX()-1);
	}
	public void moveRight()
	{
		if (tabuleiro.getWindowX() + 10 < tabuleiro.getWidth()) tabuleiro.setWindowX(tabuleiro.getWindowX()+1);
	}
	
	/**
	 * Calcula uma nova geracao do ambiente. Essa implementacao utiliza o
	 * algoritmo do Conway, ou seja:
	 * 
	 * a) uma celula morta com exatamente tres celulas vizinhas vivas se torna
	 * uma celula viva.
	 * 
	 * b) uma celula viva com duas ou tres celulas vizinhas vivas permanece
	 * viva.
	 * 
	 * c) em todos os outros casos a celula morre ou continua morta.
	 */
	public void nextGeneration() {
		tabuleiro.checarCrescimento();
		
		List<Cell> deveMudar = new ArrayList<Cell>();
		for (int i = 0; i < tabuleiro.getHeight(); i++) {
			for (int j = 0; j < tabuleiro.getWidth(); j++) {
				if ( tabuleiro.getCell(i,j).tentarMudarEstado())
					deveMudar.add(tabuleiro.getCell(i,j));
			}
		}

		for (Cell cell : deveMudar) {
			cell.tentarMudarEstado();
			if (cell.getEstado() instanceof EstadoMorto)
				statistics.recordKill();
			else
				statistics.recordRevive();
		}
	}

	/**
	 * Retorna o numero de celulas vivas no ambiente. Esse metodo eh
	 * particularmente util para o calculo de estatisticas e para melhorar a
	 * testabilidade.
	 * 
	 * @return numero de celulas vivas.
	 */
	public int numberOfAliveCells() {
		int aliveCells = 0;
		for (int i = 0; i < tabuleiro.getHeight(); i++) {
			for (int j = 0; j < tabuleiro.getWidth(); j++) {
				if (tabuleiro.getCell(i,j).getEstado() instanceof EstadoVivo) {
					aliveCells++;
				}
			}
		}
		return aliveCells;
	}

	/* Metodos de acesso as propriedades height e width */

	public int getHeight() {
		return tabuleiro.getHeight();
	}

	public int getWidth() {
		return tabuleiro.getWidth();
	}

	public boolean isCellAlive(int i, int j) {
		return tabuleiro.getCell(i,j).getEstado() instanceof EstadoVivo;
	}
	
	public EstadoAbstrato estadoCelula(int i, int j)
	{
		return tabuleiro.getCell(i,j).getEstado();
	}

	public void makeCellAlive(int i, int j) throws InvalidParameterException {
		
		if (validPosition(i, j)) {
			if (tabuleiro.getCell(i,j).getEstado() instanceof EstadoMorto)
				tabuleiro.getCell(i,j).setEstado(new EstadoVivo());
		} else {
			new InvalidParameterException("Invalid position (" + i + ", " + j
					+ ")");
		}
	}
	
	private boolean validPosition(int a, int b) {
		return a >= 0 && a < tabuleiro.getHeight() && b >= 0 && b < tabuleiro.getWidth();
	}
}
