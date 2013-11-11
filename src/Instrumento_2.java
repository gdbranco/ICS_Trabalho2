import sintese.Curva;
import sintese.Envoltoria;
import sintese.InstrumentoAditivo;
import sintese.Oscilador;
import sintese.Som;
import sintese.Somador;
import sintese.UnidadeH;

public class Instrumento_2 extends InstrumentoAditivo {
	Random gerador_ruido;
	Som som;

	public Instrumento_2() {
		prepara();
	}

	public void prepara() {
		Curva curva1, curva2;
		Envoltoria env1 = new Envoltoria();
		Envoltoria env2 = new Envoltoria();
		Oscilador o1, o2;

		curva1 = new Curva(720);
		curva1.addPonto(0f, 2000f);
		curva1.addPonto(720f, 0f);

		curva2 = new Curva(720);
		curva2.addPonto(0f, 0f);
		curva2.addPonto(30f, 1000f);
		curva2.addPonto(600f, 300f);
		curva2.addPonto(720f, 0f);

		env1.setCURVA(curva1);
		env2.setCURVA(curva2);
		env2.setGanho(3);

		UnidadeH uh1 = new UnidadeH();
		uh1.setEnvoltoria(env1);
		uh1.setH(1);
		uh1.setLambda(0.3f);
		uh1.setFase(3f);
		uh1.setGanho(1);
		this.addUnidade(uh1);

		o1 = new Oscilador(env1);
		o1.setFrequencia(180);
		gerador_ruido = new Random();
		Somador soma = new Somador(gerador_ruido, gerador_ruido);
		o2 = new Oscilador(o1, soma);
		som = new Som(o2, 10f, "teste");
	}

	public void start() {
		som.visualiza();
	}
}
