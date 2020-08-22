package ar.com.jlv.reto.xmen.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutantAnalyzerImplTest {

	@Test
	void testIsMutant() throws Exception {
		MutantAnalyzer service = new MutantAnalyzerImpl();
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		
		boolean response = service.isMutant(dna);
		assertTrue(response);
		
	}
}
