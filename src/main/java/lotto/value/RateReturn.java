package lotto.value;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record RateReturn(BigDecimal rateOfReturn) {

    public static RateReturn by(Won totalOfWinningPrize, Won amountOfPaid) {
        return new RateReturn(new BigDecimal(totalOfWinningPrize.getIntValue())
                .divide(new BigDecimal(amountOfPaid.getIntValue()), 2, RoundingMode.HALF_UP));
    }

}
