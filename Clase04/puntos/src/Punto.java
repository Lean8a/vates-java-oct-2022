public class Punto {
    private float x;
    private float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%6.2f,%6.2f)", x, y);
    }

    public String getCuadrante() {

        if (x != 0 && y != 0) {
            int cuadrante = 0;

            if (x > 0) {
                if (y > 0) cuadrante = 1;
                else cuadrante = 4;
            } else {
                if (y > 0) cuadrante = 2;
                else cuadrante = 3;
            }

            return "Cuadrante " + cuadrante;
        }
        else if (x == 0 && y == 0)
            return "Origen";
        else if (x == 0)
            return "Eje de las ordenadas";
        else
            return "Eje de las abscisas";
    }
    
    public float getDistancia() {
        return getDistancia(new Punto(0,0));
    }

    public float getDistancia(Punto otro) {
        float dx = x - otro.getX();
        float dy = y - otro.getY();

        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}
