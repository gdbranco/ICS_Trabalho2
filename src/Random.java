import sintese.*;
public class Random extends Oscilador{
	//float Amplitude;
	float R = 512;
	Envoltoria env = new Envoltoria();
	public Random()
	{
		super();
	}
	public Random(float a,Dispositivo d1)
	{
		prepara(a,d1.getSaida());
	}
	public Random(Dispositivo d1,float f)
	{
		prepara(d1.getSaida(),f);
	}
	public Random(float a,float f)
	{
		prepara(a,f);
	}
	public void prepara(float a,float f)
	{
		Curva curva;
		if(f<0 || f>512)
		{
			//adicionar excecao
		}
		else if(a<0 || a>66)
		{
			//adicionar excecao
		}
		else
		{
			curva = new Curva(511);
			float primeiro = calculaR(f);
			curva.addPonto(0, primeiro);
			for(int i=1;i<511;i++)
			{
				curva.addPonto(i+1, calculaR(f));
			}
			curva.addPonto(511, primeiro);
			env.setCURVA(curva);
			env.setGanho(75f);
		}
		setDispositivoAmplitude(env);
		setFrequencia(R);
		//setDispositivoFrequencia(env);
	}
	public float calculaR(float f)
	{
		double n = Math.random();
		return (float) ((Math.pow(-1, (int)(n*10))*n)*((R*f)/1024));
	}
	public void start()
	{
		System.out.println(getSaida()/10000);
		Som som = new Som(this,5f,"teste");
		som.visualiza();
	}
}
