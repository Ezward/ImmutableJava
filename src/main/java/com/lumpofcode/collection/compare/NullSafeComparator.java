package com.lumpofcode.collection.compare;

import java.util.Comparator;

/**
 * Null safe comparator for comparables.
 * Null is treated as least value and so sorts last.
 *
 * Created by emurphy on 10/20/15.
 */
public class NullSafeComparator<T extends Comparable> implements Comparator<T>
{
    @Override
    public int compare(T theValue, T theOtherValue)
    {
        if(null != theValue)
        {
            if(null != theOtherValue)
            {
                return theValue.compareTo(theOtherValue);
            }
            return 1;
        }
        if(null != theOtherValue)
        {
            return -1;
        }
        return 0;
    }

}
