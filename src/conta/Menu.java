package conta;

import java.util.Scanner;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner metodo = new Scanner(System.in);

		int opcao;
		
		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					         + "_____________________________________________________");
			System.out.println("                                                     ");
			System.out.println("               BANCO DO BRAZIL COM Z                 ");
			System.out.println("                                                     ");
			System.out.println("_____________________________________________________");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Número              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("_____________________________________________________");
			System.out.println("Escolha uma opção:                                   "); 
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			opcao = metodo.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.BBlack + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				metodo.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println(Cores.Green + "Criar Conta\n\n");
					break;
					
				case 2:
					System.out.println(Cores.Green + "Listar todas as Contas\n\n");
					break;
					
				case 3:
					System.out.println(Cores.Green + "Consultar dados da Conta - por número\n\n");
					break;
					
				case 4:
					System.out.println(Cores.Green + "Atualizar dados da Conta\n\n");
					break;
					
				case 5:
					System.out.println(Cores.Green + "Apagar a Conta\n\n");
					break;
					
				case 6:
					System.out.println(Cores.Green + "Saque\n\n");
					break;
					
				case 7:
					System.out.println(Cores.Green + "Depósito\n\n");
					break;
					
				case 8:
					System.out.println(Cores.Green + "Transferência entre Contas\n\n");
					break;
				
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					break;
			}
		}

	}
	
	public static void sobre() {
		System.out.println("\n--------------------------------------------------");
		System.out.println("Projeto Desenvolvido por: Rayane Moara da Silva");
		System.out.println("Contato - moararayane@gmail.com");
		System.out.println("GitHub - https://github.com/rayanemoara");
		System.out.println("----------------------------------------------------");
		
	}

}