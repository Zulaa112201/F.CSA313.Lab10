package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Part B4. Stage 1 (commit "B all-defs"): t01, t02. Stage 2 (commit "B all-DU-pairs"): t03..t11.
 * Line numbers refer to DataFlowTargets.java. Pair IDs (AT1.., SC1.. ) are the ones in README.md.
 */
class BonusTest {

    @Test
    @DisplayName("t01 all-defs: first day present, break, then 5-day streak; present 7 < threshold 8. Pairs: AT1 AT3 AT4 TH1 TH3 AV1 AV2 PR1 PR4 PR5 ST1 ST2 ST3 ST4 ST5 ST6 BE2 BE5 BE6 BE8 SC1 SC5")
    void t01_allDefs_streakAfterBreak() {
        assertEquals(3, DataFlowTargets.bonus(new int[] {1, 1, 0, 1, 1, 1, 1, 1}, 8));
    }

    @Test
    @DisplayName("t02 all-defs: single present day meets threshold. Pairs: AT1 AT3 AT4 TH1 TH4 AV2 PR1 PR6 ST1 ST4 ST5 BE2 BE7 SC4")
    void t02_allDefs_singleDayMeetsThreshold() {
        assertEquals(5, DataFlowTargets.bonus(new int[] {1}, 1));
    }

    @Test
    @DisplayName("t03: attendance == null -> exception (null branch of line 32). Pairs: AT2")
    void t03_nullAttendanceThrows() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, 1));
    }

    @Test
    @DisplayName("t04: threshold < 0 -> exception (second condition of line 32). Pairs: AT1 TH2")
    void t04_negativeThresholdThrows() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[] {1}, -1));
    }

    @Test
    @DisplayName("t05: empty array, threshold 0 (present 0 >= 0). Pairs: AT1 AT3 TH1 TH4 PR3 BE3 SC4")
    void t05_emptyArrayThresholdZero() {
        assertEquals(5, DataFlowTargets.bonus(new int[] {}, 0));
    }

    @Test
    @DisplayName("t06: empty array, threshold 1 (present 0 < 1). Pairs: AT1 AT3 TH1 TH3 PR2 BE3 SC2")
    void t06_emptyArrayThresholdOne() {
        assertEquals(0, DataFlowTargets.bonus(new int[] {}, 1));
    }

    @Test
    @DisplayName("t07: break then one day: streak 1 <= best 1 (42 F). Pairs: AT1 AT3 AT4 TH1 TH4 AV1 AV2 PR1 PR4 PR6 ST1 ST3 ST4 ST5 ST6 BE2 BE5 BE7 SC4")
    void t07_breakThenSingleDay() {
        assertEquals(5, DataFlowTargets.bonus(new int[] {1, 0, 1}, 2));
    }

    @Test
    @DisplayName("t08: exactly 5 consecutive days, present == threshold. Pairs: AT1 AT3 AT4 TH1 TH4 AV2 PR1 PR4 PR6 ST1 ST2 ST4 ST5 BE2 BE6 BE8 SC3 SC5")
    void t08_streakFiveAtThreshold() {
        assertEquals(8, DataFlowTargets.bonus(new int[] {1, 1, 1, 1, 1}, 5));
    }

    @Test
    @DisplayName("t09: one present day below threshold. Pairs: AT1 AT3 AT4 TH1 TH3 AV2 PR1 PR5 ST1 ST4 ST5 BE2 BE7 SC2")
    void t09_singleDayBelowThreshold() {
        assertEquals(0, DataFlowTargets.bonus(new int[] {1}, 2));
    }

    @Test
    @DisplayName("t10: all absent (else branch only). Pairs: AT1 AT3 AT4 TH1 TH3 AV1 PR2 BE3 SC2")
    void t10_allAbsent() {
        assertEquals(0, DataFlowTargets.bonus(new int[] {0, 0, 0}, 1));
    }

    @Test
    @DisplayName("t11: streak longer than 5. Pairs: AT1 AT3 AT4 TH1 TH4 AV2 PR1 PR4 PR6 ST1 ST2 ST4 ST5 BE2 BE6 BE8 SC3 SC5")
    void t11_longStreakSeven() {
        assertEquals(8, DataFlowTargets.bonus(new int[] {1, 1, 1, 1, 1, 1, 1}, 3));
    }
}