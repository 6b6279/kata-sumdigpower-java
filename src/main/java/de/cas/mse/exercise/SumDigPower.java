package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerBoundary, long upperBoundary) {

		List<Long> eurekaNumbers = new ArrayList<Long>();

		for (long number = lowerBoundary; number < upperBoundary; number++) {

			List<Long> digits = splitNumbertoDigits(number);

			long sum = calculateEurekaSum(digits);

			if (sum == number) {
				eurekaNumbers.add(sum);
			}

		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;
	}

	private List<Long> splitNumbertoDigits(long number) {
		List<Long> digits = new ArrayList<Long>();
		String temp = Long.toString(number);

			for (int i = 0; i < temp.length(); i++) {
				digits.add(Long.valueOf(temp.substring(i, i + 1)));
			}

		return digits;
	}


	private long calculateEurekaSum(List<Long> digits) {
		long sum = 0;
			for (int i = 1; i <= digits.size(); i++) {
				sum += Math.pow(digits.get(i - 1), i);
			}

		return sum;
	}
}