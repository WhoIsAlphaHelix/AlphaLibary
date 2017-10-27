package de.alphahelix.alphalibary.forms.d2;

import de.alphahelix.alphalibary.forms.Form;
import de.alphahelix.alphalibary.forms.FormAction;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class RayForm extends Form {

    private double lenght;
    private Vector direction;

    public RayForm(Location location, Vector direction, double dense, double lenght, FormAction action) {
        super(location, "", dense, action);
        this.lenght = lenght;
        this.direction = direction;
    }

    public double getLenght() {
        return lenght;
    }

    public RayForm setLenght(double lenght) {
        this.lenght = lenght;
        return this;
    }

    public Vector getDirection() {
        return direction;
    }

    public RayForm setDirection(Vector direction) {
        this.direction = direction;
        return this;
    }

    @Override
    public void send(Player p) {
        Vector view = getDirection().clone().normalize();

        for (double d = 0; d < getLenght(); d += getDense()) {
            getAction().action(p, getLocation().clone().add(view.clone().multiply(d)));
        }
    }
}
