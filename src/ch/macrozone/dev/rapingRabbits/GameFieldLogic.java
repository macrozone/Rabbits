package ch.macrozone.dev.rapingRabbits;

import java.awt.Color;
import java.awt.Graphics;

public class GameFieldLogic extends GameField {

	public GameFieldLogic(int _x, int _y) {
		super(_x, _y);

	}

	public void initNewTurn() {
		this.doStatistic();
		for (GameEntity oneEntity : this.entities) {
			oneEntity.initNewTurn();
		}
	}

	private void doStatistic() {

	}

	public void doOneTurn(GameArea wholeGameArea) {

		for (int i = this.entities.size() - 1; i >= 0; --i) {
			this.entities.get(i).doOneTurn((GameField) this, wholeGameArea);
		}

	}

	public int countLivingRabbits() {
		int counter = 0;
		for (GameEntity oneRabbit : this.entities) {
			if (oneRabbit instanceof Rabbit) {
				if (!oneRabbit.isDead()) {
					counter++;
				}
			}
		}
		return counter;
	}

	public int countLivingMaleRabbits() {
		int counter = 0;
		for (GameEntity oneRabbit : this.entities) {
			if (oneRabbit instanceof MaleRabbit) {
				if (!oneRabbit.isDead()) {
					counter++;
				}
			}
		}
		return counter;
	}

	public int countLivingFemaleRabbits() {
		int counter = 0;
		for (GameEntity oneRabbit : this.entities) {
			if (oneRabbit instanceof FemaleRabbit) {
				if (!oneRabbit.isDead()) {
					counter++;
				}
			}
		}
		return counter;
	}

	public int countGrasses() {
		int counter = 0;
		for (GameEntity oneEntitiy : this.entities) {
			if (oneEntitiy instanceof Grass) {
				Grass oneGrass = (Grass) oneEntitiy;
				counter += oneGrass.getGrasses();
			}
		}
		return counter;
	}

	public void paint(Graphics g) {
		if (RuntimeSettings.showGrasses) {
			drawGrass(g);
		}
		if (RuntimeSettings.showGrid) {
			drawGrid(g);
		}
		if (RuntimeSettings.showRabbits) {
			drawRabbits(g);

		}
	}

	private void drawGrass(Graphics g) {
		g.setColor(new Color(0, (int) Math.round(((double) this.countGrasses())
				/ ((double) Grass.MAX_GRASSES) * 255), 0));
		g.fillRect(WindowSettings.offsetX + this.get_x()
				* WindowSettings.fieldSize,
				WindowSettings.offsetY + this.get_y()
						* WindowSettings.fieldSize, WindowSettings.fieldSize,
				WindowSettings.fieldSize);
	}

	private void drawGrid(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.drawRect(WindowSettings.offsetX + this.get_x()
				* WindowSettings.fieldSize,
				WindowSettings.offsetY + this.get_y()
						* WindowSettings.fieldSize, WindowSettings.fieldSize,
				WindowSettings.fieldSize);
	}

	private void drawRabbits(Graphics g) {
		if (this.countLivingRabbits() > 0) {

			if (this.countLivingMaleRabbits() > this.countLivingFemaleRabbits()) { // male
				g.setColor(new Color(0, 128, 255));
			} else {
				// female
				g.setColor(new Color(255, 0, 255));
			}

			int startX = WindowSettings.offsetX + this.get_x()
					* WindowSettings.fieldSize + WindowSettings.fieldSize / 4;
			int startY = WindowSettings.offsetY + this.get_y()
					* WindowSettings.fieldSize + WindowSettings.fieldSize / 4;
			int width = WindowSettings.fieldSize / 2;
			int height = width;
			g.fillRect(startX, startY, width, height);
		}
	}
}
