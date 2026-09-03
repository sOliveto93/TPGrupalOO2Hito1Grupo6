package test;

import java.time.LocalDate;

import datos.Cajero;
import datos.Cocinero;
import negocio.StaffABM;

public class TestStaff {

    public static void main(String[] args) {
        StaffABM staffABM = new StaffABM();

        
        System.out.println(staffABM.traerStaff(1));
        System.out.println(staffABM.traerStaff(2));

        // TRAER A TODO EL PERSONAL STAFF
        System.out.println(staffABM.traerTodosStaff());

        // TRAER TODOS LOS CAJEROS
        System.out.println(staffABM.traerTodosCajeros());

        // TRAER A TODOS LOS COCINEROS
        System.out.println(staffABM.traerTodosCocineros());

        // TRAER A TODOS LOS CAJEROS DE TURNO NOCHE
        System.out.println(staffABM.traerCajerosPorTurno("noche"));

        // TRAER A TODOS LOS CAJEROS DE TURNO MAñANA
        System.out.println(staffABM.traerCajerosPorTurno("mañana"));

        // TRAER A STAFF POR DNI
        System.out.println(staffABM.traerStaffPorDni(45495509));

        // TRAER A STAFFS POR APELLIDO
        System.out.println(staffABM.traerStaffPorApellido("Crespo"));

        // TRAER A STAFF CON SUELDO MAYOR A x VALOR
        System.out.println(staffABM.traerStaffSueldoMayorA(270));

        // TRAER A STAFF ORDENADO POR APELLIDO
        System.out.println(staffABM.traerStaffOrdenadoPorApellido());

        // TRAER A STAFF INGRESADO DESPUES DE UNA FECHA
        System.out.println(staffABM.traerStaffIngresadoDespuesDe(LocalDate.of(2024, 7, 2)));

    }

}
