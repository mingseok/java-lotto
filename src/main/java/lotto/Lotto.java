package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.constants.ExceptionMessage;

public class Lotto {

    private static final int LOTTO_SIZE_NUM = 6;
    private static final int DIGIT_NUM = 6;
    private static final String REGULAR_PATTERN = "^[0-9,]*$";
    private static final int START_BETWEEN_NUMBER = 1;
    private static final int LAST_BETWEEN_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateCharacters(numbers);
        validateNumbers(numbers);
        validateBetween(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateBetween(List<Integer> numbers) {
        for (Integer lotto : numbers) {
            if (!(lotto >= START_BETWEEN_NUMBER && lotto <= LAST_BETWEEN_NUMBER)) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBERS_BETWEEN);
            }
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_INPUT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> hashSet = new HashSet<>((numbers));

        if (hashSet.size() != DIGIT_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_INPUT);
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != DIGIT_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INPUT);
        }
    }

    public void validateCharacters(List<Integer> numbers) {
        for (int lotto : numbers) {
            String oneWord = String.valueOf(lotto);
            if (!(oneWord.matches(REGULAR_PATTERN))) {
                throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_CHARACTERS);
            }
        }
    }

    public ArrayList getNumbers() {
        return new ArrayList(numbers);
    }
}