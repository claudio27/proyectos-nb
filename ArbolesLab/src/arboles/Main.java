package arboles;

/**
 *
 * @author claudio
 */
public class Main {

   
    public static void main(String[] args) {
//@todo leer el archivo, guardarlo en un string, eliminar y pasar a minuscula
        //poner cantidad de datos al arbol
        //usar replaceAll para cambiar espacios por saltos de linea
        //usar split para pasarlo a un arreglo
        //usar el arreglo para pasarle los datos al arbol
        Lectura l = new Lectura();
        Abb abb = new Abb();
        abb.BinaryTree();
        //abb.insert("a");
        String texto="";
        //guardo todo el texto en string
        texto = l.leer("revolucion_dialectica.txt");
        //paso el texto a un arreglo
        String arr[] = texto.split(" ");
        // las inserciones----poner contador de tiempo
        for(int i=0; i< arr.length; i++){
            abb.insert(arr[i]);
        }
    }

}
