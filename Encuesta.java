/**
 * Implementación del problema de las encuestas en Java.
 * 
 * Enunciado: Se han realizado el mismo número de encuestas en dos
 * ciudades diferentes, habiéndose ordenado las encuestas
 * en cada una de las ciudades alfabéticamente por el
 * nombre de la calle. Se desea obtener un algoritmo Divide
 * y Vencerás que en un tiempo O(log n) obtenga el nombre
 * de la calle que esta en la mediana de las dos ciudades.
 * 
 * Análisis de la complejidad:
 * Subproblemas: 1
 * Tamaño: n/2 (tamaño mitad)
 * 
 * Por tanto, a = 1, b = 2.
 * 
 * Se hace tan solo una operación para recombinar las soluciones parciales: elevar el resultado a
 * la función que ha hecho la llamada recursiva.
 * 
 * Por el Teorema Maestro, para que el problema tenga complejidad O(log n), d = 0, lo que significa
 * que la complejidad de combinar los subproblemas para encontrar la solución es constante (O(1)).
 * 
 * T(n) = T(n/2) + 1.
 * 
 * 
 * @author Daniel Alejandro Castro García 
 */
public class Encuesta
{
    private int[] vector1, vector2;

    /**
     * Constructor.
     * 
     * @param vector1,vector2   vectores de enteros ordenados
     */
    public Encuesta(int[] vector1, int[] vector2)
    {
        this.vector1 = vector1;
        this.vector2 = vector2;
    }

    /**
     * Procedimiento que compara los valores medios de cada vector.
     * 
     * @param v1,v2     vector1 y vector2, respectivamente, y sus respectivos subvectores
     * @param v1min...  indices entre los que hay que buscar.
     * 
     * @return valor    valor resultado 
     */

    public int compararVectores(int[] v1, int[] v2, int v1min, int v1max, int v2min, int v2max)
    {
        
        int valor, v1m, v2m, longitud1, longitud2, indice1, indice2;
        
        longitud1 = (v1max - v1min)+1;
        longitud2 = (v2max - v2min)+1;
        
        indice1 = v1min + ((longitud1-1)/2);
        indice2 = v2min + ((longitud2-1)/2);
        
        v1m = v1[indice1];
        v2m = v2[indice2];
        
        
      
        if(longitud1 == 2 && longitud2 == 2){
            if(v1max > v2max){
                indice2++;
                v2m = v2[indice2];
            }else{
                indice1++;
                v1m = v1[indice1];
            }
            if(v1m > v2m){
                valor = v2m;
            }else{
                valor = v1m;
            }
        }
        else if(v1m == v2m){
            valor = v1m;
        }else if(v1m > v2m){
            //La mediana tiene que estar entre los de la derecha del menor y los de la izquierda
            //del mayor
            
            valor = compararVectores(v1, v2, v1min, indice1, indice2, v2max);
        }else{ //v2m > v1m            
            valor = compararVectores(v1, v2, indice1, v1max, v2min, indice2);
        }
        
        return valor;
    }
}
