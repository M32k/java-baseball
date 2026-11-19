package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {

    @Test
    void 올바른_입력이면_예외가_없다() {
        assertThatCode(() -> new BaseballNumbers("123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 세자리가_아니면_예외() {
        assertThatThrownBy(() -> new BaseballNumbers("12"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_1부터_9_사이가_아니면_예외() {
        assertThatThrownBy(() -> new BaseballNumbers("103"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNumbers("1a3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_숫자가_있으면_예외() {
        assertThatThrownBy(() -> new BaseballNumbers("112"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
