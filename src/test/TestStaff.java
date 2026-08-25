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
        Cajero cajero2 =new Cajero("Lourdes","Crespo",45495509,LocalDate.of(2003,12,22),LocalDate.of(2024,11,15),400,"noche");


        //staffABM.crearStaff(cocinero);
        //staffABM.crearStaff(cajero);
        //staffABM.crearStaff(cajero2);
    
        System.out.println(staffABM.traerStaff(1));
        System.out.println(staffABM.traerStaff(2));
        System.out.println(staffABM.traerStaff(3));

        // TRAER A TODO EL PERSONAL STAFF
        System.out.println(staffABM.traerTodosStaff());

        // TRAER TODOS LOS CAJEROS
        System.out.println(staffABM.traerTodosCajeros());

        //TRAER A TODOS LOS COCINEROS
        System.out.println(staffABM.traerTodosCocineros());

        //TRAER A TODOS LOS CAJEROS DE TURNO NOCHE
        System.out.println(staffABM.traerCajerosPorTurno("noche"));

        //TRAER A TODOS LOS CAJEROS DE TURNO MAñANA
        System.out.println(staffABM.traerCajerosPorTurno("mañana"));

        //TRAER A STAFF POR DNI
        System.out.println(staffABM.traerStaffPorDni(45495509));
    }

}
