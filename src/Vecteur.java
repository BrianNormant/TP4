import java.util.Arrays;

//Brian Normant
public class Vecteur {
    private final int[] vec;
    private int valMax;//Une valeur associée à vec qui représente la valeur maximale qui sera contenue dans le vecteur
    /**
     * Initialise les éléments de vec à zéro
     * @param size Le nombre d'éléments de vec
     */
    public Vecteur(int size) {
        this.vec = new int[size];
    }

    /**
     * Initialise les éléments de vec à une valeur aléatoire comprise entre 1 et cette valeur entière.
     * La propriété valMax est initialisée à cette valeur entière.
     * @param size Le nombre d'éléments de vec
     * @param valMax une valeur entière
     */
    public Vecteur(int size, int valMax) {
        this.vec = new int[size];
        this.valMax = valMax;

        for (int i = 0; i < size; i++) {
            int rnd = (int)(Math.random() * (valMax+1));
            this.setElement(i, rnd);
        }
    }

    /**
     * Fait la somme de tous les éléments de vec de l'objet courant et de l'objet passé en paramètre.
     * La propriété valMax de l'objet retournée est mise à zéro.
     * @param vecteur Un objet de type Vecteur
     * @return Un objet de type Vecteur
     */
    public Vecteur sommeVec(Vecteur vecteur) {
        Vecteur v = new Vecteur(this.getSize());
        v.setValMax(0);
        for (int i = 0; i < this.getSize(); i++) {
            v.setElement(i,
                    this.getElement(i) + vecteur.getElement(i)
            );
        }
        return v;
    }

    /**
     * Affiche dans la fenêtre console les éléments de vec de l'objet courant.
     */
    public void afficher() {
        for (int i = 0; i < this.getSize(); i++) {
            System.out.print(this.getElement(i)+" ");
        }
        System.out.print("\n");
    }
    //Getters
    public int getSize() {
        return this.vec.length;
    }
    public int getElement(int index) {
        return this.vec[index];
    }
    //Setters
    public void setValMax(int valMax) {
        this.valMax = valMax;
    }
    public void setElement(int index, int element) {
        this.vec[index] = element;
    }
    public void fill(int element) {
        for (int i = 0; i < this.getSize(); i++) {
            this.setElement(i,element);
        }
    }

    //

    @Override
    public String toString() {
        return "Vecteur{" +
                "vec=" + Arrays.toString(vec) +
                ", valMax=" + valMax +
                '}';
    }
}
