package test;
import Taller.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EmployeeTest {
	
	private Employee SupervisorUSD;
	private Employee SupervisorNoUSD;
	
	@Before
    public void init() {
		SupervisorUSD =  new Employee(456.68F, "USD", 5.5F, EmployeeType.Supervisor);
		SupervisorNoUSD = new Employee(456.68F, "WON", 5.5F, EmployeeType.Supervisor);
        
    }
	
	/*
	 * Este caso de prueba evalúa el cálculo del salario
	 * para el tipo de empleado "Supervisor" cuando el tipo de moneda es USD 
	 * y el mes es impar, por lo que también recibe el décimo junto con su 
	 * salario y un bono.
	 */
	
	@Test
	public void csSupervisorUSDDecimoFinal() {
		float salario = SupervisorUSD.cs();
		assertEquals(522.938, salario,0.001);		
	}
	
	
	/*
	 * Este caso de prueba evalúa el cálculo del salario
	 * para el tipo de empleado "Supervisor" cuando el tipo de moneda es USD 
	 * y el mes es par.
	 */
	
	@Test
	public void csSupervisorUSDNoDecimoFinal() {
		float salario = SupervisorUSD.cs();
		assertEquals(458.605, salario,0.001);		
	}
	
	
	/*
	 * Este caso de prueba evalúa el cálculo del salario
	 * para el tipo de empleado "Supervisor" cuando el tipo de moneda no es USD 
	 * y el mes es impar, por lo que también recibe el décimo junto con su 
	 * salario y un bono.
	 */
	
	@Test
	public void csSupervisortestNoUSDDecimoFinal() {
		float salary = SupervisorNoUSD.cs();
		assertEquals(500.104, salary,0.001);		
	}
	
	/*
	 * Este caso de prueba evalúa el cálculo del salario
	 * para el tipo de empleado "Supervisor" cuando el tipo de moneda no es USD 
	 * y el mes es par.
	 */
	
	@Test
	public void csSupervisortestNoUSDNoDecimoFinal() {
		float salary = SupervisorNoUSD.cs();
		assertEquals(435.771, salary,0.001);		
	}
	

	

}
