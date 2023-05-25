package DomainClasses;

public interface Durable {
    void Reproducir(boolean reproduciendo,int tope) throws InterruptedException;
    void Avanzar(int segundos,boolean reproduciendo,int tiempoReproduccion);
    void Detener(int tiempoReproduccion,boolean reproduciendo);
}
