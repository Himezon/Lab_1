package Animals;

public class Cuckoos extends Animals{

    public Cuckoos(String name){
        super(name);
    }

    public void cuckoo(){
        System.out.println(this.getName() + " crowed.");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
