package dp.subset_sum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubsetSumUnitTest {
    private val solver = SubsetSum()

    @Test
    fun `Test subset sum exists`() {
        val nums = intArrayOf(3, 34, 4, 12, 5, 2)
        val target = 9
        assertTrue(solver.canAchieveTarget(nums, target)) // 4 + 5
    }

    @Test
    fun `Test subset sum does not exist`() {
        val nums = intArrayOf(3, 34, 4, 12, 5, 2)
        val target = 30
        assertFalse(solver.canAchieveTarget(nums, target))
    }

    @Test
    fun `Test empty array with zero target`() {
        val nums = intArrayOf()
        val target = 0
        assertTrue(solver.canAchieveTarget(nums, target)) // Empty subset
    }

    @Test
    fun `Test empty array with non-zero target`() {
        val nums = intArrayOf()
        val target = 5
        assertFalse(solver.canAchieveTarget(nums, target))
    }

    @Test
    fun `Test single element equal to target`() {
        val nums = intArrayOf(7)
        val target = 7
        assertTrue(solver.canAchieveTarget(nums, target))
    }

    @Test
    fun `Test single element not equal to target`() {
        val nums = intArrayOf(3)
        val target = 7
        assertFalse(solver.canAchieveTarget(nums, target))
    }

}