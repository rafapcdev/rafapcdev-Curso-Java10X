import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Lutador [] l = new Lutador[5];
        l[0] = new Lutador("Pretty Boy", "Fanca", 68.9f, 1.75f,2,11,1,31 );
        l[1] = new Lutador("Putscript", "Brasil", 57.8f, 1.68f,2,14,3,29 );
        l[2] = new Lutador("SnapShadow", "EUA", 80.9f, 1.65f,2,12,1,28 );
        l[3] = new Lutador("UFOCobol", "Brasil", 119.3f, 1.70f,4,5,3,37 );
        l[4] = new Lutador("Nerdaart", "Eua", 105.8f, 1.81f,2,12,4,30 );

        Random gerador = new Random();

        int indice1 = gerador.nextInt(5);
        int indice2 = gerador.nextInt(5);
        while (indice1 == indice2){
            indice2 = gerador.nextInt(5);
        }


        Lutador lutadorsortiado1 = l[indice1];
        System.out.println(lutadorsortiado1.getNome());
        Lutador lutadorsortiado2 = l[indice2];
        System.out.println(lutadorsortiado2.getNome());

        Luta luta = new Luta();
        luta.marcarLuta(lutadorsortiado1,lutadorsortiado2);
        System.out.println("após marcar a luta");
        luta.lutar();
        }
    }
