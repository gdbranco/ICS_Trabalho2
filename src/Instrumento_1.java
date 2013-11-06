import sintese.*;
public class Instrumento_1 extends Dispositivo{
	Random gerador_ruido;
	Som som;
	public Instrumento_1()
	{
		prepara();
	}
	public void prepara()
	{
		Curva        curva1, curva2;
		Envoltoria   env1   = new Envoltoria();   
		Envoltoria   env2   = new Envoltoria();   
		Oscilador o1, o2;
		
		curva1 = new Curva(720);     
	    curva1.addPonto(  0f, 2000f);
	    curva1.addPonto(720f, 0f);
	    
	    curva2 = new Curva(720);     
	    curva2.addPonto(0f, 0f);
	    curva2.addPonto(30f, 1000f);
	    curva2.addPonto(600f, 300f);
	    curva2.addPonto(720f, 0f);     
	    

	    env1.setCURVA(curva1);      
	    env2.setCURVA(curva2);     

	    env2.setGanho(3);
	    o1 = new Oscilador(env1);
	    o1.setFrequencia(180);
	    gerador_ruido = new Random(o1);
	    o2 = new Oscilador(gerador_ruido, env2);
	    som = new Som(o2,10f,"teste");
	}
	public void start()
	{
		som.visualiza();
	}
}
