import java.util.LinkedList;
import java.util.Queue;

public class NumberOfCountries {

    public int numberOfCountries(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        boolean[][] visited = new boolean[n][m];
        int countries = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    countries++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0], y = curr[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                                    !visited[nx][ny] &&
                                    A[nx][ny] == A[x][y]) {

                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return countries;
    }

    public static void main(String[] args) {
        NumberOfCountries noc = new NumberOfCountries();

        int[][] A = {
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1}
        };

        int result = noc.numberOfCountries(A);
        System.out.println("Countries: " + result);
    }
}
