public class celula{
	int Pos;
	String Num;
	boolean Mov;
	boolean Hole;
	
	public celula(int Pos,String Num,boolean Mov,boolean Hole) {
		this.Pos = Pos;
		this.Num = Num;
		this.Mov = Mov;
		this.Hole = Hole;
	}

	public int getPos() {
		return Pos;
	}

	public void setPos(int pos) {
		Pos = pos;
	}

	public String getNum() {
		return Num;
	}

	public void setNum(String num) {
		Num = num;
	}

	public boolean isMov() {
		return Mov;
	}

	public void setMov(boolean mov) {
		Mov = mov;
	}

	public boolean isHole() {
		return Hole;
	}

	public void setHole(boolean hole) {
		Hole = hole;
	}
	
}