
package aplicaçãohash;



public class Aluno extends SeparateChainingHashTable implements Hashable {
    private String nome ;
    private String matricula;


    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    


    
    @Override
    public int hash (String key, int tableSize) {
        int hashValue=0;
        for (int i=0;i<key.length();i++) {
            hashValue+=key.charAt(i);
        }
        return hashValue%tableSize;
    }
    
    
    @Override
    public int hash(int length){ 
        int hashValue = hash(this.nome , length);
        return hashValue;
    }

     @Override
     public String toString() {
                
                String s;
                s = this.nome+", "+this.matricula;
                return s;

}
}

