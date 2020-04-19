public class RangeIP implements Comparable<RangeIP> {
        private Integer ipInicial;
        private Integer ipFinal;
        //private Double ipInicial;
        //private Double ipFinal;


    public RangeIP(Integer ipInicial, Integer ipFinal) {
            this.ipInicial = ipInicial;
            this.ipFinal = ipFinal;
        }

        public Integer getIpInicial() {return ipInicial;}
        //public Double getIpInicial() {return ipInicial;}


        public Integer getIpFinal() {return ipFinal;}
        //public Double getIpFinal() {return ipFinal;}

        public void setIpInicial(Integer newIpInicial) {            this.ipInicial = newIpInicial;        }
        //public void setIpInicial(Double newIpInicial) {        this.ipInicial = newIpInicial;    }

       public void setIpFinal(Integer newIpFinal) {        this.ipFinal = newIpFinal;    }
       //public void setIpFinal(Double newIpFinal) {            this.ipFinal = newIpFinal;        }


        @Override
        public int compareTo(RangeIP outroRange) {
            return ipInicial.compareTo(outroRange.getIpInicial());
        }


        @Override
        public String toString() {
            return "IP inicial: " + ipInicial + " IP final: " + ipFinal + "\n";
        }

        /*
    @Override
    public int compareTo(RangeIP outroRange) {
            if (ipInicial < outroRange.getIpInicial()) return -1;
        if (ipInicial == outroRange.getIpInicial()) return 0;
        else return 1;
            }

         */
}
