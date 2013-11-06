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
		Curva        curva1, curva2, curva3;
		Envoltoria   env1   = new Envoltoria();   
		Envoltoria   env2   = new Envoltoria();   
		Envoltoria   env3   = new Envoltoria();   

		Oscilador o1, o2;
		Somador   somador;
		Random teste = new Random();
		
		curva1 = new Curva(720);     
	    curva1.addPonto(  0f, 2000f);
	    curva1.addPonto(720f, 0f);
	    
	    curva2 = new Curva(720);     
	    curva2.addPonto(0f, 0f);
	    curva2.addPonto(30f, 1000f);
	    curva2.addPonto(600f, 300f);
	    curva2.addPonto(720f, 0f);     
	    
	    curva3 = new Curva(720);     
	    curva3.addPonto(  0f, 200f);
	    curva3.addPonto(720f, 200f);

	    env1.setCURVA(curva1);      
	    env2.setCURVA(curva2);    
	    env3.setCURVA(curva3);    

	    env2.setGanho(3);
	    o2 = new Oscilador(env1);
	    o2.setFrequencia(180);
	    somador = new Somador(env3, o2);

	    o1 = new Oscilador(env2, somador);
	    Somador soma = new Somador(o1,teste);
	    Som som = new Som(soma,10f,"teste");
		//Som som = new Som(teste,teste.getDuracao()*10,"teste");
		som.visualiza();
	}
}
