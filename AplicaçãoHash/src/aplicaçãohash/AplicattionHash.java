
package aplicaçãohash;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AplicattionHash {
    
    public static void main(String[] args) throws FileNotFoundException {
        int i;
        String csvArquivo = "C:\\Users\\kaioh\\OneDrive\\Área de Trabalho\\Jenifer\\NOME_MATRICULA.csv";
        SeparateChainingHashTable hashtable = new SeparateChainingHashTable(100);
        Aluno[] aluno;
        aluno = new Aluno[100];
        BufferedReader conteudoCSV = null; //Ler todo conteúdo e salvar na memória
        String linha = "";
        String csvSeparadorNomeMatricula = ";"; //Indica a separação dos nome por coluna
        FileReader arquivo = new FileReader(csvArquivo);
        
        try {
            conteudoCSV = new BufferedReader (arquivo); 
            for (i=0; (linha = conteudoCSV.readLine()) != null; i++) { //Enquanto tiver conteudo
                String[] tabela = linha.split(csvSeparadorNomeMatricula); //Quando ele encontrar o ;, ele considera como um campo
                aluno[i]= new Aluno(tabela[0],tabela[1]);
                hashtable.insert(aluno[i]);
                }     
        }
        
        catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado: \n"+e.getMessage());
        }
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBounds: \n"+e.getMessage()); //Nao exite index
        }
        
        catch (IOException e) {
            System.out.println("IO Erro: \n"+e.getMessage());
        } finally {
            if (conteudoCSV != null) {
                try {
                    conteudoCSV.close();
                } catch (IOException e) {
                    System.out.println("IO Erro: \n"+e.getMessage());
                }
            }
        }
        System.out.println("\n");
        
        hashtable.printHash();
        System.out.println("\n");
        hashtable.remove(aluno[0]);
    }
        
    
    
}
