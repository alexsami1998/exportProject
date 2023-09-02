package exportProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu principal");
			System.out.println("1. Adicionar dados");
			System.out.println("2. Editar dados");
			System.out.println("3. Exibir entrada de OPS");
			System.out.println("4. Deletar dados");
			System.out.println("5. Sair");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				ManagerData.addEntry();
				break;
			case 2:
				System.out.println("Digite o número da linha no documento excel a ser editada: ");
				int rowNum = scanner.nextInt();
				scanner.nextLine();
				ManagerEdit.ManagerEdit(rowNum);
				break;
			case 3:
				ManagerList.ManagerList();
				break;
			case 4:
				ManagerDelete.ManagerDelete(choice); //manutencao
			case 5:
				System.out.println("Saindo...");
				scanner.close();
				return;
			}
	        }
		}
	}