package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Part A: all-DU-pairs coverage for gcd(x, y).
 * Line numbers refer to DataFlowTargets.java (13 params, 15 while, 16 tmp, 17 x, 18 y, 20 return).
 * Pair IDs (X1.., Y1.., T1) are the ones in README.md.
 */
class GcdTest {

    @Test
    @DisplayName("G1 gcd(12,8)=4: two iterations. Covers X1(13->16) X3(17->16) X4(17->20) "
            + "Y1(13->15 T) Y3(13->16) Y4(13->17) Y5(18->15 T) Y6(18->15 F) Y7(18->16) Y8(18->17) T1(16->18)")
    void gcd_12_8_twoIterations() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }

    @Test
    @DisplayName("G2 gcd(7,0)=7: loop body skipped. ONLY test for X2(13->20) and Y2(13->15 F)")
    void gcd_7_0_loopSkipped() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("G3 gcd(0,5)=5: x=0 swapped in one iteration. Extra boundary test (no new pair)")
    void gcd_0_5_oneIteration() {
        assertEquals(5, DataFlowTargets.gcd(0, 5));
    }
}
