package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerInclusive, long upperInclusive) {
		List<Long> eurekaNumbers = new ArrayList<Long>();

		// Kein Toter Code nur ne andere lösung ;-)
		//var result = List.of(LongStream.range(lowerInclusive, upperInclusive+1).filter(this::isEurekaNumber));
		
		for (long number = lowerInclusive; number <= upperInclusive; number++) {
			if (isEurekaNumber(number)) {
				eurekaNumbers.add(number);
			}
		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;
	}

	private boolean isEurekaNumber(long number) {
		String digits = Long.toString(number);

		long sum = 0;
		for (int digitIndex = 0; digitIndex < digits.length(); digitIndex++) {
			var digit = getDigitAtIndex(digits, digitIndex);
			sum += Math.pow(digit, digitIndex + 1);
		}

		return sum == number;
	}

	private Long getDigitAtIndex(String number, int index) {
		return Long.valueOf(number.substring(index, index+1));
	}

}