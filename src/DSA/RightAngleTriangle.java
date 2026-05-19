package DSA;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RightAngleTriangle {

    public static void main(String[] args){
        int[] A = {1, 1, 2, 3, 3};
        int[] B = {1, 2, 1, 2, 1};
        int sum = solve(A, B);
        System.out.println("sum: "+sum);
    }
    public static int solve(int[] A, int[] B) {
        Map<Integer, Integer> aMap = IntStream.range(0, A.length).mapToObj(i -> A[i]).collect(Collectors.toMap(p -> p, p -> 1, (existing, newV) -> existing + newV));
        Map<Integer, Integer> bMap = IntStream.range(0, A.length).mapToObj(i -> B[i]).collect(Collectors.toMap(p->p, p->1, (ev, nv)->ev+nv));

        int sum = IntStream.range(0, A.length).map(i -> (aMap.get(A[i])-1)*(bMap.get(B[i])-1)).sum();
        return sum;
    }
    }
