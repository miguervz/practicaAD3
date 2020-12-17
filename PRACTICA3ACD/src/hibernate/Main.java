package hibernate;

import java.util.Scanner;

import POJOS.Clientes;

public class Main {

	static Scanner menu1 = new Scanner(System.in);
	static Scanner teclado;
	static int menu2;
	public static void main(String[] args) {
		teclado = new Scanner (System.in);
		do {
			System.out.println("Seleccione:");
			System.out.println("1- Crear");
			System.out.println("2- Mostrar");
			System.out.println("3- Actualizar");
			System.out.println("4- Eliminar");
			System.out.println("5- Salir.");
			
			menu2=menu1.nextInt();
			if(menu2==1) {
				System.out.println("Nombre del cliente:");
				String nombreCliente=teclado.next();
				System.out.println("Apellidos del cliente:");
				String apellidosCliente=teclado.next();
				System.out.println("Email del cliente:");
				String emailCliente=teclado.next();
				System.out.println("DNI del cliente:");
				String DNICliente=teclado.next();
				System.out.println("Clave del cliente:");
				String claveCliente=teclado.next();
				Clientes clien = new Clientes(nombreCliente, apellidosCliente, emailCliente, DNICliente, claveCliente);
				HotelManager.create(clien);
			}
			else if (menu2==2) {
				HotelManager.readClientes();
			}
			else if (menu2==3) {
				System.out.println("ID del cliente:");
				int idClientes = teclado.nextInt();
				System.out.println("Nombre del cliente:");
				String nombreCliente=teclado.next();
				System.out.println("Apellidos del cliente:");
				String apellidosCliente=teclado.next();
				System.out.println("email del cliente:");
				String emailCliente=teclado.next();
				System.out.println("DNI del cliente:");
				String DNICliente=teclado.next();
				System.out.println("Clave del cliente:");
				String claveCliente=teclado.next();
				Clientes clien = new Clientes(idClientes, nombreCliente, apellidosCliente, emailCliente, DNICliente, claveCliente);
				HotelManager.updateClientes(clien);
			}
			else if(menu2==4) {
				System.out.println("ID del cliente que desea eliminar:");
				int id = teclado.nextInt();
				Clientes clien = new Clientes(id);
				HotelManager.deleteClientes(clien);
			}
			
		}
		while(menu2!=0);
		teclado.close();
		menu1.close();
	}
}
