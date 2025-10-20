package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerBoundInclusive, long upperBoundExclusive) {

		List<Long> eurekaNumbers = new ArrayList<Long>();

		for (long currentNumber = lowerBoundInclusive; currentNumber < upperBoundExclusive; currentNumber++) {

			String currentNumberAsString = Long.toString(currentNumber);
		
			long sum = 0;
			for (int digitIndex = 0; digitIndex < currentNumberAsString.length(); digitIndex++) {
				long digit = getDigit(currentNumberAsString, digitIndex);
				sum += Math.pow(digit, getDigitExponent(digitIndex));
			}

			if (sum == currentNumber) {
				eurekaNumbers.add(sum);
			}

		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;

	}

	private int getDigitExponent(int digitIndex) {
		return digitIndex + 1;
	}

	private long getDigit(String currentNumber, int index) {
		return Long.valueOf(currentNumber.substring(index, getDigitExponent(index)));
	}

}