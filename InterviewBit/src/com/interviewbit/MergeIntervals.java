/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Interval i1 = new Interval(4, 5);
		Interval i2 = new Interval(6, 7);
		Interval i3 = new Interval(8, 9);

		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);

		Interval newInterval = new Interval(5, 8);

		System.out.println(insert(intervals, newInterval));

	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		if (newInterval.start > newInterval.end) {

			newInterval.start = newInterval.start + newInterval.end - (newInterval.end = newInterval.start);

		}
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		ArrayList<Interval> result = new ArrayList<Interval>();
		boolean added = false;
		for (Interval interval : intervals) {

			if (interval.end < newInterval.start) {
				result.add(interval);
				
			} else if (interval.start > newInterval.end) {

				if (added) {
					result.add(interval);

				} else {
					result.add(newInterval);

					result.add(interval);
					added = true;
				}
			} else {

				Interval n = new Interval();

				n.start = Math.min(interval.start, newInterval.start);
				n.end = Math.max(interval.end, newInterval.end);
				if (added) {
					result.remove(result.size() - 1);
				}

				result.add(n);
				newInterval = n;
				added = true;
			}
		}

		if (!added) {
			result.add(newInterval);
		}
		return result;

	}

}
