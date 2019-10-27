package main.java.TP_Grupo13_2019;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialAzar;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.ControlSobreNumeroEsperado;

public class CorrerAlgoritmo {
    public static void main(String[] args) {
        ponerResultadoEnArchivoTXT();

        Configuracion config = new ConfiguracionDefault();
        config.setPoblacionInicial(50);
        config.setMetodoDeSeleccion(new ControlSobreNumeroEsperado());
        config.setCruzamiento(new BinomialAzar());
        config.setCriterioDeParo(new CantidadDeCiclos(10L));
        config.setMutacion(new MutacionSimple(0.5));

        AlgoritmoGenetico algoritmoJugadorOptimo = new AlgoritmoGenetico(config, Jugador.class);

        obtenerElMejorJugador(algoritmoJugadorOptimo);
    }

    public static void obtenerElMejorJugador(AlgoritmoGenetico algoritmoJugadorOptimo) {
        Individuo elegido = algoritmoJugadorOptimo.ejecutar();
        System.out.println("----------------------------------------------------------");
        System.out.println("***** SOLUCION *****");
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + elegido.toString());
    }

    public static void obtenerLos10Mejores(AlgoritmoGenetico algoritmoJugadorOptimo) {

        List<Individuo> mejoresJugadores = new ArrayList<Individuo>();

        for (int i = 0; i < 10; i++) {
            mejoresJugadores.add(algoritmoJugadorOptimo.ejecutar());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("\n\n***** Jugador " + (i + 1) + " *****");
            System.out.println(mejoresJugadores.get(i).toString());
        }

    }

    public static void ponerResultadoEnArchivoTXT() {
        try {
            FileHandler fileText = new FileHandler("ResultadoCorrida.txt");

            fileText.setFormatter(new SimpleFormatter());

            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).addHandler(fileText);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
