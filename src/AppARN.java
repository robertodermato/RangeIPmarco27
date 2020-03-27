import java.util.LinkedList;

public class AppARN {

    public static void main(String[] args) {

        ArvoreRubroNegra listaIps = new ArvoreRubroNegra();

        RangeIP range1 = new RangeIP(15,25);
        RangeIP range2 = new RangeIP(3,11);
        RangeIP range3 = new RangeIP(2,10);
        RangeIP range4 = new RangeIP(5,13);
        RangeIP range5 = new RangeIP(15,20);
        RangeIP range6 = new RangeIP(15,25);
        RangeIP range7 = new RangeIP(15,40);


        //Testando método add()
        listaIps.add(range1);
        listaIps.add(range2);
        listaIps.add(range3);
        listaIps.add(range4);
        listaIps.add(range5);
        listaIps.add(range6);
        listaIps.add(range7);

        System.out.println("\nLista dos IPs ordenadas pelo IP inicial - método positionsCentral");
        LinkedList <RangeIP> listaCentral = listaIps.positionsCentral();
        System.out.println(listaCentral);

        LinkedList <RangeIP> listaArrumada = listaIps.arrumaLista(listaIps.positionsCentral());
        System.out.println("\nLista arrumada");
        System.out.println(listaArrumada);

    }

}
