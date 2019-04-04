
package aplicaçãohash;
import java.util.*;


public class SeparateChainingHashTable {
    private LinkedList[ ] theLists;
    private static final int DEFAULT_TABLE_SIZE = 101;
    public SeparateChainingHashTable( ) {
        this( DEFAULT_TABLE_SIZE );
    }
    public SeparateChainingHashTable( int size ) {
        theLists = new LinkedList[nextPrime(size)]; // Garante que o tamanho é primo
        for( int i = 0; i < theLists.length; i++ )
            theLists[ i ] = new LinkedList( );
    }
    public void makeEmpty( ) {
    for( int i = 0; i < theLists.length; i++ )
        theLists[ i ].clear( );
    }
    private static int nextPrime( int n ) {
    if( n % 2 == 0 )
        n++;
    for( ; !isPrime(n); n+=2)
    ;
    return n;
    }
    private static boolean isPrime( int n ) {
    if( n == 2 || n == 3 )
        return true;
    if( n == 1 || n % 2 == 0 )
        return false; 
    for( int i = 3; i * i <= n; i+=2)
        if( n % i == 0 )
        return false;
    return true;
    }
    public void insert( Hashable x ) {
    LinkedList whichList = theLists[ x.hash(theLists.length ) ];
    if (whichList.indexOf(x)==-1) // equals será usado aqui
        whichList.add(0,x);
    }
    
    public void remove( Hashable x ) {
            Hashable teste;
            teste = x;
            theLists[ x.hash( theLists.length )].remove(x); 
            System.out.println("O nome e a matricula do aluno removido são, respectivamente: "+teste);        
    }
    
    public Hashable find( Hashable x ) {
        int Position;
        Position = theLists[ x.hash(theLists.length)].indexOf(x);
    return (Hashable)theLists[ x.hash(theLists.length)].get(Position); // equals será usado aqui
    }

    public void printHash () {                    
       int tam, i, col=0, sem_erro=0;
       for (i=0; i<theLists.length-1; i++) {
           tam = theLists[i].size();
           if (tam>=2) {
               col++;
               System.out.println("================COLIDIRAM=====================");
               System.out.println(theLists[i].toString()); 
               System.out.println("=============================================");
           }
               
           else {
               System.out.println(theLists[i].toString());   
               System.out.println("");
               sem_erro++;
           }
       }
        System.out.println("Houve "+col+" colisões e "+sem_erro+" sem colisões");
    }
    
}
