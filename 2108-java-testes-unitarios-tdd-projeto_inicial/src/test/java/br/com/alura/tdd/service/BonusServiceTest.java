package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionariosComSalariosMuitoAlto() {
		BonusService service = new BonusService();
		//Essa � uma forma de capturar excess�es
		//assertThrows(IllegalArgumentException.class, 
				//() -> service.calcularBonus(new Funcionario("Beto", LocalDate.now(),new BigDecimal("25000"))));
		//Essa � outra maneira
		try {
			service.calcularBonus(new Funcionario("Beto", LocalDate.now(),new BigDecimal("25000")));
			fail("n�o deu exception!");
		} catch (Exception e) {
			assertEquals("Funcionario com s�lario superior h� R$10.000,00 n�o pode receber b�nus!", e.getMessage());
		}
			}
	 
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Alberto", LocalDate.now(),new BigDecimal("2500")));
		
		
		assertEquals(new BigDecimal("250.0"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gilberto", LocalDate.now(),new BigDecimal("10000")));
		
		
		assertEquals(new BigDecimal("1000.0"), bonus);
	}

}
