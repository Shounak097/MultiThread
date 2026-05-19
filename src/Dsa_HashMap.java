import java.awt.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dsa_HashMap {

    public static void main(){
        int[] A = {1, 1, 2, 2, 3, 3};
        int[] B = {1, 2, 1, 2, 1, 2};
        int sum = solve(A, B);
        System.out.println("count: "+sum);
    }


    public static int solve(int[] A, int[] B) {
    // HashMap<Pair, Integer> set = new HashMap<>();
    // for(int i=0;i<A.length;i++){
    //     set.put(new Pair(A[i], B[i]), 1);
    // }
    // int count=0;
    // for(int i=0;i<A.length; i++){
    //     for(int j=i+1; j<A.length;j++){
    //         if(A[i]!=A[j] && B[i]!=B[j]){
    //             if(set.containsKey(new Pair(A[i], B[j])) && set.containsKey(new Pair(A[j], B[i])))
    //                 count++;
    //         }
    //     }
    // }
    // return count/2;
   // Set<Pair> pointSet = new HashSet<>();
    Set<Pair> pointSet = IntStream.range(0, A.length).mapToObj(i -> new Pair(A[i], B[i])).collect(Collectors.toSet());

    Long count = IntStream.range(0, A.length)
                    .mapToLong(i -> IntStream.range(i+1, A.length)
                    .filter(j -> A[i]!=A[j] && B[i]!=B[j])
                    .filter(j -> pointSet.contains(new Pair(A[i], B[j])) && pointSet.contains(new Pair(A[j],B[i])))
                    .count())
            .sum();
    return (int)(count/2);
}
}

class Pair {
    final int x;
    final int y;
    private final int hashCode;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
        this.hashCode = Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair that = (Pair) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}