import java.util.*;

public class Game {
    private final Scanner sc = new Scanner(System.in);
    private Board puzzle;   // estado atual do jogador
    private Board givens;   // células fixas
    private Board solution; // solução única

    public Game() {
        generateNewPuzzle(40); // padrão
    }

    void generateNewPuzzle(int emptyCells) {
        Board full = new Board();
        full.fillCompletedGrid();

        Board generated = full.cloneBoard();
        generated.makePuzzleUnique(emptyCells);

        this.solution = generated.cloneBoard();
        this.solution.solve();

        this.puzzle = generated.cloneBoard();
        this.givens = generated.cloneBoard();
    }

    public void loop() {
        printWelcome();
        printBoard();
        while (true) {
            System.out.print("\n> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String cmd = parts[0].toLowerCase();
            try {
                switch (cmd) {
                    case "set":
                        if (parts.length != 4) { usageSet(); break; }
                        int r = parse(parts[1]);
                        int c = parse(parts[2]);
                        int v = parse(parts[3]);
                        doSet(r, c, v);
                        break;
                    case "clear":
                        if (parts.length != 3) { System.out.println("Uso: clear r c"); break; }
                        r = parse(parts[1]);
                        c = parse(parts[2]);
                        doClear(r, c);
                        break;
                    case "hint":   doHint();   break;
                    case "check":  doCheck();  break;
                    case "print":  printBoard(); break;
                    case "solve":  doSolve();  break;
                    case "new":
                        generateNewPuzzle(45);
                        System.out.println("Novo Sudoku gerado!\n");
                        printBoard();
                        break;
                    case "help":   printHelp(); break;
                    case "exit":
                    case "quit":   System.out.println("Até mais! 👋"); return;
                    default:       System.out.println("Comando desconhecido. Digite 'help'.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }

    private void printWelcome() {
        System.out.println("Sudoku (console) – Java\nComandos: set, clear, hint, check, print, solve, new, help, exit\n");
    }
    private void printHelp() {
        System.out.println("""
Comandos disponíveis:
  set r c v  – coloca valor v (1..9) em (linha r, coluna c)
  clear r c  – limpa célula (r,c) se não for fixa
  hint       – sugere jogada válida
  check      – verifica conflitos ou vitória
  print      – mostra tabuleiro
  solve      – mostra a solução
  new        – gera novo puzzle
  help       – esta ajuda
  exit       – sair
""");
    }
    private void usageSet() { System.out.println("Uso: set r c v  (todos entre 1 e 9)"); }
    private int parse(String s) {
        int v = Integer.parseInt(s);
        if (v < 1 || v > 9) throw new IllegalArgumentException("valor fora de 1..9");
        return v;
    }

    private void doSet(int r, int c, int v) {
        r--; c--;
        if (givens.get(r, c) != 0)
            throw new IllegalArgumentException("Célula fixa (não pode alterar).");
        if (!puzzle.isSafe(r, c, v))
            throw new IllegalArgumentException("Movimento inválido.");
        puzzle.set(r, c, v);
        printBoard();
        if (puzzle.isComplete()) {
            if (puzzle.equalsGrid(solution))
                System.out.println("Parabéns! 🎉");
            else
                System.out.println("Completo mas incorreto. Use 'check' ou 'solve'.");
        }
    }

    private void doClear(int r, int c) {
        r--; c--;
        if (givens.get(r, c) != 0)
            throw new IllegalArgumentException("Célula fixa (não pode limpar).");
        puzzle.set(r, c, 0);
        printBoard();
    }

    private void doHint() {
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (puzzle.get(r, c) == 0) {
                    var cand = puzzle.candidates(r, c);
                    if (cand.size() == 1) {
                        int v = cand.get(0);
                        System.out.printf("Dica: (%d,%d) = %d%n", r + 1, c + 1, v);
                        return;
                    }
                }
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                if (puzzle.get(r, c) == 0) {
                    int v = solution.get(r, c);
                    System.out.printf("Dica (solução): (%d,%d) = %d%n", r + 1, c + 1, v);
                    return;
                }
    }

    private void doCheck() {
        boolean conflict = false;
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++) {
                int v = puzzle.get(r, c);
                if (v == 0) continue;
                puzzle.set(r, c, 0);
                boolean safe = puzzle.isSafe(r, c, v);
                puzzle.set(r, c, v);
                if (!safe) {
                    System.out.printf("Conflito em (%d,%d) com %d%n", r + 1, c + 1, v);
                    conflict = true;
                }
            }
        if (!conflict) {
            if (puzzle.equalsGrid(solution))
                System.out.println("Tudo certo! ✅");
            else if (puzzle.isComplete())
                System.out.println("Sem conflitos, mas não é a solução correta. ❗");
            else
                System.out.println("Sem conflitos até agora. 💪");
        }
    }

    private void doSolve() {
        Board temp = puzzle.cloneBoard();
        if (temp.solve()) {
            temp.print();
            System.out.println("(Solução exibida)");
        } else {
            System.out.println("Sem solução (estado inválido).");
        }
    }

    private void printBoard() { puzzle.print(); }
}
