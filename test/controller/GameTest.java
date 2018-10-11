package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void getCurrentRollScore() {

        /*
        De teoretiske sandsynligheder for hvert udfald af kast med 2 terninger er som følger:
        2: 1/36
        3: 2/36
        4: 3/36
        5: 4/36
        6: 5/36
        7: 6/36
        8: 5/36
        9: 4/36
       10: 3/36
       11: 2/36
       12: 1/36

       Er Beregnet ud fra de mulige kombinationer (tælleren) i forhold til alle kombinationer (nævneren) for terningerne.
         */

        // Arrange
        Game roll = new Game();
        int count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0,
                count8 = 0, count9 = 0, count10 = 0, count11 =0, count12 = 0;



        //Forventet forekomst for hvert udfald ved 100.000 kast udregnes, ud fra de teoretiske sandsynligheder
        int expect2and12 = 100000*1/36;
        int expect3and11 = 100000*2/36;
        int expect4and10 = 100000*3/36;
        int expect5and9 = 100000*4/36;
        int expect6and8 = 100000*5/36;
        int expect7 = 100000*6/36;

        //Tilladt afvigelse på 5 % af forventet resultat
        int dExpect2and12 = (100000*1/36)*5/100;
        int dExpect3and11 = (100000*2/36)*5/100;
        int dExpect4and10 = (100000*3/36)*5/100;
        int dExpect5and9 = (100000*4/36)*5/100;
        int dExpect6and8 = (100000*5/36)*5/100;
        int dExpect7 = (100000*6/36)*5/100;


        // Act
        for(int i = 0; i < 100000; i++) {
            roll.roll();
            int num = roll.getCurrentRollScore();

            assertTrue(num > 1 && num < 13);

            switch (num) {
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
                case 7:
                    count7++;
                    break;
                case 8:
                    count8++;
                    break;
                case 9:
                    count9++;
                    break;
                case 10:
                    count10++;
                    break;
                case 11:
                    count11++;
                    break;
                case 12:
                    count12++;
                    break;
            }
        }





        // Assert
        assertEquals(expect2and12, count2, dExpect2and12);
        assertEquals(expect3and11, count3, dExpect3and11);
        assertEquals(expect4and10, count4, dExpect4and10);
        assertEquals(expect5and9, count5, dExpect5and9);
        assertEquals(expect6and8, count6, dExpect6and8);
        assertEquals(expect7, count7, dExpect7);
        assertEquals(expect6and8, count8, dExpect6and8);
        assertEquals(expect5and9, count9, dExpect5and9);
        assertEquals(expect4and10, count10, dExpect4and10);
        assertEquals(expect3and11, count11, dExpect3and11);
        assertEquals(expect2and12, count12, dExpect2and12);

    }
}