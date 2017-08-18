package br.cefetmg.games;

import com.badlogic.gdx.Gdx;

public class Position {
	private float x;
	private float y;
	
	public Position (float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void andarVertical (boolean CimaOuBaixo, float Height){
		if (y == 0) {if (CimaOuBaixo) this.y += 1;}
		else if (y == Gdx.graphics.getHeight() - Height){if (!CimaOuBaixo) this.y -= 1;}
		if (y > 0 && y < Gdx.graphics.getHeight() - Height){
			if (CimaOuBaixo) {
				this.y += 1;
			} else {
				this.y -= 1;
			}
			
		}
	}
	public void andarHorizontal (boolean DireitaOuEsquerda, float Width){
		if (x == 0) {if (DireitaOuEsquerda) this.x += 1;}
		else if (x == Gdx.graphics.getWidth() - Width) {if (!DireitaOuEsquerda) this.x -= 1;}
		if (x > 0 && x < Gdx.graphics.getWidth() - Width){
			if (DireitaOuEsquerda) {
				this.x += 1;
			} else {
				this.x -= 1;
			}
		}
	}
	
}
