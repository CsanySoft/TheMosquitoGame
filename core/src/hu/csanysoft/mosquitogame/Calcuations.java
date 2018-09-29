package hu.csanysoft.mosquitogame;

public class Calcuations {



    /**
     * @param mosquitoWidth A szúnyog szélessége
     * @param manSpeed Az emberek sebessége
     * @param mosquitoSpeed A szúnyog sebessége
     * @param travelLength A megtenni kívánt táv
     * @return Az indulási távolság
     * */
    public float getLenghtToStart(float mosquitoWidth, float manSpeed, float mosquitoSpeed, float travelLength) {
        float d = manSpeed+mosquitoSpeed;
        return (float)((Math.floor(-2*mosquitoWidth+(Math.sqrt(Math.pow(2*mosquitoWidth,2)-4*d*(d-travelLength)))/2*d)-1)*d); //TODO: Számolást megoldani
    }
}
