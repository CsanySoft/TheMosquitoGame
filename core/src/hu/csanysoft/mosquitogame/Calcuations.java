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

    /**
     *
     * @param mosquitoWidth Szúnyog szélessége
     * @param speedManA Első ember sebessége
     * @param speedManB Második ember sebessége
     * @param speedMosquito Szúnyog sebessége
     * @param travelLength Megtenni kívánt táv
     * @return Indulási táv
     */

    public float getLenghtToStart(float mosquitoWidth, float speedManA, float speedManB, float speedMosquito, float travelLength) {
        float speedMan = speedManA + speedManB;
        float calc = (((travelLength+speedMosquito)*(5*speedMan) + 5*speedMan + (5*speedMosquito*mosquitoWidth))/speedMosquito)*((speedMan)/(speedMan*5)) - speedMosquito/10;
        System.out.println("calc = " + calc);
        System.out.println("(float)Math.ceil(calc) = " + (float)Math.ceil(calc));
        if(calc == (float)Math.floor(calc)) {
            System.out.println("dhusngxdnxgjvhjkf");
        }
        return calc;
    }

    /**
     *
     * @param mosquitoWidth Szúnyog szélessége
     * @param speedManA Első ember sebessége
     * @param speedManB Második ember sebessége
     * @param speedMosquitoLeft Szúnyog sebessége balra
     * @param speedMosquitoRight Szúnyog sebessége jobbra
     * @param travelLength Megtenni kívánt táv
     * @return Indulási táv
     */

    public float getLenghtToStart(float mosquitoWidth, float speedManA, float speedManB, float speedMosquitoLeft, float speedMosquitoRight, float travelLength) {
        float speedMan = speedManA + speedManB;
        float speedMosquito = (Math.abs(speedMosquitoLeft) + Math.abs(speedMosquitoRight)) / 2.013f; //TODO: megtalálni az osztót szél esetén
        return (((travelLength+speedMosquito)*(5*speedMan) + 5*speedMan + (5*speedMosquito*mosquitoWidth))/speedMosquito)*((speedMan)/(speedMan*5)) - speedMosquito/10;
    }

}
