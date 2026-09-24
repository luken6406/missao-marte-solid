package solidexercicio10.model;

import java.util.Random;

public final class ModelContractTest {
    private ModelContractTest() {
    }

    public static void main(String[] args) {
        verificaPontuacoes();
        verificaEmbarqueECapacidade();
        verificaMovimentoDaNave();
        verificaLimitesDoInimigo();
        verificaColisaoEMissao();
        System.out.println("model contract tests: OK");
    }

    private static void verificaPontuacoes() {
        exige(new Professor("P", 0, 0).getPontuacao() == 10, "Professor deve valer 10");
        exige(new Engenheiro("E", 0, 0).getPontuacao() == 15, "Engenheiro deve valer 15");
        exige(new Astronauta("A", 0, 0).getPontuacao() == 20, "Astronauta deve valer 20");
    }

    private static void verificaEmbarqueECapacidade() {
        Nave nave = new Nave("N1", 1);
        Missao missao = new Missao(nave);
        Passageiro primeiro = new Professor("P", 0, 0);
        Passageiro segundo = new Engenheiro("E", 0, 0);
        missao.adicionarPassageiro(primeiro);
        missao.adicionarPassageiro(segundo);

        exige(missao.embarcarPassageiroNaPosicao(), "primeiro embarque deveria funcionar");
        exige(missao.getPassageiros().size() == 1, "passageiro embarcado deveria sair do mapa");
        exige(!missao.embarcarPassageiroNaPosicao(), "embarque em nave cheia deveria falhar");
        exige(missao.getPassageiros().size() == 1, "passageiro não deveria ser removido após falha");
    }

    private static void verificaMovimentoDaNave() {
        Nave nave = new Nave("N1", 2);
        nave.moverComLimites('w', 0, 1, 0, 1);
        exige(nave.getX() == 0 && nave.getY() == 0, "nave não pode sair pelo limite superior");
        nave.moverComLimites('d', 0, 1, 0, 1);
        exige(nave.getX() == 1 && nave.getY() == 0, "movimento da nave inválido");
    }

    private static void verificaLimitesDoInimigo() {
        Inimigo inimigo = new Inimigo(0, 0);
        inimigo.mover(new DirecaoFixa(1), 0, 1, 0, 1);
        exige(inimigo.getX() == 0 && inimigo.getY() == 0, "inimigo saiu pelo limite esquerdo");
        inimigo.mover(new DirecaoFixa(0), 0, 1, 0, 1);
        exige(inimigo.getX() == 1 && inimigo.getY() == 0, "inimigo não avançou corretamente");
    }

    private static void verificaColisaoEMissao() {
        Nave nave = new Nave("N1", 1);
        Missao missao = new Missao(nave);
        missao.adicionarAsteroide(new Asteroide(0, 0));
        missao.adicionarPassageiro(new Astronauta("A", 1, 1));
        exige(missao.verificaColisao(), "colisão com asteroide não detectada");
        exige(!missao.todosEmbarcados(), "missão deveria ter passageiro pendente");
    }

    private static void exige(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new AssertionError(mensagem);
        }
    }

    private static final class DirecaoFixa extends Random {
        private final int direcao;

        private DirecaoFixa(int direcao) {
            this.direcao = direcao;
        }

        @Override
        public int nextInt(int limite) {
            return direcao;
        }
    }
}
