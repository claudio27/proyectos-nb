package arboles;

/**
 * @author claudio
 *
 */

public class Arbolbinario { 
   
  private Node Head; 
   
private static class Node { 
    Node left; 
    Node right; 
    String data;
    int cuenta;
    Node(String newData) { 
      left = null; 
      right = null; 
      data = newData; 
      cuenta = 1;
    } 
  }
 
  public void BinaryTree() { 
    Head = null; 
  } 
 
  public boolean lookup(String data) { 
    return(lookup(Head, data)); 
  } 
 
  /** 
   Recursiva busqueda de una elemento en el arbol
  */ 
  private boolean lookup(Node node, String data) { 
    if (node==null) { 
      return(false); 
    }
    
     if((node.data.compareToIgnoreCase(data)) == 0){
         return(true); 
    } 
     else if((data.compareToIgnoreCase(node.data)) > 0) { 
      return(lookup(node.right, data)); 
    } 
    else { 
      return(lookup(node.left, data));
      
    } 
  } 
 
 
  public void insert(String data) { 
    Head = insert(Head, data); 
  } 
 

  private Node insert(Node node, String data) { 
    if (node==null) { 
      node = new Node(data); 
    } 
    else {
              
        
      if ((data.compareToIgnoreCase(node.data)) > 0)  { 
          node.right = insert(node.right, data); 
      } 
      else if((data.compareToIgnoreCase(node.data)) == 0){
         node.cuenta++;
         }
     else{
      
          node.left = insert(node.left, data); 
      }
    }

    return(node); 
  }
 
  public boolean isEmpty( )
        {
            return Head == null;
        }
  
  private void printTree( Node t )
        {
            if( t != null )
            {
                printTree( t.left );
                System.out.println( t.data+" , veces "+t.cuenta);
                printTree( t.right );
            }
        }
  
  public void printTree( )
        {
       if( isEmpty( ) )
                System.out.println( "Árbol Vacio" );
        else
                printTree( Head );
        }
  

  
     public synchronized String preorden(){
        String pre=ayudantepreorden(Head);
        return(pre);
    }
    
    private String ayudantepreorden(Node nodo){
        String cadena=new String();
          if(nodo!=null){
            //return;
            
            //System.out.print(nodo.dato+" ");
            cadena=cadena+String.valueOf(nodo.data+" ");
            cadena=cadena+ayudantepreorden(nodo.left);
            cadena=cadena+ayudantepreorden(nodo.right);
            }
          else{
            cadena="";
          }
        return(cadena);
    }
    
    public synchronized String inorden(){
        String inor=ayudanteinorden(Head);
        return(inor);
    }
    
    private String ayudanteinorden(Node nodo){
        String cadena=new String();
        if(nodo!=null){
           // return;
                        
            cadena=cadena+ayudanteinorden(nodo.left);
            cadena=cadena+nodo.data+" ";
            cadena=cadena+ayudanteinorden(nodo.right);
        }
        else{cadena="";}
        return(cadena);
    }
    
    public synchronized String posorden(){
        String pos=ayudanteposorden(Head);
        return(pos);
    }
    
    private String ayudanteposorden(Node nodo){
        String cadena=new String();
        if(nodo!=null){
            
            
            
            cadena=cadena+ayudanteposorden(nodo.left);
            cadena=cadena+ayudanteposorden(nodo.right);
            cadena=cadena+nodo.data+" ";
        }
        else{cadena="";}
          return(cadena);  
    }
 
    
  public int calcularAltura() {
		return calcularAltura(Head);
	}
	

  
  public int calcularAltura(Node n) {
		if (n == null)
			return 0;
		else
			return	1 + Math.max(calcularAltura(n.left), calcularAltura(n.right));
	}
    
    int i = 0;
    String cantidad [] = new String [1000000];
    //Extraer palabras y cantidad de apariciones de los árboles
     
    public String[] cantidadpalabras(){
            
            return cantidadpalabras(Head);
        }
        
        
        public String[] cantidadpalabras(Node n){
            
                
               
                if (n != null){
                    
                cantidadpalabras(n.left);
                 
                String numero = String.valueOf(n.cuenta); //saco número
                String palabra = String.valueOf(n.data); //saco palabra
                String completa = numero+" "+palabra;
                cantidad[i] = completa;
                i++;
                cantidadpalabras(n.right);
                               
                }
               return cantidad;
        }
 
            public void borrar( Comparable x )
        {
            Head = borrar( x, Head );
        }
        
        private Node borrar( Comparable x, Node t )
        {
            if( t == null )
                return t;   // Item not found; do nothing
            if( x.compareTo( t.data ) < 0 )
                t.left = borrar( x, t.left );
            else if( x.compareTo( t.data ) > 0 )
                t.right = borrar( x, t.right );
            else if( t.left != null && t.right != null ) // Two children
            {
                t.data = findMin( t.right ).data;
                t.right = borrar( t.data, t.right );
            }
            else
                t = ( t.left != null ) ? t.left : t.right;
            return t;
        }
        
        
         private Node findMin( Node t )
        {
            if( t == null )
                return null;
            else if( t.left == null )
                return t;
            return findMin( t.left );
        }
        
}
 