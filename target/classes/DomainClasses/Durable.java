package DomainClasses;

public interface Durable {
    void Play(boolean playing, int end) throws InterruptedException;
    void Foward(int second, boolean playing, int playTime);
    void Stop(int playTime, boolean playing);
}
