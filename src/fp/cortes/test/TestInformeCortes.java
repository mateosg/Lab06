package fp.cortes.test;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Set;
import fp.cortes.FactoriaCortes;
import fp.cortes.InformeCortes;
import fp.cortes.Nivel;

public class TestInformeCortes {

	public static void main(String[] args) {
		
		/*
		// Crear informe de cortes de suministro
		System.out.println("Ejercicio: Cortes eléctricos");
		System.out.println("=====================");
		System.out.print("Leyendo fichero de cortes...");
		InformeCortes informe =
			FactoriaCortes.leerCortes("data/power_outages.csv");
		System.out.println(" leídos " + informe.getNumeroCortes() 
			+ " cortes.");

		// Tratamientos secuenciales
		// 1.
		Set<String> regiones = Set.of("Maryland", "Massachusetts");
		Nivel s = Nivel.MEDIO;		
		try {
			System.out.println("Ejercicio 1: " +
					informe.mediaAfectadosEnRegiones(s, regiones));
		} catch (NoSuchElementException e) {
			System.out.println("Ejercicio 1: Excepción capturada: no existe la media");
		}

		// 2.
		String etiqueta = "winter storm";
		//String etiqueta = "vandalism";
		Integer n = 3;
		System.out.println("Ejercicio 2: " +
				informe.compañiasCortesMasRecientes(etiqueta, n));
	
		// 3. (con streams)
		System.out.println("Ejercicio 3 (streams): " +
				informe.compañiasConCortesCriticosPorRegion());
		
		// 4.
		String region = "Madison, Wisconsin";
		System.out.println("Ejercicio 4: " +
				informe.porcentajeCortesPorSeveridadEnRegion(region));
		
		// 5.
		LocalDate f = LocalDate.of(2013, 11, 17);		
		try {
			System.out.println("Ejercicio 5: " +
					informe.compañiaConMasAfectadosEnFecha(f));
		} catch (NoSuchElementException e) {
			System.out.println("Ejercicio 5: Excepción capturada: no existe la compañía");
		}
		
		*/
	}

}
