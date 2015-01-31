package vandenrobotics.com.greengame2014.scout.model;

/**
 * Created by Programming701-A on 1/31/2015.
 */
public class TeamList {
    public int matchNumber;
    public int[] teams;

    public TeamList(){
        matchNumber = 0;
        teams = new int[6];
    }

    public TeamList(TeamList teamList){
        matchNumber = teamList.matchNumber;
        teams = teamList.teams;
    }
}
