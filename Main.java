
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
       
        System.out.println("\n Inserindo Nós");
        arvoreBinaria.inserir(50);
        arvoreBinaria.inserir(30);
        arvoreBinaria.inserir(70);
        arvoreBinaria.inserir(20);
        arvoreBinaria.inserir(40);
        arvoreBinaria.inserir(60);
        arvoreBinaria.inserir(80);
        arvoreBinaria.inserir(35);
        arvoreBinaria.inserir(45);
       
        arvoreBinaria.exibir("Em");// Exibindo árvore inicial
        System.out.println("\n Remover Nó Folha "); // Remover nó folha


        arvoreBinaria.remover(20);
        arvoreBinaria.exibir("Em");
       
        System.out.println("\n Remover nó com um filho "); // Remover nó com um filho


        arvoreBinaria.remover(40);
        arvoreBinaria.exibir("Em");
       
        System.out.println("\n Remover nó com dois filhos "); // Remover nó com dois filhos


        arvoreBinaria.remover(30);
        arvoreBinaria.exibir("Em");
       
        System.out.println("\n Remover raiz "); // Remover raiz


        arvoreBinaria.remover(50);
        arvoreBinaria.exibir("Em");
       
        System.out.println("\n Tentar remover nó inexistente ");  // Tentar remover nó inexistente
        arvoreBinaria.remover(999);
       
        // Exibindo todos os percursos no final
        System.out.println("\n Pecursos Finais");
        arvoreBinaria.exibir("Pre");
        arvoreBinaria.exibir("Em");
        arvoreBinaria.exibir("Pos");
    }
}
