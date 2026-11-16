package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Part B4, stage 1: minimal ALL-DEFS set (2 tests).
 * Line numbers refer to DataFlowTargets.java. Pair IDs (AT1.., SC1.. ...) are the ones in README.md.
 */
class BonusTest {

    @Test
    @DisplayName("t01 all-defs: first day present, break, then 5-day streak, present 7 < threshold 8. "
            + "Defs reaching a use: streak@36,41,46; best@37,43; present@35,40; score@49,54; a@38")
    void t01_allDefs_streakAfterBreak() {
        assertEquals(3, DataFlowTargets.bonus(new int[] {1, 1, 0, 1, 1, 1, 1, 1}, 8));
    }

    @Test
    @DisplayName("t02 all-defs: single present day meets threshold. Defs: score@51 (51->56)")
    void t02_allDefs_singleDayMeetsThreshold() {
        assertEquals(5, DataFlowTargets.bonus(new int[] {1}, 1));
    }
}