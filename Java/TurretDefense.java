/**
 * Created by Abhinav on 01/03/16.
 * Problem Statement
 *** You may only submit a given problem once - no resubmissions will be accepted. ***

 "Incoming! Fire the defense turrets at these coordinates! Go go go!"

 You have been given a list of incoming targets that must be shot down in the order they are given. Assuming your turret is aimed at some location, it will take time to move the turret and fire at a different location. If you are currently aimed at point (a,b), and you must move to aim at point (c,d), the time required is the absolute difference in first coordinates plus the absolute difference in second coordinates. For example, starting at (3,7) it will take 4 seconds to aim at point (5,5). Along with the coordinates of each incoming target, you are also given their arrival times. The turret must be fired precisely at the arrival time in the direction of the target. Immediately after firing, the turret can be moved to aim at the next location (no time is lost firing). Your method will return the index of the earliest target that cannot be shot down. For example, let's assume
 xs    = {3,5,6}
 ys    = {7,5,6}
 times = {11,15,16}.
 Your turret always begins aimed at (0,0) at time 0. Since the first target is arriving at location (3,7) at time 11 you have 11 seconds to move there and fire. This is 1 second more than is needed. At time 11 you fire the turret, and immediately start moving to aim at (5,5). Since the second target arrives at time 15, you have 4 seconds to aim. This is exactly enough time. At time 15, you fire at the second target. Unfortunately, the third target will arrive before you can shoot it down. You would return 2 since target 2 (third target) is the earliest one you couldn't shoot down. If you could shoot them all down, return -1. As shown above, xs[i],ys[i] are the coordinates, and times[i] is the arrival time of target i.
 Definition
 Class: TurretDefense
 Method: firstMiss
 Parameters: int[], int[], int[]
 Returns: int
 Method signature: int firstMiss(int[] xs, int[] ys, int[] times)
 (be sure your method is public)
 Limits
 Time limit (s): 840.000
 Memory limit (MB): 64
 Notes
 - xs will contain between 2 and 50 elements inclusive.
 - ys and times will contain the same number of elements as xs.
 - Each element of xs will be between 0 and 1000 inclusive.
 - Each element of ys will be between 0 and 1000 inclusive.
 - Each element of times will be between 1 and 1000000 inclusive.
 - The elements of times will be in strictly increasing order.
 Examples
 0)
 {3,5,6}
 {7,5,6}
 {11,15,16}
 Returns: 2
 From above.
 1)
 {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
 {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
 {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32}
 Returns: -1
 A target arrives every 2 seconds. Luckily it only takes 2 seconds to switch from target to target.
 2)
 {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
 {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}
 {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,31}
 Returns: 15
 Same as before, but now you only have 1 second to switch to the final target.
 3)
 {1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0}
 {1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0, 1000,0,1000,0,1000,0,1000,0,1000,0}
 {2000,4000,6000,8000,10000,12000,14000,16000,18000,20000, 22000,24000,26000,28000,30000,32000,34000,36000,38000,40000, 42000,44000,46000,48000,50000,52000,54000,56000,58000,60000, 62000,64000,66000,68000,70000,72000,74000,76000,78000,80000, 82000,84000,86000,88000,90000,92000,94000,96000,98000,100000}
 Returns: -1
 Takes a while, but you hit them all.
 4)
 {4,5}
 {4,5}
 {7,8}
 Returns: 0
 5)
 {1,2,3,4,15}
 {1,2,3,4,15}
 {100,200,300,400,405}
 Returns: 4
 */
public class TurretDefense {
    int timeRequiredToMove(int[] currentPos, int[] targetPos) {
        return Math.abs(currentPos[0]-targetPos[0]) + Math.abs(currentPos[1]-targetPos[1]);
    }

    public int firstMiss(int[] xs, int[] ys, int[] times) {
        int[] currentPos = {0,0}, targetPos = new int[2];
        int timeSpent = 0;
        for(int i=0; i<xs.length;i++) {
            targetPos[0] = xs[i];
            targetPos[1] = ys[i];

            int timeReq = timeRequiredToMove(currentPos, targetPos);

            if(times[i] < timeSpent + timeReq) {
                return i;
            }

            currentPos = targetPos.clone();
            timeSpent += times[i];
        }
        return -1;
    }

    public void test(int[] xs, int[] ys, int[] times, int firstMissIndex) {
        if (firstMiss(xs, ys, times)!=firstMissIndex) {
            System.out.println("failed");
        } else {
            System.out.println("passed");
        }
    }

    public static void main(String[] args) {
        TurretDefense a = new TurretDefense();
        a.test(new int[] {3,5,6}, new int[] {7,5,6}, new int[] {11,15,16}, 2);
    }
}
