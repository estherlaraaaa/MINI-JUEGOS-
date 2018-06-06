/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author User
 */
public class CajeraThread extends Thread {
    private String nombre;

	private Cliente cliente;

	private long initialTime;


	public CajeraThread() {
	}

	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
        
        
       
    @Override
	public void run() {

		System.out.println("La cajera " + this.nombre + " COMIENZA A PROCESAR LA TRANSACCION DEL CLIENTE " 
					+ this.cliente.getNombre() + " EN EL TIEMPO: " 
					+ (System.currentTimeMillis() - this.initialTime) / 1000 
					+ "seg");

		for (int i = 0; i < this.cliente.getTransaccion().length; i++) {
			// Se procesa el pedido en X segundos
			this.esperarXsegundos(cliente.getTransaccion()[i]);
			System.out.println("Procesado la transaccion " + (i + 1) 
						+ " del cliente " + this.cliente.getNombre() + "->Tiempo: " 
						+ (System.currentTimeMillis() - this.initialTime) / 1000 
						+ "seg");
		}

		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR LA TRANSACCION " 
						+ this.cliente.getNombre() + " EN EL TIEMPO: " 
						+ (System.currentTimeMillis() - this.initialTime) / 1000 
						+ "seg");
	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
        
        
        public class MainThread {

	 {

		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		CajeraThread cajera1 = new CajeraThread("Cajera 1", cliente1, initialTime);
		CajeraThread cajera2 = new CajeraThread("Cajera 2", cliente2, initialTime);

		cajera1.start();
		cajera2.start();
	}
}
}
