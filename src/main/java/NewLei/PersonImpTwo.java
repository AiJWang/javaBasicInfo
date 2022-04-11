package NewLei;

public class PersonImpTwo implements PersonB,PersonA{
    @Override
    public String getName() {
        return PersonA.super.getName();
    }
}
