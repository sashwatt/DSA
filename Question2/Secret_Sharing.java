package Question2;

import java.util.*;

public class Secret_Sharing {
    public static void main(String[] args) {
        int numberOfPeople = 5;
        int[][] sharingIntervals = {{0, 2}, {1, 3}, {2, 4}};
        int firstPerson = 0;

        List<Integer> result = findPeopleWhoKnowSecret(numberOfPeople, sharingIntervals, firstPerson);
        System.out.println(result);
    }

    public static List<Integer> findPeopleWhoKnowSecret(int n, int[][] intervals, int firstPerson) {
        boolean[] knowsSecret = new boolean[n];
        knowsSecret[firstPerson] = true;

        
        for (int[] interval : intervals) {
            for (int i = interval[0]; i <= interval[1]; i++) {
                if (knowsSecret[i]) {
                    for (int j = interval[0]; j <= interval[1]; j++) {
                        knowsSecret[j] = true;
                    }
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (knowsSecret[i]) {
                result.add(i);
            }
        }

        return result;
    }  
}
