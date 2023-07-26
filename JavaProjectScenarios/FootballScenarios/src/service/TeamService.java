package service;

import model.Award;
import model.AwardTypeEnum;
import model.Team;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TeamService {

    // instance'larla ilgili servicelerin methodlarını static yapmamak daha iyidir.
    public Team createTeam(String teamName, String nickName, String colors, String coach, String president,
      String stadiumName, BigDecimal budget){
            Team team = new Team();
            team.setName(teamName);
            team.setNickName(nickName);
            team.setColors(colors);
            team.setPresident(president);
            team.setStadiumName(stadiumName);
            team.setBudget(budget);

            return team;

    }
    public void addAwardToTeam(Team team, String name, int year,
                               AwardTypeEnum awardTypeEnum){
        Award award = new Award();
        award.setName(name);
        award.setYear(year);
        award.setAwardType(awardTypeEnum);

        // Object tipinde olan veriler başlangıçta null dır
        // team awardList'inde daha önce bir değer atanmışsa yeni değeri ekliyoruz
        if (team.getAwards()!= null) {
            team.getAwards().add(award);

        // team awardList'i boş ise boş bir List oluşturup o listi set ediyoruz
        } else {
            List<Award> awardList = new ArrayList<>();
            awardList.add(award);
            team.setAwards(awardList);
        }

    }

}
