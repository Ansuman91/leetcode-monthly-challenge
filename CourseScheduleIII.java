package com.leetcode.may;

public class CourseScheduleIII {

    //class Solution {
        public int scheduleCourse(int[][] courses) {
            //
            //Sort based on endTime
            Arrays.sort(courses, (a,b)->a[1]-b[1]);
            //push descending value in pq
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
            int time = 0 ;
            for(int[] c: courses){
                time += c[0];
                pq.add(c[0]);
                //if time is greater than endTime then replace with largest duration course
                if(time > c[1]){
                    time -= pq.poll();
                }
            }
            return pq.size();
        }
   // }
}
