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


}
