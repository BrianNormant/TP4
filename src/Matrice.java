import java.util.Arrays;

//Brian Normant
public class Matrice {
    private final int[][] mat;
    private int valMax;

    /**
     * Initialise les éléments de mat de l'objet courant à zéro.
     * @param xSize le nombre de lignes
     * @param ySize le nombre de colonnes
     */
    public Matrice(int xSize, int ySize) {
        mat = new int[xSize][ySize];
    }

    /**
     * Initialise les éléments de mat de l'objet courant à une valeur aléatoire comprise entre 1 et cette valeur maximale.
     * La propriété valMax est initialisée à cette valeur maximale.
     * @param xSize le nombre de lignes
     * @param ySize le nombre de colonnes
     * @param valMax la valeur maximale
     */
    public Matrice(int xSize, int ySize, int valMax) {
        this.mat = new int[xSize][ySize];
        this.valMax = valMax;

        for (int i = 0; i < this.getXSize(); i++) {
            for (int j = 0; j < this.getYSize(); j++) {
                int rnd = (int)(Math.random() * (valMax+1));
                this.setElement(i, j, rnd);
            }
        }
    }

    /**
     * Initialise les éléments de mat de l'objet courant à une valeur comprise entre 1 et la valeur contenue dans la propriété valMax de l'objet passé en paramètre.
     *
     * Les dimensions de mat de l'objet courant et de l'objet passé en paramètre doivent être identiques.
     * @param mat Un objet de type Matrice
     */
    public Matrice(Matrice mat) {
        this.mat = new int[mat.getXSize()][mat.getYSize()];
        this.valMax = mat.getValMax();

        for (int i = 0; i < this.getXSize(); i++) {
            for (int j = 0; j < this.getYSize(); j++) {
                int rnd = (int)(Math.random() * (valMax+1));
                this.setElement(i, j, rnd);
            }
        }
    }


    /**
     * Fait la somme de chaque élément de mat de l'objet courant et l'élément correspondant de mat de l'objet passé en paramètres.
     * La propriété valMax de l'objet retourné est remise à zéro.
     * @param mat Un objet de type Matrice
     * @return Un objet de type Matrice
     */
    public Matrice sommeMat(Matrice mat) {
        Matrice result = new Matrice(this.getXSize(), mat.getYSize());
        for (int i = 0; i < this.getXSize(); i++) {
            for (int j = 0; j < this.getYSize(); j++) {
                int element = this.getElement(i,j) + mat.getElement(i,j);
                result.setElement(i,j,element);
            }
        }
        return result;
    }

    /**
     * Fait le produit des matrices mat de l'objet courant et de l'objet passé en paramètre.
     * La propriété valMax de l'objet retourné est remise à zéro.
     * @param mat Un objet d type Matrice
     * @return Un objet d type Matrice
     */
    public Matrice produitMat(Matrice mat) {
        Matrice result = new Matrice(this.getXSize(), mat.getYSize());
        for (int i = 0; i < this.getXSize(); i++) {
            for (int j = 0; j < this.getYSize(); j++) {
                int element = 0;
                //On multiplie dans l'ordre, élément par élément, chaque élément d'une ligne de la première matrice
                //A par chaque élément d'une colonne de la deuxième matrice B
                for (int k = 0; k < this.getYSize(); k++) {
                    element +=  this.getElement(i,k) * mat.getElement(k,j);
                }
                result.setElement(i,j,element);
            }
        }
        return result;
    }

    /**
     * Affiche dans la fenêtre console les éléments de mat de l'objet courant.
     */
    public void afficher() {
        for (int i = 0; i < getXSize(); i++) {
            for (int j = 0; j < getYSize(); j++) {
                  System.out.print(this.getElement(i,j)+" ");
            }
            System.out.print("\n");
        }
    }
    //getters
    public int getValMax() {
        return valMax;
    }
    public int getXSize() {
        return this.mat.length;
    }
    public int getYSize() {
        return this.mat[0].length;
    }
    public int getElement(int x, int y) {
        return this.mat[x][y];
    }

    //setters
    public void setElement(int x, int y, int element) {
        this.mat[x][y] = element;
    }
    public void fill(int element) {
        for (int i = 0; i < this.getXSize(); i++) {
            for (int j = 0; j < this.getYSize(); j++) {
                this.setElement(i,j,element);
            }
        }
    }

    public String toString() {
        String s = "Matrice{mat=[";
        for (int i = 0; i < this.getXSize(); i++) {
            s += Arrays.toString(this.mat[i]);
            if (i == this.getXSize()-1) {
                s += "]";
            } else {
                s += ", ";
            }
        }
        return s+", valMax=" + valMax +'}';
    }

}
