package DomaineRoute;

/**
 * Created by 21406213 on 27/03/2015.
 */
public class Route {
    private int origineX;
    private int origineY;
    private int largeur;
    private int longueur;

    public Route(int origineX, int origineY, int largeur, int longueur) {
        this.origineX = origineX;
        this.origineY = origineY;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public int getOrigineX() {
        return origineX;
    }

    public void setOrigineX(int origineX) {
        this.origineX = origineX;
    }

    public int getOrigineY() {
        return origineY;
    }

    public void setOrigineY(int origineY) {
        this.origineY = origineY;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
}
