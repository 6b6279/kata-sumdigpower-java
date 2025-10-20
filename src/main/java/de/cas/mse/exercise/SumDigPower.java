package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> findEurekas(long intervalStart, long intervalEnd) {

		List<Long> eurekas = new ArrayList<Long>();

		for (long number = intervalStart; number < intervalEnd; number++) {

			List<Long> digits = extractDigits(Long.toString(number));

			long sum = sumDigitsPower(digits);

			if (sum == number) {
				eurekas.add(sum);
			}

		}

        System.out.println(eurekas);
		return eurekas;

	}

	private List<Long> extractDigits(String number) {
		List<Long> digits = new ArrayList<Long>();
		for (int digitIndex = 0; digitIndex < number.length(); digitIndex++) {
			digits.add(Long.valueOf(number.substring(digitIndex, digitIndex + 1)));
		}
		return digits;
	}
	
	private long sumDigitsPower(List<Long> digits) {
		long sum = 0;
		for (int digitIndex = 0; digitIndex < digits.size(); digitIndex++) {
			sum += Math.pow(digits.get(digitIndex), digitIndex + 1);
		}
		return sum;
	}
}