public final class List135<E>
{
    private final E firstElement; // If null, means this is an empty list
    private final List135<E> restOfList;
    private final int size;

    // returns reference to list with no elements, aka empty list
    public List135()
    {
        this(null, null, 0);
    }

    // private constructor creates new front of list element
    private List135(E firstElement, List135<E> restOfList, int size)
    {
        this.firstElement = firstElement;
        this.restOfList = restOfList;
        this.size = size;
    }

    // returns whether "this" refers to an empty list
    public boolean isEmpty()
    {
        return (firstElement == null);
    }

    // returns first element of list "this" refers to
    public E first()
    {
        if (isEmpty())
        {
            throw new RuntimeException("first() on empty list");
        }
        else
        {
            return firstElement;
        }
    }

    // returns reference to list that begins after the first element
    public List135<E> rest()
    {
        if (isEmpty())
        {
            throw new RuntimeException("rest() on empty list");
        }
        else
        {
            return restOfList;
        }
    }

    // returns reference to list that is newFront prepended to "this" list
    public List135<E> cons(E newFront)
    {  // returns
        if (newFront == null)
        {
            throw new RuntimeException("null elements not supported");
        }
        else
        {
            return new List135<E>(newFront, this, size + 1);
        }
    }

    // Return number of elements in the list in O(1) time
    public int size()
    {
        return size;
    }

    // Return element at index or throw IndexOutOfBoundsException
    public E get(int index)
    {
        if (isEmpty() || index > size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        return getHelper(index);
    }

    private E getHelper(int index)
    {
        if (index == 0)
        {
            return first();
        }
        return rest().getHelper(index - 1);
    }

    // Returns true iff this and o are the same length List135 and each pair
    // of elements (in the same relative position) are equal().
    public boolean equals(Object o)
    {
        // For explanation of the following pattern see
        // https://www.sitepoint.com/implement-javas-equals-method-correctly/
        if (this == o)
        {
            return true;
        }
        if (o == null)
        {
            return false;
        }
        if (getClass() != o.getClass())
        {
            return false;
        }
        @SuppressWarnings("unchecked")
        List135<E> other = (List135<E>) o;
        return equalsHelper(other);
    }

    private boolean equalsHelper(List135<E> o)
    {
        if (isEmpty() && o.isEmpty())
        {
            return true;
        }
        if (first().equals(o.first()))
        {
            return rest().equalsHelper(o.rest());
        }
        return false;
    }

    private String toStringHelper()
    {
        if (isEmpty())
        {
            return "";
        }
        else if (restOfList.isEmpty())
        {
            return firstElement.toString();
        }
        else
        {
            return firstElement.toString() + "," + restOfList.toStringHelper();
        }
    }

    // returns String representing list. Assumes each element has toString()
    public String toString()
    {
        return "[" + toStringHelper() + "]";
    }
}
