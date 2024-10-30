package lotto.value;

import java.util.List;

public record LottoNumbers(List<LottoNumber> lottoNumbers) {

    public static final int SIZE_OF_NUMBERS = 6;

    public LottoNumbers {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("[ERROR] null을 지정할 수 없습니다.");
        }
        if (lottoNumbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException(String.format("[ERROR] 정상적인 로또 번호의 개수는 %d입니다.", SIZE_OF_NUMBERS));
        }
        if (isNumbersDuplicated(lottoNumbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }

        lottoNumbers = List.copyOf(lottoNumbers.stream()
                .sorted()
                .toList());
    }

    private static boolean isNumbersDuplicated(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != lottoNumbers.stream()
                .map(LottoNumber::number)
                .distinct()
                .count();
    }

}
