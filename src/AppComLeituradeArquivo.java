public class AppComLeituradeArquivo {

    //App
    public static void main(String args[]) {

        ListaParaArrumar arvoreDeIPs = new ListaParaArrumar();
        imprimeResultado(arvoreDeIPs, "exemplo1.txt");
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
    public static void imprimeResultado(ListaParaArrumar arvoreDeIPs, String arquivo) {

        try {
            ArvoreRubroNegra listaArrumada = arvoreDeIPs.colocaRangesNaArvore(arquivo);

            if (listaArrumada == null) System.out.println("Erro no arquivo!\n");

            System.out.println("\nÁrvore lida pelo position central pelo método imprime resultado:");
            System.out.println(listaArrumada.positionsCentral());

        } catch (ArithmeticException x) {
            System.out.println("Tentativa de divisão por zero! " + x);
            System.out.println("");

        } catch (IllegalArgumentException x) {
            System.out.println("Erro no arquivo: " + x);
            System.out.println("");
        }

    }
}