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

    private int resolucao = 0;
    private int[] tamanhoTela, posicaoTitulo, posicaoBotoes, posicaoNave, posicaoInimigo;
    private String caminho;

    public Resolucao(String resolucao_escolhida) {

        if ("800x600".equals(resolucao_escolhida)) {
            resolucao = 2;
        } else {
            resolucao = 1;
        }

        /*
        * Em tamanhoTela, posicaoTitulo, posicaoBotoes e posicaoNave, a primeira
        * posição do vetor corresponde a coordenada X e as demais a coordenada Y.
        * Em posicaoInimigo as 8 primeiras posições do vetor corresponde as 
        * possíveis coordenadas X que o inimigo criado pode assumir e apenas a 
        * ultima posição corresponde a coordenada Y
        */
        tamanhoTela = new int[2]; 
        posicaoTitulo = new int[2];
        posicaoBotoes = new int[4];
        posicaoInimigo = new int[9];
        posicaoNave = new int[2];
    }

    public void definirPosicoes() {
        /*
        * Todos os prites que salvei estão nas proporções e tamanhos corretos
        * Vou criar um pdf com histoyboard e as "divisões" de tela baseada nas
        * proporções 
        *
        * A String caminho guarda a pasta correta onde os sprites devem ser 
        * buscados, para usar: resolucao.getCaminho()+"nomedoSprite.png"
        */
           
                
        if (resolucao == 1) {
            caminho = "src/assets_320x180/";

            tamanhoTela[0] = 320;
            tamanhoTela[1] = 200; //tá um pouco maior pq na definição é considerada as bordas da janela e não somenta a area do jogo

            posicaoTitulo[0] = 50;
            posicaoTitulo[1] = 50;

            posicaoBotoes[0] = 100;
            posicaoBotoes[1] = 100;
            posicaoBotoes[2] = posicaoBotoes[1] + 20;
            posicaoBotoes[3] = posicaoBotoes[2] + 20;

            posicaoNave[0] = 20;
            posicaoNave[1] = 120;

            posicaoInimigo[8] = 20;
            posicaoInimigo[0] = 10;
            for (int i = 1; i < 8; i++) {
                posicaoInimigo[i] = posicaoInimigo[i] + 10;
            }

        } else {
            caminho = "src/assets_800x600/";

            tamanhoTela[0] = 800;
            tamanhoTela[1] = 600;

            posicaoTitulo[0] = 200;
            posicaoTitulo[1] = 50;

            posicaoBotoes[0] = 270;
            posicaoBotoes[1] = 300;
            posicaoBotoes[2] = posicaoBotoes[1] + 90;
            posicaoBotoes[3] = posicaoBotoes[2] + 90;

            posicaoNave[0] = 30;
            posicaoNave[1] = 430;

            posicaoInimigo[8] = 20;
            posicaoInimigo[0] = 10;
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

}
