package negocio;

import java.util.List;

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

    public List<Staff> traerTodosStaff(){
        return dao.traerTodos();



    }

}


