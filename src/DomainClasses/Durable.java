package DomainClasses;

/**
 * The {@code Durable} interface represents a durable publication.
 * It defines methods related to playback control.
 */
public interface Durable {
    /**
     * Starts playing the publication.
     *
     * @param playing     the current playback state
     * @param end         the ending point of the playback
     * @param publication the publication to play
     * @throws InterruptedException if the playback is interrupted
     */
    void Play(boolean playing, int end, Publication publication) throws InterruptedException;

    /**
     * Moves the playback forward by a specified number of seconds.
     *
     * @param second      the number of seconds to move forward
     * @param playing     the current playback state
     * @param publication the publication being played
     */
    void Foward(int second, boolean playing, Publication publication);

    /**
     * Stops the playback of the publication.
     *
     * @param playTime    the current playback time
     * @param playing     the current playback state
     * @param publication the publication being played
     */
    void Stop(int playTime, boolean playing, Publication publication);
}