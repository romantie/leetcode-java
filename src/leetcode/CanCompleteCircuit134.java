package leetcode;

/**
 * 2020/11/18
 * 加油站，
 */
public class CanCompleteCircuit134 {
    /**
     *
     * @param gas 此站有多少升油
     * @param cost 消耗的油
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while(i<n){
            int sumgas=0;//加的油和消耗的油
            int sumcost=0;
            int cnt=0;//计数，每次前进一
            while(cnt<n ){
                int j = (i+cnt)%n;
                sumgas += gas[j];
                sumcost += cost[j];
                if (sumgas<sumcost){
                    break;
                }
                cnt++;
            }
            if (cnt == n){
                return i;
            }else {
                i = i+cnt+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,5,6};
        int[] cost = {3,2,1,2,4};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);

    }
}
