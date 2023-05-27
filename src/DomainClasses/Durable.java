package DomainClasses;

public interface Durable {
    void Play(boolean playing, int end,Publication publication) throws InterruptedException;
    void Foward(int second, boolean playing,Publication publication);
    void Stop(int playTime, boolean playing,Publication publication);
}
