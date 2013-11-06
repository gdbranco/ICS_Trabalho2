import sintese.Curva;
import sintese.Dispositivo;
import sintese.Envoltoria;
import sintese.Oscilador;
import sintese.Som;
import sintese.Somador;
public class Instrumento_3 extends Dispositivo{
	Random gerador_ruido;
	Som som;
	public Instrumento_3()
	{
		prepara();
	}
	public void prepara()
	{
		Curva        curva1, curva2;
		Envoltoria   env1   = new Envoltoria();   
		Envoltoria   env2   = new Envoltoria();   
		Oscilador o1, o2, o3;
		
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
	    o3 = new Oscilador(env2);
	    o3.setFrequencia(440);
	    gerador_ruido = new Random();
	    Somador soma = new Somador(o3,gerador_ruido);
	    o2 = new Oscilador(o1,soma);
	    som = new Som(o2,10f,"teste");
	}
	public void start()
	{
		som.visualiza();
	}
}
