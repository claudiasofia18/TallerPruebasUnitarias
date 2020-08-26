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
	private Employee ManagerUSD;
	private Employee ManagerNoUSD;
	private Employee WorkerUSDyear;
	private Employee SupervisorUSDyear;
	private Employee ManagerUSDyear;
	private Employee WorkerNoUSDyear;
	private Employee SupervisorNoUSDyear;
	private Employee ManagerNoUSDyear;

	@Before
	public void init() {
		SupervisorUSD = new Employee(456.68F, "USD", 5.5F, EmployeeType.Supervisor);
		SupervisorNoUSD = new Employee(456.68F, "WON", 5.5F, EmployeeType.Supervisor);
		WorkerUSD = new Employee(1000, "USD", 0.1f, EmployeeType.Worker);
		WorkerNoUSD = new Employee(1000, "EU", 0.1f, EmployeeType.Worker);
		ManagerUSD = new Employee(5000.99f, "USD", 2.3F, EmployeeType.Manager);
		ManagerNoUSD = new Employee(5000.99f, "YEN", 2.3F, EmployeeType.Manager);

		WorkerUSDyear = new Employee(456.68F, "USD", 0.0f, EmployeeType.Worker);
		SupervisorUSDyear = new Employee(1000f, "USD", 0.0f, EmployeeType.Supervisor);
		ManagerUSDyear = new Employee(5000.99f, "USD", 0.0f, EmployeeType.Manager);

		WorkerNoUSDyear = new Employee(456.68F, "MXN", 0.0f, EmployeeType.Worker);
		SupervisorNoUSDyear = new Employee(1000f, "YEN", 0.0f, EmployeeType.Supervisor);
		ManagerNoUSDyear = new Employee(5000.99f, "EU", 0.0f, EmployeeType.Manager);

	}

	/**
	 * Este caso de prueba evalúa el cálculo del salario para el tipo de empleado
	 * "Supervisor" cuando el tipo de moneda es USD. Cuando el mes es PAR, el
	 * empleado NO recibe decimo. Cuando el mes es IMPAR, el empleado SI recibe
	 * decimo.
	 */
	@Test
	public void csSupervisorUSDDecimoFinal() {
		float salario = SupervisorUSD.cs();
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
		localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		if (month % 2 == 0) {
			valorEsperado = 458.605f;
		} else {
			valorEsperado = 522.938f;
		}
		assertEquals(valorEsperado, salario, 0.001);
	}

	/**
	 * Este caso de prueba evalúa el cálculo del salario para el tipo de empleado
	 * "Supervisor" cuando el tipo de moneda NO es USD. Cuando el mes es PAR, el
	 * empleado NO recibe decimo. Cuando el mes es IMPAR, el empleado SI recibe
	 * decimo.
	 */
	@Test
	public void csSupervisortestNoUSDDecimoFinal() {
		float salary = SupervisorNoUSD.cs();
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
		localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		if (month % 2 == 0) {
			valorEsperado = 435.771f;
		} else {
			valorEsperado = 500.104f;
		}
		assertEquals(valorEsperado, salary, 0.001);
	}

	/**
	 * Este caso de prueba evalúa el cálculo del salario para un tipo de empleado
	 * "Worker", cuando el tiempo de moneda SI es USD. Cuando el mes es PAR, el
	 * empleado NO recibe decimo. Cuando el mes es IMPAR, el empleado SI recibe
	 * decimo.
	 */
	@Test
	public void csUSDWorkerDecimoTest() {
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
		localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		if (month % 2 == 0) {
			valorEsperado = 1000;
		} else {
			valorEsperado = 1016.083f;
		}
		assertEquals(valorEsperado, WorkerUSD.cs(), 0.0001);
	}

	/**
	 * Este caso de prueba evalúa el cálculo del salario para un tipo de empleado
	 * "Worker", cuando el tiempo de moneda NO es USD. Cuando el mes es PAR, el
	 * empleado NO recibe decimo. Cuando el mes es IMPAR, el empleado SI recibe
	 * decimo.
	 */
	@Test
	public void csNoUSDWorkerDecimoTest() {
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
		localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		if (month % 2 == 0) {
			valorEsperado = 950;
		} else {
			valorEsperado = 966.083f;
		}
		assertEquals(valorEsperado, WorkerNoUSD.cs(), 0.0001);
	}

	/**
	 * Este caso de prueba evalúa el cálculo del salario para un tipo de empleado
	 * "Manager", cuando el tipo de moneda es USD. Cuando el mes es PAR, el empleado
	 * NO recibe decimo. Cuando el mes es IMPAR, el empleado SI recibe decimo.
	 */
	@Test
	public void csUSDManagerDecimoTest() {
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
		localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		if (month % 2 == 0) {
			valorEsperado = 5002.6f;
		} else {
			valorEsperado = 5018.683f;
		}
		assertEquals(valorEsperado, ManagerUSD.cs(), 0.001);
	}

	/**
	 * Este caso de prueba evalúa el cálculo del salario para un tipo de empleado
	 * "Manager", cuando el tipo de moneda es NoUSD. Cuando el mes es PAR, el
	 * empleado NO recibe decimo. Cuando el mes es IMPAR, el empleado SI recibe
	 * decimo.
	 */
	@Test
	public void csNoUSDManagerDecimoTest() {
		float valorEsperado;
		Date date = new Date();
		LocalDate localDate;
		localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		if (month % 2 == 0) {
			valorEsperado = 4752.55f;
		} else {
			valorEsperado = 4816.884f;
		}
		assertEquals(valorEsperado, ManagerNoUSD.cs(), 0.001);
	}

	// metodo CalculateYearBonus().

	/**
	 * En este caso de prueba se evalua el bono de fin de aÃ±o para un tipo de
	 * empleado "Worker", cuando el tipo de moneda es USD. en donde se considera
	 * todo el salario.
	 */

	@Test
	public void CalculateYearBonusUSDWTest() {
		assertEquals(386.0f, WorkerUSDyear.CalculateYearBonus(), 0.001);

	}

	/**
	 * En este caso de prueba se evalua el bono de fin de aÃ±o para un tipo de
	 * empleado "Supervisor", cuando el tipo de moneda es USD. en donde se considera
	 * todo el salario.
	 */

	@Test
	public void CalculateYearBonusUSDSTest() {
		assertEquals(1193f, SupervisorUSDyear.CalculateYearBonus(), 0.001);

	}

	/**
	 * En este caso de prueba se evalua el bono de fin de aÃ±o para un tipo de
	 * empleado "Manager", cuando el tipo de moneda es USD. en donde se considera
	 * todo el salario.
	 */

	@Test
	public void CalculateYearBonusUSDMTest() {
		assertEquals(5386.99f, ManagerUSDyear.CalculateYearBonus(), 0.001);

	}

	/**
	 * En este caso de prueba se evalua el bono de fin de aÃ±o para un tipo de
	 * empleado "Worker", cuando el tipo de moneda no es USD. en donde se considera
	 * un porcentaje del salario.
	 */

	@Test
	public void CalculateYearBonusNoUSDWTest() {
		assertEquals(386.0f, WorkerNoUSDyear.CalculateYearBonus(), 0.001);

	}

	/**
	 * En este caso de prueba se evalua el bono de fin de aÃ±o para un tipo de
	 * empleado "Supervisor", cuando el tipo de moneda no es USD. en donde se
	 * considera un porcentaje del salario.
	 */

	@Test
	public void CalculateYearBonusNoUSDSTest() {
		assertEquals(1143f, SupervisorNoUSDyear.CalculateYearBonus(), 0.001);

	}

	/**
	 * En este caso de prueba se evalua el bono de fin de aÃ±o para un tipo de
	 * empleado "Manager", cuando el tipo de moneda no es USD. en donde se considera
	 * un porcentaje del salario.
	 */

	@Test
	public void CalculateYearBonusNoUSDMTest() {
		assertEquals(5136.9405f, ManagerNoUSDyear.CalculateYearBonus(), 0.001);

	}

}
