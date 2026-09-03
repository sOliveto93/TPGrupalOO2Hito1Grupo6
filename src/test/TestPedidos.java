package test;

import java.time.LocalDate;

import negocio.PedidoABM;

public class TestPedidos {

    public static void main(String[] args) {
        
    
    PedidoABM abm=new PedidoABM();
LocalDate hoy = LocalDate.now();
    System.out.println( abm.traerEntreFechas(hoy.minusDays(10),
            hoy.plusDays(10)));
    }
}
