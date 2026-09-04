package negocio;

import java.time.LocalDate;
import java.util.List;

import Enum.Estaciones;
import dao.FestivalDAO;
import datos.Festival;

public class FestivalABM {
	
	FestivalDAO festivalDAO = new FestivalDAO();
	
	public FestivalABM() {};
	
    
	public long agregarFestival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			double costoSuperficie, double costoMontaje, double plusElectricidad, double sueldoBase) throws Exception {

		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre del festival no puede estar vacío");
		}

		if (temporada == null || temporada.isBlank()) {
			throw new IllegalArgumentException("La temporada no puede estar vacía");
		}

		if (fechaInicio == null || fechaFin == null) {
			throw new IllegalArgumentException("Las fechas no pueden ser nulas");
		}

		if (fechaFin.isBefore(fechaInicio)) {
			throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
		}

		Festival festival = new Festival(nombre, temporada, fechaInicio, fechaFin, costoSuperficie, costoMontaje,
				plusElectricidad, sueldoBase);

		return festivalDAO.agregarFestival(festival);
	}
	
	public Festival traer(long id) {
		Festival festival = null;
		try {
		festival = festivalDAO.traer(id);
		} catch(Exception e){
			e.getMessage();
		}
		return festival;
	}
	
	
    public List<Festival> traerTodos() {

        List<Festival> festivales = null;

        try {

            festivales = festivalDAO.traerTodos();

        } catch(Exception e) {

            e.getMessage();

        }

        return festivales;
    }
    public List<Festival> traerFestivalesPorTemporada(Estaciones temporada)
            throws Exception {
        return festivalDAO.traerFestivalesPorTemporada(temporada.toString().toLowerCase());
    }
    public List<Festival> traerFestivalesEntreFechas(LocalDate fechaInicio, LocalDate fechaFin)
            throws Exception {
    	
    	if(fechaInicio==null || fechaFin==null) {
    		throw new IllegalArgumentException("Error: fecha de inicio o fin nula");
    	}
    	if(fechaInicio.isAfter(fechaFin))
    	{
    		throw new IllegalArgumentException("Error: fecha de inicio posterior a la fecha de finalizacion");
    	}
    	
        return festivalDAO.traerFestivalesEntreFechas(fechaInicio, fechaFin);
    }
    
    public List<Festival> traerFestivalesPorCostoSuperficie(double costoSuperficie, String condicion) throws Exception {
    	
    	if(costoSuperficie<=0) {
    		throw new IllegalArgumentException("Error: el costo de superficie es menor o igual a 0");
    	} else if (condicion==null) {
    		throw new IllegalArgumentException("Error: la condicion no puede ser nula");
    	} else if (!"mayor".equalsIgnoreCase(condicion)
    	        && !"menor".equalsIgnoreCase(condicion)) {
    	    throw new IllegalArgumentException("La condición debe ser 'mayor' o 'menor'");
    	}
    	
    	return festivalDAO.traerFestivalesPorCostoSuperficie(costoSuperficie, condicion);
    }
	public List<Festival> traerFestivalesPorDuracion(String condicion) throws Exception {

		if (condicion == null) {
			throw new IllegalArgumentException("La condición no puede ser nula");
		}

		if (!condicion.equalsIgnoreCase("mayor")
				&& !condicion.equalsIgnoreCase("menor")) {

			throw new IllegalArgumentException(
					"La condición debe ser 'mayor' o 'menor'"
			);
		}

		return festivalDAO.traerFestivalesPorDuracion(condicion);
	}


    
}
