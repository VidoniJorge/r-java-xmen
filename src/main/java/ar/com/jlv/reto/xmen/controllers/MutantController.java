package ar.com.jlv.reto.xmen.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.jlv.reto.xmen.dtos.DnaDTO;
import ar.com.jlv.reto.xmen.services.MutantAnalyzer;

@RestController
public class MutantController {
	private MutantAnalyzer mutantAnalyzer;

	public MutantController(final MutantAnalyzer mutantAnalyzer) {
		this.mutantAnalyzer = mutantAnalyzer;
	}

	@PostMapping(path="mutant/analyzer")
	public DnaDTO isMutant(final @RequestBody DnaDTO dna ) throws Exception {
		dna.setMutant(mutantAnalyzer.isMutant(dna.getDna()));
		return dna;
	}
}
