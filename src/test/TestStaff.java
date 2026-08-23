package test;

import java.time.LocalDate;

import datos.Cajero;
import datos.Cocinero;
import negocio.StaffABM;

public class TestStaff {

    public static void main(String[] args) {
        StaffABM staffABM= new StaffABM();

        Cajero cajero =new Cajero("sebas","oliveto",1122334455,LocalDate.of(1993,8,7),LocalDate.of(2026,8,23),250,"noche");
        //String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			//double sueldoBase, String especialidad, double plusCategoria
        Cocinero cocinero= new Cocinero("patricio", "no recuerdo", 88991122,LocalDate.of(2002, 5, 13),LocalDate.now(),300,"sushi",65);
        
        staffABM.crearStaff(cocinero);
        staffABM.crearStaff(cajero);
    
        System.out.println(staffABM.traerStaff(1));
        System.out.println(staffABM.traerStaff(2));


        System.out.println(staffABM.traerTodosStaff());


    }

}
