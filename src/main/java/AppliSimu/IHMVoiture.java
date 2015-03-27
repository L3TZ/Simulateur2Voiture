package AppliSimu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import DomaineRoute.Route;
import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double parametreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
    private Route maRoute;
	private CommandeVoiture maCommandeVoiture;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture, Route maRoute) {
		super();
		this.maVoiture = maVoiture;
        this.maRoute = maRoute;
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
        this.maRoute = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (parametreConversionMetresPixels * xMetres);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
        dessinerRoute(contexteGraphique);
		contexteGraphique.setColor(Color.red);
		dessinerVoiture(contexteGraphique);
	}

    private void dessinerRoute(Graphics contexteGraphique) {
        int origineXMetres = maRoute.getOrigineX();
        int origineYMetres = maRoute.getOrigineY();
        int largeurMetres = maRoute.getLargeur();
        int longueurMetres = maRoute.getLongueur();
        int aX = calculerPositionPixels(origineXMetres);
        int aY = calculerPositionPixels(origineYMetres);
        int largeurPixel = calculerPositionPixels(largeurMetres);
        int longueurPixel = calculerPositionPixels(longueurMetres);

        int bX = aX + longueurPixel;
        int bY = aY;
        int cX = aX;
        int cY = aY + largeurPixel;
        int dX = bX;
        int dY = cY;

        contexteGraphique.drawLine(aX,aY,bX,bY);
        contexteGraphique.drawLine(cX,cY,dX,dY);
    }


    private void dessinerVoiture(Graphics contexteGraphique) {
        int xMetres = maVoiture.getX();
        int xPixel = calculerPositionPixels(xMetres);
        contexteGraphique.fillRect(xPixel, 300, 30, 15);
	}
	
}
