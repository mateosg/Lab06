package fp.cortes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InformeCortes {
	private String nombre;
	private LocalDate fecha;
	private List<CorteElectrico> cortes;
	
	public InformeCortes(String nombre, LocalDate fecha) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.cortes = new ArrayList<>();
	}

	public InformeCortes(String nombre, LocalDate fecha, Stream<CorteElectrico> s) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.cortes = s.collect(Collectors.toList());
	}
	
	public String getNombre() {
		return nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public List<CorteElectrico> getCortes() {
		return new ArrayList<>(cortes);
	}

	public Integer getNumeroCortes() {
		return cortes.size();
	}

	public void incorporaCorte(CorteElectrico c) {
		if (!cortes.contains(c)) {
			cortes.add(c);
		}
	}

	public void incorporaCortes(List<CorteElectrico> cortes) {
		this.cortes.addAll(cortes);
	}
	
	public void eliminaCorte(CorteElectrico c) {
		cortes.remove(c);
	}

	public String toString() {
		return "InformeCortes [nombre=" + nombre + ", fecha=" + fecha + ", getNumeroCortes()=" + getNumeroCortes()
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cortes, fecha, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InformeCortes other = (InformeCortes) obj;
		return Objects.equals(cortes, other.cortes) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(nombre, other.nombre);
	}
	
	/****************************  Tratamientos secuenciales  **********************************/
	
	  
}
