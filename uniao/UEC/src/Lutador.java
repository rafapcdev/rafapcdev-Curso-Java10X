public class Lutador {
    private String nome;
    private String nacionalidade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias,derroatas,empates, idade;

    public Lutador(String no, String na, float pe, float al, int de, int vi, int em, int id) {
        this.nome = no;
        this.nacionalidade = na;
        this.setPeso(pe);
        this.altura = al;
        this.derroatas = de;
        this.vitorias = vi;
        this.empates = em;
        this.idade = id;
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria() {
        if (this.peso< 52.2){
            this.categoria = "Invalido";
        }else if (this.peso<= 70.3) {
            this.categoria = "Peso Leve";
        }else if (this.peso<= 83.9) {
            this.categoria = "Medio";
        } else if (this.peso<= 120.2){
            this.categoria = "Pesado";
        } else {
            this.categoria = "invalido";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerroatas() {
        return derroatas;
    }

    public void setDerroatas(int derroatas) {
        this.derroatas = derroatas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Lutador() {
    }

    public void apresentar(){
        System.out.println("Chegou a  Hora!!! apresentamos o lutador " + this.getNome());
        System.out.println("Diretamente de: " + this.getNacionalidade());
        System.out.println("COm: " + this.idade + " anos e altura: "+ this.getAltura());
        System.out.println("pesando: " + this.getPeso()+ " kg");
        System.out.println("estando na CAtegoria: " + this.getCategoria());
        System.out.println("com o cardi de: \n"+ this.getVitorias() + " VItroias \n e: "+ this.getEmpates()+ " empates \n e: "+ this.getDerroatas()+ " derrotas");
    }
    public void status(){
        System.out.println(this.getNome()+ " é um peso " + this.getCategoria());
        System.out.println("Ganhou" + this.getVitorias()+ " vezes");
        System.out.println("Empatou" + this.getEmpates()+ " vezes");
        System.out.println("Perdeu" + this.getDerroatas()+ " vezes");

    }
    public void ganharLuta(){
        this.setVitorias(getVitorias() + 1);
    }
    public void perderLuta(){
        this.setDerroatas(getDerroatas() + 1);
    }
    public void empatrLuta(){
        this.setEmpates(getEmpates() + 1);
    }
}
