public class Agente {
    private String nombre;
    private int nivelEnergia;
    private String estado;

    public Agente(String nombre, int nivelEnergia, String estado) {
        this.nombre = nombre;
        setNivelEnergia(nivelEnergia);
        setEstado(estado);
    }

    public int getNivelEnergia() { return nivelEnergia; }
    public void setNivelEnergia(int nivelEnergia) {
        if (nivelEnergia >= 0 && nivelEnergia <= 100) {
            this.nivelEnergia = nivelEnergia;
        } else {
            this.nivelEnergia = 50;
        }
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) {
        if (estado.equalsIgnoreCase("activo") || estado.equalsIgnoreCase("inactivo")) {
            this.estado = estado.toLowerCase();
        } else {
            this.estado = "inactivo";
        }
    }

    public void mostrarEstado() {
        System.out.println("Agente: " + nombre + " | Energía: " + nivelEnergia + "% | Estado: " + estado);
    }

    public static void main(String[] args) {
        Agente[] equipoAgentes = {
                new Agente("Sentinel", 95, "activo"),
                new Agente("Explorer", 40, "inactivo"),
                new Agente("Guardian", 85, "activo")
        };

        System.out.println("\n--- REPORTE INICIAL DE AGENTES ---");
        for (int i = 0; i < equipoAgentes.length; i++) {
            equipoAgentes[i].mostrarEstado();
        }

        equipoAgentes[1].setEstado("activo");
        equipoAgentes[1].setNivelEnergia(100);

        System.out.println("\n--- REPORTE ACTUALIZADO TRAS MISIÓN ---");
        for (int i = 0; i < equipoAgentes.length; i++) {
            equipoAgentes[i].mostrarEstado();
        }
    }
}
