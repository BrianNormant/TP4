import java.util.ArrayList;

public class Main {
    // Brian Normant; Méthode pour tester les classes Matrice et Vecteur
    static class Parti1 {
        public static void main(String[] args) {
            //Vecteurs
            System.out.println("Test de la classe Vecteur");
            Vecteur vec = new Vecteur(5);
            vec.afficher();
            Vecteur vec1 = new Vecteur(5,3);
            vec1.afficher();

            vec.sommeVec(vec1).afficher();

            System.out.println(vec1);

            //Matrices
            System.out.println("Test de la classe Matrice");

            Matrice mat = new Matrice(3,3),
                    mat2 = new Matrice(3,3,9),
                    mat3 = new Matrice(mat2);
            mat.afficher();
            mat2.afficher();
            mat3.afficher();
            mat3 = mat3.sommeMat(mat2);
            mat3.afficher();
            System.out.println(mat.produitMat(mat2));

            System.out.println("Test de la multiplication de matrice");
            Matrice  n = new Matrice(3, 2),
                            m = new Matrice(2, 2);
            n.setElement(0,0,1);n.setElement(0,1,2);
            n.setElement(1,0,0);n.setElement(1,1,4);
            n.setElement(2,0,3);n.setElement(2,1,-1);
            n.afficher();
            System.out.println();
            m.setElement(0,0,2);m.setElement(0,1,0);
            m.setElement(1,0,1);m.setElement(1,1,-3);
            m.afficher();
            System.out.println();
            n.produitMat(m).afficher();
        }
    }

    //Brian Normant; Méthode pour résoudre le problème
    static class Parti2 {
        public static void main(String[] args) {
            //Nom et index de chaque ville
            ArrayList<String> county = new ArrayList<>();
                                            //0         //1
            String[] villes = new String[]{"Montreal","3-Rivere"};
            county.add("Montréal");
            county.add("3-Rivières");
            county.add("Québec");
            county.add("St-Jean");
            county.add("Matane");
            county.add("Gaspé");

            //Le nombre de trajet sans escale entre deux villes quelconque
            Matrice vol1 = new Matrice(county.size(),county.size());
            {
            vol1.setElement( // Il y a 1 trajet de Montréal à 3-Rivières ...
                    county.indexOf("Montréal"),
                    county.indexOf("3-Rivières"),
                    1
            );
            vol1.setElement(
                    county.indexOf("3-Rivières"),
                    county.indexOf("Québec"),
                    1
            );
            vol1.setElement(
                    county.indexOf("3-Rivières"),
                    county.indexOf("Gaspé"),
                    1
            );
            vol1.setElement(
                    county.indexOf("Québec"),
                    county.indexOf("Matane"),
                    1
            );
            vol1.setElement(
                    county.indexOf("Québec"),
                    county.indexOf("Gaspé"),
                    1
            );
            vol1.setElement(
                    county.indexOf("St-Jean"),
                    county.indexOf("Québec"),
                    1
            );
            vol1.setElement(
                    county.indexOf("St-Jean"),
                    county.indexOf("Matane"),
                    1
            );}

            vol1.afficher();
            System.out.println();
            //Le nombre de trajet avec une escale entre deux villes quelconque
            Matrice vol2 = vol1.produitMat(vol1);
            vol2.afficher();
            System.out.println();
            //Le nombre de trajet avec deux escales entre deux villes quelconque
            Matrice vol3 = vol1.produitMat(vol2);
            vol3.afficher();

            //Si les deux complices ont 1 est 2 escales chacun alors il pourront se croiser lors que les valeurs i,j de la matrice vol2 et vol3 sont égale
            for (int i = 0; i < vol1.getXSize(); i++) {
                for (int j = 0; j < vol1.getYSize(); j++) {
                    if (vol2.getElement(i,j) == 1 && vol3.getElement(i,j) == 1) {
                        System.out.println(county.get(j)+" est une ville potentielle");
                    }
                }
            }
        }
    }
}
