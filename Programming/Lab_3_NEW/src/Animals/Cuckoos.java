package animals;

import java.util.Objects;

public class Cuckoos extends Animals{

    public Cuckoos(String name){
        super(name);
    }

    public void cuckoo(){
        System.out.println(this.getName() + " crowed.");
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        Cuckoos other = (Cuckoos) obj;
        return Objects.equals(getName(), other.getName());
    }
}
