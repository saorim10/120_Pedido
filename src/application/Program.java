package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do Cliente:");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento (dd/mm/aaaa): ");
		Date birthdate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthdate);
		
		System.out.println();
		System.out.println("Entre com os dados do Pedido:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("Quantos itens para este pedido? ");
		int qt = sc.nextInt();
		for(int i=1; i<=qt; i++) {
			System.out.println("Dados do " + i + "º item:");
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Preço do Produto: R$ ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantidade: ");
			int productQtde = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem it = new OrderItem(productQtde, productPrice, product);
			
			order.addItem(it);
		}
		System.out.println();
		System.out.println(order);
		
		sc.close();

	}

}
