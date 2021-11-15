// 2.2.8. O Estacionamento de Bashemin contém uma única alameda que
// guarda até dez carros. Existe apenas uma entrada/saída no estacionamento, em uma extremidade da alameda. Se chegar um cliente para
// retirar um carro que não seja o mais próximo da saída, todos os carros
// bloqueando seu caminho sairão do estacionamento, o carro do cliente
// será manobrado para fora do estacionamento, e os outros carros
// voltarão a ocupar a mesma seqüência inicial.
// Escreva um programa que processe um grupo de linhas de entrada.
// Cada linha de entrada contém um 'E', de entrada, ou um 'S', de saída,
// e o número da placa do carro. Presume-se que os carros cheguem e
// partam na ordem especificada pela entrada. O programa deve imprimir
// uma mensagem sempre que um carro chegar ou sair. Quando um carro
// chegar, a mensagem deve especificar se existe ou não vaga para o carro
// no estacionamento. Se não houver vaga, o carro partirá sem entrar no
// estacionamento. Quando um carro sair do estacionamento, a mensagem deverá incluir o número de vezes em que o carro foi manobrado
// para fora do estacionamento para permitir que outros carros saíssem.

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        EstacionamentoPilha estacionamento = new EstacionamentoPilha();
        Scanner scan = new Scanner(System.in);

        int opcao;
        String placa;

        while(true) {
            System.out.println("--------------------------------------");
            System.out.println("      Estacionamento de Bashemin      ");
            System.out.println("--------------------------------------");

            System.out.println("1 - QUERO ESTACIONAR MEU VEÍCULO!");
            System.out.println("2 - QUERO RETIRAR MEU VEÍCULO!");
            System.out.println("3 - DESLIGAR");
            
            opcao = scan.nextInt();

            if(opcao == 1) {
                System.out.println("\nQual o nome da placa?");
                placa = scan.next();
                Carro carro = new Carro(placa, "E");

                if(estacionamento.push(carro)) {
                    System.out.println("TEM VAGA!");
                    System.out.println(carro + " FOI ESTACIONAMENTO EM BASHEMIN");
                } else {
                    System.out.println("O ESTACIONAMENTO ESTÁ CHEIO!");
                }

            } else if (opcao == 2) {
                System.out.println("Qual o nome da placa?");
                
                placa = scan.next();
                Carro resposta = estacionamento.sairEstacionamento(placa);
                System.out.println( resposta.toString() + " foi retirado do estacionamento. Ele foi manobrado " +estacionamento.getAux().deslocamento + " vez(es).");
            } else if(opcao ==3) {
                System.out.println("Até mais.");
                break;
            } else {
                System.out.println("Opção inválida.");
            }

        }
  
    }
}