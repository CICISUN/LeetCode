import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class insert {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		int i=0; Interval cur=null;
		if(intervals.size()==0) {intervals.add(newInterval); return intervals;}

		while(i<intervals.size()){
			cur=intervals.get(i);
			if(cur.end<newInterval.start) {i++;continue;}
			else if(cur.start>newInterval.end) break;
			else {
				newInterval.start=Math.min(newInterval.start, cur.start);
				newInterval.end=Math.max(newInterval.end, cur.end);
				intervals.remove(i);
			}
		}

		intervals.add(i, newInterval);

		//			  if(cur.start<=newInterval.start && cur.end>=newInterval.start)
		//			  { cur.end=Math.max(cur.end, newInterval.end); i++;}
		//			  else if(cur.start<=newInterval.start && cur.end>newInterval.end)
		//				  i++;
		//			  else if(cur.start>=newInterval.start && cur.end<newInterval.end)
		//				  {intervals.remove(i);intervals.add(newInterval);i++;}
		//			  else if(cur.start>=newInterval.start && cur.end>=newInterval.end)
		//				  {cur.start=Math.min(cur.start, newInterval.start);i++;}
		//			  else if(cur.end<newInterval.start||cur.start>newInterval.end)
		//			  {intervals.add(newInterval); return intervals;}




		return intervals;


	}
	
	public ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
	    int insertPosition = insertByStart(intervals, newInterval.start, 0, intervals.size() - 1);
	    intervals.add(insertPosition, newInterval);
	    Iterator<Interval> it = intervals.iterator();
	    Interval prev = it.next();
	    while (it.hasNext()) {
	        Interval curr = it.next();
	        if (overlap(prev, curr)) {
	            prev.start = Math.min(prev.start, curr.start);
	            prev.end = Math.max(prev.end, curr.end);
	            it.remove();
	        } else {
	            prev = curr;
	        }
	    }
	    return intervals;
	}
	private int insertByStart(ArrayList<Interval> intervals, int x, int p, int q) {
	    if (p > q)
	        return p;
	    int mid = (p + q) / 2;
	    if (intervals.get(mid).start < x) {
	        return insertByStart(intervals, x, mid + 1, q);
	    } else {
	        return insertByStart(intervals, x, p, mid - 1);
	    }
	}
	private boolean overlap(Interval a, Interval b) {
	    return within(a.start, b) || within(a.end, b) || within(b.start, a) || within(b.end, a);
	}
	private boolean within(int v, Interval b) {
	    return v >= b.start && v <= b.end;
	}
	
	
	
	public ArrayList<Interval> insert3(ArrayList<Interval> intervals, Interval newInterval) {
		Interval cur=null;
		if(intervals.size()==0) {intervals.add(newInterval); return intervals;}
		ListIterator<Interval> it=intervals.listIterator();
		while(it.hasNext()){
			cur=it.next();
			if(newInterval.end<cur.start) {it.previous();it.add(newInterval);return intervals;}
			else if(newInterval.start>cur.end) continue;
			else {
				newInterval.start=Math.min(newInterval.start, cur.start);
				newInterval.end=Math.max(newInterval.end, cur.end);
				it.remove();
			}
		}
		intervals.add(newInterval);
		return intervals;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
