package hu.csanysoft.mosquitogame;

public class Calcuations {



    /**
     * @param mosquitoWidth A szúnyog szélessége
     * @param speedMan Az emberek sebessége
     * @param speedMosquito A szúnyog sebessége
     * @param travelLength A megtenni kívánt táv
     * @return Az indulási távolság
     * */
    public float getLenghtToStart(float mosquitoWidth, float speedMan, float speedMosquito, float travelLength) {
        return (((travelLength+speedMosquito)*(10*speedMan) + 10*speedMan + (5*speedMosquito*mosquitoWidth))/speedMosquito)*((speedMan*2)/(speedMan*10)) - speedMosquito/10;
    }

    public float getLenghtToStart(float mosquitoWidth, float speedManA, float speedManB, float speedMosquitoLeft, float speedMosquitoRight, float travelLength) {
        float speedMan = speedManA + speedManB;
        float speedMosquito = (Math.abs(speedMosquitoLeft) + Math.abs(speedMosquitoRight)) / 2.013f; //TODO: megtalálni az osztót szél esetén
        return (((travelLength+speedMosquito)*(5*speedMan) + 5*speedMan + (5*speedMosquito*mosquitoWidth))/speedMosquito)*((speedMan)/(speedMan*5)) - speedMosquito/10;
    }

}
