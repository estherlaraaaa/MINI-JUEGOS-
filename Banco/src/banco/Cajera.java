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
public class Cajera {
    
    private String nombre;

	public Cajera() {
	}

	public Cajera(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
        
        public void procesarTransaccion(Cliente cliente, long timeStamp) {

		System.out.println("La cajera " + this.nombre + 
				" COMIENZA A PROCESAR LA TRANSACCION DEL CLIENTE " + cliente.getNombre() + 
				" EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
				"seg");

		for (int i = 0; i < cliente.getTransaccion().length; i++) {
			this.esperarXsegundos(cliente.getTransaccion()[i]);
			System.out.println("Procesado la transaccion " + (i + 1) + 
					" ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + 
					"seg");
		}

		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR LA TRANSACCION " + 
							cliente.getNombre() + " EN EL TIEMPO: " + 
							(System.currentTimeMillis() - timeStamp) / 1000 + "seg");

	}
        
        private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
        
}
