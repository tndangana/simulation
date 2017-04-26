package zw.co.tndangana.business.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by tndangana on 4/26/17.
 */
@Entity
public class BasicSym extends BaseEntityName{

    private Symptom symptom;

     @Enumerated(EnumType.STRING)
    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }
}
