package io.github.cottonmc.advancements.matrix;

import io.github.cottonmc.advancements.data.Element;

import java.util.HashMap;
import java.util.Map;

public class RawMatrix<P,I> {
    private Map<P, Element<I>> structureMap;

    public RawMatrix(){
        structureMap = new HashMap<>();
    }

    public void addElement(Element<I> element,P position){
        structureMap.put(position,element);
    }

    public Matrix<P,I> build(){
        Matrix<P, I> matrix = new Matrix<>();
        structureMap.forEach((p,i)->{
            matrix.structureMap.put(p,i.getmatcher());
        });
        return matrix;
    }
}
