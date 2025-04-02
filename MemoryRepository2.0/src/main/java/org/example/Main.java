package org.example;

import java.util.Scanner;
import java.util.UUID;
import org.example.entities.User;
import org.example.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Buscar Usuário por ID");
            System.out.println("3 - Listar Todos os Usuários");
            System.out.println("4 - Deletar Usuário por ID");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (option) {
                case 1:
                    System.out.print("Nome: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Senha: ");
                    String password = scanner.nextLine();

                    User newUser = new User(UUID.randomUUID(), name, email, password);
                    userRepository.save(newUser);
                    System.out.println("Usuário cadastrado com ID: " + newUser.getUuid());
                    break;

                case 2:
                    System.out.print("Informe o ID do usuário: ");
                    UUID searchId = UUID.fromString(scanner.nextLine());
                    userRepository.findById(searchId).ifPresentOrElse(
                            user -> {
                                System.out.println("\n--- Usuário Encontrado ---");
                                System.out.println("ID: " + user.getUuid());
                                System.out.println("Nome: " + user.getName());
                                System.out.println("Email: " + user.getEmail());
                                System.out.println("-------------------------");
                            },
                            () -> System.out.println("Usuário não encontrado.")
                    );
                    break;

                case 3:
                    System.out.println("Lista de usuários cadastrados:");
                    userRepository.findAll().forEach(user -> {
                        System.out.println("ID: " + user.getUuid());
                        System.out.println("Nome: " + user.getName());
                        System.out.println("Email: " + user.getEmail());
                        System.out.println("-------------------------");
                    });
                    break;

                case 4:
                    System.out.print("Informe o ID do usuário para deletar: ");
                    UUID deleteId = UUID.fromString(scanner.nextLine());
                    userRepository.deleteById(deleteId);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 5);

        scanner.close();
    }
}
