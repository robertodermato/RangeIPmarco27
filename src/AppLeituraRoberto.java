import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AppLeituraRoberto {

    //App
    public static void main(String args[]) {

        imprimeResultado("exemplo1.txt");
        //imprimeResultado(lista, "exemplo2.txt");
        //imprimeResultado(lista, "exemplo3.txt");
        //imprimeResultado(lista, "exemplo4.txt");
        //imprimeResultado(lista, "exemplo5.txt");
        //imprimeResultado(lista, "caso01.txt");
        //imprimeResultado(lista, "caso02.txt");
        //imprimeResultado(lista, "caso03.txt");
        //imprimeResultado(lista, "caso04.txt");
        //imprimeResultado(lista, "caso05.txt");
        //imprimeResultado(lista, "caso06.txt");
        //imprimeResultado(lista, "caso07.txt");
        //imprimeResultado(arvoreDeIPs, "caso08.txt");
        //imprimeResultado(lista, "caso09.txt");
        //imprimeResultado(lista, "caso10.txt");
        //imprimeResultado(lista, "caso11.txt");
        //imprimeResultado(lista, "caso12.txt");


    }


    //Método para facilitar impressão de resultado
    public static void imprimeResultado(String arquivo) {

        try {
            ArvoreRubroNegra listaParaArrumar = new ArvoreRubroNegra();
            ArvoreRubroNegra arvoreComIPs = listaParaArrumar.colocaRangesNaArvore(arquivo);

            if (arvoreComIPs == null) System.out.println("Erro no arquivo!\n");

            System.out.println("\nÁrvore lida pelo position central pelo método imprime resultado:");
            System.out.println(arvoreComIPs.positionsCentral());

            System.out.println("\nÁrvore arrumada pelo método arrumalista da ARN");
            System.out.println(listaParaArrumar.arrumaLista(arvoreComIPs.positionsCentral()));

        } catch (ArithmeticException x) {
            System.out.println("Tentativa de divisão por zero! " + x);
            System.out.println("");

        } catch (IllegalArgumentException x) {
            System.out.println("Erro no arquivo: " + x);
            System.out.println("");
        }

    }


}