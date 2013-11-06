import sintese.*;
public class Random extends Oscilador{
	float Amplitude;
	public Random()
	{
		super();
		prepara();
	}
	public Random(Dispositivo d1)
	{
		super();
		prepara();
		setAmplitude(d1.getSaida());
	}
	public void prepara()
	{
		setFrequencia((float) Math.random());
		setAmplitude((float) Math.random());
		setFase((float) Math.random());
		setDuracao((float) Math.random());
	}
	public void setAmplitude(float a)
	{
		Amplitude = a;
	}
	public static void main(String[] args) //Teste do random com somador
	{
		Random teste = new Random();
		Som som = new Som(teste,teste.getDuracao()*10,"teste");
		som.visualiza();
	}
}
