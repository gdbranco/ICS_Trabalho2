package player;
import sintese.Curva;
import sintese.Envoltoria;
import sintese.InstrumentoAditivo;
import sintese.Oscilador;
import sintese.UnidadeH;

import player.Random;

public class Instrumento_1 extends InstrumentoAditivo {
	Random gerador_ruido;

	public Instrumento_1() {
		prepara();
	}

	public void prepara() {
		Curva curva1;// , curva2;
		Envoltoria env1 = new Envoltoria();
		// Envoltoria env2 = new Envoltoria();
		Oscilador o1, o2;

		curva1 = new Curva(512);
		curva1.addPonto(0f, 0f);
		curva1.addPonto(128f, 5000f);
		curva1.addPonto(384f, 5000f);
		curva1.addPonto(512f, 0f);
		// curva1.addPonto(80f, 3000f);
		// curva1.addPonto(320f, 2000f);
		// curva1.addPonto(540f, 1000f);
		// curva1.addPonto(680f, 148.8);
		// curva1.addPonto(720f, 0f);
		//
		// curva2 = new Curva(720);
		// curva2.addPonto(0f, 0f);
		// curva2.addPonto(30f, 1000f);
		// curva2.addPonto(257f, 8000f);
		// curva2.addPonto(600f, 300f);
		// curva2.addPonto(720f, 0f);

		env1.setCURVA(curva1);
		// env2.setCURVA(curva2);
		// env2.setGanho(3);

		UnidadeH uh1 = new UnidadeH();
		uh1.setH(2);
		uh1.setLambda(0.5f);
		uh1.setFase(0f);
		uh1.setGanho(1);
		Oscilador o3 = new Oscilador();
		o3.setClock(3);
		o3.setFrequencia(440);
		Envoltoria env2 = new Envoltoria();
		Curva curva2 = new Curva(511);
		float primeiro = 0;
		curva2.addPonto(0, primeiro);
		for (int i = 1; i < 511; i++) {
			curva2.addPonto(i + 1, Math.sin(i));
		}
		curva2.addPonto(511, primeiro);
		env2.setCURVA(curva2);
		env2.setGanho(3075f);

		o1 = new Oscilador(env1);
		o1.setFrequencia(180);
		uh1.setEnvoltoria(env2);
		this.addUnidade(uh1);
		gerador_ruido = new Random(33, o1);
		o2 = new Oscilador(gerador_ruido, o1);
	}
}
