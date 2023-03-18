package fp.cortes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public record CorteElectrico(String descripcion, LocalDateTime fechaInicio,
		LocalDateTime fechaRestablecimiento, String compañia, String region,
		Double perdida, Integer consumidores, List<String> etiquetas)
		implements Comparable<CorteElectrico> {

	static final Integer PERDIDA_CRITICA = 200;
	
	public CorteElectrico {
		Checkers.check("La fecha de restablecimiento debe ser igual o posterior a la de inicio",
				!fechaRestablecimiento.isBefore(fechaInicio));
		Checkers.check("El número de consumidores afectados debe ser mayor o igual que 0, o null",
				consumidores == null || consumidores >= 0);
		Checkers.check("La lista de etiquetas debe contener al menos una etiqueta",
				etiquetas.size() > 0);
	}
	
	public Nivel severidad() {
		Nivel res = Nivel.BAJO;
		if (consumidores != null) {
			if (consumidores >= 10000 && consumidores <= 100000) {
				res = Nivel.MEDIO;
			} else if (consumidores > 100000) {
				res = Nivel.ALTO;
			}
		}
		return res;
	}
	
	public Boolean esCritico() {
		Integer duracion = (int) fechaInicio.until(fechaRestablecimiento, ChronoUnit.HOURS);
		Boolean res = false;
		if (perdida != null) {
			res = perdida > PERDIDA_CRITICA || duracion > 10;
		}
		return res;
	}
	
	public int hashCode() {
		return Objects.hash(fechaInicio, region);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CorteElectrico other = (CorteElectrico) obj;
		return Objects.equals(fechaInicio, other.fechaInicio) && Objects.equals(region, other.region);
	}

	public int compareTo(CorteElectrico c) {
		int res = fechaInicio.compareTo(c.fechaInicio());
		if (res == 0) {
			res = region.compareTo(c.region());
		}
		return res;
	}
}
