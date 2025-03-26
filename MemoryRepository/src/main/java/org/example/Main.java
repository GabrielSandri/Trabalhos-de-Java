package org.example;

import java.util.Scanner;
import java.util.Optional;
import org.example.entities.Product;
import org.example.repository.InMemoryRepository;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Product> productRepository = new InMemoryRepository<>();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Buscar Produto");
            System.out.println("3 - Exibir Todos os Produtos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Informe o ID do produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha

                    System.out.print("Informe o nome do produto: ");
                    String name = scanner.nextLine();

                    System.out.print("Informe o preço do produto: ");
                    double price = scanner.nextDouble();

                    Product newProduct = new Product(id, name, price);
                    productRepository.save(newProduct);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Informe o ID do produto para buscar: ");
                    int searchId = scanner.nextInt();
                    Optional<Product> foundProduct = productRepository.findById(searchId);

                    if (foundProduct.isPresent()) {
                        Product product = foundProduct.get();
                        System.out.println("\n--- Produto Encontrado ---");
                        System.out.println("ID: " + product.getId());
                        System.out.println("Nome: " + product.getName());
                        System.out.println("Preço: R$ " + product.getPrice());
                        System.out.println("-------------------------");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Exibindo todos os produtos:");
                    productRepository.findAll().forEach(item ->
                            System.out.println("ID " + item.getId() + " - " + item.getName() + " - R$" + item.getPrice())
                    );
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 4);

        scanner.close();
    }
}
