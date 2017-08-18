package br.cefetmg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Goomba {
	private static final int Height = 24;
    private static final int Width = 21;
    private TextureRegion[][] quadrosDeAnimacao;
    private Animation<TextureRegion> andarParaFrente;
    private Animation<TextureRegion> andarParaTras;
    private Animation<TextureRegion> andarParaDireita;
    private Animation<TextureRegion> andarParaEsquerda;
    private float tempoDeAnimacao;
    private Position p;
    private int direcao;
    
    public Goomba(Texture spriteSheet) {
		// TODO Auto-generated constructor stub
    	p = new Position(0,	0);
    	tempoDeAnimacao = 0;
    	direcao = 1;
    	quadrosDeAnimacao = TextureRegion.split(spriteSheet, Width, Height);
        andarParaTras = new Animation<TextureRegion>(0.1f, 
        		quadrosDeAnimacao[0][0],
        		quadrosDeAnimacao[0][1],
        		quadrosDeAnimacao[0][2],
        		quadrosDeAnimacao[0][3],
        		quadrosDeAnimacao[0][4]);
        andarParaTras.setPlayMode(PlayMode.LOOP_PINGPONG);
        
        andarParaFrente = new Animation<TextureRegion>(0.1f, new TextureRegion[]{
        		quadrosDeAnimacao[2][0],
        		quadrosDeAnimacao[2][1],
        		quadrosDeAnimacao[2][2],
        		quadrosDeAnimacao[2][3],
        		quadrosDeAnimacao[2][4],
        });
        andarParaFrente.setPlayMode(PlayMode.LOOP_PINGPONG);
        
        andarParaDireita = new Animation<TextureRegion>(0.1f, new TextureRegion[]{
        		quadrosDeAnimacao[1][0],
        		quadrosDeAnimacao[1][1],
        		quadrosDeAnimacao[1][2],
        		quadrosDeAnimacao[1][3],
        		quadrosDeAnimacao[1][4],
        });
        andarParaDireita.setPlayMode(PlayMode.LOOP_PINGPONG);
        
        andarParaEsquerda = new Animation<TextureRegion>(0.1f, new TextureRegion[]{
        		quadrosDeAnimacao[3][0],
        		quadrosDeAnimacao[3][1],
        		quadrosDeAnimacao[3][2],
        		quadrosDeAnimacao[3][3],
        		quadrosDeAnimacao[3][4],
        });
        andarParaEsquerda.setPlayMode(PlayMode.LOOP_PINGPONG);

	}
    
    public void update (){
    	tempoDeAnimacao += Gdx.graphics.getDeltaTime();
    	if (Gdx.input.isKeyPressed(Keys.UP)){
    		p.andarVertical(true, Height);
        	direcao = 1;
        } else if (Gdx.input.isKeyPressed(Keys.DOWN)){
        	p.andarVertical(false, Height);
        	direcao = 2;
        } else if (Gdx.input.isKeyPressed(Keys.LEFT)){
        	p.andarHorizontal(false, Width);
        	direcao = 3;
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)){
        	p.andarHorizontal(true, Width);
        	direcao = 4;
        }
    }


	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		update();
		if (direcao == 1) { // Cima
			batch.draw((TextureRegion)andarParaFrente.getKeyFrame(tempoDeAnimacao),p.getX(),p.getY());
		} else if (direcao == 2) { // Baixo
			batch.draw((TextureRegion)andarParaTras.getKeyFrame(tempoDeAnimacao),p.getX(),p.getY());
		} else if (direcao == 3) { // Esquerda
			batch.draw((TextureRegion)andarParaEsquerda.getKeyFrame(tempoDeAnimacao),p.getX(),p.getY());
		} else if (direcao == 4){ // Direita
			batch.draw((TextureRegion)andarParaDireita.getKeyFrame(tempoDeAnimacao),p.getX(),p.getY());
		}
		
	}

}
