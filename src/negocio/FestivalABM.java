package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDAO;
import datos.Festival;

public class FestivalABM {
	
	FestivalDAO festivalDAO = new FestivalDAO();
	
	public FestivalABM() {};
	
    
	public long agregarFestival(Festival festival){
		

        long id = festivalDAO.agregarFestival(festival);
        return id;
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
    public List<Festival> traerFestivalesPorTemporada(String temporada)
            throws Exception {

        if (temporada == null) {
            throw new Exception("La temporada no puede ser nula");
        }

        switch (temporada) {
            case "Primavera":
            case "Verano":
            case "Otoño":
            case "Invierno":
                break;

            default:
                throw new Exception("Temporada inválida: " + temporada);
        }

        return festivalDAO.traerFestivalesPorTemporada(temporada);
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
    
    public List<Festival> traerFestivalesPorCostoSuperficie(double costoSuperficie, String condicion) throws Exception{
    	
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
}
