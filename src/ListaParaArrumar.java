import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListaParaArrumar {

    private ArvoreRubroNegra arvoreDeIPs;
    private int tamanho;

    public ListaParaArrumar() {
        arvoreDeIPs = new ArvoreRubroNegra();
        tamanho = 0;
    }

    //verifica se é número
    private boolean isNumber(String x) {
        try {
            double num = Integer.parseInt(x);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    //lê o arquivo e coloca ranges na árvore
    public ArvoreRubroNegra colocaRangesNaArvore(String arquivo) {
        Path path1 = Paths.get(arquivo);

        try (BufferedReader reader = Files.newBufferedReader(path1.getFileName(), Charset.forName("utf8"))) {
            String line = null;

            /*
            //Para remover linhas vazias do arquivo recebido
            while ((line = reader.readLine()) != null) {
                String s = s.replaceAll("\n", "");
                s = s.replaceAll("\r", "");
                s = s.replaceAll("\t", "");
            }
             */

            while ((line = reader.readLine()) != null) {
                if(!line.isEmpty()){
                    line = line.trim();

                    int indexDoTravessao = line.indexOf("-");

                    String ipInicialStr = line.substring(0, indexDoTravessao);
                    String ipFinalStr = line.substring(indexDoTravessao+1, line.length());

                    int ipInicial = Integer.parseInt(ipInicialStr);
                    int ipFinal = Integer.parseInt(ipFinalStr);

                    RangeIP rangeParaAdicionar = new RangeIP(ipInicial, ipFinal);

                    arvoreDeIPs.add(rangeParaAdicionar);

                }
            }

            System.out.println("Lista que foi montada na árvore");
            System.out.println(arvoreDeIPs.positionsCentral());

        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }

        return arvoreDeIPs;

    }

}
