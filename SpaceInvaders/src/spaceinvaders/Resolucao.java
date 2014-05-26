/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 *
 * @author Bianca
 *
 * Essa classe é pra indexar todas as posições iniciais dos objetos bem como a
 * resolução da tela
 *
 */
public class Resolucao {

    private static Resolucao resolucao;
    private static int resolucaoTela = 0;
    private static int[] tamanhoTela, posicaoTitulo, posicaoBotoes, posicaoNave, posicaoInimigo, score;
    private static String caminho;
    private static SpaceInvaders spaceInvaders;

    private Resolucao() {

        /*
         * Em tamanhoTela, posicaoTitulo, posicaoBotoes e posicaoNave, a primeira
         * posição do vetor corresponde a coordenada X e as demais a coordenada Y.
         * Em posicaoInimigo as 8 primeiras posições do vetor corresponde as 
         * possíveis coordenadas X que o inimigo criado pode assumir e apenas a 
         * ultima posição corresponde a coordenada Y
         */
        score= new int [3];
        tamanhoTela = new int[2];
        posicaoTitulo = new int[2];
        posicaoBotoes = new int[4];
        posicaoInimigo = new int[9];
        posicaoNave = new int[2];
    }

    public static Resolucao getInstance() {
        if (resolucao == null) {
            resolucao = new Resolucao();
        }

        return resolucao;
    }

    public void definirResolucao(String resolucao_escolhida) {
        if ("800x600".equals(resolucao_escolhida)) {
            resolucaoTela = 2;
        } else {
            resolucaoTela = 1;
        }

        resolucao.definirPosicoes();
    }

    private void definirPosicoes() {
        /*
         * Todos os prites que salvei estão nas proporções e tamanhos corretos
         * Vou criar um pdf com histoyboard e as "divisões" de tela baseada nas
         * proporções 
         *
         * A String caminho guarda a pasta correta onde os sprites devem ser 
         * buscados, para usar: resolucaoTela.getCaminho()+"nomedoSprite.png"
         */

        if (resolucaoTela == 1) {
            caminho = "src/assets_320x180/";

            score[0]=10; //posicaox
            score[1]=10; //posicaoy
            score[2]=14; //tamanho da fonte
            
            tamanhoTela[0] = 320;
            tamanhoTela[1] = 200; //tá um pouco maior pq na definição é considerada as bordas da janela e não somenta a area do jogo

            posicaoTitulo[0] = 25;
            posicaoTitulo[1] = 5;

            posicaoBotoes[0] = 90;
            posicaoBotoes[1] = 80;
            posicaoBotoes[2] = posicaoBotoes[1] + 25;
            posicaoBotoes[3] = posicaoBotoes[2] + 25;

            posicaoNave[0] = 20;
            posicaoNave[1] = 110;

            posicaoInimigo[8] = 20;
            posicaoInimigo[0] = 30;
            for (int i = 1; i < 8; i++) {
                posicaoInimigo[i] = posicaoInimigo[i] + 10;
            }

        } else {
            caminho = "src/assets_800x600/";
            
             score[0]=20; //posicaox
            score[1]=30; //posicaoy
            score[2]=30; //tamanho da fonte
            
            tamanhoTela[0] = 800;
            tamanhoTela[1] = 600;

            posicaoTitulo[0] = 100;
            posicaoTitulo[1] = 45;

            posicaoBotoes[0] = 270;
            posicaoBotoes[1] = 300;
            posicaoBotoes[2] = posicaoBotoes[1] + 90;
            posicaoBotoes[3] = posicaoBotoes[2] + 90;

            posicaoNave[0] = 30;
            posicaoNave[1] = 420;

            posicaoInimigo[8] = 20;
            posicaoInimigo[0] = 40;
            for (int i = 1; i < 8; i++) {
                posicaoInimigo[i] = posicaoInimigo[i] + 20;
            }
        }
    }

    public String getCaminho() {
        return caminho;
    }

    public int[] getTamanhoTela() {
        return tamanhoTela;
    }

    public int[] getPosicaoTitulo() {
        return posicaoTitulo;
    }

    public int[] getPosicaoBotoes() {
        return posicaoBotoes;
    }

    public int[] getPosicaoInimigo() {
        return posicaoInimigo;
    }

    public int[] getPosicaoNave() {
        return posicaoNave;
    }

    public int getLarguraTela() {
        return tamanhoTela[0];
    }

    public int getAlturaTela() {
        return tamanhoTela[1];
    }
    
    public int[] getPosiScore() {
        return score;
    }
    
    public SpaceInvaders getSpaceInvaders() {
        return spaceInvaders;
    }

    public void setSpaceInvaders(SpaceInvaders spaceInvaders) {
        Resolucao.spaceInvaders = spaceInvaders;
    }

}
