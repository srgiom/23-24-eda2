public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("Construyendo montículo desde índice " + i);
            heapify(array, n, i);
            System.out.print("Estado del montículo después de ajustar en índice " + i + ": ");
            printArray(array);
        }

        // Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            System.out.println("Extracción del montículo máximo y colocación en posición " + i);
            // llamar a la función de reducción del montículo en el montículo reducido
            heapify(array, i, 0);
            System.out.print("Estado del montículo después de extraer y ajustar: ");
            printArray(array);
        }
    }

    // Para convertir un subarreglo en un montículo
    static void heapify(int array[], int n, int i) {
        int largest = i; // Inicializar largest como raíz
        int l = 2 * i + 1; // izquierda = 2*i + 1
        int r = 2 * i + 2; // derecha = 2*i + 2

        // Si el hijo izquierdo es mayor que la raíz
        if (l < n && array[l] > array[largest])
            largest = l;

        // Si el hijo derecho es mayor que largest hasta ahora
        if (r < n && array[r] > array[largest])
            largest = r;

        // Si largest no es la raíz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            System.out.println("Swap " + array[i] + " con " + array[largest] + " en índice " + i + " y " + largest);
            // Recursivamente heapificar el subárbol afectado
            heapify(array, n, largest);
        }
    }

    // Imprimir el arreglo
    static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        printArray(array);
        sort(array);
        System.out.println("Array ordenado:");
        printArray(array);
    }
}
