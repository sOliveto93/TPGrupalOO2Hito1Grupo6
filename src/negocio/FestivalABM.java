package negocio;


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
    
}
