package io.github.cottonmc.advancements.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * I is the identifier that we use.
 * */
public class Element<I> {
    private List<I> variants;
    private I name;
    private Matcher matcher = null;

    public Element(I name) {
        this.name = name;
        variants = new LinkedList<>();
    }

    public void addVariant(I identifier) {
        variants.add(identifier);
    }

    public Matcher getmatcher(){
        if(matcher == null){
            matcher = new Matcher(variants,name);
        }
        return matcher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element<?> element = (Element<?>) o;
        return Objects.equals(variants, element.variants) &&
                Objects.equals(name, element.name);
    }

    public I getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(variants, name);
    }

    @Override
    public String toString() {
        return "Element{" +
                ", name=" + name +
                ", variants=" + variants +
                '}';
    }

    public class Matcher {
        private I start;
        private final List<I> variants;
        private final I name;

        Matcher(List<I> variants, I name) {
            this.variants = variants;
            this.name = name;
        }
        public I getName()
        {
            return name;
        }

        public boolean match(I element) {
            if (start != null) {
                return start.equals(element);
            } else {
                if(variants.contains(element)) {
                    start = element;
                    return true;
                }else
                return false;
            }
        }
    }
}
