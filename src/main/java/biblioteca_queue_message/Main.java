package biblioteca_queue_message;

public class Main {

	public static void main(String[] args) {

		try {
			Queue_message.enviar("Mensagem de teste1");

			Queue_message.enviar("Mensagem de teste2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String teste1 = Queue_message.receber("Mensagem de teste1");

			String teste2 = Queue_message.receber("Mensagem de teste2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
