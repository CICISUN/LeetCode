import java.util.*;

/**
 * FB  mianjing
 * 
I
Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , determine if a person could attend all meetings.

For example,
Given [ [0, 30], [5, 10], [15, 20] ],
return false.

II
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.
http://tiancao.me/Leetcode-Unlocked/LeetCode%20Locked/c1.6.html
*/

class meetingRoom{

    public static boolean canAttendMeetings(Interval[] meetings){
        Arrays.sort(meetings, (a,b) -> a.start-b.start);
        for(int i=0; i<meetings.length-1 ; i++) {
            if(meetings[i].end > meetings[i+1].start) return false;
        }
        return true;
    }

    // pq to store endTimes, earlier end times compared first
    public static int totalMeetingRooms(Interval[] meetings){
        Arrays.sort(meetings, (a,b) -> a.start-b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>(meetings.length, (a, b) -> a - b);
        pq.offer(meetings[0].end);
        for(int i=1; i<meetings.length ; i++) {
            if(meetings[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(meetings[i].end);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Interval a = new Interval(0, 30);
        Interval b = new Interval(5, 10);
        Interval c = new Interval(10, 20);
        Interval[] meetings = {a, b, c};
        System.out.println(meetingRoom.canAttendMeetings(meetings));
        System.out.println(meetingRoom.totalMeetingRooms(meetings));

    }
}