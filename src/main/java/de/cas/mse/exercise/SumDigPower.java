package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long rangeBegin, long rangeEnd) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = rangeBegin; currentNumber < rangeEnd; currentNumber++) {

			List<Long> digits = new ArrayList<Long>();

			String currentNumberAsString = Long.toString(currentNumber);
			int numberOfDigits = currentNumberAsString.length();

			// Split into digits
			for (int currentDigitIndex = 0; currentDigitIndex < numberOfDigits; currentDigitIndex++) {
				digits.add(Long.valueOf(currentNumberAsString.substring(currentDigitIndex, currentDigitIndex + 1)));
			}

			// Create sum of powers of digits
			long sum = 0;
			for (int currentDigitIndex = 1; currentDigitIndex <= digits.size(); currentDigitIndex++) {
				// Use natural digit indices, as the lowest power is 1, not 0
				sum += Math.pow(digits.get(currentDigitIndex - 1), currentDigitIndex);
			}

			// Test if sum is equal
			if (sum == currentNumber) {
				result.add(sum);
			}

		}

        System.out.println(result);
		return result;

	}

}