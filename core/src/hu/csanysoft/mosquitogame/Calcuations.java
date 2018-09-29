package hu.csanysoft.mosquitogame;

public class Calcuations {

    public float getLenghtToStart(float mosquitoWidth, float manSpeed, float mosquitoSpeed, float travelLength) {
        float d = manSpeed+mosquitoSpeed;
        return (float)((Math.floor(-2*mosquitoWidth+(Math.sqrt(Math.pow(2*mosquitoWidth,2)-4*d*(d-travelLength)))/2*d)-1)*d); //TODO: Számolást megoldani
    }
}
