import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class climbing_the_leaderboard {

        /*
         * Complete the 'climbingLeaderboard' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY ranked
         *  2. INTEGER_ARRAY player
         *
         * sample input
         * 3
            291 287 286
            2
            287 19
         */

        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
            TreeSet<Integer> rankedSet = new TreeSet<>();
            rankedSet.addAll(ranked);
            List<Integer> rankOnBoard = new ArrayList<>();

            System.out.println("Player size " + player.size());
            for(Integer p : player){
                boolean flag = false;
                if(!rankedSet.contains(p))
                    flag = rankedSet.add(p);

                int i =1;

                Iterator descIterator = rankedSet.descendingIterator();

                while(descIterator.hasNext()){
                    if(descIterator.next().equals(p)){
                        rankOnBoard.add(i);
                        System.out.println(i);
                        if(flag){
                            rankedSet.remove(p);
                        }
                        break;
                    }
                    i++;
                }
            }
            System.out.println("rankOnBoard " + rankOnBoard.toString());
            return rankOnBoard;

        }



        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = climbingLeaderboard(ranked, player);

//            bufferedWriter.write(
//                    result.stream()
//                            .map(Object::toString)
//                            .collect(joining("\n"))
//                            + "\n"
//            );

            bufferedReader.close();
           // bufferedWriter.close();
        }

}
/*
An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense Ranking, so its leaderboard works like this:

The player with the highest score is ranked number  on the leaderboard.
Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
Example



The ranked players will have ranks , , , and , respectively. If the player's scores are ,  and , their rankings after each game are ,  and . Return .

Function Description

Complete the climbingLeaderboard function in the editor below.

climbingLeaderboard has the following parameter(s):

int ranked[n]: the leaderboard scores
int player[m]: the player's scores
Returns

int[m]: the player's rank after each new score
Input Format

The first line contains an integer , the number of players on the leaderboard.
The next line contains  space-separated integers , the leaderboard scores in decreasing order.
The next line contains an integer, , the number games the player plays.
The last line contains  space-separated integers , the game scores.

Constraints

 for
 for
The existing leaderboard, , is in descending order.
The player's scores, , are in ascending order.
 */