package zw.co.tndangana.business.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 4/25/17.
 */


public enum Symptom {


    //diabetes
    //cancer
    //hypertension
//diabetes
    MOOD_CHANGES("Mood Changes"),
    FVB("Frequent Visits to the Bathroom"),
    THIRST("Thirsty all the Time"),
    HUNGRY("Why am I so hungry"),
    SIGN("Signs from the Skin(eg yeast infection)"),
   WL("Unexpected weight loss") ,
   IT("Increased Tiredness") ,
   NUMB("Numbness in the Limbs") ,
   BE("Blurred Eyesight"),


    //hypertension
   SH("Severe headache"),
   FATIGUE("Fatigue or confusion"),
    VISION("Vision problems"),
    CP("Chest pain") ,
   DF("Difficulty breathing"),
   IR("Irregular heartbeat"),
   BU("Blood in the urine"),
   PC(" Pounding in your chest, neck, or ears");




         private String symptomType;

         Symptom(String symptomType){
             this.symptomType = symptomType;
        }

    public String getSymptomType() {
        return symptomType;
    }

    public static List<Symptom> asList(){
             return Arrays.asList(Symptom.values());
    }

    @Override
    public String toString() {
        return getSymptomType();
    }
}
