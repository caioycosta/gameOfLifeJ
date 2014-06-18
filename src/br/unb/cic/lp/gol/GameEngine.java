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
	private int height;
	private int width;
	private Cell[][] cells;
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
		this.height = height;
		this.width = width;

		cells = new Cell[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[i][j] = new Cell(j, i, cells, width, height);
			}
		}

		this.statistics = statistics;
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
		List<Cell> deveMudar = new ArrayList<Cell>();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!cells[i][j].deveManterEstado())
					deveMudar.add(cells[i][j]);
			}
		}

		for (Cell cell : deveMudar) {
			cell.mudarEstado();
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
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (cells[i][j].getEstado() instanceof EstadoVivo) {
					aliveCells++;
				}
			}
		}
		return aliveCells;
	}

	/* Metodos de acesso as propriedades height e width */

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isCellAlive(int i, int j) {
		return cells[i][j].getEstado() instanceof EstadoVivo;
	}

	public void makeCellAlive(int i, int j) throws InvalidParameterException {
		if (validPosition(i, j)) {
			if (cells[i][j].getEstado() instanceof EstadoMorto)
				cells[i][j].mudarEstado();
		} else {
			new InvalidParameterException("Invalid position (" + i + ", " + j
					+ ")");
		}
	}
	
	private boolean validPosition(int a, int b) {
		return a >= 0 && a < height && b >= 0 && b < width;
	}
}
