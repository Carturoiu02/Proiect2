public class Telefon {
    private String sistem_operare;
    private String marca;
    private String model;
    private String memorie_interna;
    private int pret;


    public Telefon(String sistem_operare, String marca, String model, String memorie_interna, int pret) {
        this.sistem_operare = sistem_operare;
        this.marca = marca;
        this.model = model;
        this.memorie_interna = memorie_interna;
        this.pret = pret;

    }


    public String getSistem_operare() {return sistem_operare;}

    public void setSistem_operare(String sistem_operare) {
        this.sistem_operare = sistem_operare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel (String model) {this.model = model;}

    public String getMemorie_interna() {
        return memorie_interna;
    }

    public void setMemorie_interna (String memorie_interna) {this.memorie_interna = memorie_interna;}

    public int getPret() {
        return pret;
    }

    public void setPret (int pret) {this.pret = pret;}

}



