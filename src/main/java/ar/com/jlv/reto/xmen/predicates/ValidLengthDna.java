package ar.com.jlv.reto.xmen.predicates;

import java.util.Objects;
import java.util.function.Predicate;

public class ValidLengthDna implements Predicate<String[]> {
	
	@Override
	public boolean test(String values[]) {
		boolean result = true;
		if (Objects.isNull(values) || values.length == 0) {
			result = false;
		} else {
			int size = values[0].length();
			for (String value : values) {
				if (value.length() != size) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

}
