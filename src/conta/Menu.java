package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		Scanner scanner = new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino = 0;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 2507, 1, "Rayane Moara", 10000.0f, 5000.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 1710, 1, "Lana Cordeiro", 20000f, 1000.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 1211, 2, "Oliver Lima", 15000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 1706, 2, "Nilce Campos", 1000f, 8);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					         + "_________________________________________________________");
			System.out.println("                                                         ");
			System.out.println("                  BANCO DO BRASIL                        ");
			System.out.println("                                                         ");
			System.out.println("_________________________________________________________");
			System.out.println("                                                         ");
			System.out.println("            1 - Criar Conta                              ");
			System.out.println("            2 - Listar todas as Contas                   ");
			System.out.println("            3 - Buscar Conta por Número                  ");
			System.out.println("            4 - Atualizar Dados da Conta                 ");
			System.out.println("            5 - Apagar Conta                             ");
			System.out.println("            6 - Sacar                                    ");
			System.out.println("            7 - Depositar                                ");
			System.out.println("            8 - Transferir valores entre Contas          ");
			System.out.println("            9 - Sair                                     ");
			System.out.println("                                                         ");
			System.out.println("_________________________________________________________");
			System.out.println("Escolha uma opção:                                       ");
			System.out.println("                                                         " + Cores.TEXT_RESET);
			
			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao = 0;
			}

				if (opcao == 9) {
					System.out.println(Cores.Green + "\nBanco do Brasil - O seu Futuro começa aqui!");
					sobre();
					scanner.close();
					System.exit(0);
			}
				
				switch (opcao) {
				case 1:
					System.out.println("\nCriar Conta");
					System.out.println("------------");

					System.out.println("Digite o numero da Agência: ");
					agencia = scanner.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					scanner.skip("\\R?");
					titular = scanner.nextLine();

					do {
						System.out.println("Digite o Tipo de Conta (1 - Conta Corrente | 2 - Conta Poupança): ");
						tipo = scanner.nextInt();
						
					} while (tipo < 1 && tipo > 2);
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = scanner.nextFloat();

					switch (tipo) {
					
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = scanner.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite a data de Anversário da Conta: ");
						aniversario = scanner.nextInt();
						contas.cadastrar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					}
					
					keyPress();
					break;

				case 2:
					System.out.println("\n Listar todas as Contas");
					
					contas.listarTodas();
					keyPress();
					break;
				
				case 3:
					System.out.println("\nBuscar Conta por número");
					System.out.println("------------------------");
					System.out.println("Digite o número da conta: ");
					numero = scanner.nextInt();
					contas.procurarPorNumero(numero);

					keyPress();
					break;
				
				case 4:
					System.out.println("\nAtualizar dados da Conta");
					System.out.println("-------------------------");
					System.out.println("Digite o número da conta: ");
					numero = scanner.nextInt();
					var buscaConta = contas.buscarNaCollection(numero);

					if (buscaConta != null) {
						tipo = buscaConta.getTipo();

						System.out.println("Digite o Numero da Agencia: ");
						agencia = scanner.nextInt();
						System.out.println("Digite o Nome do Titular: ");
						scanner.skip("\\R?");
						titular = scanner.nextLine();
						System.out.println("Digite o Saldo da Conta(R$): ");
						saldo = scanner.nextFloat();
						
						switch (tipo) {
						
						case 1 -> {
							System.out.println("Digite Limite de Crédito (R$): ");
							limite = scanner.nextFloat();

							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
							
						}
						
						case 2 -> {
							System.out.println("Digite a data de Aniversario da Conta: ");
							aniversario = scanner.nextInt();

							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						
						default -> {
							System.out.println("Tipo de conta inválido!");
						}
						}
					
					} else {
						System.out.println("A Conta não foi encontrada!");
					}

					keyPress();
					break;
					
				 
				case 5:
					System.out.println("\nApagar Conta");
					System.out.println("--------------");
					System.out.println("Digite o número da conta: ");
					numero = scanner.nextInt();

					contas.deletar(numero);

					keyPress();
					break;
				
				case 6:
					System.out.println("\nSaque");
					System.out.println("------");
					System.out.println("Digite o Número da conta: ");
					numero = scanner.nextInt();

					do {
						System.out.println("Digite o Valor do Saque (R$): ");
						valor = scanner.nextFloat();

					} while (valor <= 0);
					contas.sacar(numero, valor);

					keyPress();
					break;
				
				case 7:
					System.out.println("\nDepósito");
					System.out.println("------------");
					System.out.println("Digite o Número da Conta: ");
					numero = scanner.nextInt();

					do {
						System.out.println("\nDigite o Valor do Depósito (R$): ");
						valor = scanner.nextFloat();

					} while (valor <= 0);

					contas.depositar(numero, valor);

					keyPress();
					break;
				
				case 8:
					System.out.println("\nTransferir");
					System.out.println("-------------");
					System.out.println("\nDigite o Número da Conta de Origem: ");
					numero = scanner.nextByte();
					System.out.println("\nDigite o Número da Conta de Destino: ");
					numeroDestino = scanner.nextInt();
					
					do {
						System.out.println("\nDigite o Valor da Transferência (R$): ");
						valor = scanner.nextInt();
					
					} while (valor <= 0);
					contas.transferir(numero, numeroDestino, valor);

					keyPress();
					break;
				
				default:
					System.out.println("\nOpção Inválida" + Cores.TEXT_RESET);

					keyPress();
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

				public static void keyPress() {

					try {

						System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
						System.in.read();

					} catch (IOException e) {

						System.out.println("Você pressionou uma tecla diferente de enter!");
					}
				}
			}