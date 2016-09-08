public class jogador{
	String Nome;
	String Data;
	float tempo;
	
	public jogador(String Nome,String Data,float tempo){
		this.Nome=Nome;
		this.Data=Data;
		this.tempo=tempo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public float getTempo() {
		return tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}
}