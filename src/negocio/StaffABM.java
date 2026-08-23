package negocio;

import dao.StaffDAO;
import datos.Staff;

public class StaffABM {

    StaffDAO dao=new StaffDAO();

    public StaffABM(){};

    public Staff crearStaff(Staff staff){
        return dao.crear(staff);
    }
    public Staff traerStaff(long id){
        return dao.traer(id);
    }
}
