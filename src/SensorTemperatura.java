public class SensorTemperatura {
    private String idSensor;
    private double valorActual;
    private String unidad;

    public SensorTemperatura(String idSensor, double valorActual, String unidad) {
        this.idSensor = idSensor;
        this.valorActual = valorActual;
        this.unidad = unidad;
    }

    public String getIdSensor() { return idSensor; }
    public void setIdSensor(String idSensor) { this.idSensor = idSensor; }

    public double getValorActual() { return valorActual; }
    public void setValorActual(double valorActual) { this.valorActual = valorActual; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public void mostrarLectura() {
        System.out.println("Sensor ID: " + idSensor + " | Lectura: " + valorActual + " " + unidad);
    }

    public static void main(String[] args) {
        SensorTemperatura[] sensores = {
                new SensorTemperatura("S-01", 23.5, "°C"),
                new SensorTemperatura("S-02", 19.8, "°C"),
                new SensorTemperatura("S-03", 25.1, "°C")
        };

        System.out.println("--- REPORTE GENERAL (Usando length) ---");
        for (int i = 0; i < sensores.length; i++) {
            sensores[i].mostrarLectura();
        }

        System.out.println("\n--- CALIBRANDO TEMPERATURAS EN TODO EL ARREGLO ---");
        for (int i = 0; i < sensores.length; i++) {
            sensores[i].setValorActual(sensores[i].getValorActual() + 1.5);
            sensores[i].mostrarLectura();
        }
    }
}