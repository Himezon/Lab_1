package mumiTroll;

import backgroundObject.BackgroundObject;
import backgroundObject.Earth;

public interface MumiTroll {
    void stand(BackgroundObject backgroundObject); // стоять
    void bury(ObjectMumiTroll objectMumiTroll, BackgroundObject backgroundObject); // зарыться
    void layDown(BackgroundObject backgroundObject, Earth earth, BackgroundObject backgroundObject1); // лег
    void dizzy(ObjectMumiTroll objectMumiTroll); // голова кружится
    void seems();

}