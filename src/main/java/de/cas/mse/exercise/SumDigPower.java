package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long rangeBegin, long rangeEnd) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = rangeBegin; currentNumber < rangeEnd; currentNumber++) {

			String currentNumberAsString = Long.toString(currentNumber);
			int numberOfDigits = currentNumberAsString.length();
			List<Long> digits = new ArrayList<Long>(numberOfDigits);

			// Split into digits
			for (int currentDigitIndex = 0; currentDigitIndex < numberOfDigits; currentDigitIndex++) {
				digits.add(Long.valueOf(currentNumberAsString.substring(currentDigitIndex, currentDigitIndex + 1)));
			}

			// Subtract powers of digits from currentNumber
			long rest = currentNumber;
			for (int currentDigitIndex = numberOfDigits; currentDigitIndex > 0; currentDigitIndex--) {
				// Use natural digit indices, as the lowest power is 1, not 0
				rest -= Math.pow(digits.get(currentDigitIndex - 1), currentDigitIndex);
				if (rest < 0) {
					// Power of current digit was too large, condition cannot be fulfilled with further digits!
					break;
				}
			}

			// Check if the subtraction of powers has rest
			if (rest == 0) {
				result.add(currentNumber);
			}

		}

        System.out.println(result);
		return result;

	}

}