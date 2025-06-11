package projetoJunto;
import java.util.ArrayList;

public class Cliente extends Utilizador {
		private int cartaoCredito;
		private ArrayList<Compra>carrinho;
		
		/**
		 * @param cartaoCreito
		 * @param listaCompra
		 */
		public Cliente(String nome,String email, String password,int cartaoCredito) {
			super(nome, email, password);
			this.cartaoCredito = cartaoCredito;
			carrinho = new ArrayList<Compra>();
		}
		
		/**
		 * @return the cartaoCreito
		 */
		public int getCartaoCredito() {
			return cartaoCredito;
		}
		/**
		 * @param cartaoCreito the cartaoCreito to set
		 */
		public void setCartaoCredito(int cartaoCreito) {
			this.cartaoCredito = cartaoCreito;
		}

		/**
		 * @return the carrinho
		 */
		public ArrayList<Compra> getCarrinho() {
			return carrinho;
		}
}