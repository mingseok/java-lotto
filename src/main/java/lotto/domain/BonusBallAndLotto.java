package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.subaction.BonusNumberCase;

public class BonusBallAndLotto {
    private static final int BONUS_CONDITIONS = 5;

    private final BonusNumberCase bonusNumberCase;

    public BonusBallAndLotto(BonusNumberCase bonusNumberCase) {
        this.bonusNumberCase = bonusNumberCase;
    }

    public List<Integer> getCorrectLocation(Lotto lottoAnswer, List<List<Integer>> random, List<Integer> resultNumber, int bonus) {
        List<Integer> WinningNumbers = lottoAnswer.getNumbers();
        List<Integer> result = new ArrayList<>();

        for (Integer integer : resultNumber) {
            int bonusCaseCount = 0;
            int correctNumberCheck = 0;

            if (integer == BONUS_CONDITIONS) {
                bonusCaseCount = bonusNumberCase.getBonusCount(random, bonus, WinningNumbers,
                        bonusCaseCount, correctNumberCheck);
            }
            result.add(bonusCaseCount);
        }
        return result;
    }
}