import java.util.Random;

public class Luta {
    private  Lutador desafiante;
    private Lutador desafiado;
    private int rounders;
    private boolean aprovada;

    public Luta(Lutador desafiante, Lutador desafiado, int rounders, boolean aparovada) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.rounders = rounders;
        this.aprovada = aprovada;
    }

    public Luta() {
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public int getRounders() {
        return rounders;
    }

    public void setRounders(int rounders) {
        this.rounders = rounders;
    }

    public boolean isAparovada() {
        return aprovada;
    }

    public void setAparovada(boolean aparovada) {
        this.aprovada = aparovada;
    }

    public void marcarLuta(Lutador desafiante, Lutador desafiado){
        if(desafiante.getCategoria().equalsIgnoreCase(desafiado.getCategoria()) && desafiado != desafiante) {
            this.aprovada = true;
            this.setDesafiado( desafiado);
            this.setDesafiante( desafiante);
        } else {
            this.aprovada = false;
            this.setDesafiado( null);
            this.setDesafiante( null);
        }
    }

    public void lutar(){
        if(this.aprovada){
            desafiado.apresentar();
            System.out.println("----------");
            desafiante.apresentar();

            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3);

            switch (vencedor) {
                case 0:
                    System.out.println(" A luta Empatou!");
                    this.desafiado.empatrLuta();
                    this.desafiante.empatrLuta();
                    break;
                case 1:
                    System.out.println(this.desafiante.getNome() +" Venceu");
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();
                    break;
                case 2:
                    System.out.println(this.desafiante.getNome()+ " venceu");
                    this.desafiado.ganharLuta();
                    this.desafiado.perderLuta();
                    break;

            }

        }else {
            System.out.println("luta nao aprovada");
        }

    }
}
