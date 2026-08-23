package test;
import java.time.LocalDate;
import datos.Festival;
import negocio.FestivalABM;

public class Main {

	public static void main(String[] args) {
		
		
        Festival festival = new Festival("Festival de Verano","Verano",LocalDate.of(2026, 1, 10),LocalDate.of(2026, 1, 20),5000,10000,3000,800000);
        FestivalABM festivalABM = new FestivalABM();
        System.out.println(festivalABM.agregarFestival(festival));
        System.out.println(festivalABM.traer(1));
	}
}
