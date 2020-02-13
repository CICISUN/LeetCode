// # We uses Oozie as job scheduler to run a series of jobs to handle our internal data flow.
// # Each job will run after all of its upstream jobs finish.
// # Given a list of jobs with their running time and upstream jobs, we would like to derive a schedule of how the job will be run, and the minimu running time.
// #  You can use the following as an example and a test case:
// #       Job Id    0    1    2    3    4
// # Running Time    5    1    3    7    2

// #             3  
// #            / \
// #           0   1
// #           /\  \
// #          / \  5
// #         /  \ /
// #         4   2
// # Input: Job ID, Running Time, UpstreamDependency [3]
// # Expected result:
// # Output-> Schedule: 3 -> 0 -> 1 -> 4 -> 2

// #     class Job {
// #     public int id;
// #     public int runningTime;
// #     public List<Integer> upstream;
// # }
// #TotalRunningTime: 15 (3 with running time 7 + 0 with running time 5 + 2 with running time 3)

import java.util.*;

class TopoSort {
    static class Job {
        public int id;
        public int runningTime;
        public List<Integer> upstreamJobIds;
        public Job(int id, int runningTime){
          this.id = id;
          this.runningTime = runningTime;
          this.upstreamJobIds = new ArrayList<>();
        }
    }
    static class Result {
        public int totalRunningTime;
        public List<Integer> jobSchedule;
        public Result() {
            totalRunningTime = 0;
            jobSchedule = new ArrayList<Integer>();
        }    
    }
  // n jobs, average k parent 
    // v * e/v  = e
    public static Result getJobScheduleResult(List<Job> jobs) {
      int[] endTime = new int[jobs.size()];
      int[] indegree = new int[jobs.size()];
      HashMap<Integer, List<Job>> map = new HashMap<>();
      Queue<Job> q = new LinkedList<>();
      Result res = new Result();
      for(Job j: jobs){
        if(j.upstreamJobIds.isEmpty()) q.offer(j);
        else{
          for(int parent: j.upstreamJobIds){
            System.out.println("add topology" + parent +"->" + j.id);
            List<Job> temp = map.getOrDefault(parent, new ArrayList<Job>());
            temp.add(j);
            map.put(parent, temp);
          }
          indegree[j.id] = j.upstreamJobIds.size();
        }
      }
      while(!q.isEmpty()){
        Job cur = q.poll();
        int end = 0;
        for(int parent: cur.upstreamJobIds){
          end = Math.max(end, endTime[parent]);
        }
        endTime[cur.id] = end + cur.runningTime;
        res.totalRunningTime = Math.max(res.totalRunningTime, endTime[cur.id]);
        res.jobSchedule.add(cur.id);
        if(map.containsKey(cur.id)){
          System.out.println("contains " + cur.id);
          for(Job child: map.get(cur.id)){
            if(--indegree[child.id] == 0)
              q.offer(child);
          }
        }
      }
      return res;
    }
    /*You can use the following as an example and a test case:
            Job Id    0    1    2    3    4
      Running Time    5    1    3    7    2
                  3 7
                 / \
                0 12   1 8
               / \ /
              4 14  2 15
    */
    public static List<Job> buildWorkflow(){
      List<Job> jobs = new ArrayList<>();
      Job j3 = new Job(3, 7);
      Job j0 = new Job(0, 5);
      j0.upstreamJobIds.add(3);
      Job j1 = new Job(1, 1);
      j1.upstreamJobIds.add(3);
      Job j4 = new Job(4, 2);
      j4.upstreamJobIds.add(0);
      Job j2 = new Job(2, 3);
      j2.upstreamJobIds.add(0);
      j2.upstreamJobIds.add(1);
      jobs.add(j0);
      jobs.add(j1);
      jobs.add(j2);
      jobs.add(j3);
      jobs.add(j4);
      return jobs;
    }
    public static void main(String[] args) {
      List<Job> jobs = buildWorkflow();
      Result result = getJobScheduleResult(jobs);
      System.out.println("Job schedule: " + result.jobSchedule.toString());
      System.out.println("Total running time:" + result.totalRunningTime);
    }
  }