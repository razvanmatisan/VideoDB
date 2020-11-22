package action;

import actor.ActorDB;
import entertainment.VideoDB;
import fileio.ActionInputData;
import user.UserDB;

import java.util.List;

public class ActionFactory {
    private final VideoDB videoDB;
    private final ActorDB actorDB;
    private final UserDB userDB;

    public ActionFactory(VideoDB videoDB, ActorDB actorDB, UserDB userDB) {
        this.videoDB = videoDB;
        this.actorDB = actorDB;
        this.userDB = userDB;
    }

    public Action getAction(ActionInputData action) {
        String actionType = action.getActionType();
        String type = action.getType();
        String title = action.getTitle();
        String username = action.getUsername();
        String criteria = action.getCriteria();
        String sortType = action.getSortType();
        String objectType = action.getObjectType();
        String genre = action.getGenre();
        List<List<String>> filters = action.getFilters();

        int number = action.getNumber();
        int actionId = action.getActionId();
        double grade = action.getGrade();
        int seasonNumber = action.getSeasonNumber();


        switch(actionType) {
            case ("command") -> {
                return new Command(actionId, type, title, username, grade, seasonNumber, videoDB, actorDB, userDB);
            }
            case("query") -> {
                return new Query(actionId, criteria, objectType, sortType, filters, number, videoDB, actorDB, userDB);
            }
            case("recommendation") -> {
                return new Recommendation(actionId, type, username, genre, videoDB, actorDB, userDB);
            }
        }

        return null;
    }
}
