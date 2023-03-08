package YangSeorim;

public class StudentData {

	private int kor,eng,mat,sc;
	private String name,sex,id;

	public StudentData(String id,String name,String sex, int kor, int eng, int mat, int sc){
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sc = sc;

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getSci() {
		return sc;
	}
	public void setSci(int sc) {
		this.sc = sc;
	}
	
	
	
	
}
