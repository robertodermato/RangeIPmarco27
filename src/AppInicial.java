import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AppInicial {

    public static void main(String args[]) {

        //nome do arquivo com intervalos
        String arquivo = "cohen01.txt";
        //Alocando IPs no vetor de IPs
        int[][] vetorIps = alocaIps(arquivo);

        //Printando o resultado dos IPs que estavam no arquivo
        System.out.println("Intervalos contidos no arquivo " + arquivo);
        System.out.print("[ ");
        for (int[] vetor:vetorIps){
            System.out.print("[" + vetor[0] +"," + vetor[1] +"] ");
        }
        System.out.println("]");

        //Arrumando os "Overlappings"
        int[][] resolvedArray = resolveOverlappingsRecursive(vetorIps);
        Arrays.sort(resolvedArray, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        //Printando o resultado dos IPs após resolver os Overlappings
        System.out.println("\n ----------------");
        System.out.println("Resultado: ");
        System.out.print("[ ");
        for (int[] vetor:resolvedArray){
            System.out.print("[" + vetor[0] +"," + vetor[1] +"] ");
        }
        System.out.println("]");

    }

    public static int[][] alocaIps(String arquivo) {
        ArrayList<int[]> listaIps = new ArrayList<int[]>(10);
        try {
            Path path1 = Paths.get(arquivo);

            try (BufferedReader reader = Files.newBufferedReader(path1.getFileName(), Charset.forName("utf8"))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if(!line.isEmpty()){
                        line = line.trim();

                        int indexDoTravessao = line.indexOf("-");

                        String ipInicialStr = line.substring(0, indexDoTravessao);
                        String ipFinalStr = line.substring(indexDoTravessao+1, line.length());

                        int ipInicial = Integer.parseInt(ipInicialStr);
                        int ipFinal = Integer.parseInt(ipFinalStr);
                        int[] range = new int[2];
                        range[0] = ipInicial;
                        range[1] = ipFinal;
                        listaIps.add(range);

                    }
                }

            } catch (IOException x) {
                System.err.format("Erro de E/S: %s%n", x);
            }

        } catch (ArithmeticException x) {
            System.out.println("Tentativa de divisão por zero! " + x);
            System.out.println("");

        } catch (IllegalArgumentException x) {
            System.out.println("Erro no arquivo: " + x);
            System.out.println("");
        }

        return listaIps.toArray(new int[listaIps.size()][]);
    }

    public static int[][] resolveOverlappingsRecursive(int[][] vetorIps) {
        ArrayList<int[]> response = new ArrayList<int[]>(1);
        ArrayList<int[]> response2 = new ArrayList<int[]>(1);
        Arrays.sort(vetorIps, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        for(int i=0; i<vetorIps.length; i++){
            response.add(vetorIps[i]);
        }

        for (int i = 0; i<response.size(); i++) {
            int[] newRange = recursive(response.get(i), response);
            response2.add(newRange);
        }
        return response2.toArray(new int[response.size()][]);
    }

    private static int[] recursive(int[] range, ArrayList<int[]> vetorIps){
        Collections.sort(vetorIps, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        if(vetorIps.size() == 1 || vetorIps.size() == 0)
            return range;
        for(int i=0; i<vetorIps.size()-1; i++){
            if(vetorIps.indexOf(range) + 1 < vetorIps.size()){
                int nextArray[] =vetorIps.get(vetorIps.indexOf(range) + 1);
                int nextBegin = nextArray[0];
                int nextEnd = nextArray[1];
                if(range[1]>=nextBegin){
                    int[] newRange = new int[2];
                    newRange[0] = Math.min(range[0], nextBegin);
                    newRange[1] = Math.max(range[1], nextEnd);
                    vetorIps.add(newRange);
                    vetorIps.remove(range);
                    vetorIps.remove(nextArray);
                    range = recursive(newRange, vetorIps);
                }
            }
            break;
        }
        return range;
    }

}