package fp.cortes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaCortes {
	
	public static InformeCortes leerCortes(String rutaFichero) {
		InformeCortes res = null;
		try {
			Stream<CorteElectrico> s =
			Files.lines(Paths.get(rutaFichero))
				.skip(1)
				.map(FactoriaCortes::parsearCorte);
			res = new InformeCortes("Informe " + LocalDate.now(),
					LocalDate.now(), s);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	private static CorteElectrico parsearCorte(String lineaCSV) {
		String[] sp = lineaCSV.split(";");
		Checkers.check("Cadena con formato no válido", sp.length == 10);	
		
		String descripcion = sp[0].trim();
		LocalDateTime fechaInicio = LocalDateTime.parse(sp[1].trim()+"-"+sp[2].trim(),
				DateTimeFormatter.ofPattern("M/d/y-H:m"));
		LocalDateTime fechaRestablecimiento = LocalDateTime.parse(sp[3].trim()+"-"+sp[4].trim(),
				DateTimeFormatter.ofPattern("M/d/y-H:m"));
		String compañia = sp[5].trim();
		String region = sp[6].trim();
		
		Double perdida = null;
		if (!sp[7].trim().equals("Unknown")) {
			perdida = Double.valueOf(sp[7].trim());
		}
		Integer consumidores = null;
		if (!sp[8].trim().equals("Unknown")) {
			consumidores = Integer.valueOf(sp[8].trim());
		}
		
		String[] array = sp[9].trim().split(",");
		List<String> etiquetas = new ArrayList<>();
		for (String e: array) {
			etiquetas.add(e.trim());
		}
		
		return new CorteElectrico(descripcion, fechaInicio,
				fechaRestablecimiento, compañia, region,
				perdida, consumidores, etiquetas);
	}
}

