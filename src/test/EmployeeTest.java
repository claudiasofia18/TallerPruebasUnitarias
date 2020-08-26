package test;
import Taller.*;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class EmployeeTest {
	
	private Employee SupervisorUSD;
	private Employee SupervisorNoUSD;
	private Employee WorkerUSD;
	private Employee WorkerNoUSD;
	
	@Before
    public void init() {
		SupervisorUSD =  new Employee(456.68F, "USD", 5.5F, EmployeeType.Supervisor);
		SupervisorNoUSD = new Employee(456.68F, "WON", 5.5F, EmployeeType.Supervisor);
		WorkerUSD = new Employee(1000,"USD",0.1f,EmployeeType.Worker);
        WorkerNoUSD = new Employee(1000,"EU",0.1f,EmployeeType.Worker);
    }
	
	/**
	 * Este caso de prueba evalúa el cálculo del salario
	 * para el tipo de empleado "Supervisor" cuando el tipo de moneda es USD. 
	 * Cuando el mes es PAR, el empleado NO recibe decimo.
	 * Cuando el mes es IMPAR, el empleado SI recibe decimo.
	 */
	@Test
	public void csSupervisorUSDDecimoFinal() {
		float salario = SupervisorUSD.cs();
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
	    localDate = date.toInstant()
	            .atZone(ZoneId.systemDefault()).toLocalDate();
	    int month = localDate.getMonthValue();
	    if(month%2==0) {
	    	valorEsperado = 458.605f;
	    }else {
	    	valorEsperado = 522.938f;
	    }
		assertEquals(valorEsperado, salario, 0.001);		
	}
	
	/**
	 * Este caso de prueba evalúa el cálculo del salario
	 * para el tipo de empleado "Supervisor" cuando el tipo de moneda NO es USD. 
	 * Cuando el mes es PAR, el empleado NO recibe decimo.
	 * Cuando el mes es IMPAR, el empleado SI recibe decimo.
	 */
	@Test
	public void csSupervisortestNoUSDDecimoFinal() {
		float salary = SupervisorNoUSD.cs();
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
	    localDate = date.toInstant()
	            .atZone(ZoneId.systemDefault()).toLocalDate();
	    int month = localDate.getMonthValue();
	    if(month%2==0) {
	    	valorEsperado = 435.771f;
	    }else {
	    	valorEsperado = 500.104f;
	    }
		assertEquals(valorEsperado, salary, 0.001);		
	}
	
	/**
	 * Este caso de prueba evalúa el cálculo del salario
	 * para un tipo de empleado "Worker", cuando el tiempo de moneda SI es USD.
	 * Cuando el mes es PAR, el empleado NO recibe decimo.
	 * Cuando el mes es IMPAR, el empleado SI recibe decimo.
	 */
	@Test
	public void csUSDWorkerDecimoTest() {
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
	    localDate = date.toInstant()
	            .atZone(ZoneId.systemDefault()).toLocalDate();
	    int month = localDate.getMonthValue();
	    if(month%2==0) {
	    	valorEsperado = 1000;
	    }else {
	    	valorEsperado = 1016.083f;
	    }
		assertEquals(valorEsperado, WorkerUSD.cs(), 0.0001);
	}
	
	/**
	 * Este caso de prueba evalúa el cálculo del salario
	 * para un tipo de empleado "Worker", cuando el tiempo de moneda NO es USD.
	 * Cuando el mes es PAR, el empleado NO recibe decimo.
	 * Cuando el mes es IMPAR, el empleado SI recibe decimo.
	 */
	@Test
	public void csNoUSDWorkerDecimoTest() {
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
	    localDate = date.toInstant()
	            .atZone(ZoneId.systemDefault()).toLocalDate();
	    int month = localDate.getMonthValue();
	    if(month%2==0) {
	    	valorEsperado = 950;
	    }else {
	    	valorEsperado = 966.083f;
	    }
		assertEquals(valorEsperado, WorkerNoUSD.cs(), 0.0001);
	}
}
