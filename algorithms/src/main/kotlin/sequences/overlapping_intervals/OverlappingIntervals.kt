package sequences.overlapping_intervals

class OverlappingIntervals {
    fun mergeIntervals(intervals: Array<IntArray>): List<IntArray> {
        if (intervals.isEmpty()) return emptyList()

        // Step 1: Sort the intervals by their start time
        intervals.sortBy { it[0] }

        val merged = mutableListOf<IntArray>()

        // Step 2: Iterate through the intervals
        for (interval in intervals) {
            // If the merged list is empty or there is no overlap, add the interval
            if (merged.isEmpty() || merged.last()[1] < interval[0]) {
                merged.add(interval)
            } else {
                // If there is an overlap, merge the intervals
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }

        return merged
    }
}