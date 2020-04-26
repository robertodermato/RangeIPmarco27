import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AppFinal {

    //App
    public static void main(String args[]) {

        imprimeResultado("cohen01.txt");
        imprimeResultado("cohen02.txt");
        imprimeResultado("cohen03.txt");
        imprimeResultado("cohen04.txt");
        imprimeResultado("cohen05.txt");
        //imprimeResultado("cohen06.txt");
        //imprimeResultado("cohen07.txt");
        //imprimeResultado("cohen08.txt");
        //imprimeResultado("cohen09.txt");
        //imprimeResultado("cohen10.txt");
        //imprimeResultado("cohen11.txt");
        //imprimeResultado("cohen12.txt");

    }


    //Método para facilitar impressão de resultado
    public static void imprimeResultado(String arquivo) {

        try {
            ArvoreRubroNegra listaParaArrumar = new ArvoreRubroNegra();
            ArvoreRubroNegra arvoreComIPs = listaParaArrumar.colocaRangesNaArvore(arquivo);

            if (arvoreComIPs == null) System.out.println("Erro no arquivo!\n");

            //System.out.println("\nÁrvore lida pelo position central pelo método imprime resultado:");
            //System.out.println(arvoreComIPs.positionsCentral());

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
