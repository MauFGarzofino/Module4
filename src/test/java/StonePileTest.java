import assignments.stonepile.StonePile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StonePileTest {

    @Test
    public void testMinimalDifferenceWithTwoStones() {
        int[] weights = {2, 3};
        assertEquals(1, StonePile.minimalDifference(weights), "The minimal difference should be 1.");
    }

    @Test
    public void testMinimalDifferenceWithEmptyArray() {
        int[] weights = {};
        assertEquals(0, StonePile.minimalDifference(weights), "The minimal difference should be 0 for an empty array.");
    }

    @Test
    public void testMinimalDifferenceWithEqualWeights() {
        int[] weights = {4, 4};
        assertEquals(0, StonePile.minimalDifference(weights), "The minimal difference should be 0 for equal weights.");
    }

    @Test
    public void testMinimalDifferenceWithMultipleStones() {
        int[] weights = {5, 8, 13, 27, 14};
        assertEquals(3, StonePile.minimalDifference(weights), "The minimal difference should be 3.");
    }
}