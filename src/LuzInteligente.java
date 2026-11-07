public class LuzInteligente {
    private String idLuz;
    private int nivelBrillo;
    private boolean encendida;

    public LuzInteligente(String idLuz) {
        this.idLuz = idLuz;
        this.nivelBrillo = 0;
        this.encendida = false;
    }

    public void encender() {
        this.encendida = true;
        if (this.nivelBrillo == 0) this.nivelBrillo = 50;
    }

    public void apagar() {
        this.encendida = false;
        this.nivelBrillo = 0;
    }

    public void ajustarBrillo(int nuevoNivel) {
        if (encendida) {
            if (nuevoNivel >= 0 && nuevoNivel <= 100) {
                this.nivelBrillo = nuevoNivel;
            } else {
                System.out.println("Error: El brillo debe estar entre 0 y 100.");
            }
        } else {
            System.out.println("Aviso: La luz " + idLuz + " está apagada, no se puede ajustar el brillo.");
        }
    }

    public void mostrarEstado() {
        String estadoStr = encendida ? "Encendida" : "Apagada";
        System.out.println("Luz ID: " + idLuz + " | Estado: " + estadoStr + " | Brillo: " + nivelBrillo + "%");
    }

    public static void main(String[] args) {
        LuzInteligente[] sistemaLuces = {
                new LuzInteligente("LNZ-101"),
                new LuzInteligente("LNZ-102"),
                new LuzInteligente("LNZ-103")
        };

        sistemaLuces[0].encender();
        sistemaLuces[0].ajustarBrillo(75);

        sistemaLuces[1].encender();
        sistemaLuces[1].ajustarBrillo(30);

        System.out.println("\n--- ESTADO DEL SISTEMA DE ILUMINACIÓN ---");
        for (int i = 0; i < sistemaLuces.length; i++) {
            sistemaLuces[i].mostrarEstado();
        }
    }
}