import sintese.*;
public class Random extends Oscilador{
	//float Amplitude;
	float R = 512;
	Envoltoria env = new Envoltoria();
	public enum errors{
		no_error,highValue;
	}
	public Random()
	{
		super();
	}
	public Random(Dispositivo d1)
	{
		prepara(33,d1.getSaida());
	}
	public Random(float a,float f)
	{
		switch(prepara(a,f))
		{
		case highValue:
			System.out.println("Erro");
		case no_error:
			System.out.println("Sem erro");
		}
	}
	public errors prepara(float a,float f)
	{
		Curva curva;
		if(f<0 || f>512)
			return errors.highValue;
		else if(a<0 || a>66)
			return errors.highValue;
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
		return errors.no_error;
	}
	public float calculaR(float f)
	{
		double n = Math.random();
		return (float) ((Math.pow(-1, (int)(n*10))*n)*((R*f)/1024));
	}
	public static void main(String[] args)
	{
		Random teste = new Random(33,256);
		System.out.println(teste.getSaida()/10000);
		Som som = new Som(teste,5f,"teste");
		som.visualiza();
	}
}
