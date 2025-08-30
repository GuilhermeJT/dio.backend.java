import java.util.*;

public class Board {
    private final int[][] g = new int[9][9];
    private final Random rnd = new Random();

    int get(int r, int c) { return g[r][c]; }
    void set(int r, int c, int v) { g[r][c] = v; }

    Board cloneBoard() {
        Board b = new Board();
        for (int r = 0; r < 9; r++) System.arraycopy(this.g[r], 0, b.g[r], 0, 9);
        return b;
    }
    boolean equalsGrid(Board o) {
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (g[r][c] != o.g[r][c]) return false;
        return true;
    }

    void print() {
        String sep = "+=======+=======+=======+";
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) System.out.println(sep);
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) System.out.print("|");
                int v = g[r][c];
                System.out.print(" " + (v == 0 ? "." : v) + " ");
            }
            System.out.println("|");
        }
        System.out.println(sep);
    }

    boolean isComplete() {
        for (int[] row : g) for (int v : row) if (v == 0) return false;
        return true;
    }

    boolean isSafe(int r, int c, int v) {
        for (int i = 0; i < 9; i++) {
            if (g[r][i] == v || g[i][c] == v) return false;
        }
        int br = (r / 3) * 3, bc = (c / 3) * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (g[br + i][bc + j] == v) return false;
        return true;
    }

    List<Integer> candidates(int r, int c) {
        if (g[r][c] != 0) return Collections.emptyList();
        List<Integer> cand = new ArrayList<>();
        for (int v = 1; v <= 9; v++) if (isSafe(r, c, v)) cand.add(v);
        return cand;
    }

    // --------- Solver ----------
    boolean solve() {
        int[] rc = findBestEmptyCell();
        if (rc == null) return true;
        int r = rc[0], c = rc[1];
        var cand = candidates(r, c);
        Collections.shuffle(cand, rnd);
        for (int v : cand) {
            g[r][c] = v;
            if (solve()) return true;
            g[r][c] = 0;
        }
        return false;
    }

    int countSolutions(int limit) {
        return countSolutionsRec(limit, new int[]{0});
    }
    private int countSolutionsRec(int limit, int[] count) {
        if (count[0] >= limit) return count[0];
        int[] rc = findBestEmptyCell();
        if (rc == null) { count[0]++; return count[0]; }
        int r = rc[0], c = rc[1];
        var cand = candidates(r, c);
        for (int v : cand) {
            g[r][c] = v;
            countSolutionsRec(limit, count);
            if (count[0] >= limit) { g[r][c] = 0; return count[0]; }
            g[r][c] = 0;
        }
        return count[0];
    }

    private int[] findBestEmptyCell() {
        int bestR = -1, bestC = -1, bestCount = 10;
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (g[r][c] == 0) {
                    int k = candidates(r, c).size();
                    if (k < bestCount) { bestCount = k; bestR = r; bestC = c; }
                    if (k == 1) return new int[]{r, c};
                }
        return bestR == -1 ? null : new int[]{bestR, bestC};
    }

    // --------- Geração ----------
    void fillCompletedGrid() {
        for (int r = 0; r < 9; r++) Arrays.fill(g[r], 0);
        for (int b = 0; b < 3; b++) fillDiagonalBlock(b);
        solve();
    }
    private void fillDiagonalBlock(int idx) {
        int br = idx * 3, bc = idx * 3;
        List<Integer> vals = new ArrayList<>();
        for (int v = 1; v <= 9; v++) vals.add(v);
        Collections.shuffle(vals, rnd);
        int t = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                g[br + i][bc + j] = vals.get(t++);
    }

    void makePuzzleUnique(int desiredEmpty) {
        Board full = this.cloneBoard();
        if (!full.solve()) throw new IllegalStateException("Não foi possível gerar grade completa.");
        for (int r = 0; r < 9; r++) System.arraycopy(full.g[r], 0, this.g[r], 0, 9);

        List<int[]> cells = new ArrayList<>();
        for (int r = 0; r < 9; r++) for (int c = 0; c < 9; c++) cells.add(new int[]{r, c});
        Collections.shuffle(cells, rnd);

        for (int[] rc : cells) {
            int r = rc[0], c = rc[1];
            int backup = g[r][c];
            g[r][c] = 0;
            Board test = this.cloneBoard();
            int sols = test.countSolutions(2);
            if (sols != 1) g[r][c] = backup;
            if (countEmpty() >= desiredEmpty) break;
        }
    }

    int countEmpty() {
        int e = 0; for (int[] row : g) for (int v : row) if (v == 0) e++; return e;
    }
}
