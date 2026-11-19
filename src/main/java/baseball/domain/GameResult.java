package baseball.domain;

public class GameResult {

    private static final int THREE_STRIKE = 3;

    private final int strike;
    private final int ball;
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isThreeStrike() {
        return strike == THREE_STRIKE;
    }

    public String toMessage() {
        if (isNothing()) {
            return NOTHING;
        }
        if (ball == 0) {
            return strike + STRIKE;
        }
        // ★1: strike가 0이면 → 볼 개수 + BALL 을 return
        if(strike == 0) {
            return ball + BALL;
        }

        // ★2: 위에 다 안 걸리면(둘 다 있음) → "1볼 1스트라이크" 모양으로 return
        //     힌트: ball + BALL + " " + strike + STRIKE
        return ball + BALL + " " + strike + STRIKE;
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }

}