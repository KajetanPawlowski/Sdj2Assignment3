package client.core;

public interface Subject {
    void attachObserver( Observer observer );

    void detachObserver( Observer observer);

    void notifyObservers();
}
