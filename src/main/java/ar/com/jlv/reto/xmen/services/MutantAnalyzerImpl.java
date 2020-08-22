package ar.com.jlv.reto.xmen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import ar.com.jlv.reto.xmen.predicates.ValidLengthDna;

@Service
public class MutantAnalyzerImpl implements MutantAnalyzer {
	private static final int LENGTH_DNA_MUTANT = 4;
	private String mutantDna[] = { "AAAA", "CCCC", "GGGG", "TTTT" };

	@Override
	public boolean isMutant(final String[] dna) throws Exception {
		Predicate<String[]> validLengthDna = new ValidLengthDna();
		if (!validLengthDna.test(dna)) {
			throw new Exception("Error en la cadena de ADN.");
		}

		char[][] matrix = generateMatixDna(dna);
		printMatrix(matrix);
		final List<String> chainMutant = findDnaMutant(matrix);

		return chainMutant.size() > 1;
	}

	private List<String> findDnaMutant(final char[][] dna) {
		final List<String> chainMutant = new ArrayList<>();
		int x = dna[0].length;
		int y = dna.length;

		// Horizontal
		for (int i = 0; i < x; i++) {
			String sample = "";
			for (int b = 0; b < y; b++) {
				if ((b > 0 && dna[i][b] == dna[i][b - 1]) || b == 0) {
					sample += dna[i][b];
				} else {
					sample = String.valueOf(dna[i][b]);
				}

				if (sample.length() == LENGTH_DNA_MUTANT && isMutant(sample)) {
					chainMutant.add(sample);
					System.out.println("Muestra Horizontal: " + sample);
				}
			}
			System.out.println("Muestra Horizontal: " + sample);
		}

		// Vertical
		for (int b = 0; b < y; b++) {
			String sample = "";
			for (int i = 0; i < x; i++) {
				if ((i > 0 && dna[i][b] == dna[i - 1][b]) || i == 0) {
					sample += dna[i][b];
				} else {
					sample = String.valueOf(dna[i][b]);
				}

				if (sample.length() == LENGTH_DNA_MUTANT) {
					if (isMutant(sample)) {
						chainMutant.add(sample);
					}
					System.out.println("Muestra Vertical: " + sample);
				}
			}
			System.out.println("Muestra Vertical: " + sample);
		}

		// Oblicua nxn
		System.out.println(x);
		for (int i = 0; i <= x - LENGTH_DNA_MUTANT; i++) {
			String sample = "";
			char old = '0';
			for (int b = 0; b < x - i; b++) {
				if ((b > 0 && dna[b][b + i] == old) || b == 0) {
					sample += dna[b][b + i];
				} else {
					sample = String.valueOf(dna[i][b]);
				}
				if (sample.length() == LENGTH_DNA_MUTANT) {
					if (isMutant(sample)) {
						chainMutant.add(sample);
					}
					System.out.println("Muestra Vertical: " + sample);
				}
				old = dna[b][b + i];
			}

			System.out.println("Muestra sampleHorizaontal: " + sample);
			sample = "";
			if (i > 0) {
				for (int b = 0; b < x - i; b++) {

					if ((b > 0 && dna[b + i][b] == old) || b == 0) {
						sample += dna[b + i][b];
					} else {
						sample = String.valueOf(dna[i][b]);
					}
					if (sample.length() == LENGTH_DNA_MUTANT) {
						if (isMutant(sample)) {
							chainMutant.add(sample);
						}
						System.out.println("Muestra Vertical: " + sample);
					}
					old = dna[b + i][b];

				}
			}
			System.out.println("Muestra sampleVertical: " + sample);
		}

		return chainMutant;
	}

	private boolean isMutant(String value) {
		for (String chain : mutantDna) {
			if (chain.equals(value)) {
				return true;
			}
		}
		return false;
	}

	private char[][] generateMatixDna(final String... values) {
		int x = values[0].length();
		int y = values.length;
		char[][] matrix = new char[x][y];
		for (int i = 0; i < x; i++) {
			String chain = values[i];
			for (int b = 0; b < y; b++) {
				matrix[i][b] = chain.toCharArray()[b];
			}
		}
		return matrix;
	}

	private void printMatrix(final char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			StringBuffer chain = new StringBuffer();
			for (int b = 0; b < matrix[i].length; b++) {
				chain.append(matrix[i][b]);
				chain.append(" ");
			}
			System.out.println(chain);
		}
	}

}
