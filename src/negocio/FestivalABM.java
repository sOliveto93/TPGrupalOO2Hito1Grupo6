package negocio;

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
    
}
