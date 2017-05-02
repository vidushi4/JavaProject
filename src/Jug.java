public class Jug
{
    int capacity;
    int value;
    Jug(int n)
    {
        capacity = n;
        value = 0;
    }
    void Fill()
    {
        value = capacity;
    }
    void Empty()
    {
        value = 0;
    }
    boolean isFull()
    {
        return value >= capacity;
    }
    boolean isEmpty()
    {
        return value == 0;
    }

    int getValue()
    {
        return value;
    }

}