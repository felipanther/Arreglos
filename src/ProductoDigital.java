import java.util.Scanner;

public class ProductoDigital {
    private String nombre;
    private double precio;
    private int stock;

    public ProductoDigital(String nombre, double precio, int stock) {
        this.nombre = nombre;
        setPrecio(precio);
        setStock(stock);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio > 0) this.precio = precio;
        else this.precio = 0.0;
    }

    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock >= 0) this.stock = stock;
        else this.stock = 0;
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + " | Precio: $" + precio + " | Stock: " + stock);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductoDigital[] inventario = new ProductoDigital[4];
        int contador = 0;
        int opcion;

        do {
            System.out.println("\n--- MENÚ GESTIÓN DE PRODUCTOS ---");
            System.out.println("1. Ingresar producto (uno por uno)");
            System.out.println("2. Mostrar todos los productos registrados");
            System.out.println("3. Consultar o modificar producto por índice");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (contador < inventario.length) {
                        System.out.print("Ingrese nombre del producto: ");
                        String nom = scanner.nextLine();
                        System.out.print("Ingrese precio (> 0): ");
                        double pre = scanner.nextDouble();
                        System.out.print("Ingrese stock (>= 0): ");
                        int sto = scanner.nextInt();

                        inventario[contador] = new ProductoDigital(nom, pre, sto);
                        contador++;
                        System.out.println("¡Producto agregado exitosamente en la posición " + (contador - 1) + "!");
                    } else {
                        System.out.println("Advertencia: El arreglo está lleno (máximo " + inventario.length + ").");
                    }
                    break;
                case 2:
                    System.out.println("\n--- INVENTARIO ACTUAL ---");
                    if (contador == 0) {
                        System.out.println("No hay productos registrados aún.");
                    } else {
                        for (int i = 0; i < contador; i++) {
                            System.out.print("Índice [" + i + "] -> ");
                            inventario[i].mostrarInfo();
                        }
                    }
                    break;
                case 3:
                    if (contador == 0) {
                        System.out.println("No hay productos para consultar.");
                        break;
                    }
                    System.out.print("Ingrese el índice del producto a consultar (0 a " + (contador - 1) + "): ");
                    int idx = scanner.nextInt();
                    if (idx >= 0 && idx < contador) {
                        System.out.println("Información actual:");
                        inventario[idx].mostrarInfo();

                        System.out.print("¿Desea actualizar el precio de este producto? (1. Sí / 2. No): ");
                        int decision = scanner.nextInt();
                        if (decision == 1) {
                            System.out.print("Ingrese el nuevo precio: ");
                            double nuevoPrecio = scanner.nextDouble();
                            inventario[idx].setPrecio(nuevoPrecio);
                            System.out.println("¡Precio actualizado correctamente!");
                        }
                    } else {
                        System.out.println("Error: Índice fuera de rango o posición vacía.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
