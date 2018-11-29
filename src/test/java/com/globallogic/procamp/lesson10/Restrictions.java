package com.globallogic.procamp.lesson10;

import java.util.List;
import java.util.Set;

public class Restrictions<T> {

//    Cannot Declare Static Fields Whose Types are Type Parameters
/*
    public static T os;
*/
    

    // Cannot Instantiate Generic Types with Primitive Types
    public void cannotInstantiateGenericTypesWithPrimitiveTypes() {
    /*
       Map<int, char> map = new HashMap<>(); 
    */
    }
    
    // Cannot Create Instances of Type Parameters
    public  <E> void  cannotCreateInstancesOfTypeParameters(List<E> list) {
    /* 
        E el = new E();
    */
    }

    // Cannot Use Casts or instanceof with Parameterized Types
    public  <E>  void cannotUseCastsOrInstanceofWithParameterizedTypes(List<E> list) {
     /*
        if (list instanceof ArrayList<Integer>) { }
     */   
    }

    // Cannot Create Arrays of Parameterized Types
    public void cannotCreateArraysOfParameterizedTypes() {
    /*
        List<Integer>[] arrayOfLists = new List<Integer>[2];  // compile-time error

        The following code illustrates what happens when different types are inserted into an array:

        Object[] strings = new String[2];
        strings[0] = "hi";   // OK
        strings[1] = 100;    // An ArrayStoreException is thrown.
        If you try the same thing with a generic list, there would be a problem:

        Object[] stringLists = new List<String>[];  // compiler error, but pretend it's allowed
        stringLists[0] = new ArrayList<String>();   // OK
        stringLists[1] = new ArrayList<Integer>();  // An ArrayStoreException should be thrown,
        // but the runtime can't detect it.
    */
    }

    // Cannot Create, Catch, or Throw Objects of Parameterized Types
    public void cannotCreateCatchOrThrowObjectsOfParameterizedTypes() {
    /*
        Extends Throwable indirectly
        class MathException<T> extends Exception {  }    // compile-time error

        Extends Throwable directly
        class QueueFullException<T> extends Throwable {  } // compile-time error
    */
    }

    // Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type
    // A class cannot have two overloaded methods that will have the same signature after type erasure.
    // The overloads would all share the same classfile representation and will generate a compile-time error.

    public void cannotOverloadAMethodWhereTheFormalParameterTypesOfEachOverloadEraseToTheSameRawType(Set<String> set) {
    }

    /*
    
    public void cannotOverloadAMethodWhereTheFormalParameterTypesOfEachOverloadEraseToTheSameRawType(Set<Integer> set) {}
    
    */

}
