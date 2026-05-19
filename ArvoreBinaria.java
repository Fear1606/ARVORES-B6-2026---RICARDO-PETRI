public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }


    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
            System.out.println("O nó " + conteudo + " foi inserido na Árvore.");
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }




    public void inserirRecursivo(No novoNo, No atual) {
        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo() == novoNo.getConteudo()) {
            System.out.println("Não é possível informar nós repetidos.");
            return;
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }




    // Remoção
    public void remover(Integer conteudo) {
        if(estaVazia()) {
            System.out.println("Árvore vazia!");
            return;
        }
       
        System.out.println("Removendo nó: " + conteudo);
        this.raiz = removerRecursivo(this.raiz, conteudo);
    }
   
    // Método recursivo para remover
    private No removerRecursivo(No atual, Integer conteudo) {
        if(atual == null || atual.getConteudo() == null) {
            System.out.println("Nó não encontrado: " + conteudo);
            return atual;
        }
       
        // Busca o nó a ser removido
        if(conteudo < atual.getConteudo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), conteudo));
        }
        else if(conteudo > atual.getConteudo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), conteudo));
        }
        else {
            // Nó encontrado
           
            // Nó folha
            if(atual.getEsquerda() == null && atual.getDireita() == null) {
                System.out.println(" Nó folha removido: " + conteudo);
                return null;
            }
           
            // Nó com um filho (direita)
            if(atual.getEsquerda() == null) {
                System.out.println(" Nó com filho à direita removido: " + conteudo);
                return atual.getDireita();
            }
           
            // Nó com um filho (esquerda)
            if(atual.getDireita() == null) {
                System.out.println("Nó com filho à esquerda removido: " + conteudo);
                return atual.getEsquerda();
            }
           
            // Nó com dois filhos
            System.out.println("Nó com dois filhos removido: " + conteudo);
           
            // Encontra o sucessor
            No sucessor = encontrarSucessor(atual.getDireita());
            System.out.println("Sucessor usado: " + sucessor.getConteudo());
           
            atual.setConteudo(sucessor.getConteudo());// Substitui o valor do nó atual pelo valor do sucessor


           
            // Remove o nó sucessor da subárvore direita
            atual.setDireita(removerRecursivo(atual.getDireita(), sucessor.getConteudo()));
        }
       
        return atual;
    }
   
    // Encontra o menor nó da subárvore (sucessor)
    private No encontrarSucessor(No atual) {
        while(atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }
   
    public boolean estaVazia() {
        if(this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }




    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.print(no.getConteudo() + " ");
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }




    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.print(no.getConteudo() + " ");
        emOrdem(no.getDireita());
    }




    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.print(no.getConteudo() + " ");
    }




    public void exibir(String percurso) {
        System.out.println("\n Perecurso " + percurso + "-ordem");
        switch (percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }
        System.out.println("\n");
    }
}






