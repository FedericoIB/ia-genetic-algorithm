package main.java.TP_Grupo13_2019;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Jugador extends Individuo
{
	
	//Caracteristicas del jugador
	//Van del 0 a 100
	private double velocidad;
	private double reaccion;
	private double potencia_golpe;
	private double precision_golpe;
	private double mentalidad;
	
	//Estadisticas de partidos
	//Van del 0 a 50, menos los metros recorridos que va de 1000 a 2000
	private double porcentaje_regularidad;	
	private double porcentaje_tiros_ganadores;
	private double porcentaje_aces;
	private double metros_corridos_partido;
	
	@Override
	public Individuo generarRandom() {
		Jugador j= new Jugador();
		j.setVelocidad(Math.random() * 100);
		j.setReaccion(Math.random() * 100);
		j.setPotencia_golpe(Math.random() * 100);
		j.setPrecision_golpe(Math.random() * 100);
		j.setMentalidad(Math.random() * 100);
		j.setPorcentaje_regularidad(Math.random() * 50);
		j.setPorcentaje_tiros_ganadores(Math.random() * 50);
		j.setPorcentaje_aces(Math.random() * 50);
		j.setMetros_corridos_partido(Math.random() * 1000 + 1000);
		return j;
	}
	
	
	@Override
	public double aptitud() {
		//F(x)=G(x)+H(x)-I(x)
		return this.evaluacionCaracteristicas()+this.evaluacionEstadisticasPartidos()-this.costoJugador();
	}
	
	public double evaluacionCaracteristicas(){ //G(x)
		// multiplico el atributo por un numero que indica la importancia
		return 	this.getVelocidad() * 6 +
				this.getReaccion() * 3 +
				this.getPotencia_golpe() * 4 +
				this.getPrecision_golpe() * 12 +
				this.getMentalidad() * 10;
	}
	
	public double evaluacionEstadisticasPartidos(){ //H(x)
		return 	this.getPorcentaje_regularidad() * 4 +
				this.getPorcentaje_tiros_ganadores() * 15 +
				this.getPorcentaje_aces() * 5 +
				this.getMetros_corridos_partido();
	}
	
	public double costoJugador(){ //I(x)
		return (this.getVelocidad() * (this.getMetros_corridos_partido() / 1000) +
				this.getPotencia_golpe() * this.getPorcentaje_tiros_ganadores()  +
				this.getPrecision_golpe() * this.getPorcentaje_tiros_ganadores()  +
				this.getMentalidad() * this.getPorcentaje_regularidad() +
				this.getReaccion() * this.getPorcentaje_aces() )
				/ 10
				;
	}
	
	
	@Override
	public String toString() {

		String output = 
			"\n"+ "Velocidad= " + this.getVelocidad() +
			"\n"+ "Reaccion= " + this.getReaccion() +	
			"\n"+ "Potencia golpe= " + this.getPotencia_golpe() +	
			"\n"+ "Precision golpe= " + this.getPrecision_golpe() +	
			"\n"+ "Mentalidad= " + this.getMentalidad() +	
			"\n"+ "Porcentaje regularidad= " + this.getPorcentaje_regularidad() +	
			"\n"+ "Porcentaje tiros ganadores= " + this.getPorcentaje_tiros_ganadores() +
			"\n"+ "Porcentaje aces= " + this.getPorcentaje_aces()  +
			"\n"+ "Metros corrido por partido= " + this.getMetros_corridos_partido() +
			"\n"+ "Funcion aptitud= " + this.aptitud();
			
			
		return output;
	}
	
	
	
	
	
	
	//Getters and Setters
	public double getVelocidad()
	{
		return velocidad;
	}

	public void setVelocidad(double velocidad)
	{
		this.velocidad=velocidad;
	}

	public double getReaccion()
	{
		return reaccion;
	}

	public void setReaccion(double reaccion)
	{
		this.reaccion=reaccion;
	}

	public double getPotencia_golpe()
	{
		return potencia_golpe;
	}

	public void setPotencia_golpe(double potencia_golpe)
	{
		this.potencia_golpe=potencia_golpe;
	}

	public double getPrecision_golpe()
	{
		return precision_golpe;
	}

	public void setPrecision_golpe(double precision_golpe)
	{
		this.precision_golpe=precision_golpe;
	}

	public double getMentalidad()
	{
		return mentalidad;
	}

	public void setMentalidad(double mentalidad)
	{
		this.mentalidad=mentalidad;
	}

	public double getPorcentaje_regularidad()
	{
		return porcentaje_regularidad;
	}

	public void setPorcentaje_regularidad(double porcentaje_regularidad)
	{
		this.porcentaje_regularidad=porcentaje_regularidad;
	}

	public double getPorcentaje_tiros_ganadores()
	{
		return porcentaje_tiros_ganadores;
	}

	public void setPorcentaje_tiros_ganadores(double porcentaje_tiros_ganadores)
	{
		this.porcentaje_tiros_ganadores=porcentaje_tiros_ganadores;
	}

	public double getPorcentaje_aces()
	{
		return porcentaje_aces;
	}

	public void setPorcentaje_aces(double porcentaje_aces)
	{
		this.porcentaje_aces=porcentaje_aces;
	}

	public double getMetros_corridos_partido()
	{
		return metros_corridos_partido;
	}

	public void setMetros_corridos_partido(double metros_corridos_partido)
	{
		this.metros_corridos_partido=metros_corridos_partido;
	}

}
