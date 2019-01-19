package io.github.cottonmc.advancements.matrix;

import io.github.cottonmc.advancements.data.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * P is the position class.
 * I is the identifier that we're looking for.
 * */
public class Matrix<P,I> {
    Map<P, Element<I>.Matcher> structureMap;

    Matrix(){
        structureMap = new HashMap<>();
    }

    public boolean matches(P position,I item){
     if(structureMap.containsKey(position)){
       return structureMap.get(position).match(item);
     }

     return false;
    }
}
